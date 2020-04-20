package com.neo.plugin_core.binding.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.neo.plugin_core.base.BaseCoreActivity
import com.neo.plugin_core.base.BaseCoreItemViewModel
import com.neo.plugin_core.base.BaseCoreViewModel
import me.tatarka.bindingcollectionadapter2.BindingCollectionAdapter
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * @author: hongyaming
 * @date: Create in 2:41 PM 2020/4/20
 * @description: please add a description here
 */
class KRecycleViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>(),BindingCollectionAdapter<T> {

    private lateinit var _itemBinding : ItemBinding<in T>
    private lateinit var _items : List<T>

    var layoutInflater : LayoutInflater ?= null
    var bindJump : BaseCoreActivity<*> ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        layoutInflater?: LayoutInflater.from(parent.context)
        val binding = onCreateBinding(layoutInflater!!,viewType,parent)
        return onCreateViewHolder(binding)
    }

    private fun onCreateViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder{
        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int  = _items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding: ViewDataBinding? = DataBindingUtil.getBinding(holder.itemView)
        bindForBaseViewModel(binding, _items[position], position)
    }

    private fun bindForBaseViewModel(binding: ViewDataBinding?, item: T, position: Int) {
        binding?.apply {
            if (itemBinding.bind(this,item)){
                this.executePendingBindings()
            }
            if (item is BaseCoreViewModel<*>){
                if (item is BaseCoreItemViewModel<*>){
                    item.count = _items.size
                    item.position = position
                    item.viewDataBinding = binding
                }
                bindJump?.apply {
                    item.jump.observe(binding.lifecycleOwner!!, Observer { model ->
                        autoBinding.autoBindingImpl?.jumpListener(model)
                    })
                }
                item.onViewBind()
            }
        }
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        layoutRes: Int,
        viewGroup: ViewGroup
    ): ViewDataBinding  = DataBindingUtil.inflate(inflater,layoutRes,viewGroup,false)

    override fun getItemBinding(): ItemBinding<in T>  = _itemBinding

    override fun setItemBinding(itemBinding: ItemBinding<in T>) {
       _itemBinding = itemBinding
    }

    override fun setItems(items: List<T>?) {
        items?.also { _items = it }
    }

    override fun getAdapterItem(position: Int): T  = _items[position]

    override fun onBindBinding(
        binding: ViewDataBinding,
        variableId: Int,
        layoutRes: Int,
        position: Int,
        item: T
    ) {
        if (itemBinding.bind(binding,item)){
            binding.executePendingBindings()
        }
    }

    private class BindingViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}