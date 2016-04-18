package com.relicemxd.jnidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.relicemxd.jnidemo.ndk.JniUtils;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("jnidemo");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        String stringFromC = new JniUtils().getStringFromC();
        if (stringFromC != null) {
            tv.setText(stringFromC);
        }
    }
}
