package com.example.tx.teststudy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GroupActivity extends AppCompatActivity {

    private LinearLayout group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        initView();
    }

    private void initView() {
        group = (LinearLayout) findViewById(R.id.activity_group);
        LayoutTransition mLayoutTransition = new LayoutTransition();

        //设置每个动画持续的时间
        mLayoutTransition.setStagger(LayoutTransition.CHANGE_APPEARING, 50);
        mLayoutTransition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 50);
        mLayoutTransition.setStagger(LayoutTransition.APPEARING, 50);
        mLayoutTransition.setStagger(LayoutTransition.DISAPPEARING, 50);

        PropertyValuesHolder appearingScaleX = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f);
        PropertyValuesHolder appearingScaleY = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f);
        PropertyValuesHolder appearingAlpha = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
        //这里的this是target，可以写this，因为最后是设置到group里
        ObjectAnimator mAnimatorAppearing = ObjectAnimator.ofPropertyValuesHolder(this, appearingAlpha,
                appearingScaleX, appearingScaleY);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(LayoutTransition.APPEARING, mAnimatorAppearing);


        PropertyValuesHolder disappearingAlpha = PropertyValuesHolder.ofFloat("alpha", 1f, 0f);
        PropertyValuesHolder disappearingRotationY = PropertyValuesHolder.ofFloat("rotationY", 0.0f, 90.0f);
        ObjectAnimator mAnimatorDisappearing = ObjectAnimator.ofPropertyValuesHolder(this, disappearingAlpha,
                disappearingRotationY);

        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(LayoutTransition.DISAPPEARING, mAnimatorDisappearing);

        ObjectAnimator mAnimatorChangeDisappearing = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mAnimatorChangeDisappearing);

        ObjectAnimator mAnimatorChangeAppearing = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f);
        //为LayoutTransition设置动画及动画类型
        mLayoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, mAnimatorChangeAppearing);

        //为mImageViewGroup设置mLayoutTransition对象
        group.setLayoutTransition(mLayoutTransition);
    }

    public void add(View view){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group.removeView(v);
            }
        });
        group.addView(imageView);
    }

}
