package com.yanxuwen.lib_common.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;

import com.yanxuwen.Base.SlidingActivity;
import com.yanxuwen.lib_common.Bean.Config;
import com.yanxuwen.lib_common.Bean.Extra.fragment.BasefragmentMsg;
import com.yanxuwen.lib_common.Bean.Value;
import com.yanxuwen.lib_common.FrameLayout.Base.BaseFragment;
import com.yanxuwen.lib_common.Listener.OnFragmentResultListener;
import com.yanxuwen.lib_common.R;
import com.yanxuwen.lib_common.Utils.RequestUtils;
import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.lib_common.retrofit.MyObserverListener;
import com.yanxuwen.loadview.LoadingDialog;
import com.yanxuwen.myutils.Utils.ToastUtil;
import com.yanxuwen.myutils.widget.StatusBar.StatusBar;
import com.yanxuwen.retrofit.Msg.ObserverListener;
import com.yanxuwen.retrofit.Msg.Publisher;
import com.yanxuwen.swipebacklibrary.IntentUtils;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bbxpc on 2016/3/17.
 */
public abstract class BaseActivity  extends SlidingActivity implements MyObserverListener,OnFragmentResultListener {
    public int revealX,revealY;
    public static Handler mHandler=new Handler();
    public RequestUtils mRequestUtils;
    public Publisher mPublisher;
    public Activity context;
    public LoadingDialog loadview;
    /**请求的code*/
    public int requestCode;
    public OnFragmentResultListener mOnFragmentResultListener;
    public void setOnFragmentResultListener(OnFragmentResultListener listener) {
        mOnFragmentResultListener = listener;
    }
    /**onBackPressed关闭后调用接口*/
    public void onFragmentResult(int requestCode, int resultCode, Intent data){}
    /**
     *加载数据，主要一些数据库
     */
    abstract public void initData();
    /**
     *initData执行完成后调用，主要设置试图
     */
    abstract public void initView(Value.ObservableStatus status);
    protected void onResume() {
        super.onResume();
        /**友盟统计*/
//        MobclickAgent.onResume(this);
    }
    protected void onPause() {
        super.onPause();
        /**友盟统计*/
//        MobclickAgent.onPause(this);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        context=this;
        getWindow().setBackgroundDrawable(null);
        StatusBar.setTranslucentStatus(this, isChangeText);
        try{setBackgroundColor(R.color.common_background);
        }catch (Exception e){}
        //6.0以上的更改状态栏文字颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //避免在状态栏的显示状态发生变化时重新布局
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        loadview=new LoadingDialog(this, Config.getInstance().LOADDIALOGTIME);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);////竖屏
        Observable.create(new Observable.OnSubscribe<Value.ObservableStatus>() {
            @Override
            public void call(Subscriber<? super Value.ObservableStatus> subscriber) {
                if (loadview != null && !loadview.isShowing()) {
                    loadview.show();
                }
                mRequestUtils=new RequestUtils(context,BaseActivity.this);
                mPublisher=new Publisher();
                //添加观察者
                mPublisher.setOb(BaseActivity.this);
                initData();
                subscriber.onNext(Value.ObservableStatus.SUCCESS);
                subscriber.onCompleted();


            }
        })
                .subscribeOn(Schedulers.io()) //事件发送，即图片加载在IO线程
                .observeOn(AndroidSchedulers.mainThread())  //事件处理，即图片显示在UI线程
                .subscribe(new Subscriber<Value.ObservableStatus>() {
                    @Override
                    public void onCompleted() {
                        if (loadview != null) {
                            loadview.onDismiss();
                        }


//                if(!isReveal)return;
//                layoutContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            layoutContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                        } else {
//                            //noinspection deprecation
//                            layoutContent.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                        }
//                        layoutContent.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                Animation.AnimationListener listener=new Animation.AnimationListener() {
//                                    @Override
//                                    public void onAnimationStart(Animation animation) {
//
//                                    }
//
//                                    @Override
//                                    public void onAnimationEnd(Animation animation) {
//                                        layoutContent.setVisibility(View.VISIBLE);
//                                        //如果有标题则layoutContent背景要设置跟标题一样的颜色，主要用于沉浸式状态栏
//                                        if(getShowTitle()){
//                                            layoutContent.osetBackgroundColor(getResources().getColor(R.color.title));
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onAnimationRepeat(Animation animation) {
//
//                                    }
//                                };
//                                try {revealX= getIntent().getExtras().getInt(BasefragmentMsg.X);}catch (Exception e){}
//                                try {revealY=getIntent().getExtras().getInt(BasefragmentMsg.Y);}catch (Exception e){}
//
//
//                                layoutContent.show(revealX,revealY, Config.getInstance().fragmentJumpTime,listener);
//                            }
//                        }, 50);
//                    }
//                });
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (loadview != null) {
                            loadview.onDismiss();
                        }
                        layoutContent.setVisibility(View.VISIBLE);
                        initView(Value.ObservableStatus.FAIL);
                    }

                    @Override
                    public void onNext(Value.ObservableStatus status) {
                        if(!isReveal){
                            layoutContent.setVisibility(View.VISIBLE);
                        }
                        initView(status);
                    }
                });
    }
    public void setRevealViewXY(Intent intent,View v){
//        if(v==null||intent==null)return;
//        int[] location = new int[2] ;
////        v.getLocationInWindow(location); //获取在当前窗口内的绝对坐标
//        v.getLocationOnScreen(location);//获取在整个屏幕内的绝对坐标
//        intent.putExtra(BasefragmentMsg.X, location[0]+v.getMeasuredWidth()/2);
//        intent.putExtra(BasefragmentMsg.Y, location[1]+v.getMeasuredHeight()/2);
    }
    public void onStartActivity(Intent intent) {
        onStartActivity(intent.putExtra(JUMPEXTRA,isReveal),true);
    }
    public void onStartActivity(final Intent intent, final boolean isTransition) {
        mHandler.postDelayed(new Runnable() {
            private WeakReference<Context> mContext;
            @Override
            public void run() {
                mContext = new WeakReference<Context>(context);
                try{  IntentUtils.getInstance().startActivity(mContext.get(), intent);}catch (Exception e){startActivity(intent);}
                if(isTransition) {
                    overridePendingTransition(R.anim.common_open_enter, 0);
                }else{
                    overridePendingTransition(0,0);
                }
            }
        },100);
    }


