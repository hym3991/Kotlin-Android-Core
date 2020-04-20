package com.neo.plugin_http.config

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * @author: hongyaming
 * @date: Create in 11:14 AM 2020/4/20
 * @description: please add a description here
 */
class KCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        TODO("Not yet implemented")
    }
}