package com.neo.plugin_core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.neo.plugin_core.binding.AutoBinding
import com.neo.plugin_core.manager.VMJumpModel
import com.neo.plugin_core.manager.jump

/**
 * @author: hongyaming
 * @date: Create in 2:27 PM 2020/4/15
 * @description: please add a description here
 */
abstract class BaseCoreFragment<V: ViewDataBinding>  : Fragment() ,AutoBinding.AutoBindingImpl {

    var viewDataBinding : V? = null
    var autoBinding : AutoBinding<V> by AutoBinding(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(activity),getLayout(),container,false)
        autoBinding.viewDataBinding = viewDataBinding
        autoBinding.autoBindingImpl = this
        return viewDataBinding?.root
    }

    override fun jumpListener(model: VMJumpModel) {
        jump(model)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    abstract fun getLayout() : Int
    inline fun <reified VM : BaseCoreViewModel<*>> bindVM(variableId : Int) : VM = autoBinding.bindVM(variableId,VM::class.java) as VM
}