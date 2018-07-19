package com.zhengchen.weight.Banner;

/**
 * Created by yanxuwen on 2017/7/14.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;


import com.yanxuwen.DensityUtil;
import com.zhengchen.R;

import java.lang.reflect.Field;

/**
 * @author Pinger
 * @since 2017/3/8 0008 下午 3:26
 * 自定义无限轮转的海报控件，抽离了适配器和滑动事件，更加轻便。
 * 请在布局使用当前类，相关属性可以通过布局或者代码设置，
 * 适配器继承BannerBaseAdapter，指定数据类型，填充布局即可
 *
 * 适用于可显示多个条目
 */
public class BannerView extends RelativeLayout {

    private static final String TAG = BannerView.class.getSimpleName();

    private ViewPager mViewPager;
    private LinearLayout layout_dots;


    // 页面边距
    private int pageMargin = 15;
    // 页面显示屏幕占比
    private float pagePercent = 0.8f;
    // 缩放和透明比例，需要自己修改想要的比例
    private float scaleMin = 0.8f;
    private float alphaMin = 0.8f;

    // 自动轮播间隔时长
    private long mScrollDuration = 4000;
    private long mAnimDuration = 1200;
    // 是否是动画滚动
    private boolean isAnimScroll;
    private boolean isAutoScroll;
    private boolean isDots=true;
    private View mRootView;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private AutoScrollTask mScrollTask;
    private long mRecentTouchTime;
    LayoutInflater inflater;
    Context context;
    public BannerView(@NonNull Context context) {
        this(context, null);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initAttrs(context, attrs);
        initView();
        initEvent();
         inflater = LayoutInflater.from(context);

    }

