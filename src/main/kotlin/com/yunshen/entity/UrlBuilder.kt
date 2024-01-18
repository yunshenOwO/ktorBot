package com.yunshen.entity

import com.yunshen.data.QQEndpoints

class UrlBuilder {
    private var host  = "http://127.0.0.1:5700"
    private var qqEndpoints: QQEndpoints? = null
    private var params = mutableMapOf<String, String>()

    fun params(value: String, key:String):UrlBuilder{
        params[value] = key
        return this
    }

    fun endpoint(qqEndpoint: QQEndpoints):UrlBuilder{
        this.qqEndpoints = qqEndpoint
        return this
    }


    fun build():String{
        var paramsUrl = "?"
        val lens = this.params.size
        var target = 0
        for ((v,k) in this.params){
            target+=1
            paramsUrl = if (target == lens){
                "$paramsUrl$v=$k"
            }else{
                "$paramsUrl$v=$k&"
            }

        }
        return "$host/${this.qqEndpoints?.endpoints}" + paramsUrl
    }

}