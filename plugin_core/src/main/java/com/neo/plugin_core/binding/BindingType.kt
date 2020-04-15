package com.neo.plugin_core.binding

import android.view.View
import androidx.lifecycle.ViewModel
import com.neo.plugin_core.base.BaseCoreViewModel

data class BindingType(val variableId : Int,var viewModelClass: Class<ViewModel>){
    var viewModel : ViewModel? = null
}
