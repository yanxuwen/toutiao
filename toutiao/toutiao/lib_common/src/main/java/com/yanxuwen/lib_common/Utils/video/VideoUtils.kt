package com.yanxuwen.lib_common.Utils.video

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.GSYSampleADVideoPlayer
import com.yanxuwen.lib_common.R
import java.util.*

/**
 * Created by yanxuwen on 2018/5/9.
 */
class VideoUtils : VideoAllCallBack {
    lateinit var detailPlayer: GSYSampleADVideoPlayer
    lateinit var context: Activity
    lateinit var orientationUtils: OrientationUtils
    protected var isPlay: Boolean = false

    constructor(context: Activity,detailPlayer: GSYSampleADVideoPlayer){
        this.context=context
        setData(detailPlayer)
    }
    constructor(context: Activity){
        this.context=context
    }
    fun setData(detailPlayer: GSYSampleADVideoPlayer){
        this.detailPlayer=detailPlayer
        setData()
    }
    private fun setData() {
        init()
        val urls = ArrayList<GSYSampleADVideoPlayer.GSYADVideoModel>()
        //广告1
        urls.add(GSYSampleADVideoPlayer.GSYADVideoModel("http://video.7k.cn/app_video/20171202/6c8cf3ea/v.m3u8.mp4",
                "", GSYSampleADVideoPlayer.GSYADVideoModel.TYPE_AD))
        //正式内容1
        urls.add(GSYSampleADVideoPlayer.GSYADVideoModel("http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4",
                "正文1标题", GSYSampleADVideoPlayer.GSYADVideoModel.TYPE_NORMAL))
        getPlayer()?.setAdUp(urls, true, 0)
        //增加封面
        val imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setImageResource(R.mipmap.icon)
        getPlayer()?.thumbImageView = imageView

        resolveNormalVideoUI()
        getPlayer()?.setIsTouchWiget(true)
        //关闭自动旋转
        getPlayer()?.isRotateViewAuto = false
        getPlayer()?.isLockLand = false
        getPlayer()?.isShowFullAnimation = false
        getPlayer()?.isNeedLockFull = true

        getPlayer()?.setVideoAllCallBack(this)
        getPlayer()?.setLockClickListener { view, lock ->
            if (orientationUtils != null) {
                //配合下方的onConfigurationChanged
                orientationUtils.isEnable = !lock
            }
        }
    }
    fun init(){
        if (getPlayer() == null) return
        orientationUtils = OrientationUtils(context, getPlayer())
        //初始化不打开外部的旋转
        orientationUtils.isEnable = false
        if (getPlayer()?.fullscreenButton != null) {
            getPlayer()?.fullscreenButton?.setOnClickListener(View.OnClickListener {
                showFull()
            })
        }
    }

    fun showFull() {
        if (orientationUtils.isLand != 1) {
            //直接横屏
            orientationUtils.resolveByClick()
        }
        //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
        getPlayer()?.startWindowFullscreen(context, true, true)

    }

    private fun resolveNormalVideoUI() {
        //增加title
        getPlayer()?.titleTextView?.visibility = View.VISIBLE
        getPlayer()?.backButton?.visibility = View.VISIBLE
    }
    fun getPlayer(): GSYSampleADVideoPlayer? {
//        return if (detailPlayer.isIfCurrentIsFullscreen) {
//            detailPlayer_full
//        }
//        else
           return detailPlayer
    }
    override fun onClickResumeFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onEnterFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onClickResume(url: String?, vararg objects: Any?) = Unit

    override fun onClickSeekbarFullscreen(url: String?, vararg objects: Any?) = Unit

    override fun onStartPrepared(url: String?, vararg objects: Any?) = Unit

    override fun onClickStartIcon(url: String?, vararg objects: Any?) = Unit

    override fun onTouchScreenSeekLight(url: String?, vararg objects: Any?) = Unit

    override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo()
        }    }

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
        isPlay = true
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
}