    public void onStartActivity(Intent intent, @Nullable Bundle options) {
        onStartActivity(intent.putExtra(JUMPEXTRA,isReveal),options,true);
    }
    public void onStartActivity(final Intent intent, @Nullable Bundle options, final boolean isTransition) {
        mHandler.postDelayed(new Runnable() {
            private WeakReference<Context> mContext;
            @Override
            public void run() {
                mContext = new WeakReference<Context>(context);
                try{  IntentUtils.getInstance().startActivity(mContext.get(), intent,null);}catch (Exception e){startActivity(intent);}
                if(isTransition) {
                    overridePendingTransition(R.anim.common_open_enter, 0);
                }else{
                    overridePendingTransition(0,0);
                }
            }
        },100);
    }

    public void onStartActivityForResult(Intent intent, int code) {
        onStartActivityForResult(intent.putExtra(JUMPEXTRA,isReveal),code,true);
    }
    public void onStartActivityForResult(final Intent intent, final int code, final boolean isTransition) {
        mHandler.postDelayed(new Runnable() {
            private WeakReference<Context> mContext;
            @Override
            public void run() {
                mContext = new WeakReference<Context>(context);
                try{IntentUtils.getInstance().startActivityForResult(mContext.get(), intent,code);}catch (Exception e){startActivityForResult(intent,code);}
                if(isTransition) {
                    overridePendingTransition(R.anim.common_open_enter, 0);
                }else{
                    overridePendingTransition(0,0);
                }
            }
        },100);

    }


