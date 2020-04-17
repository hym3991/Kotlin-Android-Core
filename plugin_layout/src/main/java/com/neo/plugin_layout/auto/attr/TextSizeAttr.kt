package com.neo.plugin_layout.auto.attr

import android.util.TypedValue
import android.view.View
import android.widget.TextView

/**
 * Created by zhy on 15/12/4.
 */
class TextSizeAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.TEXTSIZE
    }

    override fun defaultBaseWidth(): Boolean {
        return false
    }

    override fun execute(view: View, `val`: Int) {
        if (view !is TextView) return
        view.includeFontPadding = false
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, `val`.toFloat())
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): TextSizeAttr? {
            var attr: TextSizeAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> attr =
                    TextSizeAttr(`val`, Attrs.Companion.TEXTSIZE, 0)
                AutoAttr.Companion.BASE_HEIGHT -> attr =
                    TextSizeAttr(`val`, 0, Attrs.Companion.TEXTSIZE)
                AutoAttr.Companion.BASE_DEFAULT -> attr = TextSizeAttr(`val`, 0, 0)
            }
            return attr
        }
    }
}