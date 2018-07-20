package com.zhengchen.weight.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 */
public class NoScrollViewPager extends ViewPager {
    private boolean noScroll = false;
    public interface OnMyTouchListener{
        public boolean onTouch(MotionEvent event);
    }
    public OnMyTouchListener mOnMyTouchListener;
    public void setOnMyTouchListener(OnMyTouchListener mOnMyTouchListener){
        this.mOnMyTouchListener=mOnMyTouchListener;
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }
    public boolean getNoScroll(){
        return  noScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    float downX=0;
    float downY=0;
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("xxx","xxxxxxxxxxxxxxxxxxx"+event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:{
                return false;
            }
            case MotionEvent.ACTION_MOVE:{
                Log.e("xxx","xxxxxxxxxxxxxxxxxxx");
            }
        }
        if (noScroll)return false;

        else
            return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (noScroll)
            return false;
        else{
            boolean mreturn = false;
            if(mOnMyTouchListener!=null)mreturn=mOnMyTouchListener.onTouch(event);
            return mreturn?mreturn:super.onInterceptTouchEvent(event);
        }


    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
    }



}