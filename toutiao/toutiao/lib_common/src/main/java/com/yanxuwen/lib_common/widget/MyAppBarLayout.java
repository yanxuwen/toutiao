package com.yanxuwen.lib_common.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;

/**
 * Created by yanxuwen on 2017/9/12.
 */

public class MyAppBarLayout extends AppBarLayout {
    public MyAppBarLayout(Context context) {
        super(context);
    }
    public MyAppBarLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    @Override
    public float getTargetElevation() {
        return 100;
    }
}
