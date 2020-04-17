package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class WidthAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.WIDTH
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        val lp = view.layoutParams
        lp.width = `val`
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): WidthAttr? {
            var widthAttr: WidthAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> widthAttr =
                    WidthAttr(`val`, Attrs.Companion.WIDTH, 0)
                AutoAttr.Companion.BASE_HEIGHT -> widthAttr =
                    WidthAttr(`val`, 0, Attrs.Companion.WIDTH)
                AutoAttr.Companion.BASE_DEFAULT -> widthAttr = WidthAttr(`val`, 0, 0)
            }
            return widthAttr
        }
    }
}