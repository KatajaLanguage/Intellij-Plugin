package com.github.katajalanguage.intellijplugin.parser

import com.github.katajalanguage.intellijplugin.language.KatajaLanguage
import com.intellij.psi.tree.IElementType

class KatajaElementType(debugName: String): IElementType(debugName, KatajaLanguage.INSTANCE) {
}