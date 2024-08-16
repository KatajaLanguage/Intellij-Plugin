package com.github.katajalanguage.intellijplugin.module

import com.github.katajalanguage.intellijplugin.KatajaIcons
import com.intellij.openapi.module.ModuleType
import javax.swing.Icon

class KatajaModuleType: ModuleType<KatajaModuleBuilder>("kataja") {
    override fun createModuleBuilder(): KatajaModuleBuilder = KatajaModuleBuilder()

    override fun getName(): String = "Kataja"

    override fun getDescription(): String = "Kataja Module"

    override fun getNodeIcon(p0: Boolean): Icon = KatajaIcons.FILE
}