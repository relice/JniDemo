#include "com_relicemxd_jnidemo_ndk_JniUtils.h"

//C的插入排序
void intsertSorct(int *array, int len) {
    int temp;
    int i;
    for (i = 1; i < len; i++) {
        temp = array[i];//记录当前数
        int pos = i;
        int j;
        for (j = i - 1; j >= 0; j--) {
            if (array[j] > temp) {
                array[j + 1] = array[j];//向后移动一位
                pos = pos - 1;//索引向前移一位
            } else {
                break;//跳出循环
            }
        }
        array[pos] = temp;//
    }
}

JNIEXPORT jstring JNICALL Java_com_relicemxd_jnidemo_ndk_JniUtils_getStringFromC
        (JNIEnv *env, jclass cls) {
    return (*env)->NewStringUTF(env, "这是来自C的string !");
}

JNIEXPORT void JNICALL Java_com_relicemxd_jnidemo_ndk_JniUtils_insertSort
        (JNIEnv *env, jclass clas, jintArray array) {
    jint *arrs = (*env)->GetIntArrayElements(env, array, 0);
    jint len = (*env)->GetArrayLength(env, array);
    intsertSorct(arrs, len);

    //释放资源
    (*env)->ReleaseIntArrayElements(env, array, arrs, 0);
}
