package com.neo.plugin_core.binding

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
class AutoBinding<V:ViewDataBinding>(private val owner: LifecycleOwner, private val list: ArrayList<BindingType>) {

    var viewDataBinding : V? = null

    @RequiresApi(Build.VERSION_CODES.N)
    operator fun getValue(thisRef:Any?, property: KProperty<*>): AutoBinding<V> {
        Log.e("hym","getValue")
        viewDataBinding?.apply {
            list.forEach {
                if (it.viewModel == null) {
                    val viewModel = initViewModel(it.viewModelClass)
                    lifecycleOwner = owner
                    it.viewModel = viewModel
                    owner.lifecycle.addObserver(viewModel)
                    setVariable(it.variableId, viewModel)
                }
            }
        }
        return this
    }

    @RequiresApi(Build.VERSION_CODES.N)
    operator fun setValue(thisRef:Any?, property: KProperty<*>, value: Any) {
    }

    private fun initViewModel(viewModelClass: Class<out BaseCoreViewModel<*>>) : BaseCoreViewModel<*> =
        ViewModelProvider.AndroidViewModelFactory.getInstance(BaseCoreApplication.context).create(viewModelClass)

    fun getViewModel(VM : Class<out BaseCoreViewModel<*>>) : ViewModel? {
        val finds = list.find { it.viewModelClass == VM::class.java }
        return finds?.viewModel
    }

    data class BindingType(val variableId: Int,val viewModelClass: Class<out BaseCoreViewModel<*>>){
        var viewModel : ViewModel? = null
    }
}