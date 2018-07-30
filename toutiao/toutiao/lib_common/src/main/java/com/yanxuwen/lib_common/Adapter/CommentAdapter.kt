package com.yanxuwen.lib_common.Adapter

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.dragview.DragViewActivity
import com.yanxuwen.lib_common.Fragment.ImageViewerFragment
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Emoji.EmojiUtils.getEmotionContent
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options3
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.optionsRound
import com.yanxuwen.lib_common.Utils.TimeUtils
import com.yanxuwen.lib_common.retrofit.model.Comment.Comment
import kotlinx.android.synthetic.main.common_comment.view.*


/**
 * 评论适配器
 */
class CommentAdapter(private val mContext: Context, private val mDataSet: List<Comment.DataBean>) : MyBaseAdapter(mContext, mDataSet) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(setLayout(R.layout.common_comment, parent))
    }

    override fun onBindViewHolder(holder: MyBaseAdapter.BaseViewHolder, position: Int) {
        val mViewHolder = holder as ViewHolder
        var data=mDataSet[position]
        Glide.with(mContext).load(data?.comment?.user_profile_image_url).transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(mViewHolder.itemView.tv_head)
        mViewHolder.itemView.tv_name.text=data?.comment?.user_name
        if(data?.comment?.verified_reason!=null&&data?.comment?.verified_reason!=""){
            mViewHolder.itemView.tv_verified.text=data?.comment?.verified_reason
            mViewHolder.itemView.tv_verified.visibility=View.VISIBLE
        }else{
            mViewHolder.itemView.tv_verified.visibility=View.GONE
        }

        if(data?.comment?.large_image_list!=null&&!data?.comment?.large_image_list?.isEmpty()!!){
            mViewHolder.itemView.iv_content.visibility=View.VISIBLE
            Glide.with(mContext).load(data?.comment?.large_image_list?.get(0)?.url).transition(DrawableTransitionOptions.withCrossFade()).apply(options3).into(mViewHolder.itemView.iv_content)
            mViewHolder.itemView.iv_content.setOnClickListener {
                var listimage=ArrayList<Any>()
                listimage.add(data?.comment?.large_image_list?.get((data?.comment?.large_image_list?.size?:0)-1)?.url!!)
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
        if(data?.comment?.text==null||data?.comment?.text==""){
            mViewHolder.itemView.tv_content.visibility=View.GONE
        }else{
            mViewHolder.itemView.tv_content.visibility=View.VISIBLE
        }
        mViewHolder.itemView.tv_content.text= getEmotionContent(mContext,mViewHolder.itemView.tv_content,data?.comment?.text) ?:""
        mViewHolder.itemView.tv_time.text= TimeUtils.getTimeDifference(((data?.comment?.create_time?:0)*1000).toString())
        mViewHolder.itemView.tv_reply.text= String.format(mContext.getString(R.string.common_reply_count,data?.comment?.reply_count))
        mViewHolder.itemView.tv_digg.text= data ?.comment?.digg_count.toString()
        if(data?.comment?.reply_count==0L){
            mViewHolder.itemView.tv_reply.visibility=View.GONE
            mViewHolder.itemView.tv_time.text= mViewHolder.itemView.tv_time.text.toString()+mContext.getString(R.string.common_reply_count_text)
        }else{
            mViewHolder.itemView.tv_reply.visibility=View.VISIBLE
        }
        //回复列表显示
        //回复列表显示
        if(data?.comment?.reply_list!=null&&data?.comment?.reply_list?.isEmpty() != true){
            mViewHolder.itemView.layout_rv.visibility=View.VISIBLE
            var mDataSet: List<Comment.DataBean.CommentBean.ReplyListBean>
            var mReplySimpleAdapter=ReplySimpleAdapter(mContext, data?.comment?.reply_list!!)
            val layoutmanager = LinearLayoutManager(mContext)
            layoutmanager.orientation = LinearLayoutManager.VERTICAL
            if(mViewHolder.itemView.rv_reply_simple?.layoutManager==null) {
                mViewHolder.itemView.rv_reply_simple?.layoutManager = layoutmanager
            }
            mViewHolder.itemView.rv_reply_simple?.adapter = mReplySimpleAdapter
            mViewHolder.itemView.tv_reply_count_all.visibility=if(data?.comment?.reply_count==0L)View.GONE else View.VISIBLE
            mViewHolder.itemView.tv_reply_count_all.text= String.format(mContext.getString(R.string.common_reply_count_all,data?.comment?.reply_count))
        }else{
            mViewHolder.itemView.layout_rv.visibility=View.GONE
        }
        super.onBindViewHolder(holder, position)

    }
    inner class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }
}
