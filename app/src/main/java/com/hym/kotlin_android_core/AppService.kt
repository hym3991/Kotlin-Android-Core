package com.hym.kotlin_android_core

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author: hongyaming
 * @date: Create in 11:21 AM 2020/4/20
 * @description: please add a description here
 */
interface AppService {
    @POST
    fun login(@Body map : HashMap<*,*>) : Call<LoginResult>
}