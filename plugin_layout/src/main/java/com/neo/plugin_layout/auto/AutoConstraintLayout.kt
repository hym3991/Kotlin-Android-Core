package com.neo.plugin_layout.auto

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.neo.plugin_layout.auto.main.AutoLayoutHelper
import com.neo.plugin_layout.auto.main.AutoLayoutInfo

/**
 *  * Package:test.ttpc.com.test
 *  * Author: yehaijian
 *  * Date: 2017/3/14
 *  * Description: 自适应约束布局
 */
class AutoConstraintLayout : ConstraintLayout {
    private val mHelper: AutoLayoutHelper =
        AutoLayoutHelper(this) //autoLayoutHelper 处理数值转换

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }

    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return LayoutParams(context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!isInEditMode) mHelper.adjustChildren()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(
        changed: Boolean,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        super.onLayout(changed, left, top, right, bottom)
    }

    class LayoutParams : ConstraintLayout.LayoutParams , AutoLayoutHelper.AutoLayoutParams{

        lateinit var mAutoLayoutInfo : AutoLayoutInfo
        constructor(context: Context,attrs: AttributeSet?) : super(context,attrs){
            mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(context,attrs)
        }
        constructor(width : Int,height : Int) : super(width, height){

        }
        constructor(layoutParams: ViewGroup.LayoutParams) : super(layoutParams){

        }
        constructor(layoutParams: ViewGroup.MarginLayoutParams) : super(layoutParams){

        }

        override val autoLayoutInfo: AutoLayoutInfo?
            get() = mAutoLayoutInfo

    }

}