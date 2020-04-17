package com.hym.kotlin_android_core

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hym.kotlin_android_core.databinding.ActivityMainBinding
import com.neo.plugin_core.base.BaseCoreActivity

class MainActivity : BaseCoreActivity<ActivityMainBinding>() {

    var mainActivityVM : MainActivityVM = bindVM(BR.viewModel)
    var secondVM: SecondVM = bindVM(BR.secondViewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding?.apply {
            mainTitle.setOnClickListener {
                Toast.makeText(this@MainActivity,"click",Toast.LENGTH_LONG).show()
            }
            Log.e("hym","mainActivityVM - >$mainActivityVM")
            Log.e("hym","secondVM - >$secondVM")

            mainActivityVM.settext("hahahahahahaha")
        }
    }
    override fun getLayout(): Int = R.layout.activity_main
}
