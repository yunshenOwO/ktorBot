package com.yunshen.data

data class FriendData(
    val `data`: List<Data>,
    val message: String,
    val retcode: Int,
    val status: String
)