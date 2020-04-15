package com.neo.plugin_core.impl

/**
 * @author: hongyaming
 * @date: Create in 2:29 PM 2020/4/15
 * @description: please add a description here
 */
interface BaseCoreViewModelImpl {
    fun onViewBind()
    fun onViewDestory()
    fun refreshNewData()
    fun requestData()
}