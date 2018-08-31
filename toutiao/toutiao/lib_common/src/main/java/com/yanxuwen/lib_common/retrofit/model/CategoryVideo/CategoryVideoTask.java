package com.yanxuwen.lib_common.retrofit.model.CategoryVideo;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.lib_common.retrofit.MyBaseTask;
import com.yanxuwen.lib_common.DB.CategoryVideoDB;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import java.lang.reflect.Type;

import rx.Observable;


/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("视频分类")
public class CategoryVideoTask extends MyBaseTask {
    CategoryVideoDB db;
    CategoryVideoBuild mBuild;
    public CategoryVideoTask(Context context, ObserverListener ob) {
        super(context,ob);
        db=new CategoryVideoDB(context);
        mBuild=new CategoryVideoBuild(context);
    }
    @Override
    public Observable<String> getObservable() {
        return  ((CategoryVideoApi)getBaseApi()).onPostman(System.currentTimeMillis(),(System.currentTimeMillis()/1000));

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
        return Msg.CategoryVideo;
    }
    @Override
    public MyBaseRequest requestClass() {
        return mBuild;
    }
    @Override
    public Type returnClass() {
        return CategoryVideo.class;
    }
    @Override
    public  Class<?> getBaseApiClass() {return CategoryVideoApi.class;}
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
            CategoryVideo mCategoryVideo=(CategoryVideo)object;
            if(mCategoryVideo!=null&&mCategoryVideo.getData()!=null&&mCategoryVideo.getData()!=null){
                int insert_index=-1;
                for (int i=0;i<mCategoryVideo.getData().size();i++){
                    if(mCategoryVideo.getData().get(i).getCategory()=="video"){
                        insert_index=-1;
                        break;
                    }
                    if(i>1){
                        break;
                    }
                    insert_index++;
                }
                if (insert_index>=0){
                    CategoryVideo.DataBean dataBean=new CategoryVideo.DataBean();
                    dataBean.setCategory("video");
                    dataBean.setName("推荐");
                    mCategoryVideo.getData().add(insert_index,dataBean);
                }
                db.onWrite(mCategoryVideo.getData(),true);
            }
        }
    }
    @Override
    public void onFail(Object object){
        super.onFail(object);
    }
}

