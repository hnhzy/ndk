package com.hzy.ndk.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hzy.ndk.R;
import com.hzy.ndk.listener.RightOnClickListener;

public abstract class BaseActivity extends AppCompatActivity {

    private ImageView mImvLeft;
    private ImageView mImvRight;
    private TextView mTvTitle;

    private RightOnClickListener mRightOnClickListener;

    public void setmRightOnClickListener(RightOnClickListener mRightOnClickListener) {
        this.mRightOnClickListener = mRightOnClickListener;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
    }

    public abstract int getLayout();

    public abstract void initView();

    /**
     * 初始化
     *
     * @param isLeftVisible
     * @param title
     * @param isRightVisible
     */
    public void initToolBar(Boolean isLeftVisible, String title, Boolean isRightVisible) {
        mImvLeft = findViewById(R.id.imv_left);
        mImvRight = findViewById(R.id.imv_right);
        mTvTitle = findViewById(R.id.tv_title);

        mImvLeft.setVisibility(isLeftVisible ? View.VISIBLE : View.GONE);
        mImvRight.setVisibility(isRightVisible ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);
        mImvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mImvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRightOnClickListener.OnClickListener();
            }
        });

    }


}
