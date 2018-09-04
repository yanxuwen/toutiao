package com.yanxuwen.lib_common.widget.liveAnim;

import android.animation.Animator;
import android.animation.ValueAnimator;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by yanxw on 2018/9/3.
 */

public class LineScalePulseOutRapidIndicator extends LineScaleIndicator {

    @Override
    public List<Animator> createAnimation() {
        List<Animator> animators=new ArrayList<>();
        long[] delays=new long[]{400,200,0};
        for (int i = 0; i < 3; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(0.7f,0.2f,0.7f);
            scaleAnim.setDuration(600);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleYFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.start();
            animators.add(scaleAnim);
        }
        return animators;
    }

}
