package com.neo.plugin_core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.neo.plugin_core.impl.BaseCoreViewModelImpl

/**
 * @author: hongyaming
 * @date: Create in 2:28 PM 2020/4/15
 * @description: please add a description here
 */
class BaseCoreViewModel<Q , S>(requestModel : Q?,resultModel : S?) : ViewModel() ,
    BaseCoreViewModelImpl {

    override fun onViewBind() {
    }

    override fun onViewDestory() {
    }

    override fun requestData() {
    }

    override fun refreshNewData() {
    }
}