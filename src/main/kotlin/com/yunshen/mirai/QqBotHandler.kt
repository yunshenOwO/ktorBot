package com.yunshen.mirai

import net.mamoe.mirai.event.EventHandler
import net.mamoe.mirai.event.ListenerHost
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.message.data.At

class QqBotHandler : ListenerHost {
    @EventHandler
    suspend fun onGroupMessage(groupMessageEvent: GroupMessageEvent, event:MessageEvent){

        if (groupMessageEvent.message.contains(At(groupMessageEvent.bot.id))){
            val groupMessage = groupMessageEvent.message.contentToString()
            event.subject.sendMessage(groupMessage)
        }
    }
}