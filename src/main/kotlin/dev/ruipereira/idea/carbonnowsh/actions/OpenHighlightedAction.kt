package dev.ruipereira.idea.carbonnowsh.actions

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.components.service
import dev.ruipereira.idea.carbonnowsh.CarbonNowSh

class OpenHighlightedAction : AnAction() {
    private val carbonNowSh = service<CarbonNowSh>()

    override fun actionPerformed(e: AnActionEvent) {
        e.getData(PlatformDataKeys.EDITOR)?.also { editor ->
            editor.selectionModel.selectedText?.also { selectedText ->
                if (selectedText.isBlank()) return

                carbonNowSh.openInCarbon(selectedText)
            }
        }
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(PlatformDataKeys.EDITOR)

        e.presentation.apply {
            isVisible = editor != null
            isEnabled = !editor?.selectionModel?.selectedText.isNullOrBlank()
        }
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }
}