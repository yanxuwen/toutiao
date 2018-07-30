package com.yanxuwen.lib_common.Adapter

import android.app.Activity
import android.content.Context
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.dragview.DragViewActivity
import com.yanxuwen.lib_common.Fragment.ImageViewerFragment
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Emoji.EmojiUtils
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options3
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.optionsRound
import com.yanxuwen.lib_common.Utils.TimeUtils
import com.yanxuwen.lib_common.retrofit.model.ReplyList.ReplyList
import com.yanxuwen.lib_common.widget.MyImageSpan
import kotlinx.android.synthetic.main.common_reply_list.view.*


/**
 * 回复列表评论适配器
 */
class ReplyListAdapter(private val mContext: Context, private val mDataSet: List<ReplyList.DataBeanX.DataBean>) : MyBaseAdapter(mContext, mDataSet) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(setLayout(R.layout.common_reply_list, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        var data=mDataSet[position]
        mViewHolder.itemView.tv_name.text=data?.user.name
        if(data?.user?.verified_reason!=null&&data?.user?.verified_reason!=""){
            mViewHolder.itemView.tv_verified.text=data?.user?.verified_reason
            mViewHolder.itemView.tv_verified.visibility=View.VISIBLE
        }else{
            mViewHolder.itemView.tv_verified.visibility=View.GONE
        }
        Glide.with(mContext).load(data?.user.avatar_url).transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(mViewHolder.itemView.tv_head)
        mViewHolder.itemView.tv_time.text= TimeUtils.getTimeDifference(((data?.create_time?:0)*1000).toString())+mContext.getString(R.string.common_reply_count_text)
        mViewHolder.itemView.tv_digg.text= data ?.digg_count.toString()
        //是否是有回复谁
        if(data.reply_to_comment!=null){
            //判断是否是回复作者，如果回复作者，则要显示作者图标
            var text=data?.content+"\t//@"
            var text_and_replyname=text+data.reply_to_comment.user_name
            var spannableString = if(data?.reply_to_comment?.author_badge!=null&&!(data?.reply_to_comment.author_badge.isEmpty())) {
                EmojiUtils.getEmotionContent(mContext,mViewHolder.itemView.tv_content,text_and_replyname+"【作者】:"+data?.reply_to_comment.text)
            }else{
                EmojiUtils.getEmotionContent(mContext,mViewHolder.itemView.tv_content,text_and_replyname+":"+data?.reply_to_comment.text)
            }
            val colorSpan = ForegroundColorSpan(mContext.resources.getColor(R.color.common_deep_blue))
            spannableString.setSpan(colorSpan, text.length-1, text_and_replyname.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            if(data?.reply_to_comment?.author_badge!=null&&!(data?.reply_to_comment.author_badge.isEmpty())) {
                val span = MyImageSpan(mContext,  R.mipmap.d_author)
                spannableString.setSpan(span,text_and_replyname.length, text_and_replyname.length+4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
            }else{}
            mViewHolder.itemView.tv_content.text=spannableString

        }else{
            mViewHolder.itemView.tv_content.text= EmojiUtils.getEmotionContent(mContext,mViewHolder.itemView.tv_content,data?.content)
        }

        //如果没有内容，则隐藏
        if(mViewHolder.itemView.tv_content?.text?.toString()==""){
            mViewHolder.itemView.tv_content.visibility=View.GONE
        }else{
            mViewHolder.itemView.tv_content.visibility=View.VISIBLE
        }
        //显示图片
        if(data?.thumb_image_list!=null&&!data?.thumb_image_list?.isEmpty()!!){
            mViewHolder.itemView.iv_content.visibility=View.VISIBLE
            Glide.with(mContext).load(data?.thumb_image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options3).into(mViewHolder.itemView.iv_content)
            mViewHolder.itemView.iv_content.setOnClickListener {
                var listimage=ArrayList<Any>()
                listimage.add(data?.large_image_list?.get((data?.large_image_list?.size?:0)-1)?.url!!)
                var listFragment: java.util.ArrayList<Class<*>> = java.util.ArrayList()
                listFragment.add(ImageViewerFragment::class.java)
                //展开放大图片
                DragViewActivity.startActivity(mContext as Activity?, position,object : DragViewActivity.OnDataListener{

                    override fun getListData(): java.util.ArrayList<Any> = listimage

                    override fun onBackPressed(): Boolean = true

                    override fun getListView(): java.util.ArrayList<View>? = null

                    override fun getListFragmentClass(): java.util.ArrayList<Class<*>> = listFragment

                    override fun onPageSelected(position: Int) = Unit

                    override fun init() = Unit

                })
            }
        }else{
            mViewHolder.itemView.iv_content.visibility=View.GONE
        }
        super.onBindViewHolder(holder, position)

    }
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
