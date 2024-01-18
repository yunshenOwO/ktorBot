package com.yunshen.entity

import com.yunshen.data.QQEndpoints
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

object Message {

    @OptIn(InternalAPI::class)
    suspend fun sendGroupMessage(groupId:String, message:String){
        val client = HttpClient()
        val response = coroutineScope {
            async {
                val url = UrlBuilder().endpoint(QQEndpoints.SEND_MESSAGE)
                    .params("group_id", groupId)
                    .params("message", message)
                    .build()
                client.use {
                    it.get(url)
                }
            }
        }
        println("发送成功: " +response.await().content)
    }

    suspend fun sign(groupId: String){
        val client = HttpClient()
        val result = coroutineScope {
            async {
                val url = UrlBuilder().endpoint(QQEndpoints.SEND_GROUP_SIGN)
                    .params("group_id", groupId)
                    .build()
                client.use {
                    it.get(url)
                }
            }
        }
        result.await()
    }

    @Suppress("unused")
    @OptIn(InternalAPI::class)
    suspend fun friendList():String{
        val client = HttpClient()
        val result = coroutineScope {
            async {
                val url  = UrlBuilder().endpoint(QQEndpoints.GET_FRIEND_LIST)
                    .build()
                client.use {
                    it.get(url)
                }
            }
        }
        return result.await().content.toString()
    }
}
