package com.github.katajalanguage.intellijplugin.run

import com.intellij.execution.RunManager
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.ProgramRunner
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys


class KatajaRunAction: AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project
        val file = event.dataContext.getData(CommonDataKeys.VIRTUAL_FILE)

        if (project == null || file == null) {
            return
        }

        val runManager = RunManager.getInstance(project)
        val configuration = runManager.createConfiguration(file.name, KatajaConfigurationFactory(KatajaRunConfigurationType()))

        (configuration.configuration as KatajaRunConfiguration).options.setMainClass(file.path.substring(0, file.path.length - 4))

        runManager.addConfiguration(configuration)
        runManager.selectedConfiguration = runManager.findSettings(configuration.configuration)
        ProgramRunner.getRunner(DefaultRunExecutor.EXECUTOR_ID, configuration.configuration)?.execute(ExecutionEnvironment(DefaultRunExecutor.getRunExecutorInstance() ,ProgramRunner.getRunner(DefaultRunExecutor.EXECUTOR_ID, configuration.configuration)!!, configuration, project))
    }

    override fun update(event: AnActionEvent) {
        val file = event.getData(CommonDataKeys.VIRTUAL_FILE)
        event.presentation.isEnabledAndVisible = file != null && file.fileType.name == "Kataja File"
    }

    /*
        // Setze spezifische Parameter für deine Run-Konfiguration
        if (configuration instanceof MyRunConfiguration) {
            ((MyRunConfiguration) configuration).setFilePath(file.getPath());
        }

        // Füge die Konfiguration zu RunManager hinzu und setze sie als ausgewählte Konfiguration
        runManager.addConfiguration(configuration);
        runManager.setSelectedConfiguration(runManager.findSettings(configuration));

        // Starte die Konfiguration
        ProgramRunner<?> runner = ProgramRunner.getRunner(DefaultRunExecutor.EXECUTOR_ID, configuration);
        if (runner != null) {
            try {
                runner.execute(DefaultRunExecutor.getRunExecutorInstance(), new ExecutionEnvironment(configuration, project));
            } catch (Exception e) {
                e.printStackTrace();
                Messages.showErrorDialog(project, "Fehler beim Starten der Run-Konfiguration", "Error");
            }
        }
    }
     */
}