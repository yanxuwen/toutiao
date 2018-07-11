package com.yanxuwen.lib_common.retrofit.model.NewsList;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;

@Description("新闻列表")
public class NewsListTask extends MyBaseTask {
    NewsListBuild mBuild;
    public NewsListTask(Context context, ObserverListener ob, boolean refresh, int refresh_idx, int count, int list_count, String category, String behot_time) {
        super(context,ob);
        mBuild=new NewsListBuild(context);
        mBuild.setRefresh_reason((refresh?1:0));
        mBuild.setTt_from(refresh?"pull":"pre_load_more");
        mBuild.setSession_refresh_idx(refresh_idx);
        mBuild.setCount(count);
        mBuild.setList_count(list_count);
        mBuild.setCategory(category);
        mBuild.setMax_behot_time(behot_time);
        mBuild.setMin_behot_time(behot_time);

    }
    @Override
    public Observable<String> getObservable() {
        if(mBuild.getCategory().equals("recommend")){
            if(mBuild.getRefresh_reason()==1){
                return  ((NewsListApi)getBaseApi()).onPostmanRefreshRecommend(mBuild.getTt_from(),mBuild.getRefresh_reason(),mBuild.getSession_refresh_idx(),mBuild.getCount(),mBuild.getList_count(),mBuild.getMin_behot_time());
            }else{
                return  ((NewsListApi)getBaseApi()).onPostmanLoadRecommend(mBuild.getTt_from(),mBuild.getCount(),mBuild.getList_count(),mBuild.getMax_behot_time());

            }
        }else{
            if(mBuild.getRefresh_reason()==1){
                return  ((NewsListApi)getBaseApi()).onPostmanRefresh(mBuild.getTt_from(),mBuild.getRefresh_reason(),mBuild.getSession_refresh_idx(),mBuild.getCount(),mBuild.getList_count(),mBuild.getCategory(),mBuild.getMin_behot_time());
            }else{
                return  ((NewsListApi)getBaseApi()).onPostmanLoad(mBuild.getTt_from(),mBuild.getCount(),mBuild.getList_count(),mBuild.getCategory(),mBuild.getMax_behot_time());

            }
        }

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
        return Msg.NewsList;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return NewsList.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return NewsListApi.class;}
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

