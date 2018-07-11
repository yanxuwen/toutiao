package com.yanxuwen.lib_common.Adapter

import android.content.Context
import android.text.Spannable
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.view.ViewGroup
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Emoji.EmojiUtils
import com.yanxuwen.lib_common.retrofit.model.Comment.Comment
import com.yanxuwen.lib_common.widget.MyImageSpan
import kotlinx.android.synthetic.main.common_reply_simple.view.*


/**
 * 简单的回复评论适配器
 */
class ReplySimpleAdapter(private val mContext: Context, private val mDataSet: List<Comment.DataBean.CommentBean.ReplyListBean>) : MyBaseAdapter(mContext, mDataSet) {
    init {
        setIsAnimate(false)
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(setLayout(R.layout.common_reply_simple, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        var data=mDataSet[position]

        var spannableString = if(data?.author_badge!=null&&!(data?.author_badge.isEmpty())) {
            EmojiUtils.getEmotionContent(mContext,mViewHolder.itemView.tv_text,data?.user_name+"【作者】:"+data?.text)
        }else{
            EmojiUtils.getEmotionContent(mContext,mViewHolder.itemView.tv_text,data?.user_name+":"+data?.text)
        }
        val colorSpan = ForegroundColorSpan(mContext.resources.getColor(R.color.common_deep_blue))
        spannableString.setSpan(colorSpan, 0, data?.user_name.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        if(data?.author_badge!=null&&!(data?.author_badge.isEmpty())) {
            val span = MyImageSpan(mContext,  R.mipmap.d_author)
            spannableString.setSpan(span, data?.user_name.length, data?.user_name.length+4, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }else{

        }
        mViewHolder.itemView.tv_text.text = spannableString

        super.onBindViewHolder(holder, position)

    }
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
