package com.github.katajalanguage.intellijplugin.file

import com.github.katajalanguage.intellijplugin.language.KatajaFileType
import com.github.katajalanguage.intellijplugin.language.KatajaLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class KatajaFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, KatajaLanguage.INSTANCE) {
    override fun getFileType(): FileType = KatajaFileType.INSTANCE

    override fun toString(): String = "Kataja File"

}