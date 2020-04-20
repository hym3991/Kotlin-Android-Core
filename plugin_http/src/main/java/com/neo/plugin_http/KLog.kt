package com.neo.plugin_http

import android.util.Log

/**
 * @author: hongyaming
 * @date: Create in 10:16 AM 2020/4/20
 * @description: please add a description here
 */
object KLog {
    val TAG = "KChecker"
    fun e(tag : String,logMsg : String){
        val length : Int = logMsg.length
        val offset = 3000
        if (length > offset) {
            var num = 0
            var i = 0
            while (i < length) {
                num += offset
                if (num > length) num = length
                Log.e(TAG,"<<" + tag + ">> " + logMsg.substring(i, num))
                i += offset
            }
        } else {
            Log.e(TAG, "<<$tag>> $logMsg")
        }
    }
}