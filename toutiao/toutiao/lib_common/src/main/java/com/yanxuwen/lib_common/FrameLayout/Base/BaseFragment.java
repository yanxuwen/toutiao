package com.yanxuwen.lib_common.FrameLayout.Base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanxuwen.lib_common.Base.BaseActivity;
import com.yanxuwen.lib_common.Bean.Config;
import com.yanxuwen.lib_common.Bean.Extra.fragment.BasefragmentMsg;
import com.yanxuwen.lib_common.Bean.Value;
import com.yanxuwen.lib_common.FrameLayout.Reveal.RevealLayout;
import com.yanxuwen.lib_common.Listener.OnFragmentResultListener;
import com.yanxuwen.lib_common.R;
import com.yanxuwen.lib_common.R2;
import com.yanxuwen.lib_common.Utils.BackgroundUtils;
import com.yanxuwen.lib_common.Utils.RequestUtils;
import com.yanxuwen.myutils.widget.StatusBar.StatusBar;
import com.yanxuwen.retrofit.Msg.ObserverListener;
import com.yanxuwen.retrofit.Msg.Publisher;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

/**
 * 作者：严旭文 on 2016/5/30 14:31
 * 邮箱：420255048@qq.com
 */
public abstract  class BaseFragment extends Fragment implements ObserverListener,OnFragmentResultListener {
    @BindView(R2.id.reveal_layout)
    RevealLayout revealLayout;
    @BindView(R2.id.content_fragment)
    LinearLayout contentFragment;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.iv_left)
    ImageView ivLeft;
    @BindView(R2.id.tv_right)
    TextView tvRight;
    @BindView(R2.id.iv_right_sub)
    ImageView ivRightSub;
    @BindView(R2.id.layout_title)
    RelativeLayout layoutTitle;
    public BaseActivity activity;
    public RequestUtils mRequestUtils;
    public Publisher mPublisher;

    /**状态栏*/
    public View view_status;
    public int layoutid;
    /**额外的高度，状态栏跟标题的的高度*/
    public int extraHeight;
    public OnFragmentResultListener mOnFragmentResultListener;
    /**请求的code*/
    public int requestCode;
    public void setFramentResultCode(int code){
        this.requestCode=code;
    }
    public void setOnFragmentResultListener(OnFragmentResultListener l){
        mOnFragmentResultListener=l;
    }
    /**onBackPressed关闭后调用接口*/
    public void onFragmentResult(int requestCode, int resultCode,Intent data){}
    /**
     * 带返回值得关闭
     */
    public void onBackPressed(int resultCode,Bundle args){
        Intent intent=new Intent();
        intent.putExtras(args);
        if(mOnFragmentResultListener!=null){
            if(mOnFragmentResultListener!=null)mOnFragmentResultListener.onFragmentResult(requestCode,resultCode,intent);
        }
        activity.onBackPressed();
    }
    /**
     * 正常关闭
     */
    public void onBackPressed(){
        activity.onBackPressed();
    }

    /**
     * 正常跳转
     */
    public void onStartFragemnt(BaseFragment baseFragment,View v){
        activity.onStartFragemnt(baseFragment, v);
    }

    /**
     * 能够有返回值的跳转，，类似Activity,前提那个界面返回要调用onBackPressed(int resultCode,Bundle args)
     */
    public void onStartFragemntForResult(BaseFragment baseFragment,View v,int code){
        this.requestCode=code;
        baseFragment.setOnFragmentResultListener(this);
        activity.onStartFragemntForResult(baseFragment, v, code, true);
    }
    public void setContentView(int layoutid) {
        this.layoutid=layoutid;
    }
    public void setTitle(int id){
        setTitle(activity.getString(id));
    }
    public void setTitle(String title){
        view_status.setBackgroundColor(activity.getResources().getColor(R.color.common_title));
        if(layoutTitle!=null) {
            layoutTitle.setVisibility(View.VISIBLE);
            if (null != title) {
                tvTitle.setText(title);
            }
        }
    }
    /**最好只设置标题跟布局，不允许对View进行操作*/
    abstract public void onCreateView( Bundle savedInstanceState);

    /**
     *加载数据，主要一些数据库
     */
    abstract public void initData();
    /**
     *initData执行完成后调用，主要设置试图
     */
    abstract public void initView(Value.ObservableStatus status);
    public void initTitle(View v){
        layoutTitle=(RelativeLayout)v.findViewById(R.id.layout_title);
        tvTitle=(TextView)v.findViewById(R.id.tv_title);
        tvRight=(TextView)v.findViewById(R.id.tv_right);
        ivRightSub=(ImageView)v.findViewById(R.id.iv_right_sub);
        layoutTitle.setVisibility(View.GONE);

    }
    public void onResume() {
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activity=(BaseActivity)getActivity();
        View rootView = inflater.inflate(R.layout.common_base_fragment, container, false);
        View title_view = inflater.inflate(R.layout.title_layout, container, false);
        contentFragment=(LinearLayout)rootView.findViewById(R.id.content_fragment);
        //添加状态栏,默认状态栏颜色为背景颜色
        view_status= BackgroundUtils.getStatusView(activity, R.color.common_background);
        contentFragment.addView(view_status);
        contentFragment.addView(title_view);
        initTitle(title_view);
        onCreateView(savedInstanceState);
        contentFragment.addView(inflater.inflate(layoutid, container, false));
        ButterKnife.bind(this, rootView);
        revealLayout.setContentShown(false);
        extraHeight=BackgroundUtils.getTitileHeight(activity)+ StatusBar.getStatusHeight(activity);
        final int x=getArguments().getInt(BasefragmentMsg.X);
        final int y=getArguments().getInt(BasefragmentMsg.Y)+extraHeight;
        revealLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    revealLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    //noinspection deprecation
                    revealLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                revealLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        revealLayout.show(x,y, Config.getInstance().fragmentJumpTime);
                    }
                }, 50);
            }
        });
        Observable.create(new Observable.OnSubscribe<Value.ObservableStatus>() {
            @Override
            public void call(Subscriber<? super Value.ObservableStatus> subscriber) {
                if(activity.loadview!=null&&!activity.loadview.isShowing()){
                    activity.loadview.show();
                }
                mRequestUtils=new RequestUtils(getActivity(),BaseFragment.this);
                mPublisher=new Publisher();
                //添加观察者
                mPublisher.setOb(BaseFragment.this);
                initData();
                subscriber.onNext(Value.ObservableStatus.SUCCESS);
                subscriber.onCompleted();


            }
        }).subscribe(new Subscriber<Value.ObservableStatus>() {
            @Override
            public void onCompleted() {
                if(activity.loadview!=null){
                    activity.loadview.onDismiss();
                }
            }

            @Override
            public void onError(Throwable e) {
                if(activity.loadview!=null){
                    activity.loadview.onDismiss();
                }
                initView(Value.ObservableStatus.FAIL);
            }

            @Override
            public void onNext(Value.ObservableStatus status) {
                initView(status);
            }
        });

        return rootView;
    }

    public void onBackPressed(Animation.AnimationListener listener) {
        Random r=new Random();
        int x=r.nextInt(this.getView().getWidth());
        int y=r.nextInt(this.getView().getHeight());//10为避免误差
        x=x<0?0:x;
        y=y<0?0:y;
        revealLayout.hide(x, y, Config.getInstance().fragmentFinishTime, listener);
    }

    @Override
    public void onDestroyView() {
        //移除观察者
        mPublisher.removeOb();
        super.onDestroyView();
    }
    public void onPause() {
        super.onPause();
    }
    /**
     * 注意子类在调用的时候一定要执行
     *    super.onClick(v);一定要放在前面
     *    并且执行
     *
     if(!isClick()){
     return;
     }
     */
    @CallSuper
    @OnClick({R2.id.iv_left, R2.id.tv_right, R2.id.iv_right_sub})
    public void onClick(View view){
        if(!isClick()){
            return;
        }
        switch (view.getId()) {
            case R2.id.iv_left:
                activity.onBackPressed();
                break;
        }
    }
    public boolean isClick(){
        return activity.isClick();
    }
    /**
     * 请求数据返回结果
     * @param status 请求成功还是失败
     * @param type
     * @param object 类型
     */
    @CallSuper
    public void onNotifyData(STATUS status,String type,Object object){
        activity.onHandlingData(status,type,object);
    }
}
