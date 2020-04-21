package com.neo.plugin_core.binding.smartrefresh

import androidx.databinding.BindingAdapter
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.RefreshHeader

/**
 * @author: hongyaming
 * @date: Create in 3:45 PM 2020/4/21
 * @description: please add a description here
 */
class KSmartRefreshBindingAdapter {
    @BindingAdapter(
        value = ["header","footer","head_w","head_h","footer_w","foot_h","default_header","default_footer"],
        requireAll = false
    )
    fun setCreator(smartRefreshLayout: SmartRefreshLayout,
                   header:RefreshHeader?,
                   footer: RefreshFooter?,
                   head_w:Int?,
                   head_h:Int?,
                   foot_w:Int?,
                   foot_h:Int?,
                   default_header:Boolean,
                   default_footer:Boolean){

        smartRefreshLayout.apply {

            if (default_header){
                setEnableRefresh(true)
                setRefreshHeader(KDefaultHeader())
            }else{
                setEnableRefresh(header!=null)
                header?.apply {
                    setRefreshHeader(this,head_w?:0,head_h?:0)
                }
            }

            if (default_footer){
                setEnableLoadMore(true)
                setRefreshFooter(KDefaultFooter())
            }else{
                setEnableLoadMore(footer!=null)
                footer?.apply {
                    setRefreshFooter(this,foot_w?:0,foot_h?:0)
                }
            }

            setEnableLoadMoreWhenContentNotFull(false)
            tag = "close egg"
        }
    }
}