package com.yanxuwen.module_bottomtab0.Main

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.lib_common.ARouter.MyARouter
import com.yanxuwen.lib_common.Adapter.CommentAdapter
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.Bean.Value
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.optionsRound
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.video.TypeConver
import com.yanxuwen.lib_common.Utils.video.VideoInfoUtils
import com.yanxuwen.lib_common.Utils.video.VideoListUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.model.Comment.Comment
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import com.yanxuwen.lib_common.retrofit.model.VideoRecommend.VideoRecommend
import com.yanxuwen.lib_common.widget.Drawer.ReplyDragLayout
import com.yanxuwen.lib_common.Base.Key.VideoKey
import com.yanxuwen.module_bottomtab0.Main.Adapter.VideoRecommendAdapter
import com.yanxuwen.module_bottomtab0.R
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.bt0_activity_video.*
import kotlinx.android.synthetic.main.bt0_foot_video_expand.view.*
import kotlinx.android.synthetic.main.bt0_video_ad.view.*
import kotlinx.android.synthetic.main.bt0_video_head.view.*

/**
 * Created by yanxuwen on 2018/5/22.
 */
@Route(path = ARouterPath.Module_Bottomtab0_VideoActiviy)
class VideoActivity : BaseActivity(), MyRecyclerView.LoadingListener {
    var offset=0
    val mNewsContent: NewsContent by lazy {
        intent.extras.getSerializable(VideoKey.NewsContent) as NewsContent
    }
    val seek: Long by lazy {
        intent.getLongExtra(VideoKey.seek,0)
    }
    /**推荐的显示数据*/
    var listRecommedData: ArrayList<VideoRecommend.DataBean.RelatedVideoToutiaoBean> = ArrayList()
    val mVideoRecommendAdapter: VideoRecommendAdapter by lazy {
        VideoRecommendAdapter(context, listRecommedData)
    }

