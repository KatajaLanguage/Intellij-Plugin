package com.github.katajalanguage.intellijplugin.run

import com.intellij.execution.DefaultExecutionResult
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.filters.TextConsoleBuilderFactory
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.CompilerProjectExtension
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import java.io.File

class KatajaCommandLineState(private val environment: ExecutionEnvironment): CommandLineState(environment) {

    override fun startProcess(): ProcessHandler {
        val sdk = ProjectRootManager.getInstance(environment.project).projectSdk?: throw RuntimeException("No Compiler found")
        if(sdk.sdkType !is KatajaCompiler) throw RuntimeException("Expected Kataja Compiler")
        var sdkHomePath = sdk.homePath ?: throw RuntimeException("Compiler home path not found")
        sdkHomePath = (sdkHomePath + "\\" + File(sdkHomePath).listFiles()?.get(0)?.name)

        val commandLine = GeneralCommandLine("java").withParameters("-jar").withParameters(sdkHomePath).withParameters("-q").withParameters("-o").withParameters(CompilerProjectExtension.getInstance(environment.project)?.compilerOutputUrl!!.substring(7)).withParameters("-c")

        for(module in ModuleManager.getInstance(environment.project).modules) for(srcFolder in ModuleRootManager.getInstance(module).sourceRoots) commandLine.withParameters(srcFolder.path)

        if((environment.runProfile as KatajaRunConfiguration).options.getMainClass() == null || (environment.runProfile as KatajaRunConfiguration).options.getMainClass()!!.isEmpty()) throw RuntimeException("Main Class is not specified")

        commandLine.withParameters("-e").withParameters((environment.runProfile as KatajaRunConfiguration).options.getMainClass()!!)

        val consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(environment.project).console
        val processHandler = OSProcessHandler(commandLine)

        consoleView.attachToProcess(processHandler)

        return DefaultExecutionResult(consoleView, processHandler).processHandler
    }
}