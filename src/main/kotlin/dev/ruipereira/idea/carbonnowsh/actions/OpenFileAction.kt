package dev.ruipereira.idea.carbonnowsh.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.components.service
import dev.ruipereira.idea.carbonnowsh.CarbonNowSh

class OpenFileAction : AnAction() {
    private val carbonNowSh = service<CarbonNowSh>()

    override fun actionPerformed(e: AnActionEvent) {
        e.getData(PlatformDataKeys.VIRTUAL_FILE)?.also { virtualFile ->
            val fileContents = virtualFile.contentsToByteArray().toString(virtualFile.charset)
            if (fileContents.isBlank()) return

            carbonNowSh.openInCarbon(fileContents)
        }
    }

    override fun update(e: AnActionEvent) {
        val virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE)

        e.presentation.isEnabledAndVisible = virtualFile != null
    }
}