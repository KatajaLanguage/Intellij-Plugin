package com.github.katajalanguage.intellijplugin.run

import com.github.katajalanguage.intellijplugin.language.KatajaIcons
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.openapi.util.NotNullLazyValue

class KatajaRunConfigurationType: ConfigurationTypeBase("kataja", "Kataja", "", NotNullLazyValue.createValue{ KatajaIcons.FILE}){
    init {
        addFactory(KatajaConfigurationFactory(this))
    }
}