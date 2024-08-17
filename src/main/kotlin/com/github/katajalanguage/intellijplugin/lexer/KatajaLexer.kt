package com.github.katajalanguage.intellijplugin.lexer

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType

class KatajaLexer: Lexer() {

    private val operators: Set<Char> = setOf('+', '-', '*', '/', '^', '!', '%', '&', '=', '|', '<', '>', '~', '\\')
    private val primitiveTypes: Set<String> = setOf("short", "int", "long", "boolean", "double", "float", "byte", "char", "void")
    val keywords: Set<String> = setOf(
        "if",
        "else",
        "while",
        "return",
        "true",
        "false",
        "null",
        "this",
        "main",
        "class",
        "interface",
        "type",
        "data",
        "public",
        "private",
        "protected",
        "static",
        "synchronised",
        "abstract",
        "use",
        "from",
        "as",
        "const",
        "final",
        "extends",
        "throw",
        "switch",
        "default",
        "for",
        "in",
        "break",
        "try",
        "catch",
        "object",
        "do",
        "volatile",
        "transient",
        "strict",
        "native"
    )

    private lateinit var buffer: CharSequence
    private var state = 0
    private var pos: Int = -2
    private var end: Int = 0
    private var tokenStart: Int = 0
    private var tokenEnd: Int = 0

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        pos = startOffset - 1
        end = endOffset - 1
        state = initialState
    }

    override fun getState(): Int = state

    override fun getTokenStart(): Int = tokenStart

    override fun getTokenEnd(): Int = tokenEnd

    override fun getBufferSequence(): CharSequence = buffer

    override fun getBufferEnd(): Int = end

    override fun getCurrentPosition(): LexerPosition = KatajaLexerPosition(pos, state)

    override fun restore(position: LexerPosition) {
        pos = position.offset
        state = position.state
    }

    override fun getTokenType(): IElementType? {
        if(pos == -2 || pos > end) return null

        advance()
        pos = tokenStart - 1

        return when(state){
            1 -> KatajaTokenTypes.IDENTIFIER
            2 -> KatajaTokenTypes.SINGLE
            3 -> KatajaTokenTypes.OPERATOR
            4 -> KatajaTokenTypes.NUMBER
            5 -> KatajaTokenTypes.KEYWORD
            6 -> KatajaTokenTypes.COMMENT
            7 -> KatajaTokenTypes.WHITESPACE
            8 -> KatajaTokenTypes.NEW_LINE
            9 -> KatajaTokenTypes.SPECIAL
            10 -> KatajaTokenTypes.STRING
            11 -> KatajaTokenTypes.CHAR
            12 -> KatajaTokenTypes.BAD_CHARACTER
            13 -> KatajaTokenTypes.PRIMITIVE
            else -> null
        }
    }

    override fun advance() {
        if(pos < end){
            pos++
            tokenStart = pos
            val current: Char = buffer[pos]

            if(current == '\n') state = 8
            else if(current == ';' || current == ',' || current == '$') state = 9
            else if(current == '\''){
                if(pos + 2 > end || buffer[pos + 2] != '\'') state = 12
                else{
                    state = 11
                    pos += 2
                }
            }else if(current == '"'){
                if(pos == end) state = 12
                else {
                    pos++
                    while (pos < end && !setOf('"', '\n').contains(buffer[pos])) pos++

                    state = if(buffer[pos] == '"') 10
                    else 12
                }
            }else if(setOf(' ', '\t').contains(current)){
                state = 7
                while(pos < end && setOf(' ', '\t').contains(buffer[pos + 1])) pos++
            }else if(current == '#'){
                state = 6
                while(pos < end && !setOf('#', '\n').contains(buffer[pos + 1])) pos++
                if(pos < end && buffer[pos + 1] == '#') pos++
            }else if(current > ('0' - 1) && current < ('9' + 1)){
                state = 4
                while(pos < end && buffer[pos + 1] > ('0' - 1) && buffer[pos + 1] < ('9' + 1)) pos++

                if(pos < end && buffer[pos + 1] == '.'){
                    pos++
                    while(pos < end && buffer[pos + 1] > ('0' - 1) && buffer[pos + 1] < ('9' + 1)) pos++
                }

                if(pos < end && setOf('i', 'd', 'l', 's', 'f').contains(buffer[pos + 1])) pos++
            }else if(operators.contains(current)){
                state = 3
                while(pos < end && operators.contains(buffer[pos + 1])) pos++
            }else if((current > ('a' - 1) && current < ('z' + 1)) || (current > ('A' - 1) && current < ('Z' + 1))){
                state = 1
                while(pos < end && ((buffer[pos + 1] == '_') || (buffer[pos + 1] > ('a' - 1) && buffer[pos + 1] < ('z' + 1)) || (buffer[pos + 1] > ('A' - 1) && buffer[pos + 1] < ('Z' + 1)) || (buffer[pos + 1] > ('0' - 1) && buffer[pos + 1] < ('9' + 1)))) pos++

                val identifier = buffer.subSequence(tokenStart, pos + 1).toString()

                if(primitiveTypes.contains(identifier)) state = 13
                if(keywords.contains(identifier)) state = 5
            }else state = 2

            tokenEnd = pos + 1
        }else state = 0
    }
}

class KatajaLexerPosition(private val offset: Int, private val state: Int): LexerPosition {

    override fun getOffset(): Int = offset

    override fun getState(): Int = state

}