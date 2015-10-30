#include <stdio.h>
#include "jni.h"
#include "HelloWorld.h"

JNIEXPORT void JNICALL Java_HelloWorld_displayHelloWorld(JNIEnv * env, jobject obj) {
    printf("dushishuang HelloWorld!\n");
    return;
}
