package com.neo.plugin_layout.auto.attr

import android.os.Build
import android.view.View

/**
 * Created by zhy on 15/12/24.
 */
class MinWidthAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.MIN_WIDTH
    }

    override fun defaultBaseWidth(): Boolean {
        return true
    }

    override fun execute(view: View, `val`: Int) {
        try {
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinWidth", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (ignore: Exception) {
        }
        view.minimumWidth = `val`
    }

    companion object {
        @JvmStatic
        fun getMinWidth(view: View): Int {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) return view.minimumWidth
            try {
                val minWidth = view.javaClass.getField("mMinWidth")
                minWidth.isAccessible = true
                return minWidth[view] as Int
            } catch (ignore: Exception) {
            }
            return 0
        }

        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): MinWidthAttr? {
            var attr: MinWidthAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr = MinWidthAttr(
                    `val`,
                    Attrs.Companion.MIN_WIDTH,
                    0
                )
                AutoAttr.Companion.BASE_HEIGHT -> attr = MinWidthAttr(
                    `val`,
                    0,
                    Attrs.Companion.MIN_WIDTH
                )
                AutoAttr.Companion.BASE_DEFAULT -> attr = MinWidthAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}