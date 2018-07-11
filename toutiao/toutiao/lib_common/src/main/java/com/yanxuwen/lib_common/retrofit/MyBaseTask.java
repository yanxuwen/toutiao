package com.yanxuwen.lib_common.retrofit;

/**
 * Created by yxe on 2017/6/17.
 */

import android.app.Activity;
import android.content.Context;

import com.yanxuwen.lib_common.BaseApplication;
import com.yanxuwen.lib_common.Bean.Config;
import com.yanxuwen.lib_common.Bean.HttpError;
import com.yanxuwen.loadview.LoadingDialog;
import com.yanxuwen.myutils.Utils.ToastUtil;
import com.yanxuwen.retrofit.BaseRequest;
import com.yanxuwen.retrofit.BaseTask;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;
import java.util.Map;

import rx.Observable;

public class MyBaseTask extends BaseTask{
    protected Integer API_ERROR_CODE[];
    public LoadingDialog loadview;

    /**
     * 初始化API_ERROR_CODE的值
     */
    public void  initApiCode(){

    }
    public MyBaseTask(final Context context, ObserverListener ob) {
        super(context,ob);
        initApiCode();
        if(API_ERROR_CODE!=null){
            onHttpFailConditionCode(API_ERROR_CODE);
        }else{
            setSuccessConditionCode(0);
        }
        if(context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadview = new LoadingDialog(context, Config.getInstance().LOADDIALOGTIME);
                }
            });
        }


    }

    @Override
    public Observable<String> getObservable() {
        return null;
    }

    @Override
    public String getDataType() {
        return null;
    }

    @Override
    public BaseRequest requestClass() {
        return null;
    }

    @Override
    public Class<?> getBaseApiClass() {
        return null;
    }

    @Override
    public Type returnClass() {
        return null;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Object object) {

    }

    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void onFail(Object object) {
        //由于后台不翻译，所以我们根据error返回的信息，进行判断是什么错误，然后Toast出来
        if(object!=null){
            MyBaseModel mMyBaseModel=(MyBaseModel)object;
            if(mMyBaseModel!=null&&mMyBaseModel.getError()!=null){
                ToastUtil.showToast(context, HttpError.getInstance().getValue(mMyBaseModel.getError()));
            }
        }
    }
    public Map<String,String> addHeaders(){
        return null;
    }
    /**是否加密,默认不加密*/
    public boolean isEncrypt(){return false;}
    /** 设置是否显示加载框,模式是*/
    public  boolean isShow(){return true;}
    /** 设置是否显示Log*/
    public  boolean isLog(){return  ((BaseApplication)(((Activity)context)).getApplication()).isLog;}
    /**是否直接返回String,默认为false*/
    public  boolean isReturnString(){return false;};
    /**是否统一显示后台返回的提示文字,默认false*/
    public  boolean isToast(){return false;}

    /*显示加载框*/
    public void onShowLoading(){
        if (loadview != null && !loadview.isShowing()) {
            loadview.show();
        }
    }
    /*取消加载框*/
    public void onDismissLoading(){
        if (loadview != null) {
            loadview.onDismiss();
        }
    }
    /*加密*/
    public String onEncrypti(String json){return json;}
    /*解密*/
    public String onDecrypt(String json){return json;}


}
