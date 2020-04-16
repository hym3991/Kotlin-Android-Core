package com.neo.plugin_http.manager

import okhttp3.OkHttpClient

/**
 * Created by Neo on 2020/4/16.
 * Description :
 */
class HttpManager {
    private fun initOkHttpClient(serviceName : String){
        var builder : OkHttpClient.Builder
        builder.connectTimeout(HttpCon)
    }

}