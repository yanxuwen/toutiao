//package com.zhengchen.weight.Images;
//
///**
// * Created by yanxuwen on 2017/10/30.
// */
//
//import android.animation.Animator;
//import android.animation.ValueAnimator;
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.support.annotation.CallSuper;
//import android.support.annotation.FloatRange;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.view.WindowManager;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.zhengchen.R;
//
//import java.io.ByteArrayOutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 图片展示界面
// * Created by RushKing on 2017/4/7.
// */
//
//public class ImageShowActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
//    RelativeLayout layout_bottom;
//    RelativeLayout layout_viewpage;
//    RelativeLayout layout_bg;
//
//    public FixMultiViewPager mViewPager;
//    public static List<String> imageUrls;
//    private Bitmap mBitmap;
//    public static ArrayList<ImageBean> imageBeans;
//    private MyDragPhotoView[] mPhotoViews;
//    private int mStatusHeight;
//    public int currentPosition;
//    public PagerAdapter mPagerAdapter;
//
//    private boolean isShowStatusBar;
//    public static void startImageActivity(Activity activity, ImageView iv, Bitmap mBitmap) {
//        ImageView[] imageViews=new ImageView[]{iv};
//        Intent intent = new Intent(activity, ImageShowActivity.class);
////        ImageBean[] imageBeans = new ImageBean[imageViews.length];
//        ArrayList<ImageBean> imageBeans = new ArrayList<>();
//        for (ImageView imageView : imageViews) {
//            ImageBean imageBean = new ImageBean();
//            int location[] = new int[2];
//            imageView.getLocationOnScreen(location);
//            imageBean.left = location[0];
//            imageBean.top = location[1];
//            imageBean.width = imageView.getWidth();
//            imageBean.height = imageView.getHeight();
////            imageBeans[i] = imageBean;
//            imageBeans.add(imageBean);
//        }
//        intent.putParcelableArrayListExtra("imageBeans", imageBeans);
//        intent.putExtra("currentPosition", 0);
//
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte [] bitmapByte =baos.toByteArray();
//        intent.putExtra("bitmap", bitmapByte);
//
//        activity.startActivity(intent);
//        activity.overridePendingTransition(0, 0);
//    }
//    public static void startImageActivity(Activity activity, ImageView imageView, String imageUrl) {
//        startImageActivity(activity, new ImageView[]{imageView}, new String[]{imageUrl}, 0);
//    }
//
//    public static void startImageActivity(Activity activity, ImageView[] imageViews, String[] imageUrls, int currentPosition) {
//        Intent intent = new Intent(activity, ImageShowActivity.class);
//        activity.startActivity(getExtra(activity,intent,imageViews,imageUrls,currentPosition));
//        activity.overridePendingTransition(0, 0);
//    }
//    protected static Intent getExtra(Activity activity, Intent intent,ImageView[] imageViews, String[] imageUrls, int currentPosition){
//        intent.putParcelableArrayListExtra("imageBeans", getImageBeans(imageViews));
//        intent.putExtra("currentPosition", currentPosition);
//        intent.putExtra("imageUrls", imageUrls);
//        return intent;
//    }
//    public static ArrayList<ImageBean> getImageBeans(ImageView[] imageViews){
//        ArrayList<ImageBean> imageBeans = new ArrayList<>();
//        for (ImageView imageView : imageViews) {
//            ImageBean imageBean = new ImageBean();
//            int location[] = new int[2];
//            imageView.getLocationOnScreen(location);
//            imageBean.left = location[0];
//            imageBean.top = location[1];
//            imageBean.width = imageView.getWidth();
//            imageBean.height = imageView.getHeight();
////            imageBeans[i] = imageBean;
//            imageBeans.add(imageBean);
//        }
//        return imageBeans;
//    }
//
//    public void setLayoutView(int layoutResID){
//        LayoutInflater inflater = LayoutInflater.from(this);
//        layout_bottom.addView(inflater.inflate(layoutResID, null));
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        //将window扩展至全屏，并且不会覆盖状态栏
////        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        //避免在状态栏的显示状态发生变化时重新布局
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//        setIsShowStatusBar(false);
//
//
//        mStatusHeight = getStatusHeight();
//        mViewPager = new FixMultiViewPager(this);
//
//        setContentView(R.layout.imageshow);
//        layout_bottom=(RelativeLayout)findViewById(R.id.layout_bottom);
//        layout_viewpage=(RelativeLayout)findViewById(R.id.layout_viewpage);
//        layout_bg=(RelativeLayout)findViewById(R.id.layout_bg);
//        layout_viewpage.addView(mViewPager);
//        setAlpha(0);
//        Intent intent = getIntent();
//        currentPosition = intent.getIntExtra("currentPosition", 0);
//        imageUrls=new ArrayList<>();
//        try {
//            imageUrls.addAll(Arrays.asList(intent.getStringArrayExtra("imageUrls")));
//        }catch (Exception e){}
//        imageBeans = intent.getParcelableArrayListExtra("imageBeans");
//        //读取bitmap
//        try {
//            byte[]  bis=intent.getByteArrayExtra("bitmap");
//            mBitmap= BitmapFactory.decodeByteArray(bis, 0, bis.length);
//        }catch (Exception e){}
//        if (imageUrls == null || imageUrls.size() == 0) {
//            if(mBitmap==null){
//                return;
//            }
//        }
//        if(imageUrls==null&&mBitmap!=null){
//            mPhotoViews = new MyDragPhotoView[(1)];
//        }else if (imageUrls!=null&&mBitmap==null){
//            mPhotoViews = new MyDragPhotoView[imageUrls.size()];
//        }else {
//            return;
//        }
//
//        setPhotoViewAndViewPager();
//        //设置入场动画参数
//        mViewPager.getViewTreeObserver()
//                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                    @Override
//                    public void onGlobalLayout() {
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                            mViewPager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                        } else {
//                            mViewPager.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                        }
//                        int left = imageBeans.get(currentPosition>=imageBeans.size()?imageBeans.size()-1:currentPosition).left;
//                        int top = imageBeans.get(currentPosition>=imageBeans.size()?imageBeans.size()-1:currentPosition).top;
//                        int height = imageBeans.get(currentPosition>=imageBeans.size()?imageBeans.size()-1:currentPosition).height;
//                        int width = imageBeans.get(currentPosition>=imageBeans.size()?imageBeans.size()-1:currentPosition).width;
//
//                        final MyDragPhotoView photoView = mPhotoViews[currentPosition];
//                        int[] locationPhoto = new int[2];
//                        photoView.getLocationOnScreen(locationPhoto);
//                        float targetHeight = (float) photoView.getHeight();
//                        float targetWidth = (float) photoView.getWidth();
//                        float scaleX = (float) width / targetWidth;
//                        float scaleY = (float) height / targetHeight;
//
//                        float targetCenterX = locationPhoto[0] + targetWidth / 2;
//                        float targetCenterY = locationPhoto[1] + targetHeight / 2;
//
//                        float translationX = left + width / 2 - targetCenterX;
//                        float translationY = top + height / 2 - targetCenterY;
//                        photoView.setTranslationX(translationX);
//                        photoView.setTranslationY(translationY);
//                        photoView.setScaleX(scaleX);
//                        photoView.setScaleY(scaleY);
//                        photoView.performEnterAnimation(scaleX, scaleY);
//                        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0, 1});
//                        animator.setDuration(400);
//                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                                float mAlpha = (float) valueAnimator.getAnimatedValue();
//                                setAlpha(mAlpha);
//                            }
//                        });
//                        animator.addListener(new Animator.AnimatorListener() {
//                            @Override
//                            public void onAnimationStart(Animator animation) {
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animator animation) {
//                                onViewFinish();
//                            }
//
//                            @Override
//                            public void onAnimationCancel(Animator animation) {
//                            }
//
//                            @Override
//                            public void onAnimationRepeat(Animator animation) {
//                            }
//                        });
//                        animator.start();
//                    }
//                });
//    }
//    public ViewPager getViewPager(){
//       return mViewPager;
//    }
//    public PagerAdapter getPagerAdapter(){
//        return mPagerAdapter;
//    }
//
//
//    /**
//     * 图片集合
//     */
//    public List<String> getImageUrls(){
//        return imageUrls;
//    }
//
//    /**
//     * 拖动视图集合
//     */
//    public MyDragPhotoView[] getPhotoViews(){
//        return mPhotoViews;
//    }
//    public void setMyDragPhotoView(int size){
//        mPhotoViews= new MyDragPhotoView[size];
//    }
//    public void setPhotoViewAndViewPager() {
//        for (int i = 0; i < mPhotoViews.length; i++) {
//            mPhotoViews[i] = new MyDragPhotoView(this);
//            mPhotoViews[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//            if(imageUrls==null&&mBitmap!=null){
//                showImage(mBitmap, mPhotoViews[i]);
//            }else if (imageUrls!=null&&mBitmap==null){
//                showImage(imageUrls.get(i), mPhotoViews[i]);
//            }else {
//                return;
//            }
//            mPhotoViews[i].setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finishWithAnimation();
//                }
//            });
//            final int index = i;
//            mPhotoViews[i].setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
////                    Dialog dialog = new AlertDialog.Builder(ImageShowActivity.this)
////                            .setTitle("长按Dialog").setMessage("这是第" + index + "个位置的图片")
////                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
////                                @Override
////                                public void onClick(DialogInterface dialog, int which) {
////                                    dialog.dismiss();
////                                }
////                            }).create();
////                    dialog.show();
//                    return true;
//                }
//            });
//            mPhotoViews[i].setOnDragListener(new MyDragPhotoView.OnDragListener() {
//                @Override
//                public void onDrag(MyDragPhotoView view, float moveX, float moveY,int mAlpha) {
//                    if (!isShowStatusBar) {
//                        setIsShowStatusBar(true);
//                    }
//                    setAlpha((float) mAlpha/255);
//                }
//            });
//            mPhotoViews[i].setOnTapListener(new MyDragPhotoView.OnTapListener() {
//                @Override
//                public void onTap(MyDragPhotoView view,int mAlpha) {
//                    if (isShowStatusBar) {
//                        setIsShowStatusBar(false);
//                    }
//                    setAlpha((float) mAlpha/255);
//                }
//            });
//
//            mPhotoViews[i].setOnExitListener(new MyDragPhotoView.OnExitListener() {
//                @Override
//                public void onExit(MyDragPhotoView view, float x, float y, float w, float h, int maxTranslateY,int mAlpha) {
//                    performExitAnimation(view, x, y, w, h);
//                    setAlpha((float) mAlpha/255);
////                    finish();
////                    overridePendingTransition(0, 0);
//                }
//            });
//        }
//        if(mPagerAdapter!=null){
//            mViewPager.setAdapter(mPagerAdapter);
//        }else {
//            mPagerAdapter = new PagerAdapter() {
//                @Override
//                public int getCount() {
//                    if (imageUrls == null && mBitmap != null) {
//                        return 1;
//                    } else if (imageUrls != null && mBitmap == null) {
//                        return imageUrls.size();
//                    } else {
//                        return 0;
//                    }
//                }
//
//                @Override
//                public Object instantiateItem(ViewGroup container, int position) {
//                    container.addView(mPhotoViews[position]);
//                    return mPhotoViews[position];
//                }
//
//                @Override
//                public void destroyItem(ViewGroup container, int position, Object object) {
//                    container.removeView(mPhotoViews[position]);
//                }
//
//                @Override
//                public boolean isViewFromObject(View view, Object object) {
//                    return view == object;
//                }
//            };
//            mViewPager.setAdapter(mPagerAdapter);
//        }
//        mViewPager.removeOnPageChangeListener(this);
//        mViewPager.addOnPageChangeListener(this);
//        mViewPager.setCurrentItem(currentPosition);
//    }
//
//    private void performExitAnimation(final MyDragPhotoView view, float x, float y, float w, float h) {
//        int position=(currentPosition>=imageBeans.size())?imageBeans.size()-1:currentPosition;
//        mPhotoViews[currentPosition].performExitAnimation(this, imageBeans.get(position).left, imageBeans.get(position).top,
//                imageBeans.get(position).width, imageBeans.get(position).height);
//    }
//
//    private void finishWithAnimation() {
//        if (!isShowStatusBar) {
//            setIsShowStatusBar(true);
//        }
//        int position=(currentPosition>=imageBeans.size())?imageBeans.size()-1:currentPosition;
//        mPhotoViews[currentPosition].finishWithAnimation(this, imageBeans.get(position).left, imageBeans.get(position).top,
//                imageBeans.get(position).width, imageBeans.get(position).height);
//    }
//
//    @Override
//    public void onBackPressed() {
//        finishWithAnimation();
//    }
//
//    /**
//     * 显示图片
//     */
//    public void showImage(String url, ImageView imageView) {
//        if (!TextUtils.isEmpty(url) && url.length() > 0) {
//            url = url.replaceAll(" ", "");
//        }
//        if (TextUtils.isEmpty(url)) {
//            return;
//        }
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        imageView.setAdjustViewBounds(true);
//        Glide.with(this).load(url)
//                .dontAnimate()
//                .placeholder(R.drawable.ic_img_loading)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .error(R.drawable.ic_img_loadfail)
//                .into(imageView);
////        Picasso.with(this).load(url)
////                .error(R.mipmap.ic_loding_error)
////                .into(imageView);
//    }
//    /**
//     * 显示图片
//     */
//    public void showImage(Bitmap bmp, ImageView imageView) {
//        if (bmp==null) {
//            return;
//        }
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        imageView.setAdjustViewBounds(true);
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        byte [] bitmapByte =baos.toByteArray();
//        Glide.with(this)
//                .load(bitmapByte)
//                .dontAnimate()
//                .placeholder(R.drawable.ic_img_loading)
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .error(R.drawable.ic_img_loadfail)
//                .into(imageView);
////        Picasso.with(this).load(url)
////                .error(R.mipmap.ic_loding_error)
////                .into(imageView);
//    }
//
//    public int getStatusHeight() {
//        int statusHeight = 0;
//        try {
//            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
//            Object object = clazz.newInstance();
//            int height = Integer.parseInt(clazz.getField("status_bar_height")
//                    .get(object).toString());
//            statusHeight = getResources().getDimensionPixelSize(height);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return statusHeight;
//    }
//
//    /**
//     * 不会导致Activity重新排版的全屏
//     */
//    /*
//    关键是，在做了该Activity的全屏设置的前提下，还要在onCreate()方法中加入如下语句：
//    //将window扩展至全屏，并且不会覆盖状态栏
//    getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//    //避免在状态栏的显示状态发生变化时重新布局
//    getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//     */
//    private void setIsShowStatusBar(boolean show) {
////        isShowStatusBar = show;
////        if (show) {
////            //显示
////            WindowManager.LayoutParams attrs = getWindow().getAttributes();
////            attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
////            getWindow().setAttributes(attrs);
////        } else {
////            //隐藏
////            WindowManager.LayoutParams attrs = getWindow().getAttributes();
////            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
////            getWindow().setAttributes(attrs);
////        }
//    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        onMyPageScrolled(position,positionOffset,positionOffsetPixels);
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        onMyPageSelected(position);
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//        onMyPageScrollStateChanged(state);
//    }
//
//    public static class ImageBean implements Parcelable {
//        int top;
//        int left;
//        int width;
//        int height;
//
//        @Override
//        public int describeContents() {
//            return 0;
//        }
//
//        @Override
//        public void writeToParcel(Parcel dest, int flags) {
//            dest.writeInt(this.top);
//            dest.writeInt(this.left);
//            dest.writeInt(this.width);
//            dest.writeInt(this.height);
//        }
//
//        public ImageBean() {
//        }
//
//        private ImageBean(Parcel in) {
//            this.top = in.readInt();
//            this.left = in.readInt();
//            this.width = in.readInt();
//            this.height = in.readInt();
//        }
//
//        public static final Creator<ImageBean> CREATOR = new Creator<ImageBean>() {
//            @Override
//            public ImageBean createFromParcel(Parcel source) {
//                return new ImageBean(source);
//            }
//
//            @Override
//            public ImageBean[] newArray(int size) {
//                return new ImageBean[size];
//            }
//        };
//    }
//
//
//    /**
//     * Author :  suzeyu
//     * Time   :  2016-12-26  上午1:41
//     * ClassDescription : 对多点触控场景时, {@link ViewPager#onInterceptTouchEvent(MotionEvent)}中
//     * pointerIndex = -1. 发生IllegalArgumentException: pointerIndex out of range 处理
//     */
//    public class FixMultiViewPager extends ViewPager {
//        private final String TAG = FixMultiViewPager.class.getSimpleName();
//
//        public FixMultiViewPager(Context context) {
//            super(context);
//        }
//
//        public FixMultiViewPager(Context context, AttributeSet attrs) {
//            super(context, attrs);
//        }
//
//        @Override
//        public boolean onInterceptTouchEvent(MotionEvent ev) {
//            try {
//                switch (ev.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        break;
//                }
//                return super.onInterceptTouchEvent(ev);
//            } catch (IllegalArgumentException ex) {
//                ex.printStackTrace();
//            }
//            return false;
//        }
//
//    }
//
//    /**
//     * 设置透明度
//     */
//    @CallSuper
//     public void setAlpha(@FloatRange(from=0.0, to=1.0) float alpha){
//        layout_bg.setAlpha(alpha);
//     }
//
//    /**
//     * 初始的视图加载完成
//     */
//    @CallSuper
//     public void onViewFinish(){
//
//     }
//    @CallSuper
//    public void onMyPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//    @CallSuper
//    public void onMyPageSelected(int position) {
//        currentPosition = position;
//    }
//    @CallSuper
//    public void onMyPageScrollStateChanged(int state) {
//
//    }
//    //设置不能在3秒内连续点击两次返回按钮
//    private long mExitTime;
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if ((System.currentTimeMillis() - mExitTime) > 3000) {
//                mExitTime = System.currentTimeMillis();
//            } else {
//                return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//
//    @Override
//    protected void onDestroy() {
//        imageUrls=null;
//        imageBeans=null;
//        super.onDestroy();
//    }
//}
