package com.yanxuwen.lib_common;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.yanxuwen.lib_common.ARouter.MyARouter;
import com.yanxuwen.lib_common.Bean.Config;
import com.yanxuwen.myutils.Utils.CrashHandler;
import com.yanxuwen.myutils.Utils.LogUtils;
import com.yanxuwen.myutils.Utils.SDUtils;
import com.yanxuwen.retrofit.api.ApiManager;

import java.io.File;

/**
 * Created by yxe on 2018/4/6.
 */

public class BaseApplication extends Application {
    public  boolean isLog=true;
    public RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
        //retroft初始化
        Config mConfig= Config.getInstance();
        ApiManager.init(mConfig.BASE_URL);
        ApiManager.initSSLSocketFactory("srca.cer");
        ApiManager.initHttpsType(ApiManager.HttpType.HTTP);


        if (BuildConfig.DEBUG) {
            //一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
            MyARouter.openDebug();
            MyARouter.openLog();
        }
        ARouter.init(this);
        MyARouter.init(this);


        //内存检测
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }else{
            refWatcher= LeakCanary.install(this);
//        }
    }


    /**
     * 初始化Log
     */
    public void initLog(){
        //初始化崩溃日志，默认位置为根目录/apk名字/crash
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        //传递log保存路径，确保已microlog.properties设置的路径一样
        String logpath= SDUtils.getAPPPath(this) + File.separator + "log";
        LogUtils.initConfig(this,logpath);
        //判断log文件大小
        File filelog=new File(logpath,"mylog.txt");
        try{
            long size=SDUtils.getFileSize(filelog);
            //如果大于5M则删掉文件
            if(size>=5*1024*1000){
                SDUtils.delete(filelog);
            }}catch (Exception e){}

    }
    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication application = (BaseApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
