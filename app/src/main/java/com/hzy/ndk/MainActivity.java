package com.hzy.ndk;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hzy.ndk.base.BaseActivity;
import com.hzy.ndk.listener.RightOnClickListener;
import com.hzy.ndk.view.InputView;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MainActivity extends BaseActivity {

    private TextView tv;
    private InputView mInputView;
    private ImageView imv_equel;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        tv = findViewById(R.id.tv);
        mInputView = findViewById(R.id.input_view);
        imv_equel = findViewById(R.id.imv_equel);
        imv_equel.setImageResource(R.mipmap.icon);
        Log.d("MainActivity-imv",imv_equel.getWidth()+"");
        Log.d("MainActivity-imv",imv_equel.getHeight()+"");
        Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        });
        /**
         * ToolBar
         */
        initToolBar(false, "首页", true);
        setmRightOnClickListener(new RightOnClickListener() {
            @Override
            public void OnClickListener() {
                Toast.makeText(MainActivity.this, "点击了右边", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * ndk
         */
//        HelloWorld.callStaticMothod(1);//callStaticMothod-静态方法1
//        HelloWorld.callStaticMothod(2, "callStaticMothod-静态方法2");//callStaticMothod-静态方法2
//        new HelloWorld().callInstanceMothod(1);//callInstanceMothod-实例方法1
//        new HelloWorld().callInstanceMothod(2, "callInstanceMothod-实例方法2");//callInstanceMothod-实例方法2
//        tv.setText(HelloWorld.sayHello());
        /**
         * onTouch/onClick
         */
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick execute");
            }
        });
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN://ACTION_DOWN= 0;

                        break;
                    case MotionEvent.ACTION_MOVE://ACTION_MOVE= 2;

                        break;
                    case MotionEvent.ACTION_UP://ACTION_UP= 1;

                        break;
                }
                return false;//true 事件被onTouch消费掉了，因而不会再继续向下传递。
            }
        });
    }

}
