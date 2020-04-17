package com.neo.plugin_core.binding

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neo.plugin_core.base.BaseCoreApplication
import com.neo.plugin_core.base.BaseCoreViewModel
import com.neo.plugin_core.manager.VMJumpModel
import kotlin.reflect.KProperty


/**
 * @author: hongyaming
 * @date: Create in 5:13 PM 2020/4/15
 * @description: please add a description here
 */
class AutoBinding<V:ViewDataBinding>(private val owner: LifecycleOwner) {

    var typeBindArray : ArrayList<BindingType> = arrayListOf()
    var viewDataBinding : V? = null
    set(value) {
        field = value
        typeBindArray.forEach {
            value?.setVariable(it.variableId,it.viewModel)
        }
    }
    var autoBindingImpl : AutoBindingImpl? = null
    set(value) {
        field = value
        typeBindArray.forEach { it ->
            it.viewModel?.jump?.observe(owner, Observer { model ->
                value?.jumpListener(model)
            })
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    operator fun getValue(thisRef:Any?, property: KProperty<*>): AutoBinding<V> {
        viewDataBinding?.apply {
            lifecycleOwner = owner
        }
        return this
    }

    @RequiresApi(Build.VERSION_CODES.N)
    operator fun setValue(thisRef:Any?, property: KProperty<*>, value: Any) {
    }

    private fun initViewModel(viewModelClass: Class<out BaseCoreViewModel<*>>) : BaseCoreViewModel<*> =
        ViewModelProvider.AndroidViewModelFactory.getInstance(BaseCoreApplication.context).create(viewModelClass)

    fun bindVM(variableId : Int,VM : Class<out BaseCoreViewModel<*>>) : ViewModel?{
        val findResult = typeBindArray.find { it.viewModelClass == VM::class.java }
        return if (findResult == null){
            val viewModel = initViewModel(VM)
            typeBindArray.add(BindingType(variableId,VM,viewModel))
            owner.lifecycle.addObserver(viewModel)
            viewModel
        }else{
            findResult.viewModel
        }
    }

    interface AutoBindingImpl{
        fun jumpListener(model : VMJumpModel)
    }

    data class BindingType(val variableId: Int,val viewModelClass: Class<out BaseCoreViewModel<*>>, var viewModel : BaseCoreViewModel<*>?)
}