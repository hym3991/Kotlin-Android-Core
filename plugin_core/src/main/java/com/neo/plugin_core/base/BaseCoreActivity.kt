package com.neo.plugin_core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.neo.plugin_core.binding.AutoBinding
import com.neo.plugin_core.manager.VMJumpModel
import com.neo.plugin_core.manager.jump

/**
 * @author: hongyaming
 * @date: Create in 2:27 PM 2020/4/15
 * @description: please add a description here
 */
abstract class BaseCoreActivity<V:ViewDataBinding> : AppCompatActivity(),AutoBinding.AutoBindingImpl {

    var viewDataBinding : V? = null
    var autoBinding : AutoBinding<V> by AutoBinding(this)

    var test : () -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<V>(this,getLayout())
        autoBinding.viewDataBinding = viewDataBinding
        autoBinding.autoBindingImpl = this
    }

    override fun jumpListener(model: VMJumpModel) {
        jump(model)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun getLayout() : Int

    inline fun <reified VM : BaseCoreViewModel<*>> bindVM(variableId : Int) : VM = autoBinding.bindVM(variableId,VM::class.java) as VM
}