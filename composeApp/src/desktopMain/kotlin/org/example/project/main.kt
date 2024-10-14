package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KeyboardHeatMap",
    ) {
        App()

        val file = File("KeyLog.txt")
        JpKeyLogParser(file).parse()
    }
}
