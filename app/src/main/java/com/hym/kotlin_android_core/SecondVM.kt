package com.hym.kotlin_android_core

import android.util.Log
import com.neo.plugin_core.base.BaseCoreModel
import com.neo.plugin_core.base.BaseCoreViewModel
import java.util.*

/**
 * @author: hongyaming
 * @date: Create in 2:15 PM 2020/4/16
 * @description: please add a description here
 */
class SecondVM : BaseCoreViewModel<BaseCoreModel>() {
    override fun onViewBind() {
        super.onViewBind()
        Log.e("hym","SecondVM onViewBind")
    }

    override fun onViewDestory() {
        super.onViewDestory()
        Log.e("hym","SecondVM onViewDestory")
    }
}