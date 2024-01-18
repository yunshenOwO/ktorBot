package com.yunshen

import com.yunshen.plugins.RobotLogger.logger
import com.yunshen.plugins.configureRouting
import com.yunshen.plugins.configureSecurity
import com.yunshen.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*


fun main() {
    logger.info("启动成功")
    embeddedServer(Tomcat, port = 5701, module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureRouting()
}
