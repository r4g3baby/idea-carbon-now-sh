package dev.ruipereira.idea.carbonnowsh.settings.ui

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.panel
import dev.ruipereira.idea.carbonnowsh.CarbonBundle.message
import dev.ruipereira.idea.carbonnowsh.CarbonNowSh
import javax.swing.JPanel

class CarbonSettingsComponent {
    private lateinit var trimIndentCheckBox: JBCheckBox
    private lateinit var showNotificationsCheckbox: JBCheckBox

    private lateinit var carbonBaseUrlTextField: JBTextField

    val panel: JPanel = panel {
        group(message("settings.general")) {
            row {
                trimIndentCheckBox = checkBox(message("settings.general.trimIndent")).component
            }
            row {
                showNotificationsCheckbox = checkBox(message("settings.general.showNotifications")).component
            }
        }

        group(message("settings.carbonUrl")) {
            row {
                carbonBaseUrlTextField = textField().resizableColumn().align(AlignX.FILL).component

                button(message("settings.carbonUrl.default")) {
                    carbonBaseUrlTextField.text = CarbonNowSh.BASE_URL
                }.align(AlignX.RIGHT).component
            }
        }
    }

    var trimIndent: Boolean
        get() = trimIndentCheckBox.isSelected
        set(value) {
            trimIndentCheckBox.isSelected = value
        }

    var showNotifications: Boolean
        get() = showNotificationsCheckbox.isSelected
        set(value) {
            showNotificationsCheckbox.isSelected = value
        }

    var carbonBaseUrl: String
        get() = carbonBaseUrlTextField.text
        set(value) {
            carbonBaseUrlTextField.text = value
        }
}