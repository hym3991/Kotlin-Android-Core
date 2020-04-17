package com.neo.plugin_layout.auto.main

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import com.neo.plugin_layout.LayoutUtils.getScreenSize

/**
 * Created by zhy on 15/11/18.
 */
class AutoLayoutConifg private constructor() {
    var screenWidth = 0
        private set
    var screenHeight = 0
        private set
    var designWidth = 0
        private set
    var designHeight = 0
        private set
    private var useDeviceSize = false
    var screenOriatation = 0
        private set

    fun checkParams() {
        if (designHeight <= 0 || designWidth <= 0) {
            throw RuntimeException(
                "you must set $KEY_DESIGN_WIDTH and $KEY_DESIGN_HEIGHT  in your manifest file."
            )
        }
    }

    fun useDeviceSize(): AutoLayoutConifg {
        useDeviceSize = true
        return this
    }

    fun init(context: Context) {
        getMetaData(context)
        val screenSize = getScreenSize(context, useDeviceSize)
        screenWidth = screenSize!![0]
        //mScreenHeight = screenSize[1];
        //取宽度作为基准
        val design = 1.0f * designHeight / designWidth
        val screen = 1.0f * screenSize[1] / screenSize[0]
        if (screen > design) {
            screenHeight = (screenWidth * design).toInt()
        } else {
            screenHeight = screenSize[1]
        }
    }

    private fun getMetaData(context: Context) {
        screenOriatation =
            AutoUtils.getScreenOriatation(context)
        val packageManager = context.packageManager
        val applicationInfo: ApplicationInfo?
        try {
            applicationInfo = packageManager.getApplicationInfo(
                context
                    .packageName, PackageManager.GET_META_DATA
            )
            if (applicationInfo != null && applicationInfo.metaData != null) {
                if (screenOriatation == Configuration.ORIENTATION_PORTRAIT) {
                    designWidth =
                        applicationInfo.metaData[KEY_DESIGN_WIDTH] as Int
                    designHeight =
                        applicationInfo.metaData[KEY_DESIGN_HEIGHT] as Int
                } else if (screenOriatation == Configuration.ORIENTATION_LANDSCAPE) {
                    designWidth =
                        applicationInfo.metaData[KEY_DESIGN_HEIGHT] as Int
                    designHeight =
                        applicationInfo.metaData[KEY_DESIGN_WIDTH] as Int
                } else {
                    designWidth =
                        applicationInfo.metaData[KEY_DESIGN_WIDTH] as Int
                    designHeight =
                        applicationInfo.metaData[KEY_DESIGN_HEIGHT] as Int
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            throw RuntimeException(
                "you must set $KEY_DESIGN_WIDTH and $KEY_DESIGN_HEIGHT  in your manifest file.",
                e
            )
        }
    }

    companion object {
        val instance = AutoLayoutConifg()
        private const val KEY_DESIGN_WIDTH = "design_width"
        private const val KEY_DESIGN_HEIGHT = "design_height"
    }
}