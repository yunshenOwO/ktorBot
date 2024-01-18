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
                client.get(url)
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
                client.get(url)
            }
        }
        result.await()
    }
}
