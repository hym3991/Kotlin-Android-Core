package com.neo.plugin_core.binding

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neo.plugin_core.base.BaseCoreApplication
import com.neo.plugin_core.base.BaseCoreViewModel
import kotlin.reflect.KProperty

/**
 * @author: hongyaming
 * @date: Create in 5:13 PM 2020/4/15
 * @description: please add a description here
 */
class AutoBinding<V:ViewDataBinding>(private val owner: LifecycleOwner, val viewDataBinding: V?, val list: ArrayList<BindingType>) {

    operator fun getValue(thisRef:Any?, property: KProperty<*>)  = this

    //必须 - setValue
    operator fun setValue(thisRef:Any?, property: KProperty<*>, value: Any) {
        viewDataBinding?.apply {
            list.forEach {
                val viewModel = initViewModel(it.viewModelClass)
                setVariable(it.variableId, viewModel)
                lifecycleOwner = owner
                if (viewModel is BaseCoreViewModel<*,*>){
                    viewModel.onViewBind()
                }
                it.viewModel = viewModel
            }
        }
    }

    private fun initViewModel(viewModelClass: Class<ViewModel>) : ViewModel =
        ViewModelProvider.AndroidViewModelFactory.getInstance(BaseCoreApplication.context).create(viewModelClass)

    fun <M:BaseCoreViewModel<*,*>>getViewModel() : M{
        list.forEach {

        }
    }



}