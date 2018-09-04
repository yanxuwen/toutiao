package com.yanxuwen.lib_common.Utils.video;

import android.content.Context;
import android.util.AttributeSet;

import com.yanxuwen.lib_common.R;

/**
 * Created by yanxw on 2018/9/3.
 */

public class LiveCoverVideo2 extends SampleCoverVideo {
    public LiveCoverVideo2(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public LiveCoverVideo2(Context context) {
        super(context);
    }

    public LiveCoverVideo2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public int getLayoutId() {
        return R.layout.common_live_layout_cover2;
    }

}
