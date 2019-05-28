//
// Created by Administrator on 2019/5/28.
//
#include "com_hzy_ndk_HelloWorld.h"

JNIEXPORT jstring JNICALL Java_com_hzy_ndk_HelloWorld_sayHello(JNIEnv * env, jclass jc){
    return env->NewStringUTF("say HelloWorld from c++");
}