package com.yanxuwen.lib_common.retrofit.model.SearchSuggest;

import android.content.Context;

import com.google.gson.Gson;
import com.yanxuwen.lib_common.DB.SearchSuggestDB;
import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;


/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("分类")
public class SearchSuggestTask extends MyBaseTask {
    SearchSuggestDB db;
    SearchSuggestBuild mBuild;
    public SearchSuggestTask(Context context, ObserverListener ob,String category) {
        super(context,ob);
        db=new SearchSuggestDB(context,category);
        SearchSuggestBuild.SuggestWordBeanX.SuggestWordBean mSuggestWordBean=new  SearchSuggestBuild.SuggestWordBeanX.SuggestWordBean();
        mSuggestWordBean.setSug_category(category);
        mSuggestWordBean.setFrom("feed");
        SearchSuggestBuild.SuggestWordBeanX mSuggestWordBeanX=new  SearchSuggestBuild.SuggestWordBeanX();

        mSuggestWordBeanX.setSuggest_word(mSuggestWordBean);
        mBuild=new SearchSuggestBuild(context);
        Gson gson=new Gson();
        mBuild.setSuggest_params(gson.toJson(mSuggestWordBeanX));
        mBuild.setRecom_cnt(3);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((SearchSuggestApi)getBaseApi()).onPostman(mBuild.getSuggest_params(),mBuild.getRecom_cnt());

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
        return Msg.SearchSuggest;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return SearchSuggest.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return SearchSuggestApi.class;}
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
            SearchSuggest mSearchSuggest=(SearchSuggest)object;
            if(mSearchSuggest!=null&&mSearchSuggest.getData()!=null){
                db.onWrite(mSearchSuggest.getData());
            }
        }
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

