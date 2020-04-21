package com.neo.plugin_core.binding.smartrefresh

import android.view.View
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshKernel
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.constant.SpinnerStyle

/**
 * @author: hongyaming
 * @date: Create in 4:14 PM 2020/4/21
 * @description: please add a description here
 */
class KDefaultHeader : RefreshHeader {
    override fun getSpinnerStyle(): SpinnerStyle {
        TODO("Not yet implemented")
    }

    override fun onFinish(refreshLayout: RefreshLayout, success: Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun onInitialized(kernel: RefreshKernel, height: Int, maxDragHeight: Int) {
        TODO("Not yet implemented")
    }

    override fun onHorizontalDrag(percentX: Float, offsetX: Int, offsetMax: Int) {
        TODO("Not yet implemented")
    }

    override fun onReleased(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        TODO("Not yet implemented")
    }

    override fun getView(): View {
        TODO("Not yet implemented")
    }

    override fun setPrimaryColors(vararg colors: Int) {
        TODO("Not yet implemented")
    }

    override fun onStartAnimator(refreshLayout: RefreshLayout, height: Int, maxDragHeight: Int) {
        TODO("Not yet implemented")
    }

    override fun onStateChanged(
        refreshLayout: RefreshLayout,
        oldState: RefreshState,
        newState: RefreshState
    ) {
        TODO("Not yet implemented")
    }

    override fun onMoving(
        isDragging: Boolean,
        percent: Float,
        offset: Int,
        height: Int,
        maxDragHeight: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun isSupportHorizontalDrag(): Boolean {
        TODO("Not yet implemented")
    }

}