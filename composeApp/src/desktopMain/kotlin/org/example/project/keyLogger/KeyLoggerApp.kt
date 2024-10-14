package org.example.project.keyLogger

import org.jnativehook.GlobalScreen
import org.slf4j.LoggerFactory
import java.awt.SystemTray
import java.awt.image.BufferedImage
import java.util.logging.Level
import java.util.logging.LogManager
import java.util.logging.Logger
import javax.imageio.ImageIO

fun main() {
    initialize()

    LoggerFactory.getLogger("KeyLogger.class").info("Key logger has benn started.")

    GlobalScreen.registerNativeHook()
    GlobalScreen.addNativeKeyListener(KeyLogger())
}

fun initialize() {
    // Supress console log of jnativehook.
    LogManager.getLogManager().reset()

    // Set the location of log4j configuration file.
    System.setProperty("log4j.configurationFile", "desktopMain/resources/log4j2.xml")

    val logger = Logger.getLogger(GlobalScreen::class.java.packageName)
    logger.level = Level.WARNING

    logger.useParentHandlers = false

    val resourceName = "KeyLoggerIcon.png"
    val image = loadImageFromResources(resourceName)
    if (image != null) {
        val trayItem = TaskTrayItem(image).also { it.displayMessage("Start!") }
        SystemTray.getSystemTray().add(trayItem)
    }
}

fun loadImageFromResources(resourceName: String): BufferedImage? {
    return try {
        val resource = Thread.currentThread().contextClassLoader.getResource(resourceName)

        if (resource == null) {
            println("Resource not found: $resourceName")
            null
        } else {
            ImageIO.read(resource)
        }
    } catch (e: Exception) {
        println("Failed to load image: ${e.message}")
        null
    }
}
