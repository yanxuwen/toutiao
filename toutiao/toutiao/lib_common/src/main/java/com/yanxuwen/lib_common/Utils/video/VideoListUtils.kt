package com.yanxuwen.lib_common.Utils.video

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
import com.shuyu.gsyvideoplayer.utils.GSYVideoType
import com.shuyu.gsyvideoplayer.utils.GSYVideoType.SCREEN_TYPE_FULL
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.RequestUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.MyObserverListener
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import com.yanxuwen.lib_common.retrofit.model.NewsList.SoonVideo
import com.yanxuwen.lib_common.retrofit.model.VideoInfo.VideoInfo
import com.yanxuwen.retrofit.Msg.ObserverListener

/**
 * Created by yanxuwen on 2018/5/9.
 */
class VideoListUtils : VideoAllCallBack, MyObserverListener {
    companion object {
        val TAG = "VideoListUtils"
    }
    var isFirstPlay=false

    interface OnVideoStatus {
        fun onVideoPlay()
    }

    var mOnVideoStatus: OnVideoStatus? = null
    fun setOnVideoStatus(l: OnVideoStatus) {
        mOnVideoStatus = l
    }
    lateinit var orientationUtils: OrientationUtils
    open val mRequestUtils: RequestUtils by lazy {
        RequestUtils(context, this)
    }


    val options by lazy {
        RequestOptions()
                .centerCrop()
            .placeholder(R.color.common_gray_30)
//            .error(com.yanxuwen.myutils.R.drawable.loadimage)
                .priority(Priority.HIGH)
    }
    lateinit var context: Activity
     private var gsyVideoPlayer: StandardGSYVideoPlayer?=null
    lateinit var imageView: ImageView
    lateinit var gsyVideoOptionBuilder: GSYVideoOptionBuilder


