//
// Created by Administrator on 2019/5/28.
//
#include "com_hzy_ndk_HelloWorld.h"
#include <stdio.h>
#include <stdlib.h>
#include <jni.h>
#include <string.h>
/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    sayHello
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_hzy_ndk_HelloWorld_sayHello(JNIEnv *env, jclass jc) {
    return env->NewStringUTF("say HelloWorld from c++");
}

/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    callStaticMothod
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_hzy_ndk_HelloWorld_callStaticMothod__
        (JNIEnv *env, jclass jc);

/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    callStaticMothod
 * Signature: (I)V
 */
JNIEXPORT void JNICALL
Java_com_hzy_ndk_HelloWorld_callStaticMothod__I(JNIEnv *env, jclass jc, jint i) {

    //找到对应的类
    jclass cls_hello = env->FindClass("com/hzy/ndk/HelloWorld");
    if (cls_hello == NULL) {
        return;
    }

    //找到java层需要调用的方法
    jmethodID mtd_static_method = env->GetStaticMethodID(cls_hello, "staticMothod",
                                                         "(Ljava/lang/String;)V");
    if (mtd_static_method == NULL) {
        return;
    }

    //声明传递的String
    jstring data = env->NewStringUTF("call java static callStaticMothod1 from c++");
    if (data == NULL) {
        return;
    }

    //调用Java层方法
    env->CallStaticVoidMethod(cls_hello, mtd_static_method, data);
    //删除引用
    env->DeleteLocalRef(cls_hello);
    env->DeleteLocalRef(data);
}

/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    callStaticMothod
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL
Java_com_hzy_ndk_HelloWorld_callStaticMothod__JLjava_lang_String_2(JNIEnv *env, jclass jc, jlong l,
                                                                   jstring s) {
    //找到对应的类
    jclass cls_hello = env->FindClass("com/hzy/ndk/HelloWorld");
    if (cls_hello == NULL) {
        return;
    }
    //找到java层需要调用的方法
    jmethodID mtd_static_mothod = env->GetStaticMethodID(cls_hello, "staticMothod",
                                                         "(Ljava/lang/String;)V");
    if (mtd_static_mothod == NULL) {
        return;
    }

    jfieldID fld_name = env->GetStaticFieldID(cls_hello, "name", "Ljava/lang/String;");
    if (fld_name == NULL) {
        return;
    }
    jstring name = env->NewStringUTF("hzy");
    env->SetStaticObjectField(cls_hello, fld_name, name);

    jstring data = env->NewStringUTF("call java static callStaticMothod2 from c++");

    if (data == NULL) {
        return;
    }

    //调用Java层方法
    env->CallStaticVoidMethod(cls_hello, mtd_static_mothod, data);
    //删除引用
    env->DeleteLocalRef(cls_hello);
    env->DeleteLocalRef(data);
    env->DeleteLocalRef(name);

}

/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    callInstanceMothod
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_hzy_ndk_HelloWorld_callInstanceMothod__I
        (JNIEnv *env, jobject jb, jint i) {
    //找到对应的类
    jclass cls_hello = env->FindClass("com/hzy/ndk/HelloWorld");
    if (cls_hello == NULL) {
        return;
    }
    //找到对应的方法
    jmethodID mtd_mothod = env->GetMethodID(cls_hello, "mothod", "(Ljava/lang/String;)V");
    if (mtd_mothod == NULL) {
        return;
    }
    //找到对应的构造方法
    jmethodID mtd_construct = env->GetMethodID(cls_hello, "<init>", "()V");
    if (mtd_construct == NULL) {
        return;
    }
    //创建相应的对象
    jobject hello = env->NewObject(cls_hello, mtd_construct, NULL);
    if (hello == NULL) {
        return;
    }
    jstring message = env->NewStringUTF("call instance mothod1");

    //调用java层方法
    env->CallVoidMethod(hello, mtd_mothod, message);

    //删除引用
    env->DeleteLocalRef(message);
    env->DeleteLocalRef(hello);
    env->DeleteLocalRef(cls_hello);
}

/*
 * Class:     com_hzy_ndk_HelloWorld
 * Method:    callInstanceMothod
 * Signature: (JLjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_hzy_ndk_HelloWorld_callInstanceMothod__JLjava_lang_String_2
        (JNIEnv *env, jobject jb, jlong l, jstring s) {
    //找到对应的类
    jclass cls_hello = env->FindClass("com/hzy/ndk/HelloWorld");
    if (cls_hello == NULL) {
        return;
    }
    //找到对应的方法
    jmethodID mtd_mothod = env->GetMethodID(cls_hello, "mothod", "(Ljava/lang/String;)V");
    if (mtd_mothod == NULL) {
        return;
    }
    //找到对应的构造方法
    jmethodID mtd_construct = env->GetMethodID(cls_hello, "<init>", "()V");
    if (mtd_construct == NULL) {
        return;
    }
    //创建相应的对象
    jobject hello = env->NewObject(cls_hello, mtd_construct, NULL);
    if (hello == NULL) {
        return;
    }
    jfieldID fld_address=env->GetFieldID(cls_hello,"address","Ljava/lang/String;");
    if (fld_address == NULL) {
        return;
    }
    jstring address=env->NewStringUTF("changsha");
    if (address == NULL) {
        return;
    }
    env->SetObjectField(hello, fld_address, (jobject) address);

    jstring message = env->NewStringUTF("call instance mothod2");

    //调用java层方法
    env->CallVoidMethod(hello, mtd_mothod, message);

    //删除引用
    env->DeleteLocalRef(message);
    env->DeleteLocalRef(hello);
    env->DeleteLocalRef(cls_hello);
    env->DeleteLocalRef(address);
}

