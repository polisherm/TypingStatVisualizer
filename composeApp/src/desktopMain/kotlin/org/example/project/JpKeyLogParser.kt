package org.example.project

import java.io.File

class JpKeyLogParser(private val keyLogFile: File) : IKeyLogParser {
    val keyCodeToCount: Map<Int, Int>

    init {
        keyCodeToCount = parse()
    }

    override fun parse(): Map<Int, Int> {
        // 空白区切りでkeycodeを取得する。
        val keyCodes = mutableListOf<Int>()
        keyLogFile.forEachLine { line ->
            // 要素が空白なら削除する。
            val keyCodesString = line.split(" ").filter { it.isNotEmpty() }
            keyCodesString.forEach {
                // String->Int
                val code = it.toInt()
                keyCodes.add(code)
            }
        }

        // 要素をkeyに、要素の数をValueに。
        val keyCodeToCount = keyCodes.groupingBy { it }.eachCount()

        // テスト出力
        keyCodeToCount.forEach { (key, value) ->
            // keycodeをkeytextに変換して出力する。Use NativeKeyEvent.getKeyText()
            println("keycode: ${org.jnativehook.keyboard.NativeKeyEvent.getKeyText(key)}, count: $value")
        }

        return keyCodeToCount
    }
}


