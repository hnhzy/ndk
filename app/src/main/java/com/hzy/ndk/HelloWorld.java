package com.hzy.ndk;

public class HelloWorld {

    static {
        System.loadLibrary("HelloWorld");
    }

    public static native String sayHello();

}
