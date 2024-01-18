package com.yunshen

import com.yunshen.data.QQEndpoints
import com.yunshen.entity.UrlBuilder
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        val url = UrlBuilder().endpoint(QQEndpoints.SEND_MESSAGE)
            .params("group_id", "hello")
            .params("message", "hello")
            .build()
        println(url)
    }
}
