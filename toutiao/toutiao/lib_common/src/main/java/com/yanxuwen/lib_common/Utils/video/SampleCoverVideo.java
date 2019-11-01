package com.yanxuwen.lib_common.Utils.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.yanxuwen.lib_common.R;

/**
 * 该封面不是播放器自带的封面，为了封面切换到视频（该播放器封面切换到视频会黑屏，体验不好），会闪烁而多增加了一个封面
 */
public class SampleCoverVideo extends StandardGSYVideoPlayer {

    ImageView thumbImage2;

    View mThumbImageViewLayout2;

    String mCoverOriginUrl;


    int mDefaultRes;

    public SampleCoverVideo(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public SampleCoverVideo(Context context) {
        super(context);
    }

    public SampleCoverVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void init(Context context) {
        super.init(context);
        thumbImage2 = findViewById(R.id.thumbImage2);
        mThumbImageViewLayout2 = findViewById(R.id.thumb2);
    }

    @Override
    public int getLayoutId() {
        return R.layout.common_video_layout_cover;
    }

    public void loadCoverImage(String url, int res) {
        mCoverOriginUrl = url;
        mDefaultRes = res;
        Glide.with(getContext().getApplicationContext())
                .setDefaultRequestOptions(
                        new RequestOptions()
                                .frame(1000000)
                                .centerCrop()
                                .error(res)
                                .placeholder(res))
                .load(url)
                .into(thumbImage2);
    }

    public void onInfo(int what, int extra) {
        super.onInfo(what, extra);
        switch (what) {
            case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                thumbImage2.setVisibility(GONE);
                break;
        }
    }
}
