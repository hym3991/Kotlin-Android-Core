package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class PaddingRightAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.PADDING_RIGHT
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        val l = view.paddingLeft
        val t = view.paddingTop
        val b = view.paddingBottom
        view.setPadding(l, t, `val`, b)
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): PaddingRightAttr? {
            var attr: PaddingRightAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = PaddingRightAttr(
                    `val`,
                    Attrs.Companion.PADDING_RIGHT,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = PaddingRightAttr(
                    `val`,
                    0,
                    Attrs.Companion.PADDING_RIGHT
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = PaddingRightAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}