package com.yanxuwen.dragviewlayout

import android.os.Bundle
import android.os.Handler
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.dragview.DragFragment
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions
import com.yanxuwen.lib_common.Utils.video.VideoInfoUtils
import com.yanxuwen.lib_common.Utils.video.VideoListUtils
import com.yanxuwen.lib_common.retrofit.model.NewsList.SoonVideo
import com.yanxuwen.lib_common.widget.Drawer.CommentDragLayout
import kotlinx.android.synthetic.main.common_drag_comments.view.*
import kotlinx.android.synthetic.main.common_soonvideo_fragment.view.*


/**
 * Created by yanxuwen on 2018/6/15.
 * 小视频
 */
class SoonVideoFragment : DragFragment() ,View.OnClickListener {


    var isVisibleToUser = false
    var mSoonVideo: SoonVideo? = null
    private val mVideoListUtils: VideoListUtils by lazy {
        VideoListUtils(activity)
    }

    override fun getDragView(): View? = if (view == null) null else view.layout_drag


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.common_soonvideo_fragment)
        super.onCreate(savedInstanceState)

    }

    override fun initView() {
        mSoonVideo = data as SoonVideo
//        Glide.with(context).load(mSoonVideo?.raw_data?.first_frame_image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(GlideOptions.options).into(view?.iv_thumb)
        view?.tv_author?.text = mSoonVideo?.raw_data?.user?.info?.name
        if (mSoonVideo?.raw_data?.title == null) {
            view?.tv_title?.visibility = View.GONE
        }
        if (mSoonVideo?.raw_data?.music == null || mSoonVideo?.raw_data?.music?.album_name == null) {
            view?.layout_music?.visibility = View.GONE
        }
        view?.tv_title?.text = mSoonVideo?.raw_data?.title
        view?.tv_music?.text = mSoonVideo?.raw_data?.music?.album_name
        view?.tv_digg_count?.text = VideoInfoUtils().setCount(context, mSoonVideo?.raw_data?.action?.digg_count ?: 0)
        view?.tv_comment_count?.text = VideoInfoUtils().setCount(context, mSoonVideo?.raw_data?.action?.comment_count ?: 0)
        Glide.with(context).load(mSoonVideo?.raw_data?.user?.info?.avatar_url).transition(DrawableTransitionOptions.withCrossFade()).apply(GlideOptions.optionsRound).into(view?.iv_head!!)
        view?.layout_comment?.setOnClickListener(this)
        view?.iv_close?.setOnClickListener(this)
        mVideoListUtils.setData(view?.layout_player!!, -1, mSoonVideo!!)
        if (isVisibleToUser) {
            Handler().postDelayed({
                if (isVisibleToUser) {
                    mVideoListUtils?.getPlayer()?.startPlayLogic()
                }
            }, 500)
        }
    }

    override fun init() {
        if (mSoonVideo == null) return
        Handler().postDelayed({
            if (mVideoListUtils?.getPlayer()?.isInPlayingState == false&&isVisibleToUser) {
                mVideoListUtils?.getPlayer()?.startPlayLogic()
            }
        },300)

    }

    override fun onDragStatus(status: Int) {
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        if (!isVisibleToUser) {
            if (mSoonVideo == null) return
            mVideoListUtils?.getPlayer()?.onVideoPause()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layout_comment -> {
                (view?.common_drag_comments as CommentDragLayout).item_id = mSoonVideo?.id.toString()
                (view?.common_drag_comments as CommentDragLayout)?.open()

            }
            R.id.iv_close->{
                activity.onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mVideoListUtils?.getPlayer() == null) return
        mVideoListUtils?.getPlayer()?.release()
    }

    fun onBackPressed():Boolean{
        if((view?.common_drag_comments as CommentDragLayout).isOpen){
            (view?.common_drag_comments as CommentDragLayout).close()
            return false
        }
        return true

    }
}
