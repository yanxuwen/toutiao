package com.yanxuwen.lib_common.Adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.optionsRound
import com.yanxuwen.lib_common.Utils.RequestUtils
import com.yanxuwen.lib_common.Utils.TimeUtils
import com.yanxuwen.lib_common.Utils.video.VideoListUtils
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import kotlinx.android.synthetic.main.common_live_video.view.*
import kotlinx.android.synthetic.main.common_newslist_image.view.*
import kotlinx.android.synthetic.main.common_newslist_image2.view.*
import kotlinx.android.synthetic.main.common_newslist_image3.view.*
import kotlinx.android.synthetic.main.common_newslist_image_many.view.*
import kotlinx.android.synthetic.main.common_newslist_video.view.*
import kotlinx.android.synthetic.main.common_video_large.view.*


/**
 * 新闻列表适配器
 */
class NewsListAdapter(private val mContext: Context, private val mDataSet: List<NewsContent>,mRequestUtils: RequestUtils) : MyBaseAdapter(mContext, mDataSet)  {
     var mRequestUtils: RequestUtils = mRequestUtils
    //是否是图集，如果是图集则要把排列的3张图片改成中间图片
    var pictures = false

    private val type = 10000
    /**视频类型*/
    public val ViewTypeVideo = 1000
    /**图片类型*/
    val ViewTypeImage = 1001
    /**文字类型类型*/
    val ViewTypeWords = 1002
    /**广告类型*/
    val ViewTypeAd = 1003
    /**直播*/
    val ViewTypeLive = 1004

    /**判断是图片还是视频，还是广告*/
     fun getType(position: Int): Int {
        var data = mDataSet[position]
        if (data.raw_ad_data == null && data.raw_data == null) {
            //视频类型
             if (data.isHas_video ) {
                return ViewTypeVideo
            }
            //图片类型
            else if (data.isHas_image) {
                    return ViewTypeImage
                }
            //文字
            else if (!data.isHas_image && !data.isHas_video) {
                return ViewTypeWords
            }
        }
        //广告
        else if (data.raw_ad_data != null) {
            return ViewTypeAd
        }
        //直播
        else if (data.raw_data != null) {
            return ViewTypeLive
        }
        return 0
    }

    /*****具体类型则在数值的末尾加上 getType的值，避免冲突***/
    val type_image = 100*type+ViewTypeImage//图集1
    val type_image2 = 102*type+ViewTypeImage//图集2
    val type_image3 = 103*type+ViewTypeImage//右侧图片
    val type_image_many = 104*type+ViewTypeImage//多张图片
    val type_words = 105*type+ViewTypeWords//文字

    val type_vide_0 = 0*type+ViewTypeVideo//右侧视频
    val type_vide_2 = 2*type+ViewTypeVideo//中间大视频，没有头像

    val type_vide_12 = 12*type+ViewTypeVideo//中间大视频，有头像

    val type_ad_7 = 7*type+ViewTypeAd//图片广告2，单张图片，图片分类
    val type_ad_2 = 2*type+ViewTypeAd//图片广告2，单张图片，懂车帝分类
    val type_ad_3 = 3*type+ViewTypeAd//图片广告3，多张图片，懂车帝分类
    val type_ad_4 = 4*type+ViewTypeAd//图片广告4，右侧图片，懂车帝分类
    val type_ad_8 = 8*type+ViewTypeAd//含有头像的广告，也就是视频分类里面的广告

    val type_live = 106*type+ViewTypeLive//直播

