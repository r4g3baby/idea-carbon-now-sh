package dev.ruipereira.idea.carbonnowsh.settings

import com.intellij.openapi.components.service
import com.intellij.openapi.options.SearchableConfigurable
import dev.ruipereira.idea.carbonnowsh.CarbonBundle.message
import dev.ruipereira.idea.carbonnowsh.settings.ui.CarbonSettingsComponent
import javax.swing.JComponent

class CarbonSettingsConfigurable : SearchableConfigurable {
    private val settingsState = service<CarbonSettingsState>()
    private val settingsComponent by lazy { CarbonSettingsComponent() }

    override fun getDisplayName(): String {
        return message("name")
    }

    override fun getId(): String {
        return displayName
    }

    override fun createComponent(): JComponent {
        return settingsComponent.panel
    }

    override fun isModified(): Boolean {
        return settingsComponent.trimIndent != settingsState.trimIndent ||
                settingsComponent.showNotifications != settingsState.showNotifications ||
                settingsComponent.carbonBaseUrl != settingsState.carbonBaseUrl
    }

    override fun apply() {
        settingsState.trimIndent = settingsComponent.trimIndent
        settingsState.showNotifications = settingsComponent.showNotifications
        settingsState.carbonBaseUrl = settingsComponent.carbonBaseUrl
    }

    override fun reset() {
        settingsComponent.trimIndent = settingsState.trimIndent
        settingsComponent.showNotifications = settingsState.showNotifications
        settingsComponent.carbonBaseUrl = settingsState.carbonBaseUrl
    }
}