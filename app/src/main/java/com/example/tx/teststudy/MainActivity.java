package com.example.tx.teststudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void feature1() {
        Log.e("HAHAHA", "HAHAHAHA111111");
    }

    public void feature2() {
        Log.e("HAHAHA", "HAHAHAHA111111");
    }

    public void feature3() {
        Log.e("HAHAHA", "HAHAHAHA111111");
    }

    public void submit(View view) {
        String oldPin = ((EditText) findViewById(R.id.original_eshield_password)).getText().toString();
        String newPin = ((EditText) findViewById(R.id.new_eshield_password)).getText().toString();
        String confirmPin = ((EditText) findViewById(R.id.repetitive_new_eshield_password)).getText().toString();
    public void feature4() {
        Log.e("heihei","heihei");
    }

    public void submit(View view){
        String oldPin = ((EditText)findViewById(R.id.original_eshield_password)).getText().toString();
        String newPin = ((EditText)findViewById(R.id.new_eshield_password)).getText().toString();
        String confirmPin = ((EditText)findViewById(R.id.repetitive_new_eshield_password)).getText().toString();
        //正则表达式校验
        String pat = "^([a-zA-Z0-9]|[\\\\!`@#$%^&*&nbsp;~(\")_=\\-+\\]?>\\[<':}\\{|;'/. ,\t])+";
        Pattern pattern = Pattern.compile(pat);
        Log.e(TAG, oldPin + "+++" + pattern.matcher(oldPin).matches() + "----" + pattern.matcher(newPin).matches() +
                "=====" +
                pattern.matcher(confirmPin).matches());
    }
}
