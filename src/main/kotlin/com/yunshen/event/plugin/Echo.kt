package com.yunshen.event.plugin

import com.yunshen.data.QMessage
import com.yunshen.entity.BotPlugin
import com.yunshen.entity.Message
import com.yunshen.event.MessageEvent


@BotPlugin
class Echo :MessageEvent{

    override suspend fun sendMessage(json: QMessage): Boolean {
        if ( json.post_type == "message" && json.message.startsWith("echo")){
            Message.sendGroupMessage(json.group_id, json.message)
            return true
        }else{
            return false
        }
    }
}