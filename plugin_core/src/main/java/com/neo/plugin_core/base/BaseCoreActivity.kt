package com.neo.plugin_core.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider.*
import com.neo.plugin_core.binding.AutoBinding

/**
 * @author: hongyaming
 * @date: Create in 2:27 PM 2020/4/15
 * @description: please add a description here
 */
abstract class BaseCoreActivity<T:BaseCoreViewModel<Any?,Any?>,V:ViewDataBinding> : AppCompatActivity() {

    var viewDataBinding : V? = null
    var viewModel : T? = null

    var autoBinding : AutoBinding<V> = AutoBinding(this,viewDataBinding, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<V>(this,getLayout())

        viewDataBinding?.apply {
            lifecycleOwner = this@BaseCoreActivity
            viewModel = initViewModel()
            setVariable(getBindVMBR(),viewModel)
            viewModel?.onViewBind()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.onViewDestory()
    }

    private fun initViewModel() : T =
        AndroidViewModelFactory.getInstance(BaseCoreApplication.context).create(getViewModelClass())
    abstract fun getLayout() : Int
    abstract fun getBindVMBR() : Int
    abstract fun getViewModelClass() : Class<T>

    inline fun <reified T : Activity> Context.startActivity(){
        val intent = Intent(this,T :: class.java)
        startActivity(intent)
    }
}