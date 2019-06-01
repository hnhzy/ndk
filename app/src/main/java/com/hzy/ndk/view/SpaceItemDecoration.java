package com.hzy.ndk.view;


import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

/**
 * ItemDecoration
 * 设置RecyclerView的边距
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpaceItemDecoration(int space, RecyclerView parent) {
        mSpace = space;
        getRecyclerViewoffests(parent);
    }

    /**
     * @param outRect Ttem的边界矩形
     * @param view    ItemView
     * @param parent  RecyclerView
     * @param state   RecyclerView的状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
    }

    private void getRecyclerViewoffests(@NonNull RecyclerView parent) {
        /**
         * View Margin
         * margin为正  则View会距离边界产生一个距离
         * margin为负  则View会超过边界产生一个距离
         */
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin = -mSpace;
        parent.setLayoutParams(layoutParams);
    }
}
