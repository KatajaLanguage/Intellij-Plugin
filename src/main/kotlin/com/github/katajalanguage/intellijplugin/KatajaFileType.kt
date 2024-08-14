package com.github.katajalanguage.intellijplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class KatajaFileType private constructor() : LanguageFileType(KatajaLanguage) {
    override fun getName(): String = "Kataja File"

    override fun getDescription(): String = "Kataja language file"

    override fun getDefaultExtension(): String = "ktj"

    override fun getIcon(): Icon = KatajaIcons.FILE

    companion object {
        val INSTANCE: KatajaFileType = KatajaFileType()
    }
}