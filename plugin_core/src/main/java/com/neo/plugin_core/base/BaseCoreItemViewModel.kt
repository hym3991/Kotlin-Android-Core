package com.neo.plugin_core.base

import androidx.databinding.ViewDataBinding

/**
 * @author: hongyaming
 * @date: Create in 4:53 PM 2020/4/20
 * @description: please add a description here
 */
class BaseCoreItemViewModel<T> : BaseCoreViewModel<T>() {
    var position : Int ?= null
    var count : Int ?= null
    var viewDataBinding : ViewDataBinding ?= null
}