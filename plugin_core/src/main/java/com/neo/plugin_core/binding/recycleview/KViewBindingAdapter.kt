package com.neo.plugin_core.binding.recycleview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.neo.plugin_core.base.BaseCoreActivity
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * @author: hongyaming
 * @date: Create in 2:31 PM 2020/4/20
 * @description: please add a description here
 */
class KViewBindingAdapter {
    @BindingAdapter(
        value = [ "itemBinding", "items", "adapter"],
        requireAll = false
    )
    fun <T> setAdapter(recyclerView: RecyclerView, itemBinding: ItemBinding<in T>?, items: List<T>?, adapter: KRecycleViewAdapter<T>?){
        require(itemBinding != null) { "itemBinding or typePool must not be null" }
        val oldAdapter : KRecycleViewAdapter<*> ?= recyclerView.adapter as KRecycleViewAdapter<*>?
        val useAdapter = adapter?: oldAdapter ?: KRecycleViewAdapter<T>()
        recyclerView.adapter = useAdapter.apply {
            this.itemBinding = itemBinding
            this.setItems(items as List<Nothing>?)
            this.bindJump = recyclerView.context as BaseCoreActivity<*>
        }
    }

    @BindingAdapter("layoutManager")
    fun setLayoutManager(recyclerView: RecyclerView,layoutManagerFactory: KLayoutManagers.LayoutManagerFactory){
        recyclerView.layoutManager = layoutManagerFactory.create(recyclerView)
    }
}
