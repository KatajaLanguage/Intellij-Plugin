package com.github.katajalanguage.intellijplugin.run

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment

class KatajaCommandLineState(private val environment: ExecutionEnvironment): CommandLineState(environment) {

    override fun startProcess(): ProcessHandler {
        TODO("Not yet implemented")
    }

    /*override fun execute(executor: Executor?, programRunner: ProgramRunner<*>): ExecutionResult {
        val consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(environment.project).console
        val processHandler = OSProcessHandler(GeneralCommandLine(""))

        consoleView.attachToProcess(processHandler)
        CommandLineState

        return DefaultExecutionResult(consoleView, processHandler)
    }
        // Finde das SDK, das dem Modul zugeordnet ist
        Module module = ModuleUtilCore.findModuleForFile(file, project);
        if (module == null) {
            throw new IllegalStateException("Kein Modul gefunden.");
        }

        // SDK des Moduls abrufen
        Sdk sdk = ModuleUtilCore.getSdk(module);
        if (sdk == null) {
            throw new IllegalStateException("Kein SDK gefunden.");
        }

        // Pfad zum Compiler (SDK)
        String sdkPath = sdk.getHomePath();
        if (sdkPath == null) {
            throw new IllegalStateException("SDK-Pfad ist ungültig.");
        }

        try {
            // Beispiel: Verwende den Compiler im SDK, um den Quellcode zu kompilieren
            Class<?> compilerClass = Class.forName("path.to.compiler.Main", true, new URLClassLoader(new URL[] { new File(sdkPath).toURI().toURL() }));

            Method compileMethod = compilerClass.getMethod("compile", String.class);

            // Der Pfad zur Quellcode-Datei
            String sourcePath = file.getPath();

            // Kompiliere den Quellcode
            Object compilerInstance = compilerClass.getDeclaredConstructor().newInstance();
            compileMethod.invoke(compilerInstance, sourcePath);

            // Nach der Kompilierung kann das Programm ausgeführt werden
            runProgram();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runProgram() {
        // Hier sollte die Logik zur Ausführung des kompilierten Programms kommen.
        // Zum Beispiel kannst du ein Prozessobjekt starten:
        try {
            Process process = new ProcessBuilder("path_to_executable").start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
}