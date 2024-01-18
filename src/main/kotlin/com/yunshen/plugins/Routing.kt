package com.yunshen.plugins

import com.google.gson.Gson
import com.yunshen.data.QMessage
import com.yunshen.event.Subject
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        post("/") {
            val sjson:String =  call.receiveText()
            val json = Gson().fromJson(sjson, QMessage::class.java)
            Subject(json)
            call.respond(HttpStatusCode.OK, "ok")
        }
    }
}