    private void initAttrs(Context context, AttributeSet attrs) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pageMargin, dm);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BannerView);
        pageMargin = (int) a.getDimension(R.styleable.BannerView_bannerPageMargin, pageMargin);
        pagePercent = a.getFloat(R.styleable.BannerView_bannerPagePercent, pagePercent);
        scaleMin = a.getFloat(R.styleable.BannerView_bannerPageScale, scaleMin);
        alphaMin = a.getFloat(R.styleable.BannerView_bannerPageAlpha, alphaMin);
        mScrollDuration = a.getInteger(R.styleable.BannerView_bannerScrollDuration, (int) mScrollDuration);
        mAnimDuration = a.getInteger(R.styleable.BannerView_bannerAnimDuration, (int) mAnimDuration);
        isAnimScroll = a.getBoolean(R.styleable.BannerView_bannerAnimScroll, isAnimScroll);
        isAutoScroll = a.getBoolean(R.styleable.BannerView_bannerAutoScroll, isAutoScroll);
        isDots = a.getBoolean(R.styleable.BannerView_isDots, isDots);

        a.recycle();
    }


    private void initView() {
        mRootView = LayoutInflater.from(getContext()).inflate(R.layout.banner_view, this);
        mViewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);

        // 注意clipChildren属性的使用
        // 初始化ViewPager
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mViewPager.getLayoutParams();
        params.width = (int) (getScreenWidth() * pagePercent);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mViewPager.setLayoutParams(params);
        mViewPager.setPageMargin(pageMargin);
        mViewPager.setPageTransformer(false, new BannerPageTransformer());
        mViewPager.setOffscreenPageLimit(5);
    }


    private void initEvent() {
        mViewPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        stopAutoScroll();
                        break;
                    case MotionEvent.ACTION_UP:
                        startAutoScroll();
                        break;
                }
                return false;
            }
        });

        // 父亲将触摸事件交给孩子处理
        mRootView.findViewById(R.id.viewpager_container).setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
    }
    public void setPrevious(){
        mHandler.removeCallbacks(mRunnable);
        mViewPager.setCurrentItem(mViewPager.getCurrentItem()-1);
        stopAutoScroll();
        mHandler.postDelayed(mRunnable,1000);
    }
    public void setNext(){
        mHandler.removeCallbacks(mRunnable);
        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
        stopAutoScroll();
        mHandler.postDelayed(mRunnable,1000);
    }
    Runnable mRunnable=new Runnable(){
        @Override
        public void run() {
            startAutoScroll();
        }
    };

    private int getScreenWidth() {
        return ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        // 视图初始化完毕，开始轮播任务
        if (mScrollTask == null) mScrollTask = new AutoScrollTask();
        if (isAutoScroll) startAutoScroll();
    }

    /**
     * 自动轮播任务
     */
    private class AutoScrollTask implements Runnable {

        @Override
        public void run() {
            int currentPosition = mViewPager.getCurrentItem();

            if (mViewPager.getAdapter() != null) {
                if (currentPosition == mViewPager.getAdapter().getCount() - 1) {
                    // 最后一页
                    mViewPager.setCurrentItem(0);
                } else {
                    mViewPager.setCurrentItem(currentPosition + 1);
                }
            }
            Log.d(TAG, "run: currentPosition = " + mViewPager.getCurrentItem());
            // 一直给自己发消息
            mHandler.postDelayed(this, mScrollDuration);
        }

        void start() {
            mHandler.removeCallbacks(this);
            mHandler.postDelayed(this, mScrollDuration);
        }

        void stop() {
            mHandler.removeCallbacks(this);
        }
    }

    /**
     * 设置滑动动画持续时间
     *
     * @param during
     */
    public void setAnimationScroll(final int during) {
        try {
            // viewPager平移动画事件
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            Scroller mScroller = new Scroller(getContext(),
                    // 动画效果与ViewPager的一致
                    new Interpolator() {
                        public float getInterpolation(float t) {
                            t -= 1.0f;
                            return t * t * t * t * t + 1.0f;
                        }
                    }) {

                @Override
                public void startScroll(int startX, int startY, int dx,
                                        int dy, int duration) {
                    // 如果手动滚动,则加速滚动
                    // TODO 使用这种设置极不稳定，需要抽离
                    if (System.currentTimeMillis() - mRecentTouchTime > mScrollDuration && isAnimScroll) {
                        // 动画滑动
                        duration = during;
                    } else {
                        // 手势滚动
                        duration /= 2;

                    }
                    super.startScroll(startX, startY, dx, dy, duration);
                }

                @Override
                public void startScroll(int startX, int startY, int dx,
                                        int dy) {
                    super.startScroll(startX, startY, dx, dy, during);
                }
            };
            mField.set(mViewPager, mScroller);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mRecentTouchTime = System.currentTimeMillis();
        return super.onInterceptTouchEvent(ev);
    }


    /**
     * ViewPager Item动画转换类
     */
    private class BannerPageTransformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View page, float position) {
            Log.d(TAG, "transformPage: position=" + position);
            // 不同位置的缩放和透明度
            float scale = (position < 0)
                    ? ((1 - scaleMin) * position + 1)
                    : ((scaleMin - 1) * position + 1);
            float alpha = (position < 0)
                    ? ((1 - alphaMin) * position + 1)
                    : ((alphaMin - 1) * position + 1);
            // 保持左右两边的图片位置中心
            if (position < 0) {
                ViewCompat.setPivotX(page, page.getWidth());
                ViewCompat.setPivotY(page, page.getHeight() / 2);
            } else {
                ViewCompat.setPivotX(page, 0);
                ViewCompat.setPivotY(page, page.getHeight() / 2);
            }
            Log.d(TAG, "transformPage: scale=" + scale);
            ViewCompat.setScaleX(page, scale);
            ViewCompat.setScaleY(page, scale);
            ViewCompat.setAlpha(page, Math.abs(alpha));
        }
    }


    /**
     * ==================================API==================================
     */
    public ViewPager getViewPager() {
        return mViewPager;
    }

    public void setAdapter(PagerAdapter adapter) {
        mViewPager.setAdapter(adapter);
        if (adapter instanceof BannerBaseAdapter) {
            ((BannerBaseAdapter) adapter).setBannerView(this);
        }
    }

    /**
     * 开启自动轮播
     */
    public void startAutoScroll() {
        if (mScrollTask != null&&isAutoScroll){
            mScrollTask.start();
            setAnimationScroll((int) mAnimDuration);
            Log.d(TAG, "startAutoScroll");
        }
    }

    /**
     * 停止自动轮播
     */
    public void stopAutoScroll() {
        if (mScrollTask == null) return;
        mScrollTask.stop();
        Log.d(TAG, "stopAutoScroll");
    }

    /**
     * 是否动画轮播
     *
     * @param isAnimScroll
     */
    public void isAnimScroll(boolean isAnimScroll) {
        this.isAnimScroll = isAnimScroll;
    }

    /**
     * 重置当前的位置
     *
     * @param size
     */
    public void resetCurrentPosition(int size) {
        if (size == 0) return;
        // 去除动画
        // isAnimScroll(false);
        mViewPager.setCurrentItem(size * 1000);
    }
    public void setDots(int size,int position){
        if(!isDots)return;
        //初始化圆点
        layout_dots = mRootView.findViewById(R.id.layout_dots);
        layout_dots.removeAllViews();
        for (int i = 0; i <size; i++) {
            layout_dots.addView(dotsItem(i));
        }
        layout_dots.getChildAt(position).setSelected(true);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(layout_dots==null||layout_dots.getChildAt(position % layout_dots.getChildCount())==null)return;
                for (int i = 0; i < layout_dots.getChildCount(); i++) {
                    layout_dots.getChildAt(i).setSelected(false);
                }
                layout_dots.getChildAt(position % layout_dots.getChildCount()).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        if (mViewPager != null) {
            mViewPager.addOnPageChangeListener(listener);
        }
    }

    public void setPageMargin(int pageMargin) {
        this.pageMargin = pageMargin;
    }

    public void setPagePercent(float pagePercent) {
        this.pagePercent = pagePercent;
    }

    public void setPageScale(float scale) {
        this.scaleMin = scale;
    }

    public void setPageAlpha(float alpha) {
        this.alphaMin = alpha;
    }

    public void setScrollDuration(long scrollDuration) {
        mScrollDuration = scrollDuration;
    }

    public void setAnimDuration(long animDuration) {
        mAnimDuration = animDuration;
    }

    /**
     * 设置圆点
     */
    private View dotsItem(int position) {
        View layout = inflater.inflate(R.layout.dot_image, null);
        View iv =layout.findViewById(R.id.face_dot);
        iv.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_circle_dot));
        iv.setId(position);
        return layout;
    }
}