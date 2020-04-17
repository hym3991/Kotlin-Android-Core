/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neo.plugin_layout.auto

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.neo.plugin_layout.auto.main.AutoLayoutHelper
import com.neo.plugin_layout.auto.main.AutoLayoutHelper.AutoLayoutParams
import com.neo.plugin_layout.auto.main.AutoLayoutInfo

class AutoFrameLayout : FrameLayout {
    private val mHelper = AutoLayoutHelper(this)

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context!!, attrs, defStyleAttr) {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context!!, attrs, defStyleAttr, defStyleRes) {
    }

    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return LayoutParams(context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!isInEditMode) {
            mHelper.adjustChildren()
        }
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

    class LayoutParams : FrameLayout.LayoutParams, AutoLayoutParams {
        override var autoLayoutInfo: AutoLayoutInfo? = null
            private set

        constructor(c: Context?, attrs: AttributeSet?) : super(
            c!!,
            attrs
        ) {
            autoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(c, attrs)
        }

        constructor(width: Int, height: Int) : super(width, height) {}
        constructor(width: Int, height: Int, gravity: Int) : super(width, height, gravity) {}
        constructor(source: ViewGroup.LayoutParams?) : super(source!!) {}
        constructor(source: MarginLayoutParams?) : super(source!!) {}
        constructor(source: FrameLayout.LayoutParams) : super((source as MarginLayoutParams)) {
            gravity = source.gravity
        }

        constructor(source: LayoutParams) : this(source as FrameLayout.LayoutParams) {
            autoLayoutInfo = source.autoLayoutInfo
        }

    }
}