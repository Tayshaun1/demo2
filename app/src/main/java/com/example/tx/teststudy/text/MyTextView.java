package com.example.tx.teststudy.text;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 谭鑫 on 2017/4/12.
 */

public class MyTextView extends TextView {

    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
