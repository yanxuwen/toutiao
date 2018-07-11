package com.yanxuwen.lib_common.widget.Behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by yanxuwen on 2017/9/11.
 * 由于系统自带的Behavior有时候会出现卡顿问题，所以重新自定义
 */

public final class FlingBehavior extends AppBarLayout.Behavior {

    private static final String TAG = FlingBehavior.class.getName();
    private static final int TOP_CHILD_FLING_THRESHOLD = 1;
    private static final float OPTIMAL_FLING_VELOCITY = 3500;
    private static final float MIN_FLING_VELOCITY = 20;

    boolean shouldFling = false;
    float flingVelocityY = 0;

    public FlingBehavior() {
    }

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target,
                                  int velocityX, int velocityY, int[] consumed) {

        super.onNestedPreScroll(coordinatorLayout, child, target, velocityX, velocityY, consumed);

        if (velocityY > MIN_FLING_VELOCITY) {
            shouldFling = true;
            flingVelocityY = velocityY;
        } else {
            shouldFling = false;
        }
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout abl, View target) {
        super.onStopNestedScroll(coordinatorLayout, abl, target);
        if (shouldFling) {
            Log.d(TAG, "onNestedPreScroll: running nested fling, velocityY is " + flingVelocityY);
            onNestedFling(coordinatorLayout, abl, target, 0, flingVelocityY, true);
        }
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target,
                                 float velocityX, float velocityY, boolean consumed) {

        if (target instanceof RecyclerView && velocityY < 0) {
            Log.d(TAG, "onNestedFling: target is recyclerView");
            final RecyclerView recyclerView = (RecyclerView) target;
            final View firstChild = recyclerView.getChildAt(0);
            final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
            consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
        }

        // prevent fling flickering when going up
        if (target instanceof NestedScrollView && velocityY > 0) {
            consumed = true;
        }

        if (Math.abs(velocityY) < OPTIMAL_FLING_VELOCITY) {
            velocityY = OPTIMAL_FLING_VELOCITY * (velocityY < 0 ? -1 : 1);
        }
        Log.d(TAG, "onNestedFling: velocityY - " + velocityY + ", consumed - " + consumed);

        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}
