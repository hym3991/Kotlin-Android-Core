package com.neo.plugin_http.interceptor

import com.neo.plugin_http.KLog
import okhttp3.*

/**
 * @author: hongyaming
 * @date: Create in 9:59 AM 2020/4/20
 * @description: please add a description here
 */
class HttpTnterceptor(val serviceName: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request  = chain.request()
        //一些处理工作
        //url处理
        val url = parsingUrl(request.url())
        val builder = request.newBuilder().url(url)
        KLog.e("request_url","request url## ：$url")
        //获取body
        if (request.body() is FormBody){
            val body = request.body() as FormBody
            KLog.e("request","request header## ：${body.value(1)}")
        }
        val nreRequest = builder.build()
        return chain.proceed(nreRequest)
    }

    private fun parsingUrl(url: HttpUrl) = url
}