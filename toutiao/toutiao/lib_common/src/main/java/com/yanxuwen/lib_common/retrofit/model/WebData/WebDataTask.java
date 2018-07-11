package com.yanxuwen.lib_common.retrofit.model.WebData;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("视频信息")
public class WebDataTask extends MyBaseTask {
    WebDataBuild mBuild;
    public WebDataTask(Context context, ObserverListener ob) {
        super(context,ob);
        mBuild=new WebDataBuild(context);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((WebDataApi)getBaseApi()).onPostman();

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
        return true;
    }
    @Override
    public String getDataType() {
        return "";
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return WebData.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return WebDataApi.class;}
    @Override
    public void onCompleted() {
        super.onCompleted();
    }
    @Override
    public void onError(Object object){
        super.onError(object);
    }
    @Override
    public void onSuccess(Object object){
        super.onSuccess(object);
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

