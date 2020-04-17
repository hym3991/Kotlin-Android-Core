package com.neo.plugin_layout.auto.attr

import android.view.View
import android.view.ViewGroup.MarginLayoutParams

/**
 * Created by zhy on 15/12/5.
 */
class MarginLeftAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.MARGIN_LEFT
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        if (view.layoutParams !is MarginLayoutParams) {
            return
        }
        val lp = view.layoutParams as MarginLayoutParams
        lp.leftMargin = `val`
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): MarginLeftAttr? {
            var attr: MarginLeftAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = MarginLeftAttr(
                    `val`,
                    Attrs.Companion.MARGIN_LEFT,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = MarginLeftAttr(
                    `val`,
                    0,
                    Attrs.Companion.MARGIN_LEFT
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = MarginLeftAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}