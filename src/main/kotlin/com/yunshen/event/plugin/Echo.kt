package com.yunshen.event.plugin

import com.google.gson.Gson
import com.yunshen.data.FriendData
import com.yunshen.data.QMessage
import com.yunshen.entity.BotPlugin
import com.yunshen.entity.Message
import com.yunshen.event.MessageEvent


@BotPlugin
class Echo :MessageEvent{

    override suspend fun sendMessage(json: QMessage): Boolean {
        if ( json.post_type == "message" && json.message.startsWith("echo")){
            val friendData = Gson().fromJson(Message.friendList(), FriendData::class.java)
            for (friend in friendData.data){
                Message.sendGroupMessage(json.group_id, friend.nickname)
            }
            Message.sendGroupMessage(json.group_id, json.message)
            return true
        }else{
            return false
        }
    }
}