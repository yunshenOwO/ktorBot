package com.yunshen.event.plugin

import com.yunshen.data.QMessage
import com.yunshen.entity.BotPlugin
import com.yunshen.entity.Message
import com.yunshen.event.MessageEvent

@BotPlugin
class SignIn:MessageEvent {
    override suspend fun sendMessage(json: QMessage): Boolean {
        if (json.post_type == "message"&& json.message == "签到"){
            Message.sign(json.group_id)
        }
        return true
    }
}