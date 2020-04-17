package com.neo.plugin_layout.auto.attr

import android.view.View
import android.view.ViewGroup.MarginLayoutParams

/**
 * Created by zhy on 15/12/5.
 */
class MarginTopAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.MARGIN_TOP
    }

    override fun defaultBaseWidth(): Boolean {
        return false
    }

    override fun execute(view: View, `val`: Int) {
        if (view.layoutParams !is MarginLayoutParams) {
            return
        }
        val lp = view.layoutParams as MarginLayoutParams
        lp.topMargin = `val`
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): MarginTopAttr? {
            var attr: MarginTopAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = MarginTopAttr(
                    `val`,
                    Attrs.Companion.MARGIN_TOP,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = MarginTopAttr(
                    `val`,
                    0,
                    Attrs.Companion.MARGIN_TOP
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = MarginTopAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}