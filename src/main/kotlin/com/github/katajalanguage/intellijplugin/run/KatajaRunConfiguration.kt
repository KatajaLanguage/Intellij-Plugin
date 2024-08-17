package com.github.katajalanguage.intellijplugin.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class KatajaRunConfiguration(project: Project, factory: ConfigurationFactory, name:String): RunConfigurationBase<KatajaRunConfiguration>(project, factory, name) {
    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState = KatajaCommandLineState(environment)

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = KtjSettingsEditor()
}