package com.hym.kotlin_android_core

import android.os.Bundle
import android.util.Log
import com.hym.kotlin_android_core.databinding.ActivitySecondBinding
import com.neo.plugin_core.base.BaseCoreActivity

/**
 * @author: hongyaming
 * @date: Create in 3:44 PM 2020/4/17
 * @description: please add a description here
 */
class SecondActivity : BaseCoreActivity<ActivitySecondBinding>() {

    var secondVM : SecondVM = bindVM(BR.viewModel)

    override fun getLayout(): Int = R.layout.activity_second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hym","$secondVM")
    }
}