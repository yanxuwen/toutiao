package com.yanxuwen.lib_common.retrofit.model.Version;

import android.app.Activity;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.myutils.Utils.ToastUtil;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;

/**
 * 作者：严旭文 on 2016/7/4.
 * 邮箱：420255048@qq.com
 */
public class VersionTask extends MyBaseTask {
    VersionBuild mBuild;
    Activity context;
    public VersionTask(Activity context,ObserverListener ob) {
        super(context,ob);
        this.context=context;
        mBuild=new VersionBuild(context);
        mBuild.platform=0;
        mBuild.channel="bus";
        mBuild.version="3.5.0";
    }
    @Override
    public Observable<String> getObservable() {
        return  ((VersionApi)getBaseApi()).postString(getRequestBody());
    }
    @Override
    public boolean isEncrypt() {
        return true;
    }
    @Override
    public boolean isShow() {
        return false;
    }
    @Override
    public boolean isReturnString() {
        return false;
    }
    @Override
    public String getDataType() {
        return Msg.VERSION;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return Version.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return VersionApi.class;}
    @Override
    public void onCompleted() {
        super.onCompleted();
    }
    @Override
    public void onError(Object object){
        super.onError(object);
        ToastUtil.showToast(context,"报错");
    }
    @Override
    public void onSuccess(Object object){
        super.onSuccess(object);
        ToastUtil.showToast(context,"检测成功");
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
        ToastUtil.showToast(context,"检测失败");
    }
}

