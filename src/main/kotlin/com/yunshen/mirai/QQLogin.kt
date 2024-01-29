package com.yunshen.mirai

import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.auth.BotAuthorization
import net.mamoe.mirai.utils.BotConfiguration

object QQLogin {
    suspend fun login(){
        val bot = BotFactory.newBot(3115024431L, BotAuthorization.byQRCode()) {
            protocol = BotConfiguration.MiraiProtocol.ANDROID_WATCH
        }
        bot.login()
        bot.eventChannel.registerListenerHost(QqBotHandler())
    }
}