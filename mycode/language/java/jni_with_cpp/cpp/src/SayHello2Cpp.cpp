#include <jni.h>
#include <stdio.h>
#include "com_dss_SayHello2Cpp.h"


JNIEXPORT void JNICALL Java_com_dss_SayHello2Cpp_sayHello
 (JNIEnv * env, jobject obj, jstring words) {
    printf("Hello world %s\n", env->GetStringUTFChars(words, NULL));
}
  
