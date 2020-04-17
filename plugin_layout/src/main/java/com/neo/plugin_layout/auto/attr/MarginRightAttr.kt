package com.neo.plugin_layout.auto.attr

import android.view.View
import android.view.ViewGroup.MarginLayoutParams

/**
 * Created by zhy on 15/12/5.
 */
class MarginRightAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.MARGIN_RIGHT
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        if (view.layoutParams !is MarginLayoutParams) {
            return
        }
        val lp = view.layoutParams as MarginLayoutParams
        lp.rightMargin = `val`
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): MarginRightAttr? {
            var attr: MarginRightAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = MarginRightAttr(
                    `val`,
                    Attrs.Companion.MARGIN_RIGHT,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = MarginRightAttr(
                    `val`,
                    0,
                    Attrs.Companion.MARGIN_RIGHT
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = MarginRightAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}