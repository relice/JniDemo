#include "com_relicemxd_jnidemo_ndk_JniUtils.h"

JNIEXPORT jstring JNICALL Java_com_relicemxd_jnidemo_ndk_JniUtils_getStringFromC
        (JNIEnv *env, jclass cls) {
    return (*env)->NewStringUTF(env, "这是来自C的string !");
}