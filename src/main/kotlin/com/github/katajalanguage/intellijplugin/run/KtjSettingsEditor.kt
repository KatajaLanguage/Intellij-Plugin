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
        panel = FormBuilder.createFormBuilder().addLabeledComponent("Main Class", mainClassField).panel
    }

    override fun resetEditorFrom(configuration: KatajaRunConfiguration) {
        mainClassField.text = configuration.getOptions().getMainClass().toString()
    }

    override fun applyEditorTo(configuration: KatajaRunConfiguration) {
        configuration.options.setMainClas(mainClassField.text)
    }

    override fun createEditor(): JComponent = panel
}