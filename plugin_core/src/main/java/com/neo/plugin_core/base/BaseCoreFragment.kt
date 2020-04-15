package com.neo.plugin_core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * @author: hongyaming
 * @date: Create in 2:27 PM 2020/4/15
 * @description: please add a description here
 */
abstract class BaseCoreFragment<T:BaseCoreViewModel<Any?,Any?>,V: ViewDataBinding>  : Fragment() {

    var viewDataBinding : V? = null
    var viewModel : T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(activity),getLayout(),container,false)
        viewDataBinding?.apply {
            lifecycleOwner = this@BaseCoreFragment
            viewModel = initViewModel()
            setVariable(getBindVMBR(),viewModel)
            viewModel?.onViewBind()
        }
        return viewDataBinding?.root
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initViewModel() : T =
        ViewModelProvider.AndroidViewModelFactory.getInstance(BaseCoreApplication.context).create(getViewModelClass())
    abstract fun getLayout() : Int
    abstract fun getBindVMBR() : Int
    abstract fun getViewModelClass() : Class<T>
}