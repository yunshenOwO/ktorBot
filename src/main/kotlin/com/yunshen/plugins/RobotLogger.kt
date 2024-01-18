package com.yunshen.plugins

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object RobotLogger {
    val logger: Logger = LoggerFactory.getLogger("qqbot")
    init {
        val banner = """
        ___  __    ________  ________  ________  ________  _________   
    |\  \|\  \ |\   __  \|\   __  \|\   __  \|\   __  \|\___   ___\ 
    \ \  \/  /|\ \  \|\  \ \  \|\  \ \  \|\ /\ \  \|\  \|___ \  \_| 
    \ \   ___  \ \  \\\  \ \  \\\  \ \   __  \ \  \\\  \   \ \  \  
    \ \  \\ \  \ \  \\\  \ \  \\\  \ \  \|\  \ \  \\\  \   \ \  \ 
    \ \__\\ \__\ \_____  \ \_____  \ \_______\ \_______\   \ \__\
    \|__| \|__|\|___| \__\|___| \__\|_______|\|_______|    \|__|
                    \|__|     \|__|                            
                github: 
        """.trimIndent()
        println(banner)

    }
}