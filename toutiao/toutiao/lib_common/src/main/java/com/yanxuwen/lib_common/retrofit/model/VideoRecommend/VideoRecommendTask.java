package com.yanxuwen.lib_common.retrofit.model.VideoRecommend;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;

@Description("视频推荐")
public class VideoRecommendTask extends MyBaseTask {
    VideoRecommendBuild mBuild;
    public VideoRecommendTask(Context context, ObserverListener ob, String video_id, String group_id, String item_id) {
        super(context,ob);
        mBuild=new VideoRecommendBuild(context);
        mBuild.setVideo_id(video_id);
        mBuild.setGroup_id(group_id);
        mBuild.setItem_id(item_id);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((VideoRecommendApi)getBaseApi()).onPostman(mBuild.getGroup_id(),mBuild.getItem_id());
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
        return Msg.VideoRecommend;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return VideoRecommend.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return VideoRecommendApi.class;}
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

