package com.example.app.myapplication.Activity.Login.Welcome;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.app.myapplication.Activity.Main.MainActivity;
import com.example.app.myapplication.R;
import com.yanxuwen.lib_common.Base.BaseActivity;
import com.yanxuwen.lib_common.Bean.ARouterPath;
import com.yanxuwen.lib_common.Bean.Value;
import com.yanxuwen.lib_common.DB.CategoryDB;
import com.yanxuwen.lib_common.DB.CategoryVideoDB;
import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.model.Category.Category;
import com.yanxuwen.lib_common.retrofit.model.CategoryVideo.CategoryVideo;
import com.yanxuwen.myutils.Utils.SDUtils;

import java.io.File;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：严旭文 on 2016/6/20 10:37
 * 邮箱：420255048@qq.com
 */
@Route(path= ARouterPath.App_WelcomeActivity)
public class WelcomeActivity extends BaseActivity implements IWelcomeContract.View{
    public boolean isFinishCategory=false;
    public boolean isFinishCategoryVideo=false;

    CategoryDB dbCategory;
    CategoryVideoDB dbCategoryVideo;

    IWelcomeContract.Presenter mPresenter;
    protected void onCreate(Bundle savedInstanceState) {

        // 隐藏状态栏
        isChangeText=true;
        setContentView(R.layout.activity_welcome);
        super.onCreate(savedInstanceState);
        setSlideable(false);
        setStatusFull(true);


    }
    @Override
    public void initData() {
        dbCategory=new CategoryDB(context);
        dbCategoryVideo=new CategoryVideoDB(context);
        mRequestUtils.requestCategory();
        mRequestUtils.requestCategoryVideo();

    }

    @Override
    public void initView(Value.ObservableStatus status) {
        mPresenter=new WelcomePresenter(this,this);
        mPresenter.initData();
        setStatusFull(true);
    }

    /**
     * 根据情况判断跳转
     */
    @Override
    public void onJump(boolean isFirstIn){
        if(isFirstIn){
            onStartActivityFinish(new Intent(context, MainActivity.class));
        }else{
            onStartActivityFinish(new Intent(context, MainActivity.class));
        }
    }

    @Override
    public void onfinish() {
        finish();
    }

    /**
     * 请求数据返回结果
     * @param status 请求成功还是失败
     * @param type
     * @param object 类型
     */
    public void onNotifyData(STATUS status, String type, Object object){
//      if(isDataFail(status)){
//        return;
//      }
        switch(type){
            case Msg.VERSION:
                //定期删除安装包,最好在最新版本的时候没有更新，才执行删除
                SDUtils.delete(new File(SDUtils.getApkPath(this)));
                String url="http://android7bus-10016677.file.myqcloud.com/bbxpc_client_1.0.3_091802.apk";
                mPresenter.onUpdate(false, url);
                return;
            case Msg.Category:
                isFinishCategory=true;
                if (mRequestUtils.isDataFail(status)) {
                    onReadCategory();
                    return;
                }
                if(object!=null){
                    Category mCategory=(Category)object;
                    if(mCategory!=null&&mCategory.getData()!=null&&mCategory.getData().getData()!=null){
                        MainActivity.Companion.setDataBeenCategory(mCategory.getData().getData());
                        if(isFinishCategoryVideo){
                            mPresenter.onJump();
                        }
                    }else {
                        onReadCategory();
                    }
                }
                return;
            case Msg.CategoryVideo:
                isFinishCategoryVideo=true;
                if (mRequestUtils.isDataFail(status)) {
                    onReadCategoryVideo();
                    return;
                }
                if(object!=null){
                    CategoryVideo mCategoryVideo=(CategoryVideo)object;
                    if(mCategoryVideo!=null&&mCategoryVideo.getData()!=null){
                        MainActivity.Companion.setDataBeenCategoryVideo(mCategoryVideo.getData());
                        if(isFinishCategory){
                            mPresenter.onJump();
                        }
                    }else {
                        onReadCategoryVideo();
                    }
                }
                return;
            default:break;
        }
        super.onNotifyData(status,type,object);
    }
    public void onReadCategory(){
        Observable.just(dbCategory.onReadAll())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Category.DataBeanX.DataBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isFinishCategoryVideo){
                            mPresenter.onJump();
                        }
                    }

                    @Override
                    public void onNext(List<Category.DataBeanX.DataBean> dataBeen) {
                        MainActivity.Companion.setDataBeenCategory(dataBeen);
                        if(isFinishCategoryVideo){
                            mPresenter.onJump();
                        }
                    }
                });
    }
    public void onReadCategoryVideo() {
        Observable.just(dbCategoryVideo.onReadAll())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<CategoryVideo.DataBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isFinishCategory){
                            mPresenter.onJump();
                        }
                    }

                    @Override
                    public void onNext(List<CategoryVideo.DataBean> dataBeen) {
                        MainActivity.Companion.setDataBeenCategoryVideo(dataBeen);
                        if(isFinishCategory){
                            mPresenter.onJump();
                        }
                    }
                });
    }
}
