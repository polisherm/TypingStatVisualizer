package org.example.project.keyLogger

import java.awt.Image
import java.awt.TrayIcon

class TaskTrayItem(image: Image) : TrayIcon(image) {
    init {
        popupMenu = TaskTrayMenu()
    }

    fun displayMessage(text: String) {
        super.displayMessage("message", text, MessageType.INFO)
        println("Start!")
    }
}
