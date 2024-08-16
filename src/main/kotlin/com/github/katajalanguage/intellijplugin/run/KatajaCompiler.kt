package com.github.katajalanguage.intellijplugin.run

import com.github.katajalanguage.intellijplugin.KatajaIcons
import com.intellij.openapi.projectRoots.*
import org.jdom.Element
import javax.swing.Icon

class KatajaCompiler: SdkType("Kataja Compiler"){

    override fun getPresentableName(): String = "Kataja Compiler"

    override fun suggestHomePath(): String? = null

    override fun getDownloadSdkUrl(): String = "https://github.com/KatajaLanguage/Compiler/tree/master/releases"

    override fun getIcon(): Icon = KatajaIcons.FILE

    override fun saveAdditionalData(data: SdkAdditionalData, element: Element) {}

    override fun isValidSdkHome(path: String): Boolean = true

    override fun suggestSdkName(p0: String?, p1: String): String = "Kataja Compiler"

    override fun createAdditionalDataConfigurable(model: SdkModel, modificator: SdkModificator): AdditionalDataConfigurable? = null
}