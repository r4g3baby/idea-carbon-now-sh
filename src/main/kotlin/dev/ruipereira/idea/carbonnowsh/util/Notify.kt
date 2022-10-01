package dev.ruipereira.idea.carbonnowsh.util

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

object Notify {
    private const val NOTIFICATION_GROUP_ID = "CarbonNowSh"

    fun info(project: Project?, content: String) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup(NOTIFICATION_GROUP_ID)
            .createNotification(content, NotificationType.INFORMATION)
            .notify(project)
    }
}