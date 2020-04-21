package com.neo.plugin_http.main

import com.neo.plugin_http.manager.HttpManager

/**
 * @author: hongyaming
 * @date: Create in 10:34 AM 2020/4/20
 * @description: please add a description here
 */
object Http {
    inline fun <reified T> useService() : T = HttpManager.createService(T::class.java)
}