package com.hzy.ndk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hzy.ndk.R;

public class InputView extends FrameLayout {

    private String hintStr;
    private Boolean isPasswd = false;
    private int inputIconRes;
    private View mView;
    private ImageView mImageView;
    private ClearEditText mEditText;

    public InputView(Context context) {
        super(context);
        initView(context, null);
    }

    public InputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public InputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }


    private void initView(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.inputView);
        isPasswd = ta.getBoolean(R.styleable.inputView_input_passwd, false);
        hintStr = ta.getString(R.styleable.inputView_input_hint);
        inputIconRes = ta.getResourceId(R.styleable.inputView_input_icon, R.mipmap.ic_launcher);
        ta.recycle();

        mView = LayoutInflater.from(context).inflate(R.layout.input_view, null);
        mImageView = mView.findViewById(R.id.imv_icon);
        mEditText = mView.findViewById(R.id.et_input);
        mImageView.setImageResource(inputIconRes);
        mEditText.setHint(hintStr);
//        if (isPasswd) {
//            mEditText.setInputType(InputType.TYPE_CLASS_TEXT);
//        }
        addView(mView);
    }

    /**
     * 返回输入内容
     *
     * @return
     */
    public String getInputStr() {
        return mEditText.getText().toString().trim();
    }

}
