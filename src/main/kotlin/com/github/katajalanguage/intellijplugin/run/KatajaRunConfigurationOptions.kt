package com.github.katajalanguage.intellijplugin.run

import com.intellij.execution.configurations.RunConfigurationOptions

class KatajaRunConfigurationOptions: RunConfigurationOptions() {

    val mainClass = string("").provideDelegate(this, "mainClass")

    fun getMainClass(): String? {
        return mainClass.getValue(this)
    }

    fun setMainClas(mainClassName: String) {
        mainClass.setValue(this, mainClassName)
    }
}