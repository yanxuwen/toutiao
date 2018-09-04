package com.yanxuwen.lib_common.widget.liveAnim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.yanxuwen.MyRecyclerview.progressindicator.indicator.BaseIndicatorController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2015/10/19.
 */
public class LineScaleIndicator extends BaseIndicatorController {

    public static final float SCALE=1.0f;

    float[] scaleYFloats=new float[]{SCALE,
            SCALE,
            SCALE,};

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float translateX=getWidth()/11;
        float translateY=getHeight()/2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate((1 + i * 2.2f) * translateX - translateX / 2, translateY);
            canvas.scale(SCALE, scaleYFloats[i]);
            RectF rectF=new RectF(-translateX/2,-getHeight()/2.5f,translateX/2,getHeight()/2.5f);
            canvas.drawRoundRect(rectF, 3, 3, paint);
            canvas.restore();
        }
    }

    @Override
    public List<Animator> createAnimation() {
        List<Animator> animators=new ArrayList<>();
        long[] delays=new long[]{100,200,300};
        for (int i = 0; i < 3; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1, 0.4f, 1);
            scaleAnim.setDuration(500);
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
