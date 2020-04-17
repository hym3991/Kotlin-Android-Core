package com.neo.plugin_layout.auto.attr

import android.view.View

/**
 * Created by zhy on 15/12/5.
 */
class HeightAttr(pxVal: Int, baseWidth: Int, baseHeight: Int) :
    AutoAttr(pxVal, baseWidth, baseHeight) {
    override fun attrVal(): Int {
        return Attrs.Companion.HEIGHT
    }

    override fun defaultBaseWidth(): Boolean {
        return false
    }

    override fun execute(view: View, `val`: Int) {
        val lp = view.layoutParams
        lp.height = `val`
    }

    companion object {
        @JvmStatic
        fun generate(`val`: Int, baseFlag: Int): HeightAttr? {
            var heightAttr: HeightAttr? = null
            when (baseFlag) {
                AutoAttr.Companion.BASE_WIDTH -> heightAttr =
                    HeightAttr(`val`, Attrs.Companion.HEIGHT, 0)
                AutoAttr.Companion.BASE_HEIGHT -> heightAttr =
                    HeightAttr(`val`, 0, Attrs.Companion.HEIGHT)
                AutoAttr.Companion.BASE_DEFAULT -> heightAttr = HeightAttr(`val`, 0, 0)
            }
            return heightAttr
        }
    }
}