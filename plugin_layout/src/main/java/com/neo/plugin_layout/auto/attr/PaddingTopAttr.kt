package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class PaddingTopAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.PADDING_TOP
    }

    override fun defaultBaseWidth(): Boolean {
        return false
    }

    override fun execute(view: View, `val`: Int) {
        val l = view.paddingLeft
        val r = view.paddingRight
        val b = view.paddingBottom
        view.setPadding(l, `val`, r, b)
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): PaddingTopAttr? {
            var attr: PaddingTopAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = PaddingTopAttr(
                    `val`,
                    Attrs.Companion.PADDING_TOP,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = PaddingTopAttr(
                    `val`,
                    0,
                    Attrs.Companion.PADDING_TOP
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = PaddingTopAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}