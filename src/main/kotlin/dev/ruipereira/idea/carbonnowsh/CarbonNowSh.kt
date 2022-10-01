package dev.ruipereira.idea.carbonnowsh

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import dev.ruipereira.idea.carbonnowsh.CarbonBundle.message
import dev.ruipereira.idea.carbonnowsh.settings.CarbonSettingsState
import dev.ruipereira.idea.carbonnowsh.util.Notify
import java.net.URLEncoder

@Service
class CarbonNowSh {
    companion object {
        const val BASE_URL = "https://carbon.now.sh"
    }

    private val settings = service<CarbonSettingsState>()

    fun openInCarbon(content: String) {
        var code = content
        if (settings.trimIndent) {
            code = code.trimIndent()
        }

        val url = "${settings.carbonBaseUrl}?code=${URLEncoder.encode(code, Charsets.UTF_8)}"
        BrowserUtil.browse(url)

        if (settings.showNotifications) {
            Notify.info(null, message("notification.browser"))
        }
    }
}