    var listCommentData: ArrayList<Comment.DataBean> = ArrayList()
    val mVideoCommentAdapter: CommentAdapter by lazy {
        CommentAdapter(context, listCommentData)
    }
    val mMyRecyclerViewUtilsRecommend: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, null, head_view.rv_video_recommend, mVideoRecommendAdapter)
    }
    val mMyRecyclerViewUtilsComment: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, null, rv_video_comment, mVideoCommentAdapter)
    }
    val head_view: View by lazy {
        LayoutInflater.from(this).inflate(R.layout.bt0_video_head, null)
    }
    val foot_view: View by lazy {
        LayoutInflater.from(this).inflate(R.layout.bt0_foot_video_expand, null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.bt0_activity_video)
        super.onCreate(savedInstanceState)
        setStatusFull(true)
    }

    override fun initData() {
    }

    override fun initView(status: Value.ObservableStatus?) {
        initListViewComment()
        initListViewRecommend()
        initVideoInfo()
    }
    fun initListViewComment(){
        rv_video_comment.addHeaderView(head_view)
        rv_video_comment?.setLoadingListener(this)
        mMyRecyclerViewUtilsComment.setRecyclerView()
        rv_video_comment?.adapter = mVideoCommentAdapter
        mVideoCommentAdapter.setOnItemClickListener(object : MyBaseAdapter.OnItemClickListener{
            override fun onItemClick(holder: MyBaseAdapter.BaseViewHolder?, view: View?, position: Int) =
                    if(listCommentData[position].comment.reply_count!=0L){
                        (common_drag_reply as ReplyDragLayout)?.id= (listCommentData[position]?.comment?.id).toString()
                        (common_drag_reply as ReplyDragLayout)?.open()
                    }else{}

        })
    }
    fun initListViewRecommend() {
        mRequestUtils.requestVideoRecommend(mNewsContent?.video_id, mNewsContent?.item_id, mNewsContent?.item_id)
        head_view.rv_video_recommend.addFootView(foot_view)
        foot_view.visibility=View.GONE
        mMyRecyclerViewUtilsRecommend.setRecyclerView()
        head_view.rv_video_recommend?.adapter = mVideoRecommendAdapter
        mVideoRecommendAdapter.setOnItemClickListener({ holder, view, position ->
             MyARouter.getInstance().build(ARouterPath.Module_Bottomtab0_VideoActiviy)
                            .withSerializable(VideoKey.NewsContent, TypeConver.onVideoRecommendToNewContent(listRecommedData[position]))
                            .withLong(VideoKey.seek, 0)
                            .navigation(context)
        })
    }

    fun initVideoInfo() {
        tv_author.text=mNewsContent?.source
        //找不到粉丝的数量哪里取，先随便取
        tv_fans.text = VideoInfoUtils().setFansCount(context, 542123)
        Glide.with(context).load(mNewsContent.user_info?.avatar_url).transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(iv_head)
        head_view.tv_video_title.text = mNewsContent?.title
        head_view.iv_expand.setOnClickListener(this)
        head_view.tv_video_title.setOnClickListener(this)
        head_view.tv_video_title2.setOnClickListener(this)
        head_view.tv_video_title2.text = mNewsContent?.title
        head_view.tv_play_count.text = VideoInfoUtils().setPlayCount(context, (mNewsContent?.video_detail_info?.video_watch_count ?: 0))
        head_view.tv_publish.text = VideoInfoUtils().setPublishTime(context, (mNewsContent?.publish_time))
        head_view.tv_abstract.text = mNewsContent.abstractX
        var mVideoListUtils= VideoListUtils(context)
        var title=mNewsContent.title
        var imgUrl=mNewsContent?.large_image_list?.get(mNewsContent?.large_image_list.size-1)?.url?:""
        var url="https://aweme.snssdk.com/aweme/v1/play/?video_id=8c6d59d9dcba426da4d6ec896e1e995f&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0"
        mVideoListUtils.setData(layout_player,-1,title,imgUrl,url)
        mVideoListUtils.getPlayer()?.seekOnStart = seek
        mVideoListUtils.getPlayer()?.startPlayLogic()
    }
    fun initVideoAd(mAdBean : VideoRecommend.DataBean.AdBean){
        if(mAdBean?.mixed == null)return
        foot_view.tv_ad_title.text=mAdBean?.mixed?.title
        Glide.with(context).load(if(mAdBean.mixed!=null&&mAdBean?.mixed?.image!=null)mAdBean?.mixed?.image  else mAdBean?.mixed?.image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(foot_view.iv_ad_image)
        foot_view.tv_ad_title.text=mAdBean?.mixed?.title
        foot_view.tv_ad_author.text=mAdBean?.mixed.source_name
        foot_view.tv_ad_type.text=mAdBean?.mixed.button_text
    }

    override fun onLoadMore() {
        offset=listCommentData.size
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtilsComment.limit,mNewsContent?.item_id, mNewsContent?.item_id)
    }

    override fun onRefresh() {
        offset=0
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtilsComment.limit,mNewsContent?.item_id, mNewsContent?.item_id)
    }
    /**视频推荐*/
    fun notifyDataSetChangedRecommend(isRefresh: Boolean, count: Int, overtime: Boolean) {
        mMyRecyclerViewUtilsRecommend.notifyDataSetChanged(0, "", overtime)
    }
    /**评论*/
    fun notifyDataSetChangedComment(isRefresh: Boolean, count: Int, overtime: Boolean) {
        mMyRecyclerViewUtilsComment.notifyDataSetChanged(count, overtime)
    }

    override fun onNotifyData(status: ObserverListener.STATUS?, type: String?, mobject: Any?) {
        when (type) {
            Msg.Comment->{
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChangedComment(true, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mComment = (mobject as Comment)
                    if(mComment.isRefresh){
                        listCommentData.clear()
                    }
                    var list_data = ArrayList<Comment.DataBean>()
                    if (mComment != null && mComment.data != null) {
                        list_data.addAll(mComment.data)
                    }
                    listCommentData.addAll(list_data)
                    notifyDataSetChangedComment(true, list_data.size, false)
                }
            }
            Msg.VideoRecommend -> {
                onRefresh()
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChangedRecommend(true, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mVideoRecommend = (mobject as VideoRecommend)
                    //设置广告
                    if(mVideoRecommend?.data?.ad!=null&&mVideoRecommend?.data?.ad?.mixed!=null){
                        initVideoAd(mVideoRecommend?.data?.ad!!)
                        foot_view.layout_ad.visibility=View.VISIBLE
                    }else{
                        foot_view.layout_ad.visibility=View.GONE
                    }
                    var list_data = ArrayList<VideoRecommend.DataBean.RelatedVideoToutiaoBean>()
                    if (mVideoRecommend != null && mVideoRecommend.data != null && mVideoRecommend.data.related_video_toutiao != null) {
                        list_data.addAll(mVideoRecommend.data.related_video_toutiao)
                    }
                    for (i in 0..5){
                        listRecommedData.add(list_data[i])
                    }
                    if(list_data.size>6){
                        foot_view.tv_expand.visibility=View.VISIBLE
                    }
                    foot_view.setOnClickListener{
                        listRecommedData.clear()
                        listRecommedData.addAll(list_data)
                        notifyDataSetChangedRecommend(true, list_data.size, false)
                        foot_view.tv_expand.visibility=View.GONE
                    }
                    foot_view.visibility=View.VISIBLE
                    notifyDataSetChangedRecommend(true, list_data.size, false)

                }
            }
            else -> {
                super.onNotifyData(status, type, mobject)

            }
        }
    }

    override fun onClick(view: View?) = when (view?.id) {
        R.id.iv_expand, R.id.tv_video_title, R.id.tv_video_title2 -> {
            if (head_view.layout_expand.isShown) {
                val animator = ObjectAnimator.ofFloat(head_view.iv_expand, "rotation", 180f, 0f)
                animator.duration = 200
                animator.start()
                head_view.tv_video_title.visibility = View.VISIBLE
                head_view.layout_expand.visibility = View.GONE

            } else {
                val animator = ObjectAnimator.ofFloat(head_view.iv_expand, "rotation", 0f, 180f)
                animator.duration = 200
                animator.start()
                head_view.tv_video_title.visibility = View.GONE
                head_view.layout_expand.visibility = View.VISIBLE

            }
        }
        else -> {
            super.onClick(view)
        }
    }

    override fun onResume() {
        GSYVideoManager.onResume()
        super.onResume()
    }
    override fun onPause() {
        GSYVideoManager.onPause()
        super.onPause()
    }
    override fun onDestroy() {
        GSYVideoManager.releaseAllVideos()
        super.onDestroy()
    }
    override fun onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        else if((common_drag_reply as ReplyDragLayout).isOpen){
            (common_drag_reply as ReplyDragLayout).close()
            return
        }
        super.onBackPressed()
    }
}