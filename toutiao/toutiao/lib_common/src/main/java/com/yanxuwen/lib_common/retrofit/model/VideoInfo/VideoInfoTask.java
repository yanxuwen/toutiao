package com.yanxuwen.lib_common.retrofit.model.VideoInfo;

import android.content.Context;

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
@Description("视频信息")
public class VideoInfoTask extends MyBaseTask {
    VideoInfoBuild mBuild;
    public VideoInfoTask(Context context, ObserverListener ob, String video_id, String item_id) {
        super(context,ob);
        mBuild=new VideoInfoBuild(context);
        mBuild.setVideo_id(video_id);
        mBuild.setItem_id(item_id);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((VideoInfoApi)getBaseApi()).onPostman(mBuild.getVideo_id(),mBuild.getItem_id());

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
        return Msg.VideoInfo;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return VideoInfo.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return VideoInfoApi.class;}
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

