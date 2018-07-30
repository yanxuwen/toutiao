package com.yanxuwen.module_bottomtab0.Main.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options
import com.yanxuwen.lib_common.Utils.TimeUtils
import com.yanxuwen.lib_common.Utils.video.VideoInfoUtils
import com.yanxuwen.lib_common.retrofit.model.VideoRecommend.VideoRecommend
import com.yanxuwen.module_bottomtab0.R
import kotlinx.android.synthetic.main.bt0_item_video_recommend.view.*


/**
 * 视频推荐
 */
class VideoRecommendAdapter(private val mContext: Context, private val mDataSet: List<VideoRecommend.DataBean.RelatedVideoToutiaoBean>) : MyBaseAdapter(mContext, mDataSet) {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(setLayout(R.layout.bt0_item_video_recommend, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        var data=mDataSet[position]
        Glide.with(mContext).load(if(data?.video_detail_info?.detail_video_large_image!=null)data?.video_detail_info?.detail_video_large_image?.url else
            data?.middle_image.url
        ).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(mViewHolder.itemView.iv_thumb)
        mViewHolder.itemView.tv_title.text=data?.title
        mViewHolder.itemView.tv_author.text=data?.source
        mViewHolder.itemView.tv_video_count.text = TimeUtils.millisToString((data?.video_duration * 1000).toString())
        if(data.tag!=null&&data.tag == "ad"){
            mViewHolder.itemView. tv_video_ad.visibility=View.VISIBLE
        }else{
            mViewHolder.itemView. tv_video_ad.visibility=View.GONE
            mViewHolder.itemView.tv_author.text=mViewHolder.itemView.tv_author.text.toString()+"   \t"+
                    VideoInfoUtils().setPlayCount(mContext,(data?.video_detail_info?.video_watch_count?:0))
        }
        super.onBindViewHolder(holder, position)

    }
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
