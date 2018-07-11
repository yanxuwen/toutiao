package com.yanxuwen.lib_common.retrofit.model.Token;

import android.content.Context;

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
public class TokenTask extends MyBaseTask {
    MyBaseRequest mBuild;
    public TokenTask(Context context, ObserverListener ob) {
        super(context,ob);
        mBuild =new TokenBuild(context);
        mBuild.access_token="QcTfVgAAAAAHALMfqOxKcR8pHctCebKcxktS";
        mBuild.uid="917048770148592";
    }
    @Override
    public Observable<String> getObservable() {
        return  ((TokenApi)getBaseApi()).postString(getRequestBody());
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
        return Msg.TOKEN;
    }
    @Override
    public BaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {return Token.class;}
    @Override
    public Class<?> getBaseApiClass() {return TokenApi.class;}
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
