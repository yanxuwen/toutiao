package com.zhengchen.Utils.anim;

import android.view.View;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator;

import java.util.ArrayList;
import java.util.List;

public class AnimHelper {
    private static final long DURATION = BaseViewAnimator.DURATION;
    private static final long NO_DELAY = 0;

	public static AnimationComposer with(BaseViewAnimator animator) {
        return new AnimationComposer(animator);
    }

    public static final class AnimationComposer {

        private List<Animator.AnimatorListener> callbacks = new ArrayList<Animator.AnimatorListener>();

        private BaseViewAnimator animator;
        private long duration = DURATION;
        private long delay = NO_DELAY;
        private Interpolator interpolator;
        private View target;

        private AnimationComposer(BaseViewAnimator animator) {
            this.animator = animator;
        }

        public AnimationComposer duration(long duration) {
            this.duration = duration;
            return this;
        }

        public AnimationComposer delay(long delay) {
            this.delay = delay;
            return this;
        }

        public AnimationComposer interpolate(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }


        public AnimationComposer withListener(Animator.AnimatorListener listener) {
            callbacks.add(listener);
            return this;
        }

        public AnimManager playOn(View target) {
            this.target = target;
            return new AnimManager(play(), this.target);
        }
        
        private BaseViewAnimator play() {
            animator.setTarget(target);
            animator.setDuration(duration)
                    .setInterpolator(interpolator)
                    .setStartDelay(delay);

            if (callbacks.size() > 0) {
                for (Animator.AnimatorListener callback : callbacks) {
                    animator.addAnimatorListener(callback);
                }
            }

            animator.animate();
            return animator;
        }
    }
    
    public static final class AnimManager{

        private BaseViewAnimator animator;
        private View target;

        private AnimManager(BaseViewAnimator animator, View target){
            this.target = target;
            this.animator = animator;
        }

        public boolean isStarted(){
            return animator.isStarted();
        }

        public boolean isRunning(){
            return animator.isRunning();
        }

        public void stop(boolean reset){
            animator.cancel();

            if(reset)
                animator.reset(target);
        }
    }

}
