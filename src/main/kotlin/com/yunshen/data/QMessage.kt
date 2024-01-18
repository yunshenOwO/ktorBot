package com.yunshen.data

data class QMessage(
    val anonymous: Any,
    val font: Int,
    val group_id: String,
    val message: String,
    val message_id: Int,
    val message_seq: Int,
    val message_type: String,
    val post_type: String,
    val raw_message: String,
    val self_id: Long,
    val sender: Sender,
    val sub_type: String,
    val time: Int,
    val user_id: String
)

data class Sender(
    val age: Int,
    val area: String,
    val card: String,
    val level: String,
    val nickname: String,
    val role: String,
    val sex: String,
    val title: String,
    val user_id: Long
)