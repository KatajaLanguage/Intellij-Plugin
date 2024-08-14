package com.github.katajalanguage.intellijplugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class KatajaSyntaxHighlighter() : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return KatajaLexer()
    }

    override fun getTokenHighlights(type: IElementType): Array<TextAttributesKey> {
        if (type == KatajaTokenTypes.IDENTIFIER) return Identifier
        if (type == KatajaTokenTypes.SPECIAL) return Special
        if (type == KatajaTokenTypes.KEYWORD || type == KatajaTokenTypes.PRIMITIVE) return Keyword
        if (type == KatajaTokenTypes.NUMBER) return Number
        if (type == KatajaTokenTypes.COMMENT) return Comment
        if (type == KatajaTokenTypes.SINGLE) return Single
        if (type == KatajaTokenTypes.STRING) return String
        if (type == KatajaTokenTypes.CHAR) return Char
        if (type == KatajaTokenTypes.OPERATOR) return Operator
        if (type == KatajaTokenTypes.BAD_CHARACTER) return BAD_CHARACTER
        return emptyArray()
    }

    companion object {
        val identifier: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Identifier", DefaultLanguageHighlighterColors.IDENTIFIER)
        val keyword: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Keyword", DefaultLanguageHighlighterColors.KEYWORD)
        val primitive: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Primitive", DefaultLanguageHighlighterColors.KEYWORD)
        val number: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Number", DefaultLanguageHighlighterColors.NUMBER)
        val comment: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Comment", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val semicolon: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Semicolon", DefaultLanguageHighlighterColors.SEMICOLON)
        val string: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_String", DefaultLanguageHighlighterColors.STRING)
        val operator: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Operator", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val bad_character: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_BAD_CHARACTER", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
        val character: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Char", DefaultLanguageHighlighterColors.STRING)
        val special: TextAttributesKey = TextAttributesKey.createTextAttributesKey("Kataja_Special", DefaultLanguageHighlighterColors.IDENTIFIER)

        private val Identifier = arrayOf(identifier)
        private val Keyword = arrayOf(keyword, primitive)
        private val Number = arrayOf(number)
        private val Comment = arrayOf(comment)
        private val Special = arrayOf(semicolon)
        private val String = arrayOf(string)
        private val Operator = arrayOf(operator)
        private val BAD_CHARACTER = arrayOf(bad_character)
        private val Char = arrayOf(character)
        private val Single = arrayOf(special)
    }
}