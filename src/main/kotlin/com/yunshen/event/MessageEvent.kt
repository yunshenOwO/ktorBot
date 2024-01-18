package com.yunshen.event

import com.yunshen.data.QMessage

interface MessageEvent {
    suspend fun sendMessage(json:QMessage):Boolean
}