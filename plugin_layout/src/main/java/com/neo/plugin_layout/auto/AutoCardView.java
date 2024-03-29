package com.neo.plugin_layout.auto;


import android.content.Context;
import android.util.AttributeSet;

import androidx.cardview.widget.CardView;

import com.neo.plugin_layout.auto.main.AutoLayoutHelper;

/**
 * <li>Package:test.ttpc.com.test
 * <li>Author: yehaijian
 * <li>Date: 2017/3/14
 * <li>Description: 自适卡片布局
 */

public class AutoCardView extends CardView {
    private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);

    public AutoCardView(Context context)
    {
        super(context);
    }

    public AutoCardView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public AutoCardView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public AutoFrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new AutoFrameLayout.LayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        if (!isInEditMode())
        {
            mHelper.adjustChildren();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
