package com.github.katajalanguage.intellijplugin.run

import com.intellij.openapi.options.SettingsEditor
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class KatajaSettingsEditor: SettingsEditor<KatajaRunConfiguration>() {

    private val panel: JPanel

    init{
        panel = JPanel()
        panel.add(JLabel("test"))
    }

    override fun resetEditorFrom(configuration: KatajaRunConfiguration){}

    override fun applyEditorTo(editor: KatajaRunConfiguration){}

    override fun createEditor(): JComponent = panel
}