    public void onStartActivityForResult(Intent intent, int code,@Nullable Bundle options) {
        onStartActivityForResult(intent.putExtra(JUMPEXTRA,isReveal),code,options,true);
    }
    public void onStartActivityForResult(final Intent intent, final int code, @Nullable final Bundle options, final boolean isTransition) {
        mHandler.postDelayed(new Runnable() {
            private WeakReference<Context> mContext;
            @Override
            public void run() {
                mContext = new WeakReference<Context>(context);
                try{IntentUtils.getInstance().startActivityForResult(mContext.get(), intent,code,options);}catch (Exception e){startActivityForResult(intent,code);}
                if(isTransition) {
                    overridePendingTransition(R.anim.common_open_enter, 0);
                }else {
                    overridePendingTransition(0,0);
                }
            }
        },100);
    }
//    public void onStartActivityForResult(Intent intent, int code,boolean isAmim) {
//        if(isAmim){
//            onStartActivityForResult(intent,code);
//        }else{
//            try{startActivityForResult(intent,code);}catch (Exception e){startActivityForResult(intent,code);}
//            overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
//
//        }
//
//    }

    /**
     * 代表跳转后关闭之前的Actvity
     */
    public void onStartActivityFinish(final Intent intent){
        mHandler.postDelayed(new Runnable() {
            private WeakReference<Context> mContext;
            @Override
            public void run() {
                mContext = new WeakReference<Context>(context);
                try{  IntentUtils.getInstance().startActivity(mContext.get(), intent);}catch (Exception e){startActivity(intent);}
                overridePendingTransition(R.anim.common_open_enter,0);
                finish();
            }
        },100);

    }

    /**
     * 跳到主界面
     */
    public void onStartActivityMain(){
//        Intent intent = new Intent();
//        intent.setClass(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 注意本行的FLAG设置
//        onStartActivity(intent);
    }
    /**
     * Fragment跳到主界面
     */
    public void onStartFragmentMain(){
//        onStartActivityMain();
//        if (getSupportFragmentManager().getFragments() != null
//                && getSupportFragmentManager().getFragments().size() > 0) {
//            getSupportFragmentManager().getFragments().clear();
//        }
    }
    /**
     * 正常的跳转到fragment
     */
    public void onStartFragemnt(BaseFragment baseFragment, View v){
        onStartFragemnt(baseFragment,v,0);
    }
    /**
     * isFragment用于判断是Fragemnt跳转还是Activity跳转
     */
    public void onStartFragemntForResult(BaseFragment baseFragment,View v,int code,boolean isFragment){
        if(!isFragment){
            this.requestCode=code;
            baseFragment.setOnFragmentResultListener(this);
        }
        onStartFragemnt(baseFragment, v, code);
    }
    /**
     * 主要用于Acticity跳转到Fragement的，，Fragment跳转不要执行这句话
     */
    public void onStartFragemntForResult(BaseFragment baseFragment,View v,int code){
        onStartFragemntForResult(baseFragment, v, code, false);
    }
    private void onStartFragemnt(BaseFragment baseFragment,View v,int code){
        Bundle args = baseFragment.getArguments();
        if(args==null){
            args=new Bundle();
        }
        args.putInt(BasefragmentMsg.X, (int)(( v.getRight()-v.getLeft())/2+v.getLeft()));
        args.putInt(BasefragmentMsg.Y, (int) ((v.getBottom() - v.getTop()) / 2 + v.getTop()));
        baseFragment.setArguments(args);
        baseFragment.setFramentResultCode(code);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("tag")
                .add(android.R.id.content, baseFragment)
                .commit();
    }
    public  void finishAfterTransition() {
        if (Build.VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            finish();
        }
    }
    /**
     * 正常Activity关闭界面
     */
    public void finish() {
        hideInput();
//        if(isReveal){
//            Animation.AnimationListener listener=new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//                    if(getShowTitle()){
//                        layoutContent.setBackgroundColor(getResources().getColor(R.color.transparent));
//                    }
//                }
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    isReveal=false;
//                    context.finish();
//                    overridePendingTransition(0,0);
//                }
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//
//                }
//            };
//            layoutContent.hide(revealX, revealY, Config.getInstance().fragmentFinishTime, listener);
//            overridePendingTransition(0,0);
//        }
//        if(!isReveal) {
        super.finish();
        overridePendingTransition(0,R.anim.common_close_exit);
//        }
    }

