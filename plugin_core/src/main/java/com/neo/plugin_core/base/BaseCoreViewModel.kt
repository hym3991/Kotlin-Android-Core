package com.neo.plugin_core.base

import androidx.lifecycle.*
import com.neo.plugin_core.impl.BaseCoreViewModelImpl
import com.neo.plugin_core.manager.VMJumpModel

/**
 * @author: hongyaming
 * @date: Create in 2:28 PM 2020/4/15
 * @description: please add a description here
 */
open class BaseCoreViewModel<T> : ViewModel() ,
    BaseCoreViewModelImpl,LifecycleObserver {
    var model : T? = null
    var jump : MutableLiveData<VMJumpModel> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onViewBind() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onViewDestory() {
    }

    override fun requestData() {
    }

    override fun refreshNewData() {
    }

}