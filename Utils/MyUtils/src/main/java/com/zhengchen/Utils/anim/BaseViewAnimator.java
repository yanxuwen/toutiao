package com.zhengchen.Utils.anim;

import android.view.View;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.view.ViewHelper;

public abstract class BaseViewAnimator {

	public static final long DURATION = 1000;

	private AnimatorSet mAnimatorSet;
	private long mDuration = DURATION;

	{
		mAnimatorSet = new AnimatorSet();
	}


	protected abstract void prepare(View target);

	public BaseViewAnimator setTarget(View target) {
		reset(target);
		prepare(target);
		return this;
	}

	public void animate() {
		start();
	}

	/**
	 * reset the view to default status
	 *
	 * @param target
	 */
	public void reset(View target) {
		ViewHelper.setAlpha(target, 1);
		ViewHelper.setScaleX(target, 1);
		ViewHelper.setScaleY(target, 1);
		ViewHelper.setTranslationX(target, 0);
		ViewHelper.setTranslationY(target, 0);
		ViewHelper.setRotation(target, 0);
		ViewHelper.setRotationY(target, 0);
		ViewHelper.setRotationX(target, 0);
		ViewHelper.setPivotX(target, target.getMeasuredWidth() / 2.0f);
		ViewHelper.setPivotY(target, target.getMeasuredHeight() / 2.0f);
	}

	/**
	 * start to animate
	 */
	public void start() {
		mAnimatorSet.setDuration(mDuration);
		mAnimatorSet.start();
	}

	public BaseViewAnimator setDuration(long duration) {
		mDuration = duration;
		return this;
	}

	public BaseViewAnimator setStartDelay(long delay) {
		getAnimatorAgent().setStartDelay(delay);
		return this;
	}

	public long getStartDelay() {
		return mAnimatorSet.getStartDelay();
	}

	public BaseViewAnimator addAnimatorListener(AnimatorListener l) {
		mAnimatorSet.addListener(l);
		return this;
	}

	public void cancel(){
		mAnimatorSet.cancel();
	}

	public boolean isRunning(){
		return mAnimatorSet.isRunning();
	}

	public boolean isStarted(){
		return mAnimatorSet.isStarted();
	}

	public void removeAnimatorListener(AnimatorListener l) {
		mAnimatorSet.removeListener(l);
	}

	public void removeAllListener() {
		mAnimatorSet.removeAllListeners();
	}

	public BaseViewAnimator setInterpolator(Interpolator interpolator) {
		mAnimatorSet.setInterpolator(interpolator);
		return this;
	}

	public long getDuration() {
		return mDuration;
	}

	public AnimatorSet getAnimatorAgent() {
		return mAnimatorSet;
	}

}