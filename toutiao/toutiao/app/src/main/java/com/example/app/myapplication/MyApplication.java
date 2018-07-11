package com.example.app.myapplication;

import android.view.WindowManager;

import com.yanxuwen.lib_common.BaseApplication;

/**
 * 作者：严旭文 on 2016/7/5 17:45
 * 邮箱：420255048@qq.com
 */
public class MyApplication extends BaseApplication {
//    public static synchronized MyApplication getInstance() {
//        return mApplication;
//    }
    @Override
    public void onCreate() {
        super.onCreate();
        isLog=BuildConfig.LOG_DEBUG;
    }
}
