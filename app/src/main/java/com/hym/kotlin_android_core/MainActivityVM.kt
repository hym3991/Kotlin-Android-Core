package com.hym.kotlin_android_core

import android.util.Log
import androidx.databinding.ObservableField
import com.neo.plugin_core.base.BaseCoreModel
import com.neo.plugin_core.base.BaseCoreViewModel
import java.util.*

/**
 * @author: hongyaming
 * @date: Create in 10:40 AM 2020/4/16
 * @description: please add a description here
 */
class MainActivityVM : BaseCoreViewModel<BaseCoreModel>() {

    var text : ObservableField<String> = ObservableField("1")

    fun settext(str : String){
        Log.e("hym","settext")
        text.set(str)
    }

    override fun onViewBind() {
        super.onViewBind()
        Log.e("hym","MainActivityVM onViewBind")
    }

    override fun onViewDestory() {
        super.onViewDestory()
        Log.e("hym","MainActivityVM onViewDestory")
    }
}