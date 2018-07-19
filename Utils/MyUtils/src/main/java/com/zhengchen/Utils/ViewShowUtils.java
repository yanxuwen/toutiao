package com.zhengchen.Utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by yanxuwen on 2017/10/11.
 */

public class ViewShowUtils {
    /**显示view，则用动画效果显示出来。*/
    public static void showAlphaView(View v,int duration){
        if(v==null||v.isShown())return;
        ObjectAnimator anim = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
        anim.setDuration(duration);
        anim.start();
        v.setVisibility(View.VISIBLE);
    }
    /**显示view，则用动画效果隐藏起来。*/
    public static void hideAlphaView(final View v, int duration){
        if(v==null||!v.isShown())return;
        ObjectAnimator anim = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f);
        anim.setDuration(duration);
        anim.start();
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}
            @Override
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(View.GONE);}
            @Override
            public void onAnimationCancel(Animator animation) {}
            @Override
            public void onAnimationRepeat(Animator animation) {}
        });
    }

    public static ObjectAnimator showRotationView(View v,int duration){
        if(v==null)return null;
        ObjectAnimator animator = ObjectAnimator.ofFloat(v,"rotation",0,360);
        animator.setDuration(duration);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }
}
