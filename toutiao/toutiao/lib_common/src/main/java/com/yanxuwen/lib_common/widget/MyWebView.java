package com.yanxuwen.lib_common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by yanxuwen on 2017/6/7.
 */

public class MyWebView extends WebView {
    public boolean isClick=true;

    public MyWebView(Context context, AttributeSet attrs, int defStyle,
                     boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
        // TODO Auto-generated constructor stub
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyWebView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
         if(isClick){
             return super.onTouchEvent(ev);
         }
        return true;
    }
    public void setIsClick(boolean isClick){
        this.isClick=isClick;
    }
}