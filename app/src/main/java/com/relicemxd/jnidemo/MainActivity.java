package com.relicemxd.jnidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.relicemxd.jnidemo.ndk.JniUtils;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("jnidemo");
    }


    public void createArray(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = (int) (Math.random() * 100 + 1);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        final JniUtils jniUtils = new JniUtils();
        assert tv != null;
        tv.setText(jniUtils.getStringFromC());

        new Thread(new Runnable() {
            @Override
            public void run() {

                final int[] array = new int[100000];
                createArray(array);
//        jniUtils.printArrays(array);
                long start = System.currentTimeMillis();
//        jniUtils.intsertSorctFromJava(ints);//Java 排序
                jniUtils.insertSort(array);//C 排序
                long end = System.currentTimeMillis();

                System.out.println("排序后..." + "耗时: " + (end - start));
//        jniUtils.printArrays(array);
            }
        }).start();
    }
}
