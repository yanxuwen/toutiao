package com.example.app.myapplication.Activity.Login.Welcome;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

import com.example.app.myapplication.Bean.ShareKey;
import com.yanxuwen.lib_common.Base.BaseActivity;
import com.yanxuwen.lib_common.update.MyUpdateLoad;
import com.yanxuwen.mydialog.widget.MyAlertDialog;
import com.yanxuwen.myutils.Utils.DateFormat;
import com.yanxuwen.myutils.Utils.SPUtils;

/**
 * 作者：严旭文 on 2016/8/11 09:18
 * 邮箱：420255048@qq.com
 */
public class WelcomePresenter implements IWelcomeContract.Presenter {
    boolean isFirstIn;
    private long starttime;
    private static  long SPLASH_DELAY_MILLIS = 1000;
    private Activity context;
    IWelcomeContract.View mView;
    public WelcomePresenter(Activity context,IWelcomeContract.View mView) {
        this.context=context;
        this.mView = mView;
    }

    @Override
    public void initData() {
        starttime = DateFormat.getTime();
        isFirstIn = (boolean) SPUtils.get(context,
                ShareKey.isFirstIn, true);
//        RequestUtils.requestVersion(context);
//        onJump();
    }
    @Override
    public void onJump() {
        long currentTime = DateFormat.getTime();
        long differTime = currentTime - starttime;
        long delayMillis = 0;
        if (differTime < SPLASH_DELAY_MILLIS) {
            delayMillis = SPLASH_DELAY_MILLIS - differTime;
        }
        ((BaseActivity)context).mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.onJump(isFirstIn);
            }
        }, delayMillis);
    }
    @Override
    public void onUpdate(final boolean isForce, final String url) {
        {
            final MyAlertDialog alertdialog=new MyAlertDialog(context);
            //强制
            if(isForce){
                alertdialog.setTitle("提醒");
                alertdialog.setMsg("有新的版本？");
                alertdialog.setCancelable(false);
                alertdialog.setPositiveButton("更新", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyUpdateLoad mMyUpdateLoad=new MyUpdateLoad();
                        mMyUpdateLoad.downloadApk(context, isForce, MyUpdateLoad.UpdateType.TYPE_QIDONG,url,"3.5.0");
                        mMyUpdateLoad.getDialog().getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                mView.onfinish();
                            }
                        });
                    }
                });
                alertdialog.show();
            }
            //不强制
            else{
                alertdialog.setTitle("提醒");
                alertdialog.setMsg("有新的版本？");
                alertdialog.setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
                alertdialog.setPositiveButton("更新", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyUpdateLoad mMyUpdateLoad = new MyUpdateLoad();
                        mMyUpdateLoad.downloadApk(context, isForce, MyUpdateLoad.UpdateType.TYPE_QIDONG, url, "3.5.0");
                    }
                });
                alertdialog.show();
                alertdialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        onJump();
                    }
                });
            }
        }
    }
}
