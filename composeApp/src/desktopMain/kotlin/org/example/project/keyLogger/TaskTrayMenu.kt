package org.example.project.keyLogger

import java.awt.MenuItem
import java.awt.PopupMenu
import java.awt.event.ActionListener
import kotlin.system.exitProcess

class TaskTrayMenu : PopupMenu() {
    init {
        class Menu(menuString: String) : MenuItem(menuString) {
            override fun addActionListener(l: ActionListener?) {
                super.addActionListener {
                    exitProcess(0)
                }
            }
        }

        val menu = Menu("終了")
        add(menu).addActionListener {
            exitProcess(0)
        }
    }
}
