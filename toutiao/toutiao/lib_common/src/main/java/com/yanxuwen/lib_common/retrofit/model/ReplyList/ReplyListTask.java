package com.yanxuwen.lib_common.retrofit.model.ReplyList;

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
public class ReplyListTask extends MyBaseTask {
    ReplyListBuild mBuild;
    public ReplyListTask(Context context, ObserverListener ob, int offset, int count, String id) {
        super(context,ob);
        mBuild=new ReplyListBuild(context);
        mBuild.setOffset(offset);
        mBuild.setCount(count);
        mBuild.setId(id);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((ReplyListApi)getBaseApi()).onPostman(mBuild.getOffset(),mBuild.getCount(),mBuild.getId());

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
        return Msg.ReplyList;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return ReplyList.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return ReplyListApi.class;}
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
            ReplyList mReplyList=(ReplyList)object;
            if(mReplyList!=null){
                mReplyList.setRefresh(mBuild.getOffset()==0);
            }
        }
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

