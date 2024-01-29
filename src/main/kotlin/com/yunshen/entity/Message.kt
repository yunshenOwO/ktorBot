package com.yunshen.entity

import com.yunshen.data.QQEndpoints
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object Message {

    suspend fun sendGroupMessage(groupId:String, message:String){
        val url = UrlBuilder().endpoint(QQEndpoints.SEND_MESSAGE)
            .params("group_id", groupId)
            .params("message", message)
            .build()
        val response  = sendRequest(url)
        println("发送成功: $response")
    }

    suspend fun sign(groupId: String){
        val url = UrlBuilder().endpoint(QQEndpoints.SEND_GROUP_SIGN)
            .params("group_id", groupId)
            .build()
        sendRequest(url)
    }

    suspend fun friendList():String{
        val url  = UrlBuilder().endpoint(QQEndpoints.GET_FRIEND_LIST)
            .build()
        return sendRequest(url)
    }
    @Suppress("unused")
    suspend fun botInfo(){
        val url = UrlBuilder()
            .endpoint(QQEndpoints.GET_LOG_INFO)
            .build()
        sendRequest(url)
    }
    private suspend fun sendRequest(url:String):String{
        val client  =HttpClient()
        val result = coroutineScope {
            async {
                client.get(url)
            }
        }
        return result.await().bodyAsText()
    }

    @Suppress("unused")
    suspend fun deleteFriend(userId:String):String{
        val url = UrlBuilder().endpoint(QQEndpoints.DELETE_FRIEND)
            .params("user_id", userId)
            .build()
        return sendRequest(url)
    }

    @Suppress("unused")
    suspend fun sendPrivateMsg(userId: String, groupId: String, message: String){
        val url = UrlBuilder().endpoint(QQEndpoints.SEND_PRIVATE_MSG)
            .params("group_id", groupId)
            .params("user_id", userId)
            .params("message", message)
            .build()
        sendRequest(url)
    }
}