    /**获取更加具体的类型，比如，广告下的某个类型*/
    override fun getItemViewType(position: Int): Int {
        var data = mDataSet[position]
        when (getType(position)) {
        //视频
            ViewTypeVideo -> {
                return data.video_style*type+ViewTypeVideo
            }
        //图片
            ViewTypeImage -> {
                if (data.image_list == null) {
                    //右侧图片
                    return  type_image3
                } else {
                    //图集2
                    if(data.image_list==null||data.image_list.size<3){
                        return  type_image2
                    }
                    //如果是组图分类，则使用中间图片，则使用多张图片
                    return if (pictures) type_image else type_image_many
                }

            }
        //文字
            ViewTypeWords -> {
                return type_words
            }
        //广告
            ViewTypeAd -> {
                return data.raw_ad_data.display_type*type+ViewTypeAd
            }
            ViewTypeLive -> {
                return type_live
            }
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var layout = 0
        when (viewType) {
           //图集1
            type_image, type_ad_7 -> {
                layout = R.layout.common_newslist_image
            }
           //图集2
            type_image2->{
                layout = R.layout.common_newslist_image2
            }
            type_image_many, type_ad_2, type_words, type_ad_3 -> {
                layout = R.layout.common_newslist_image_many
            }
            type_vide_12, type_ad_8 -> {
                layout = R.layout.common_newslist_video
            }
            //右侧图片跟右侧视频,右侧广告,主要判断行数更改打X位置
            type_image3, type_vide_0,type_ad_4 -> {
                layout = R.layout.common_newslist_image3
            }
            type_vide_2->{
                layout = R.layout.common_video_large
            }
            //直播
            type_live->{
                layout = R.layout.common_live_video
            }
            else -> {
                layout = R.layout.common_newslist_null
            }
        }
        return ViewHolder(setLayout(layout, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        when(getType(position)){
            ViewTypeVideo->{setViewTypeVideo(position,mViewHolder.itemView)}
            ViewTypeImage->{setViewTypeImage(position,mViewHolder.itemView)}
            ViewTypeWords->{setViewTypeWords(position,mViewHolder.itemView)}
            ViewTypeAd->{setViewTypeAd(position,mViewHolder.itemView)}
            ViewTypeLive->{setViewTypeLive(position,mViewHolder.itemView)}

        }
        if(getType(position)!=ViewTypeVideo&&getType(position)!=ViewTypeAd){
            var data = mDataSet[position]
            if(data.article==null){
                mRequestUtils.requestHtml(data?.group_id.toString())
            }
        }else if(getType(position)==ViewTypeVideo){
        }
        super.onBindViewHolder(holder, position)

    }

    /**设置视频*/
    fun setViewTypeVideo(position: Int,itemView:View) {
        var data = mDataSet[position]
        when (getItemViewType(position)) {
        //中间大视频，有头像
            type_vide_12 -> {
                var mVideoListUtils=VideoListUtils(mContext as Activity)
                var title=data.title
                var imgUrl=data?.large_image_list?.get(data?.large_image_list.size-1)?.url?:""
                var url="https://aweme.snssdk.com/aweme/v1/play/?video_id=8c6d59d9dcba426da4d6ec896e1e995f&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0"
                mVideoListUtils.setData(itemView.layout_player,position,title,imgUrl,url)
                mVideoListUtils.setOnVideoStatus(object :VideoListUtils.OnVideoStatus{
                    override fun onVideoPlay() {
                        itemView.iv_head.visibility=View.GONE
                        itemView.iv_headbg.visibility=View.GONE
                        itemView.tv_video_count.visibility=View.GONE

                    }
                })
                //根据播放状态来判断是否显示
                itemView.iv_head.visibility=if(mVideoListUtils.isFirstPlay)View.GONE else View.VISIBLE
                itemView.iv_headbg.visibility=if(mVideoListUtils.isFirstPlay)View.GONE else View.VISIBLE
                itemView.tv_video_count.visibility=if(mVideoListUtils.isFirstPlay)View.GONE else View.VISIBLE


                itemView.tv_video_ad.visibility = View.GONE
                itemView.iv_headbg.setTextAndColor("", mContext.resources.getColor(R.color.white))
                Glide.with(mContext).load(data?.user_info?.avatar_url).transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(itemView.iv_head)
                itemView.tv_video_follow.text = if (data?.user_info?.isFollow == true) mContext.getString(R.string.common_has_follow) else mContext.getString(R.string.common_follow)
                itemView.tv_video_count.text = TimeUtils.millisToString((data?.video_duration * 1000).toString())
                itemView.tv_video_author.text = data?.source
                itemView.tv_video_comment.setTextColor(mContext.resources.getColor(R.color.black))
                itemView.tv_video_comment.text = String.format(mContext.getString(R.string.common_newscontent_comment2), data?.comment_count)
            }
        //中间大视频，没有头像
            type_vide_2->{
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_video_large)
                itemView.tv_video_large_title.text= data?.title
                itemView.tv_video_large_author.text=String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
                itemView.tv_video_large_count.text = TimeUtils.millisToString((data?.video_duration * 1000).toString())

            }
        //右侧视频
            type_vide_0 -> {
                itemView.tv_image3_duration.visibility = View.VISIBLE
                if(data?.middle_image!=null){
                    Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image3)
                    itemView.iv_image3.visibility=View.VISIBLE
                    itemView.tv_image3_duration.visibility=View.VISIBLE
                    itemView.tv_image3_duration.text = TimeUtils.millisToString((data?.video_duration * 1000).toString())

                }else{
                    itemView.iv_image3.visibility=View.GONE
                    itemView.tv_image3_duration.visibility=View.GONE
                }
                if(data.label!=null){
                    itemView.tv_image3_label.visibility=View.VISIBLE
                    itemView.tv_image3_label.text = data.label
                }else{
                    itemView.tv_image3_label.visibility=View.GONE
                }
                itemView.tv_image3_title.text = data?.title
                itemView.tv_image3_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
                itemView.tv_image3_title.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener{
                    override fun onPreDraw(): Boolean {
                        //打X的位置要调整
                        if(itemView.tv_image3_title.lineCount<3){
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.tv_image3_title)
                            itemView.layout_image3_author.layoutParams = params
                        }else{
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.iv_image3)
                            itemView.layout_image3_author.layoutParams = params
                        }
                        itemView.tv_image3_title.viewTreeObserver.removeOnPreDrawListener(this)
                        return true
                    }
                })
            }
        }
    }
    /**设置图片*/
    fun setViewTypeImage(position: Int,itemView:View) {
        var data = mDataSet[position]
        when (getItemViewType(position)) {
            //图集1
            type_image -> {
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_image)
                itemView.tv_image_title.text = data?.title
                itemView.tv_image_count.text = String.format(mContext.getString(R.string.common_newscontent_image_count), data?.gallary_image_count)
                itemView.tv_image_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
           //图集2
            type_image2 -> {
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image2_image)
                itemView.tv_image2_title.text = data?.title
                itemView.tv_image2_count.text = String.format(mContext.getString(R.string.common_newscontent_image_count), data?.gallary_image_count)
                itemView.tv_image2_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
        //多张图片
            type_image_many -> {
                try{
                Glide.with(mContext).load(data.image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many1)
                Glide.with(mContext).load(data.image_list?.get(1)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many2)
                Glide.with(mContext).load(data.image_list?.get(2)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many3)
                }catch (e:Exception){}
                itemView.tv_image_many_title.text = data?.title
                itemView.tv_image_many_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
        //右侧图片
            type_image3 -> {
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image3)
                itemView.tv_image3_title.text = data?.title
                itemView.tv_image3_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
                itemView.tv_image3_title.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener{
                    override fun onPreDraw(): Boolean {
                        //打X的位置要调整
                        if(itemView.tv_image3_title.lineCount<3){
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.tv_image3_title)
                            itemView.layout_image3_author.layoutParams = params
                        }else{
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.iv_image3)
                            itemView.layout_image3_author.layoutParams = params
                        }
                        itemView.tv_image3_title.viewTreeObserver.removeOnPreDrawListener(this)
                        return true
                    }
                })


            }
        }
    }
    /**设置文字*/
    fun setViewTypeWords(position: Int,itemView:View) {
        var data = mDataSet[position]
        when (getItemViewType(position)) {
        //文字，
            type_words -> {
                itemView.layout_image_manys.visibility = View.GONE
                itemView.tv_image_many_title.text = data?.title
                itemView.tv_image_many_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
        }
    }
    /**设置广告*/
    fun setViewTypeAd(position: Int,itemView:View) {
        var data = mDataSet[position]
        when (getItemViewType(position)) {
        //含有头像的广告，也就是视频分类里面的广告
            type_ad_8 -> {
                var mVideoListUtils=VideoListUtils(mContext as Activity)
                var title=data.title
                var imgUrl=data?.large_image_list?.get(data?.large_image_list.size-1)?.url?:""
                var url="https://aweme.snssdk.com/aweme/v1/play/?video_id=8c6d59d9dcba426da4d6ec896e1e995f&line=0&ratio=720p&media_type=4&vr_type=0&test_cdn=None&improve_bitrate=0"
                mVideoListUtils.setData(itemView.layout_player,position,title,imgUrl,url)
                itemView.tv_video_count.visibility = View.GONE
                itemView.tv_video_follow.visibility = View.GONE
                itemView.tv_video_ad.visibility = View.VISIBLE
                itemView.iv_headbg.setTextAndColor("", mContext.resources.getColor(R.color.white))
                itemView.iv_head.setTextAndColor(if (data?.source == null || data?.source == "") "" else data?.source.substring(0, 1), mContext.resources.getColor(R.color.gray))
                itemView.tv_video_author.text = data?.source
                itemView.tv_video_comment.setTextColor(mContext.resources.getColor(R.color.common_blue))
                itemView.tv_video_comment.text = data?.raw_ad_data?.button_text
            }
        //图片广告7，单张图片，图片分类
            type_ad_7 -> {
                itemView.tv_image_type.visibility = View.VISIBLE
                itemView.tv_image_count.text = mContext.getString(R.string.common_ad)
                itemView.tv_image_title.text = data?.title
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_image)
                itemView.tv_image_type.text = data?.raw_ad_data?.button_text
                itemView.tv_image_author.text = data?.source
            }

        //图片广告2，单张图片，懂车帝分类
            type_ad_2 -> {
                itemView.layout_image_manys.visibility = View.GONE
                itemView.iv_image_many.visibility = View.VISIBLE
                itemView.tv_image_many_ad.visibility = View.VISIBLE
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many)
                itemView.tv_image_many_title.text = data?.title
                itemView.tv_image_many_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
         //图片广告3，多张图片，懂车帝分类
            type_ad_3 -> {
                itemView.tv_image_many_ad.visibility = View.VISIBLE
                Glide.with(mContext).load(data.image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many1)
                Glide.with(mContext).load(data.image_list?.get(1)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many2)
                Glide.with(mContext).load(data.image_list?.get(2)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image_many3)
                itemView.tv_image_many_title.text = data?.title
                itemView.tv_image_many_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
            }
        //图片广告4，右侧图片，懂车帝分类
            type_ad_4 ->{
                itemView.tv_image3_ad.visibility=View.VISIBLE
                Glide.with(mContext).load(data?.thumb_url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.iv_image3)
                itemView.tv_image3_title.text = data?.title
                itemView.tv_image3_author.text = String.format(mContext.getString(R.string.common_newscontent_comment), data?.source, data?.comment_count)
                itemView.tv_image3_title.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener{
                    override fun onPreDraw(): Boolean {
                        //打X的位置要调整
                        if(itemView.tv_image3_title.lineCount<3){
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.tv_image3_title)
                            itemView.layout_image3_author.layoutParams = params
                        }else{
                            val params = itemView.layout_image3_author.layoutParams as RelativeLayout.LayoutParams
                            params.addRule(RelativeLayout.ALIGN_RIGHT, R.id.iv_image3)
                            itemView.layout_image3_author.layoutParams = params
                        }
                        itemView.tv_image3_title.viewTreeObserver.removeOnPreDrawListener(this)
                        return true
                    }
                })
            }
        }
    }
    /**设置直播*/
     fun setViewTypeLive(position: Int,itemView:View){
        var data = mDataSet[position]
        when (getItemViewType(position)) {
            //直播
            type_live -> {
                var imgUrl=data?.raw_data?.large_image?.url_list?.get((data?.raw_data?.large_image?.url_list)?.size!! -1)?.url?:""

                Glide.with(mContext).load(imgUrl).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(itemView.layout_live_player)

                itemView.iv_live_headbg.setTextAndColor("", mContext.resources.getColor(R.color.white))
                Glide.with(mContext).load(data?.raw_data?.user_infoX?.avatar_url).transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(itemView.iv_live_head)
                itemView.tv_live_follow.text = if (data?.raw_data?.user_infoX?.isFollow == true) mContext.getString(R.string.common_has_follow) else mContext.getString(R.string.common_follow)
                itemView.tv_live_author.text = data?.raw_data?.user_infoX?.name
            }
        }
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
