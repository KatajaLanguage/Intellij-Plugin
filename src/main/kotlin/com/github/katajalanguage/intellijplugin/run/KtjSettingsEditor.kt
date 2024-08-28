package com.github.katajalanguage.intellijplugin.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.FormBuilder
import javax.swing.*

class KtjSettingsEditor: SettingsEditor<KatajaRunConfiguration>() {

    private val panel: JPanel
    private val mainClassField = TextFieldWithBrowseButton()

    init{
        mainClassField.addBrowseFolderListener("Select Main Class", null, null, FileChooserDescriptorFactory.createSingleFileDescriptor())
        panel = FormBuilder.createFormBuilder().addLabeledComponent("Main class", mainClassField).panel
    }

    override fun resetEditorFrom(configuration: KatajaRunConfiguration) {
        mainClassField.text = configuration.getMainClass()!!
    }

    override fun applyEditorTo(configuration: KatajaRunConfiguration) {
        configuration.setMainClass(mainClassField.text)
    }

    override fun createEditor(): JComponent = panel
}