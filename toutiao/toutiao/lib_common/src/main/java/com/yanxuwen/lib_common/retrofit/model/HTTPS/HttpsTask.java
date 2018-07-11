package com.yanxuwen.lib_common.retrofit.model.HTTPS;

import android.app.Activity;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.retrofit.BaseRequest;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;


/**
 * 作者：严旭文 on 2016/4/25 16:53
 * 邮箱：420255048@qq.com
 */
public class HttpsTask extends MyBaseTask {
    MyBaseRequest mBuild;
    public HttpsTask(Activity context,ObserverListener ob) {
        super(context,ob);
        mBuild =new MyBaseRequest(context);
    }
    @Override
    public Observable<String> getObservable() {
        return ((HttpsApi)getBaseApi()).getString2();
    }
    @Override
    public boolean isEncrypt() {
        return true;
    }
    @Override
    public boolean isShow() {return true;}
    @Override
    public boolean isReturnString() {return false;}

    @Override
    public boolean isToast() {
        return true;
    }

    @Override
    public String getDataType() {
        return Msg.HTTPS;
    }
    @Override
    public BaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {return null;}
    @Override
    public Class<?> getBaseApiClass() {return HttpsApi.class;}
    @Override
    public void onCompleted() {
        super.onCompleted();
    }
    @Override
    public void onError(Object object) {
        super.onError(object);
    }
    @Override
    public void onSuccess(Object object) {
        super.onSuccess(object);
    }
    @Override
    public void onFail(Object object) {
        super.onFail(object);
    }
}
