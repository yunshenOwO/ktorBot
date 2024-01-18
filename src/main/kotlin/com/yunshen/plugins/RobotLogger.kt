package com.yunshen.plugins

import com.yunshen.entity.BotInfo
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object RobotLogger {
    val logger: Logger = LoggerFactory.getLogger("qqbot")
    init {
        val kClass = Class.forName("com.yunshen.ApplicationKt")
        val botInfo = kClass.getMethod("main").getAnnotation(BotInfo::class.java)
        val version = botInfo.version
        val author = botInfo.author
        val banner = """
        ___  __    ________  ________  ________  ________  _________   
    |\  \|\  \ |\   __  \|\   __  \|\   __  \|\   __  \|\___   ___\ 
    \ \  \/  /|\ \  \|\  \ \  \|\  \ \  \|\ /\ \  \|\  \|___ \  \_| 
    \ \   ___  \ \  \\\  \ \  \\\  \ \   __  \ \  \\\  \   \ \  \  
    \ \  \\ \  \ \  \\\  \ \  \\\  \ \  \|\  \ \  \\\  \   \ \  \ 
    \ \__\\ \__\ \_____  \ \_____  \ \_______\ \_______\   \ \__\
    \|__| \|__|\|___| \__\|___| \__\|_______|\|_______|    \|__|
                    \|__|     \|__|                            
github: https://github.com/yunshenOwO/ktorBot  version: $version  作者: $author
        """.trimIndent()
        println(banner)

    }
}