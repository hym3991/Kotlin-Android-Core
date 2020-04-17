package com.neo.plugin_layout

import android.content.Context
import android.content.res.Resources.NotFoundException
import android.graphics.Point
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Display
import android.view.WindowManager

/**
 * @author: hongyaming
 * @date: Create in 3:55 PM 2020/4/17
 * @description: please add a description here
 */
object LayoutUtils {
    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        try {
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
        } catch (e: NotFoundException) {
            e.printStackTrace()
        }
        return result
    }

    fun getScreenSize(
        context: Context,
        useDeviceSize: Boolean
    ): IntArray? {
        val size = IntArray(2)
        val w = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val d = w.defaultDisplay
        val metrics = DisplayMetrics()
        d.getMetrics(metrics)
        var widthPixels = metrics.widthPixels
        var heightPixels = metrics.heightPixels
        if (!useDeviceSize) {
            size[0] = widthPixels
            size[1] = heightPixels - getStatusBarHeight(context)
            return size
        }
        try {
            widthPixels = Display::class.java.getMethod("getRawWidth").invoke(d) as Int
            heightPixels = Display::class.java.getMethod("getRawHeight").invoke(d) as Int

        } catch (ignored: Exception) {

        }
        try {
            val realSize = Point()
            Display::class.java.getMethod("getRealSize", Point::class.java)
                .invoke(d, realSize)
            widthPixels = realSize.x
            heightPixels = realSize.y
        } catch (ignored: Exception) {

        }
        size[0] = widthPixels
        size[1] = heightPixels
        return size
    }

    private fun getComplexUnit(data: Int): Int {
        return TypedValue.COMPLEX_UNIT_MASK and (data shr TypedValue.COMPLEX_UNIT_SHIFT)
    }

    fun isPxVal(`val`: TypedValue?): Boolean {
        return `val` != null && `val`.type == TypedValue.TYPE_DIMENSION && getComplexUnit(`val`.data) == TypedValue.COMPLEX_UNIT_PX
    }
}