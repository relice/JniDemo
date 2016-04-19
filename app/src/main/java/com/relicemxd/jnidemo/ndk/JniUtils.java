package com.relicemxd.jnidemo.ndk;

/**
 * @Package: com.relicemxd.jnidemo.ndk
 * @Author: Relice
 * @Date: 16/4/18
 * @Des: TODO
 */
public class JniUtils {
    public native String getStringFromC();

    public native void insertSort(int[] array);

    public void intsertSorctFromJava(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];//记录当前数
            int pos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];//向后移动一位
                    pos -= 1;//索引向前移一位
                } else {
                    break;//跳出循环
                }
            }
            array[pos] = temp;//
        }
    }

    public void printArrays(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}
