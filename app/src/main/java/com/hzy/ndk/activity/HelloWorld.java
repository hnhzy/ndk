package com.hzy.ndk.activity;

import android.util.Log;

public class HelloWorld {

    static {
        System.loadLibrary("HelloWorld");
    }

    private static String name = "mlx";

    private String address = "shenzhen";

    public static native String sayHello();

    public static void logMessage(String data) {
        Log.d("HelloWorld-log", data);
    }

    public static void staticMothod(String data) {
        logMessage(data);
        logMessage(name);
    }

    public void mothod(String data) {
        logMessage(data);
        logMessage(address);
    }

    public static native void callStaticMothod();

    public static native void callStaticMothod(int i);

    public static native void callStaticMothod(long l, String s);

    public native void callInstanceMothod(int i);

    public native void callInstanceMothod(long i, String s);

}
