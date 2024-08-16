package com.github.katajalanguage.intellijplugin.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType

class KatajaModuleBuilder: ModuleBuilder() {
    override fun getModuleType(): ModuleType<*> = KatajaModuleType()
}