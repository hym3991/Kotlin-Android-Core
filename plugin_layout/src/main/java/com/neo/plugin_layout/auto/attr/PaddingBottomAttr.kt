package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class PaddingBottomAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.PADDING_BOTTOM
    }

    override fun defaultBaseWidth(): Boolean {
        return false
    }

    override fun execute(view: View, `val`: Int) {
        val l = view.paddingLeft
        val t = view.paddingTop
        val r = view.paddingRight
        view.setPadding(l, t, r, `val`)
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): PaddingBottomAttr? {
            var attr: PaddingBottomAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = PaddingBottomAttr(
                    `val`,
                    Attrs.Companion.PADDING_BOTTOM,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = PaddingBottomAttr(
                    `val`,
                    0,
                    Attrs.Companion.PADDING_BOTTOM
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = PaddingBottomAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}