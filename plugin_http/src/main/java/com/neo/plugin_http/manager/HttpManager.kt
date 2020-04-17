package com.neo.plugin_http.manager

import com.neo.plugin_http.HttpUtils
import com.neo.plugin_http.config.HttpConfig
import com.neo.plugin_http.config.SSLSocketFactoryCompat
import okhttp3.OkHttpClient
import java.time.Duration
import java.time.temporal.Temporal
import java.util.concurrent.TimeUnit

/**
 * Created by Neo on 2020/4/16.
 * Description :
 */
class HttpManager {
    private fun initOkHttpClient(serviceName : String){
        val builder  = OkHttpClient.Builder()
        builder.connectTimeout(HttpConfig.timeOut.toLong(),TimeUnit.SECONDS)
        builder.readTimeout((HttpConfig.timeOut + 5).toLong(),TimeUnit.SECONDS)
        var x509TrustManager = HttpUtils.getX509TrustManager()
        builder.sslSocketFactory(SSLSocketFactoryCompat(x509TrustManager),x509TrustManager)
    }

}