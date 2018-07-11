package com.yanxuwen.lib_common.retrofit.model.Comment;

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
@Description("评论")
public class CommentTask extends MyBaseTask {
    CommentBuild mBuild;
    public CommentTask(Context context, ObserverListener ob, int offset, int count, String group_id, String item_id) {
        super(context,ob);
        mBuild=new CommentBuild(context);
        mBuild.setOffset(offset);
        mBuild.setCount(count);
        mBuild.setGroup_id(group_id);
        mBuild.setItem_id(item_id);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((CommentApi)getBaseApi()).onPostman(mBuild.getOffset(),mBuild.getCount(),mBuild.getGroup_id(),mBuild.getItem_id());

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
        return Msg.Comment;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return Comment.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return CommentApi.class;}
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
            Comment mComment=(Comment)object;
            if(mComment!=null){
                mComment.setRefresh(mBuild.getOffset()==0);
            }
        }
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

