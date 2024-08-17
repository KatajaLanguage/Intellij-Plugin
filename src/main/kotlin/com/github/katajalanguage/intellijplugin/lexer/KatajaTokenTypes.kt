package com.github.katajalanguage.intellijplugin.lexer

import com.github.katajalanguage.intellijplugin.language.KatajaLanguage
import com.intellij.psi.tree.IElementType

object KatajaTokenTypes {
    val IDENTIFIER    : KatajaTokenType = KatajaTokenType("IDENTIFIER")
    val KEYWORD       : KatajaTokenType = KatajaTokenType("KEYWORD")
    val SPECIAL       : KatajaTokenType = KatajaTokenType("SPECIAL")
    val OPERATOR      : KatajaTokenType = KatajaTokenType("OPERATOR")
    val NUMBER        : KatajaTokenType = KatajaTokenType("NUMBER")
    val COMMENT       : KatajaTokenType = KatajaTokenType("COMMENT")
    val WHITESPACE    : KatajaTokenType = KatajaTokenType("WHITESPACE")
    val NEW_LINE      : KatajaTokenType = KatajaTokenType("NEW_LINE")
    val PRIMITIVE     : KatajaTokenType = KatajaTokenType("PRIMITIVE")
    val SINGLE        : KatajaTokenType = KatajaTokenType("SINGLE")
    val STRING        : KatajaTokenType = KatajaTokenType("STRING")
    val CHAR          : KatajaTokenType = KatajaTokenType("CHAR")
    val BAD_CHARACTER : KatajaTokenType = KatajaTokenType("BAD_CHARACTER")
}

class KatajaTokenType(debugName: String): IElementType(debugName, KatajaLanguage.INSTANCE) {

    override fun toString(): String = "KatajaTokenType." + super.toString()
}