package com.neo.plugin_layout.auto.attr

import android.view.View
import com.neo.plugin_layout.auto.main.AutoUtils

/**
 * Created by zhy on 15/12/4.
 */
abstract class AutoAttr(protected var pxVal: Int, protected var baseWidth: Int, protected var baseHeight: Int) {
    open fun apply(view: View) {
        val log = view.tag != null && view.tag.toString() == "auto"
        var `val`: Int
        `val` = if (useDefault()) {
            if (defaultBaseWidth()) percentWidthSize else percentHeightSize
        } else if (baseWidth()) {
            percentWidthSize
        } else {
            percentHeightSize
        }
        if (`val` > 0) {
            `val` = Math.max(`val`, 1) //for very thin divider
        }
        execute(view, `val`)
    }

    protected val percentWidthSize: Int
        protected get() = AutoUtils.getPercentWidthSizeBigger(pxVal)

    protected val percentHeightSize: Int
        protected get() = AutoUtils.getPercentHeightSizeBigger(pxVal)

    protected fun baseWidth(): Boolean {
        return contains(baseWidth, attrVal())
    }

    protected fun useDefault(): Boolean {
        return !contains(baseHeight, attrVal()) && !contains(baseWidth, attrVal())
    }

    protected fun contains(baseVal: Int, flag: Int): Boolean {
        return baseVal and flag != 0
    }

    protected abstract fun attrVal(): Int
    protected abstract fun defaultBaseWidth(): Boolean
    protected abstract fun execute(view: View, `val`: Int)
    override fun toString(): String {
        return "AutoAttr{" +
                "pxVal=" + pxVal +
                ", baseWidth=" + baseWidth() +
                ", defaultBaseWidth=" + defaultBaseWidth() +
                '}'
    }

    companion object {
        const val BASE_WIDTH = 1
        const val BASE_HEIGHT = 2
        const val BASE_DEFAULT = 3
    }

}