package com.example.alex.weartest;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimationActivity extends Activity implements View.OnClickListener {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        tv = (TextView) findViewById(R.id.text);
        tv.setOnClickListener(this);
        startAnimation();
    }

    private void startAnimation(){
        Animation anim = null;
        Bundle b = getIntent().getExtras();
        int i = b.getInt("animation");
        switch (i){
            case 0:
                anim = AnimationUtils.loadAnimation(this, R.anim.bounce);
                break;
            case 1:
                anim = AnimationUtils.loadAnimation(this, R.anim.jump);
                break;
            case 2:
                anim = AnimationUtils.loadAnimation(this, R.anim.rotation);
                break;
            case 3:
                ArrayList<Integer> arr = new ArrayList<>();
                ValueAnimator anim1 = ValueAnimator.ofInt(Color.BLACK, Color.RED);
                anim1.setDuration(1000);
                anim1.setEvaluator(new ArgbEvaluator());
                anim1.setRepeatCount(3);
                anim1.setRepeatMode(ValueAnimator.REVERSE);
                anim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        tv.setTextColor((Integer) animation.getAnimatedValue());
                    }
                });
                anim1.start();
        }
        if(anim != null)
            tv.startAnimation(anim);
    }

    @Override
    public void onClick(View v) {
        startAnimation();
    }
}