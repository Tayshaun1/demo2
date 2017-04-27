package com.example.tx.teststudy.text;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.tx.teststudy.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 谭鑫 on 2017/4/12.
 */

public class TextSwitchView extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private int index = -1;
    private Context context;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    index = next(); //取得下标值
                    updateText();  //更新TextSwitcherd显示内容;
                    break;
            }
        }

        ;
    };
    private String[] resources = {
            "静夜思",
            "床前明月光", "疑是地上霜",
            "举头望明月",
            "低头思故乡"
    };
    private Timer timer; //

    public TextSwitchView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public TextSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        if (timer == null)
            timer = new Timer();
        this.setFactory(this);
        this.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.in_animation));
        this.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.out_animation));
    }

    public void setResources(String[] res) {
        this.resources = res;
    }

    public void setTextStillTime(long time) {
        if (timer == null) {
            timer = new Timer();
        } else {
            timer.scheduleAtFixedRate(new MyTask(), 1, time);//每3秒更新
        }
    }

    private class MyTask extends TimerTask {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(1);
        }
    }

    private int next() {
        int flag = index + 1;
        if (flag > resources.length - 1) {
            flag = flag - resources.length;
        }
        return flag;
    }

    private void updateText() {
        this.setText(resources[index]);
    }

    @Override
    public View makeView() {
        TextView tv = new TextView(context);
        float size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, getResources().getDisplayMetrics());
        tv.setTextSize(size);
        tv.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv.setGravity(Gravity.CENTER);
        return tv;
    }
}
