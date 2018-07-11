package com.yanxuwen.lib_common.widget;

import android.support.design.widget.AppBarLayout;

/**
 * Created by yanxuwen on 2017/10/17.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;
    private boolean EXPANDED;
    private boolean COLLAPSED;
    private boolean IDLE;


    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            mCurrentState = State.EXPANDED;
            if (mCurrentState == State.EXPANDED&&!EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED,i);
                EXPANDED=true;
            }
            COLLAPSED=false;
            IDLE=false;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            mCurrentState = State.COLLAPSED;
            if (mCurrentState == State.COLLAPSED&&!COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED,i);
                COLLAPSED=true;
            }
            EXPANDED=false;
            IDLE=false;
        } else {
            mCurrentState = State.IDLE;
            if (mCurrentState == State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE,i);
            }
            EXPANDED=false;
            COLLAPSED=false;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state,int i);
}
