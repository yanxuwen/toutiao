package com.zhengchen.weight.guideview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * 参考了https://github.com/laxian/GuideView  现在性能和功能完爆它
 * <p>
 * 方法回调：创建GuideView -- initParams(初始化参数) -- getTargetViewPosition(获取TargetView位置核心方法) -- addHintView --
 * show(添加GuideView进DecorView) -- GuideView.onMeasure -- GuideView.onLayout -- GuideView.Draw -- drawMaskLayer(绘制完毕)
 * <p>
 * view.post(new Runnable(){
 * public void run(){
 * new GuideView.Builder()
 * .setTargetView()
 * .create().show();
 * }
 * });
 * <p>
 * Created by linlongxin on 2016/7/22.
 *
 *
 */
public class GuideView extends RelativeLayout {

    private final String TAG = "GuideView";

    private boolean hasMeasure = false;
    private boolean hasAddHintView = false;
    private boolean isShowing = false;
    private int mHintViewSpace = 0; //hintView和TargetView间距,默认20px
    private int mTransparentPadding;
    private int mTransparentPaddingLeft;
    private int mTransparentPaddingTop;
    private int mTransparentPaddingRight;
    private int mTransparentPaddingBottom;
    private int mTransparentMargin;
    private int mTransparentMarginLeft;
    private int mTransparentMarginRight;
    private int mTransparentMarginTop;
    private int mTransparentMarginBottom;
    private int mHintViewMargin;  //mHintViewSpace和它意义相同，但mHintViewMargin会覆盖其他的margin类型
    private int mHintViewMarginLeft;
    private int mHintViewMarginRight;
    private int mHintViewMarginTop;
    private int mHintViewMarginBottom;
    private int[] mTargetViewLocation = new int[2];
    private int mTargetViewWidth;
    private int mTargetViewHeight;
    private int mHintViewDirection;

    private int mScreenWidth;
    private int mScreenHeight;
    private
    @ColorInt
    int MASK_LAYER_COLOR = 0xe6000000;  //遮罩层默认颜色

    private LayoutParams mHintLayoutParams;

    private Paint mBackgroundPaint;  //遮罩层画笔
    private Paint mTransparentPaint;  //透明椭圆画笔

    private View mHintView;
    private View mTargetView;
    private FrameLayout mDecorView;

    public GuideView(Context context) {
        this(context, null);
    }

