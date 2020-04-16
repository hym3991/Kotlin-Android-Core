package com.hym.kotlin_android_core

import android.os.Bundle
import android.widget.Toast
import com.hym.kotlin_android_core.databinding.ActivityMainBinding
import com.neo.plugin_core.base.BaseCoreActivity
import com.neo.plugin_core.binding.AutoBinding.BindingType

class MainActivity : BaseCoreActivity<ActivityMainBinding>() {

    lateinit var mainActivityVM : MainActivityVM
    lateinit var secondVM: SecondVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityVM = getViewModel()
        secondVM = getViewModel()
        viewDataBinding?.apply {
            mainTitle.setOnClickListener {
                Toast.makeText(this@MainActivity,"click",Toast.LENGTH_LONG).show()
            }
        }
    }
    override fun getLayout(): Int = R.layout.activity_main
    override fun getViewModelBind(): ArrayList<BindingType>
       = arrayListOf(
            BindingType(BR.viewModel,MainActivityVM::class.java),
            BindingType(BR.secondVM,SecondVM::class.java)
        )
}
