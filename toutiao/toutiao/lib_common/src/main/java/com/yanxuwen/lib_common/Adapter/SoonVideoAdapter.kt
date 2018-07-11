package com.yanxuwen.lib_common.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options
import com.yanxuwen.lib_common.Utils.video.VideoInfoUtils
import com.yanxuwen.lib_common.retrofit.model.NewsList.SoonVideo
import kotlinx.android.synthetic.main.common_soonvideo_item.view.*
import java.util.*


/**
 * 小视频适配器
 */
class SoonVideoAdapter(private val mContext: Context, private val mDataSet: List<Any>) : MyBaseAdapter(mContext, mDataSet) {

    var list_viewholder= HashMap<Int,ViewHolder>()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(setLayout(R.layout.common_soonvideo_item, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        if(list_viewholder?.containsKey(position)){
            list_viewholder[position] = mViewHolder
        }else{
            list_viewholder.put(position,mViewHolder)

        }
        var data=mDataSet[position] as SoonVideo
        Glide.with(mContext).load(data?.raw_data?.first_frame_image_list?.get(data?.raw_data?.first_frame_image_list?.size!! -1)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options).into(mViewHolder.itemView.iv_thumb)
        mViewHolder.itemView.tv_title.text = data?.raw_data?.title
        mViewHolder.itemView.tv_play_count.text =VideoInfoUtils().setPlayCount(mContext,(data?.raw_data.action?.play_count?:0))
        mViewHolder.itemView.tv_digg_count.text =VideoInfoUtils().setPlayCount(mContext,(data?.raw_data.action?.digg_count?:0))
        super.onBindViewHolder(holder, position)

    }
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
