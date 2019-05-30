package com.hzy.ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HelloWorld.callStaticMothod(1);//callStaticMothod-静态方法1
        HelloWorld.callStaticMothod(2,"callStaticMothod-静态方法2");//callStaticMothod-静态方法2
//        new HelloWorld().callInstanceMothod(1);//callInstanceMothod-实例方法1
//        new HelloWorld().callInstanceMothod(2, "callInstanceMothod-实例方法2");//callInstanceMothod-实例方法2
//        tv = findViewById(R.id.tv);
//        tv.setText(HelloWorld.sayHello());
    }
}
