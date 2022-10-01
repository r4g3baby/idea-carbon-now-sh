package dev.ruipereira.idea.carbonnowsh.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import dev.ruipereira.idea.carbonnowsh.CarbonNowSh

@State(name = "CarbonSettingsState", storages = [Storage("carbonNowSh.xml")])
class CarbonSettingsState : PersistentStateComponent<CarbonSettingsState> {
    var trimIndent = true
    var showNotifications = true

    var carbonBaseUrl = CarbonNowSh.BASE_URL

    override fun getState() = this

    override fun loadState(state: CarbonSettingsState) = XmlSerializerUtil.copyBean(state, this)
}