    public GuideView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, " --- GuideView");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = displayMetrics.widthPixels;
        mScreenHeight = displayMetrics.heightPixels;
        mDecorView = (FrameLayout) ((Activity) getContext()).getWindow().getDecorView();
        mBackgroundPaint = new Paint();
        mTransparentPaint = new Paint();
        mBackgroundPaint.setColor(MASK_LAYER_COLOR);
        Log.i(TAG, "screenWidth : " + mScreenWidth);
        Log.i(TAG, "screenHeight : " + mScreenHeight);
    }

    public void initParams(Builder.GuideViewParams params) {
        Log.i(TAG, "initParams");
        mTargetView = params.mTargetView;
        mHintView = params.mHintView;
        mHintViewSpace = params.mHintViewSpace; //hintView和TargetView间距,默认20px
        mTransparentPadding = params.mTransparentPadding;
        mTransparentPaddingLeft = params.mTransparentPaddingLeft;
        mTransparentPaddingTop = params.mTransparentPaddingTop;
        mTransparentPaddingRight = params.mTransparentPaddingRight;
        mTransparentPaddingBottom = params.mTransparentPaddingBottom;
        mTransparentMargin = params.mTransparentMargin;
        mTransparentMarginLeft = params.mTransparentMarginLeft;
        mTransparentMarginRight = params.mTransparentMarginRight;
        mTransparentMarginTop = params.mTransparentMarginTop;
        mTransparentMarginBottom = params.mTransparentMarginBottom;
        mHintViewMargin = params.mHintViewMargin;  //mHintViewSpace和它意义相同，但mHintViewMargin会覆盖其他的margin类型
        mHintViewMarginLeft = params.mHintViewMarginLeft;
        mHintViewMarginRight = params.mHintViewMarginRight;
        mHintViewMarginTop = params.mHintViewMarginTop;
        mHintViewMarginBottom = params.mHintViewMarginBottom;
        mHintViewDirection = params.mDirection;
        MASK_LAYER_COLOR = params.MASK_LAYER_COLOR;  //遮罩层默认颜色
        mHintLayoutParams = params.mHintLayoutParams;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i(TAG, " --- onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, " --- onLayout");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, " --- onDraw");
        drawMaskLayer(canvas);
    }

    /**
     * 绘制遮罩层
     *
     * @param canvas
     */
    private void drawMaskLayer(Canvas canvas) {
        Log.i(TAG, " --- drawMaskLayer");

        //先绘制遮罩层
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mTemp = new Canvas(bitmap);
        mTemp.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mBackgroundPaint);

        PorterDuffXfermode mDrawMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
        mTransparentPaint.setXfermode(mDrawMode);
        mTransparentPaint.setAntiAlias(true);

        /**
         * 透明区域padding设置
         */
        if (mTransparentPadding != 0) {
            mTransparentPaddingLeft = mTransparentPadding;
            mTransparentPaddingRight = mTransparentPadding;
            mTransparentPaddingTop = mTransparentPadding;
            mTransparentPaddingBottom = mTransparentPadding;
        }
        /**
         * 透明区域Margin设置
         */
        if (mTransparentMargin != 0) {
            mTransparentMarginLeft = mTransparentMargin;
            mTransparentMarginRight = mTransparentMargin;
            mTransparentMarginTop = mTransparentMargin;
            mTransparentMarginBottom = mTransparentMargin;
        }
        /**
         * HintView margin设置
         */
        if (mHintViewMargin != 0) {
            mHintViewMarginLeft = mHintViewMargin;
            mHintViewMarginRight = mHintViewMargin;
            mHintViewMarginTop = mHintViewMargin;
            mHintViewMarginBottom = mHintViewMargin;
        }

        RectF rectF = new RectF(mTargetViewLocation[0] - mTransparentPaddingLeft + mTransparentMarginLeft,
                mTargetViewLocation[1] - mTransparentPaddingTop + mTransparentMarginTop,
                mTargetViewLocation[0] + mTargetViewWidth + mTransparentPaddingRight - mTransparentMarginRight,
                mTargetViewLocation[1] + mTargetViewHeight + mTransparentPaddingBottom - mTransparentMarginBottom);
        mTemp.drawOval(rectF, mTransparentPaint);

        //绘制到GuideView的画布上
        canvas.drawBitmap(bitmap, 0, 0, mBackgroundPaint);
    }

    /**
     * 添加HintView
     */
    private void addHintView() {
        if (hasAddHintView) {
            return;
        }
        Log.i(TAG, " --- addHintView");
        if (mHintView != null) {

            LayoutParams layoutParams;
            if (mHintLayoutParams != null) {
                layoutParams = mHintLayoutParams;
            } else {
                layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
            }

            switch (mHintViewDirection) {
                /**
                 * FrameLayout没有setGravity()方法
                 */
                //左边相关
                case Direction.LEFT:
                    this.setGravity(Gravity.RIGHT);
                    layoutParams.setMargins(0, mTargetViewLocation[1],
                            mScreenWidth - mTargetViewLocation[0] + mHintViewSpace + mHintViewMarginRight, 0);
                    break;
                case Direction.LEFT_BOTTOM:
                    this.setGravity(Gravity.RIGHT | Gravity.TOP);
                    layoutParams.setMargins(0, mTargetViewLocation[1] + mTargetViewHeight + mHintViewSpace + mHintViewMarginTop,
                            mScreenWidth - mTargetViewLocation[0] + mHintViewSpace + mHintViewMarginRight, 0);
                    break;
                case Direction.LEFT_ABOVE:
                    this.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
                    layoutParams.setMargins(0, 0, mScreenWidth - mTargetViewLocation[0] + mHintViewSpace + mHintViewMarginRight,
                            mScreenHeight - mTargetViewLocation[1] + mHintViewSpace + mHintViewMarginBottom);
                    break;
                case Direction.LEFT_ALIGN_BOTTOM:
                    this.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
                    layoutParams.setMargins(0, mTargetViewLocation[1],
                            mScreenWidth - mTargetViewLocation[0] + mHintViewSpace + mHintViewMarginRight,
                            mScreenHeight - mTargetViewLocation[1] - mTargetViewHeight);
                    break;

                //右边相关
                case Direction.RIGHT:
                    this.setGravity(Gravity.LEFT);
                    layoutParams.setMargins(mTargetViewLocation[0] + mTargetViewWidth + mHintViewSpace + mHintViewMarginLeft,
                            mTargetViewLocation[1], 0, 0);
                    break;
                case Direction.RIGHT_ABOVE:
                    this.setGravity(Gravity.LEFT | Gravity.BOTTOM);
                    layoutParams.setMargins(mTargetViewWidth + mTargetViewLocation[0] + mHintViewSpace + mHintViewMarginLeft, 0,
                            0, mScreenHeight - mTargetViewLocation[1] + mHintViewSpace + mHintViewMarginBottom);
                    break;
                case Direction.RIGHT_BOTTOM:
                    this.setGravity(Gravity.LEFT | Gravity.TOP);
                    layoutParams.setMargins(mTargetViewLocation[0] + mTargetViewWidth + mHintViewSpace + mHintViewMarginLeft,
                            mTargetViewLocation[1] + mTargetViewHeight + mHintViewSpace + mHintViewMarginTop, 0, 0);
                    break;
                case Direction.RIGHT_ALIGN_BOTTOM:
                    this.setGravity(Gravity.LEFT | Gravity.BOTTOM);
                    layoutParams.setMargins(mTargetViewLocation[0] + mTargetViewWidth + mHintViewSpace + mHintViewMarginLeft,
                            0, 0, mScreenHeight - mTargetViewLocation[1] - mTargetViewHeight + mHintViewMarginBottom);
                    break;

                //上方相关
                case Direction.ABOVE:
                    this.setGravity(Gravity.BOTTOM);
                    layoutParams.setMargins(0, 0,
                            0, mScreenHeight - mTargetViewLocation[1] + mHintViewSpace + mHintViewMarginBottom);
                    break;
                case Direction.ABOVE_ALIGN_LEFT:
                    this.setGravity(Gravity.BOTTOM | Gravity.LEFT);
                    layoutParams.setMargins(mTargetViewLocation[0] + mHintViewMarginLeft, 0, 0,
                            mScreenHeight - mTargetViewLocation[1] + mHintViewSpace + mHintViewMarginBottom);
                    break;
                case Direction.ABOVE_ALIGN_RIGHT:
                    this.setGravity(Gravity.BOTTOM | Gravity.RIGHT);
                    layoutParams.setMargins(0, 0, mScreenWidth - mTargetViewLocation[0] - mTargetViewWidth + mHintViewMarginRight,
                            mScreenHeight - mTargetViewLocation[1] + mHintViewSpace + mHintViewMarginBottom);
                    break;

                //下方相关
                case Direction.BOTTOM:
                    this.setGravity(Gravity.TOP);
                    layoutParams.setMargins(0, mTargetViewLocation[1] + mTargetViewHeight + mHintViewMarginTop, 0, 0);
                    break;
                case Direction.BOTTOM_ALIGN_LEFT:
                    this.setGravity(Gravity.TOP | Gravity.LEFT);
                    layoutParams.setMargins(mTargetViewLocation[0] + mHintViewMarginLeft,
                            mTargetViewLocation[1] + mTargetViewHeight + mHintViewSpace + mHintViewMarginTop, 0, 0);
                    break;
                case Direction.BOTTOM_ALIGN_RIGHT:
                    this.setGravity(Gravity.TOP | Gravity.RIGHT);
                    layoutParams.setMargins(0, mTargetViewLocation[1] + mTargetViewHeight + mHintViewSpace + mHintViewMarginTop,
                            mScreenWidth - mTargetViewLocation[0] - mTargetViewWidth + mHintViewMarginRight, 0);
            }
            this.addView(mHintView, layoutParams);
            hasAddHintView = true;
        }
    }

    public void hide() {
        Log.i(TAG, "hide");
        this.removeAllViews();
        mDecorView.removeView(this);
    }

    public void show() {
        if (isShowing || !hasMeasure) {
            return;
        }
        Log.i(TAG, "show : add GuideView into DecorView");
        this.setBackgroundColor(Color.TRANSPARENT); //这句为什么么必须要。
        addHintView();
        mDecorView.addView(this);
        isShowing = true;
    }

    public boolean isShowing() {
        return isShowing;
    }

    /**
     * 获取TargetView位置
     */
    public void getTargetViewPosition() {
        Log.i(TAG, "getTargetViewPosition");
        if (mTargetView.getWidth() > 0 && mTargetView.getHeight() > 0) {
            mTargetView.getLocationInWindow(mTargetViewLocation);
            if (mTargetViewWidth == 0 || mTargetViewHeight == 0) {
                mTargetViewWidth = mTargetView.getWidth();
                mTargetViewHeight = mTargetView.getHeight();
            }
            if (mTargetViewLocation[0] >= 0 && mTargetViewLocation[1] > 0) {
                hasMeasure = true;
            }
            Log.i(TAG, "targetView.width : " + mTargetView.getWidth() + " location x : " + mTargetViewLocation[0]);
            Log.i(TAG, "targetView.height : " + mTargetView.getHeight() + " location y : " + mTargetViewLocation[1]);
        } else {
            hasMeasure = false;
            Log.i(TAG, "targetView is not measured,please user view.post(Runnable run) initialize GuideView");
        }
    }

    /**
     * 通过Builder构建
     */
    public static class Builder {

        private static class GuideViewParams {
            View mTargetView;
            View mHintView;
            int mDirection;
            int mHintViewSpace = 20; //hintView和TargetView间距,默认20px
            int mTransparentPadding;
            int mTransparentPaddingLeft;
            int mTransparentPaddingTop;
            int mTransparentPaddingRight;
            int mTransparentPaddingBottom;
            int mTransparentMargin;
            int mTransparentMarginLeft;
            int mTransparentMarginRight;
            int mTransparentMarginTop;
            int mTransparentMarginBottom;
            int mHintViewMargin;  //mHintViewSpace和它意义相同
            int mHintViewMarginLeft;
            int mHintViewMarginRight;
            int mHintViewMarginTop;
            int mHintViewMarginBottom;
            @ColorInt
            int MASK_LAYER_COLOR = 0xe6000000;  //遮罩层默认颜色
            LayoutParams mHintLayoutParams;
            OnClickListener mClickListener;
        }

        private GuideViewParams mParams;
        private Context mContext;

        public Builder(Context ctx) {
            mParams = new GuideViewParams();
            mContext = ctx;
        }

        public Builder setTargetView(View targetView) {
            mParams.mTargetView = targetView;
            return this;
        }

        public Builder setTargetView(@IdRes int resId) {
            mParams.mTargetView = ((Activity) mContext).findViewById(resId);
            return this;
        }

        public Builder setHintView(View hintView) {
            mParams.mHintView = hintView;
            return this;
        }

        public Builder setHintViewDirection(int direction) {
            mParams.mDirection = direction;
            return this;
        }

        public Builder setTransparentOvalPadding(int px) {
            mParams.mTransparentPadding = px;
            return this;
        }

        public Builder setTransparentOvalPaddingLeft(int px) {
            mParams.mTransparentPaddingLeft = px;
            return this;
        }

        public Builder setTransparentOvalPaddingRight(int px) {
            mParams.mTransparentPaddingRight = px;
            return this;
        }

        public Builder setTransparentOvalPaddingTop(int px) {
            mParams.mTransparentPaddingTop = px;
            return this;
        }

        public Builder setTransparentOvalPaddingBottom(int px) {
            mParams.mTransparentPaddingBottom = px;
            return this;
        }

        public Builder setTransparentMargin(int px) {
            mParams.mTransparentMargin = px;
            return this;
        }

        public Builder setTransparentMarginLeft(int mTransparentMarginLeft) {
            mParams.mTransparentMarginLeft = mTransparentMarginLeft;
            return this;
        }

        public Builder setTransparentMarginRight(int mTransparentMarginRight) {
            mParams.mTransparentMarginRight = mTransparentMarginRight;
            return this;
        }

        public Builder setTransparentMarginTop(int mTransparentMarginTop) {
            mParams.mTransparentMarginTop = mTransparentMarginTop;
            return this;
        }

        public Builder setTransparentMarginBottom(int mTransparentMarginBottom) {
            mParams.mTransparentMarginBottom = mTransparentMarginBottom;
            return this;
        }

        public Builder setHintViewMargin(int px) {
            mParams.mHintViewMargin = px;
            return this;
        }

        public Builder setHintViewMarginLeft(int px) {
            mParams.mHintViewMarginLeft = px;
            return this;
        }

        public Builder setHintViewMarginRight(int px) {
            mParams.mHintViewMarginRight = px;
            return this;
        }

        public Builder setHintViewMarginTop(int px) {
            mParams.mHintViewMarginTop = px;
            return this;
        }

        public Builder setHintViewMarginBottom(int px) {
            mParams.mHintViewMarginBottom = px;
            return this;
        }

        public Builder setHintViewSpace(int px) {
            mParams.mHintViewSpace = px;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int color) {
            mParams.MASK_LAYER_COLOR = color;
            return this;
        }

        public Builder setHintLayoutParams(LayoutParams mHintLayoutParams) {
            mParams.mHintLayoutParams = mHintLayoutParams;
            return this;
        }

        public Builder setOnClickListener(OnClickListener listener) {
            mParams.mClickListener = listener;
            return this;
        }

        public GuideView create() {
            if (mParams.mTargetView == null) {
                throw new RuntimeException("please set a targetView");
            }
            GuideView guideView = new GuideView(mContext);
            guideView.initParams(mParams);
            guideView.setOnClickListener(mParams.mClickListener);
            guideView.getTargetViewPosition(); //获取TargetView的位置
            return guideView;
        }

        public void show() {
            create().show();
        }
    }
}