    constructor(context: Activity) {
        this.context = context
        imageView = ImageView(context)
        gsyVideoOptionBuilder = GSYVideoOptionBuilder()
    }
    fun setData(mSoonCoverVideo: SoonCoverVideo, position: Int, mSoonVideo: SoonVideo) {
        this.gsyVideoPlayer = mSoonCoverVideo
        orientationUtils = OrientationUtils(context, getPlayer())
        var mGSYVideoType= GSYVideoType()
        //根据类型视频类型判断是否全屏
        GSYVideoType.setShowType(SCREEN_TYPE_FULL)
        //增加封面
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        Glide.with(context).load(mSoonVideo?.raw_data?.first_frame_image_list?.get((mSoonVideo?.raw_data?.first_frame_image_list?.size?:0)-1)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(imageView)
        if (imageView.parent != null) {
            val viewGroup = imageView.parent as ViewGroup
            viewGroup.removeView(imageView)
        }
        var url = "https://aweme.snssdk.com/aweme/v1/play/?video_id=v0200f660000bcctpu51mikeotmsqs10&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0"
        val title: String =""
        //防止错位，离开释放
        getPlayer()?.initUIState()
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
                .setThumbImageView(imageView)
                .setUrl(url)
                .setSetUpLazy(true)//lazy可以防止滑动卡顿
                .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setDialogProgressColor(context.resources.getColor(R.color.common_red),context.resources.getColor(R.color.common_gray_30))
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setLooping(true)
                .setPlayPosition(position)
                .setVideoAllCallBack(this).build(getPlayer())
    }
    fun setData(gsyVideoPlayer: SampleCoverVideo, position: Int, title:String , imgUrl:String , url:String) {
        this.gsyVideoPlayer = gsyVideoPlayer
        orientationUtils = OrientationUtils(context, getPlayer())
        GSYVideoType.setShowType(SCREEN_TYPE_FULL)

        //增加封面
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        Glide.with(context).load(imgUrl).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(imageView)
        if (imageView.parent != null) {
            val viewGroup = imageView.parent as ViewGroup
            viewGroup.removeView(imageView)
        }
        val title: String = title

        //防止错位，离开释放
        getPlayer()?.initUIState()
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
                .setThumbImageView(imageView)
                .setUrl(url)
                .setSetUpLazy(true)//lazy可以防止滑动卡顿
                .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setDialogProgressColor(context.resources.getColor(R.color.common_red),context.resources.getColor(R.color.common_gray_30))
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setPlayPosition(position)
                .setVideoAllCallBack(this).build(getPlayer())


        //增加title
//        getPlayer()?.mTopContainer?.visibility = View.VISIBLE
        getPlayer()?.titleTextView?.text = title

        //设置返回键
        getPlayer()?.backButton?.visibility = View.GONE

        //设置全屏按键功能
        getPlayer()?.fullscreenButton?.setOnClickListener { resolveFullBtn(getPlayer()) }
    }

    /**
     * 全屏幕按键处理
     */
    private fun resolveFullBtn(standardGSYVideoPlayer: StandardGSYVideoPlayer?) {
        standardGSYVideoPlayer?.startWindowFullscreen(context, false, true)
    }

    override fun onClickResumeFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onEnterFullscreen(url: String?, vararg objects: Any?) {
        GSYVideoManager.instance().isNeedMute = false
        getPlayer()?.currentPlayer?.titleTextView?.text = objects[0] as String
    }

    override fun onClickResume(url: String?, vararg objects: Any?) = Unit

    override fun onClickSeekbarFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onStartPrepared(url: String?, vararg objects: Any?) {
//        if (url == null || url == "") {
//            isFirstPlay=true
//            if(mOnVideoStatus!=null)mOnVideoStatus?.onVideoPlay()
//            mRequestUtils.requestVideoInfo(data.video_id,data.item_id.toString())
//        }
        isFirstPlay=true
        if(mOnVideoStatus!=null)mOnVideoStatus?.onVideoPlay()
    }

    override fun onClickStartIcon(url: String?, vararg objects: Any?) {

    }

    override fun onTouchScreenSeekLight(url: String?, vararg objects: Any?) = Unit

    override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo()
        }
    }

    override fun onClickStartThumb(url: String?, vararg objects: Any?) = Unit

    override fun onEnterSmallWidget(url: String?, vararg objects: Any?) = Unit

    override fun onClickStartError(url: String?, vararg objects: Any?) = Unit

    override fun onClickBlankFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onPrepared(url: String?, vararg objects: Any?) {
        if (orientationUtils == null) {
            throw NullPointerException("initVideo() or initVideoBuilderMode() first")
        }
        //开始播放了才能旋转和全屏
        orientationUtils.isEnable = true
    }

    override fun onAutoComplete(url: String?, vararg objects: Any?) = Unit

    override fun onQuitSmallWidget(url: String?, vararg objects: Any?) = Unit

    override fun onTouchScreenSeekVolume(url: String?, vararg objects: Any?) = Unit

    override fun onClickBlank(url: String?, vararg objects: Any?) = Unit

    override fun onClickStop(url: String?, vararg objects: Any?) = Unit

    override fun onClickSeekbar(url: String?, vararg objects: Any?) = Unit

    override fun onPlayError(url: String?, vararg objects: Any?) = Unit

    override fun onClickStopFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onTouchScreenSeekPosition(url: String?, vararg objects: Any?) = Unit

    fun getPlayer(): StandardGSYVideoPlayer? {
//        return if (detailPlayer.isIfCurrentIsFullscreen) {
//            detailPlayer_full
//        }
//        else
        return gsyVideoPlayer
    }

    override fun onNotifyData(status: ObserverListener.STATUS, type: String, mobject: Any) {
        when (type) {
            Msg.VideoInfo -> {
                if (mRequestUtils.isDataFail(status)) {
                    return
                }
                if (mobject != null) {
                    var mVideoInfo = (mobject as VideoInfo)
                    var url=mVideoInfo?.video_info?.data?.video_list?.video_1?.main_url
                    if(url!=null&& url != ""){
                        gsyVideoOptionBuilder.setUrl(url).build(getPlayer())
                        getPlayer()?.startPlayLogic()
                    }
                    //由于现在请求有加密，所以暂时获取不到视频地址
                    else{
                        url="http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4"
                        gsyVideoOptionBuilder.setUrl(url).build(getPlayer())
                        getPlayer()?.startPlayLogic()
                    }
                }
            }
        }
    }

}