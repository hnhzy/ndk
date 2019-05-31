package com.hzy.ndk.view;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 宽高相等的ImageView
 */
public class EquelImageView extends AppCompatImageView {



    public EquelImageView(Context context) {
        super(context);
    }

    public EquelImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EquelImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
