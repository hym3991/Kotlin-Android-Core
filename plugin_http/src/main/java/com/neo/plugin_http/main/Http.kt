package com.neo.plugin_http.main

import com.neo.plugin_http.manager.HttpManager
import okhttp3.internal.http.HttpMethod
import retrofit2.Retrofit
import rx.schedulers.Schedulers
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory




/**
 * @author: hongyaming
 * @date: Create in 10:34 AM 2020/4/20
 * @description: please add a description here
 */
object Http {
    inline fun <reified T> useService() : T = HttpManager.createService(T::class.java)
}