package com.yanxuwen.lib_common.retrofit.model.Category;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.lib_common.DB.CategoryDB;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;


/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("分类")
public class CategoryTask extends MyBaseTask {
    CategoryDB db;
    CategoryBuild mBuild;
    public CategoryTask(Context context, ObserverListener ob) {
        super(context,ob);
        db=new CategoryDB(context);
        mBuild=new CategoryBuild(context);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((CategoryApi)getBaseApi()).onPostman(System.currentTimeMillis(),(System.currentTimeMillis()/1000));

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
        return Msg.Category;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return Category.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return CategoryApi.class;}
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
        if(object!=null){
            Category mCategory=(Category)object;
            if(mCategory!=null&&mCategory.getData()!=null&&mCategory.getData().getData()!=null){
                db.onWrite(mCategory.getData().getData(),true);
            }
        }
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

