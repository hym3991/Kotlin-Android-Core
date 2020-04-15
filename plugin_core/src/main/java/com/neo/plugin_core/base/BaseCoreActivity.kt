package com.neo.plugin_core.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.neo.plugin_core.binding.AutoBinding

/**
 * @author: hongyaming
 * @date: Create in 2:27 PM 2020/4/15
 * @description: please add a description here
 */
abstract class BaseCoreActivity<V:ViewDataBinding> : AppCompatActivity() {

    var viewDataBinding : V? = null

    var autoBinding : AutoBinding<V> by AutoBinding(this,viewDataBinding, this.getViewModelBind())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<V>(this,getLayout())
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun getViewModel(className : Class<BaseCoreViewModel<*,*>>) = autoBinding.getViewModel(className)

    abstract fun getLayout() : Int
    abstract fun getViewModelBind() : ArrayList<AutoBinding.BindingType>

    inline fun <reified T : Activity> Context.startActivity(){
        val intent = Intent(this,T :: class.java)
        startActivity(intent)
    }
}