    /**
     *带有返回值的Activity关闭界面
     */
    public void finish(int resultCode,Bundle args) {
        Intent intent = new Intent();
        if(args!=null) {
            intent.putExtras(args);
        }
        setResult(resultCode, intent);
        finish();
    }
    public void onDestroy(){
        //移除观察者
        mPublisher.removeOb();
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();

    }
    public boolean mIsInBackAnimation = false;
    /**
     * fragemnt的跳转
     */
    @Override
    public void onBackPressed () {
        super.onResume();
        if (mIsInBackAnimation) return;
        final List<Fragment> fragments = getSupportFragmentManager().getFragments();
        //fragments.size() is not correct.
        final int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        if (fragments != null && fragmentCount > 0) {
            Fragment lastFragment = fragments.get(fragmentCount-1);
            if (lastFragment != null && lastFragment instanceof BaseFragment) {
                ((BaseFragment) lastFragment).onBackPressed(new Animation.AnimationListener() {
                    @Override public void onAnimationRepeat(Animation animation) {}

                    @Override
                    public void onAnimationStart(Animation animation) {
                        mIsInBackAnimation = true;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mIsInBackAnimation = false;
                        getSupportFragmentManager().popBackStackImmediate();
                        if(fragmentCount==1){//当fragment等于1的时候，要自己添加Publisher，因为关闭fragment的时候不会调用onResume
                        }else if(fragmentCount>=2){//还有其他的Fragments,则调用onResume，因为onResume不会重新调用，则要自己调用
                            Fragment last2Fragment = fragments.get(fragmentCount - 2);
                            ((BaseFragment) last2Fragment).onResume();
                        }
                    }
                });
                return;
            }
        }
        super.onBackPressed();
    }

    /**
     * 设置是否开启滑动关闭
     */
    public void setSlideable(boolean isslide){
        slideLayout.setSlideable(isslide);
    }


    /**
     * 请求数据返回结果
     * @param status 请求成功还是失败
     * @param type
     * @param object 类型
     * 在BaseActivity里面执行，通常都是做一些弹窗,toast数据库存储这些公用的东西
     */
    @CallSuper
    public void onNotifyData(ObserverListener.STATUS status, String type, Object object){
        onHandlingData(status, type, object);
    }
//
//    /**
//     * 消息推送
//     * @param status 请求成功还是失败
//     * @param object 类型
//     */
//    @Override
//    public void onNotify(ObserverListener.STATUS status, Object object) {
//        if(mRequestUtils.isDataFail(status)){
//            return;
//        }
//    }

    /**
     * 处理请求的数据的返回，onNotifyData方法
     */
    public void onHandlingData(ObserverListener.STATUS status, String type, Object object){
        if(mRequestUtils.isDataFail(status)){
            return;
        }
        switch(type){
            case Msg.TOKEN:
                ToastUtil.showToast(context, "成功");
                break;
            case Msg.VERSION:
//                http://android7bus-10016677.file.myqcloud.com/bbxpc_client_1.0.3_091802.apk
                ToastUtil.showToast(context, "成功");
                break;
        }
    }
    /**
     * 判断是否执行点击操作
     */
    public boolean isClick(){
        if(this.mIsInBackAnimation){
            return false;
        }
        return true;
    }
    public void onClick(View view) {
        if(!isClick()){
            return;
        }
        switch (view.getId()) {
            default:
                super.onClick(view);
                break;
        }
    }

}
