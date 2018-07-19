package com.zhengchen.weight.Banner;

/**
 * Created by yanxuwen on 2017/7/14.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhengchen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pinger
 * @since 2017/3/8 0008 下午 6:29
 * ViewPager基类适配器，需要传入Item视图和数据
 */
public abstract class BannerBaseAdapter<T> extends PagerAdapter {

    private Context mContext;
    private List<T> mDatas = new ArrayList<>();
    private OnPageTouchListener mListener;
    private long mDownTime;
    private View mConvertView;
    private BannerView mBannerView;

    public BannerBaseAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return mDatas == null || mDatas.size() == 0 ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    public T getItem(int position) {
        return position >= mDatas.size() ? mDatas.get(0) : mDatas.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mConvertView = LayoutInflater.from(mContext).inflate(getLayoutResID(), null);
        mConvertView.setClickable(true);

        if (mDatas != null && mDatas.size() != 0) {
            position = position % mDatas.size();
        }

        if (mDatas != null) {
            // 处理视图和数据
            convert(mConvertView, getItem(position));
        }

        final int finalPosition = position;

        // 处理条目的触摸事件
        mConvertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        mDownTime = System.currentTimeMillis();
                        if (mListener != null) {
                            mListener.onPageDown();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        long upTime = System.currentTimeMillis();
                        if (mListener != null) {
                            mListener.onPageUp();
                        }
                        if (upTime - mDownTime < 500) {
                            // 500毫秒以内就算单击
                            if (mListener != null && getItem(finalPosition) != null) {
                                mListener.onPageClick(finalPosition, getItem(finalPosition));
                            }
                        }
                        break;
                }
                return false;
            }
        });

        container.addView(mConvertView);
        return mConvertView;
    }


    public void setData(List<T> datas) {
        if (datas == null) return;
        this.mDatas = new ArrayList<>(datas);
        notifyDataSetChanged();
        if (mBannerView != null) {
            mBannerView.resetCurrentPosition(datas.size());
            mBannerView.setDots(datas.size(),0);
        }
    }


    protected <K extends View> K getView(@IdRes int id) {
        return (K) mConvertView.findViewById(id);
    }


    protected BannerBaseAdapter setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    protected BannerBaseAdapter setImage(int viewId, int drawableId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }
    protected BannerBaseAdapter setImage(int viewId, String imageUrl) {
        ImageView iv = getView(viewId);
        Glide.with(mContext)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .placeholder(R.mipmap.img_loading)
                .into(iv);
        return this;
    }

    protected BannerBaseAdapter setImage(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }


    /**
     * 获取Item对象
     *
     * @return
     */
    protected View getItemView() {
        return mConvertView;
    }

    // 绑定视图和数据
    protected abstract int getLayoutResID();

    protected abstract void convert(View convertView, T data);

    public void setOnPageTouchListener(OnPageTouchListener<T> listener) {
        this.mListener = listener;
    }

    public int getRealCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setBannerView(BannerView bannerView) {
        this.mBannerView = bannerView;
    }

    /**
     * 条目页面的触摸事件
     */
    public interface OnPageTouchListener<T> {
        void onPageClick(int position, T t);

        void onPageDown();

        void onPageUp();
    }
}
