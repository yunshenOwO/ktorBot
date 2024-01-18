package com.yunshen.entity

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class BotInfo (
    val version:String,
    val author:String = "云深不知处"
)