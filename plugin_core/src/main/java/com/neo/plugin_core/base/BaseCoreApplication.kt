package com.neo.plugin_core.base

import android.app.Application
import com.neo.plugin_core.manager.CoreActivitysManager

/**
 * @author: hongyaming
 * @date: Create in 2:30 PM 2020/4/15
 * @description: please add a description here
 */
open class BaseCoreApplication : Application() {
    companion object{
        lateinit var context : Application
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        CoreActivitysManager.instance.init(this)
    }
}