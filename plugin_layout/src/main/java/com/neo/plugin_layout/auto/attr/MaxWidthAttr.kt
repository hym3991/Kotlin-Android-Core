package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/24.
 */
class MaxWidthAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.MAX_WIDTH
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        try {
            val setMaxWidthMethod =
                view.javaClass.getMethod("setMaxWidth", Int::class.javaPrimitiveType)
            setMaxWidthMethod.invoke(view, `val`)
        } catch (ignore: Exception) {
        }
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): MaxWidthAttr? {
            var attr: MaxWidthAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = MaxWidthAttr(
                    `val`,
                    Attrs.Companion.MAX_WIDTH,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = MaxWidthAttr(
                    `val`,
                    0,
                    Attrs.Companion.MAX_WIDTH
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = MaxWidthAttr(`val`, 0, 0)
            }
            return attr
        }

        @JvmStatic
        fun getMaxWidth(view: View): Int {
            try {
                val setMaxWidthMethod =
                    view.javaClass.getMethod("getMaxWidth")
                return setMaxWidthMethod.invoke(view) as Int
            } catch (ignore: Exception) {
            }
            return 0
        }
    }
}