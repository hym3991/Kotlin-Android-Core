package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class PaddingLeftAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.PADDING_LEFT
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        val t = view.paddingTop
        val r = view.paddingRight
        val b = view.paddingBottom
        view.setPadding(`val`, t, r, b)
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): PaddingLeftAttr? {
            var attr: PaddingLeftAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = PaddingLeftAttr(
                    `val`,
                    Attrs.Companion.PADDING_LEFT,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = PaddingLeftAttr(
                    `val`,
                    0,
                    Attrs.Companion.PADDING_LEFT
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = PaddingLeftAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}