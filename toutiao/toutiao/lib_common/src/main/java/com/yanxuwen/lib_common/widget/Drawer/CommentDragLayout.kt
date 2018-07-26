package com.yanxuwen.lib_common.widget.Drawer

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.lib_common.Adapter.CommentAdapter
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.RequestUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.MyObserverListener
import com.yanxuwen.lib_common.retrofit.model.Comment.Comment
import com.yanxuwen.mydrawer.BaseDragLayout
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.common_drag_comments.view.*

/**
 * Created by yanxuwen on 2018/5/30.
 * 评论列表
 */
class CommentDragLayout : BaseDragLayout , MyObserverListener, MyRecyclerView.LoadingListener {
    var offset=0
    lateinit var item_id: String
    val mRequestUtils: RequestUtils by lazy {
        RequestUtils(context,this)
    }
    var list: ArrayList<Comment.DataBean> = ArrayList()
    val mAdapter: CommentAdapter by lazy {
        CommentAdapter(context, list)
    }
    val mMyRecyclerViewUtils: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, null, rv_comment, mAdapter)
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    override fun onViewStatus(isOpen: Boolean) = if(isOpen){
        onRefresh()
    }else{
        list.clear()
        notifyDataSetChanged(true, 0, false)
    }

    override fun onViewOffset(mOffset: Float) {
    }

    override fun initView() {
        contentView =layout_drag_comment
        initListView()
        iv_drag_close.setOnClickListener({
            close()
        })
    }

    fun initListView() {
        rv_comment?.setLoadingListener(this)
        mMyRecyclerViewUtils.setRecyclerView()
        rv_comment?.adapter = mAdapter
        setRecyclerView(rv_comment)
        mAdapter.setOnItemClickListener(object : MyBaseAdapter.OnItemClickListener{
            override fun onItemClick(holder: MyBaseAdapter.BaseViewHolder?, view: View?, position: Int) =
                    if(list[position].comment.reply_count!=0L){
                        (common_drag_reply as ReplyDragLayout)?.id= (list[position]?.comment?.id).toString()
                        (common_drag_reply as ReplyDragLayout)?.open()
                    }else{}

        })
    }

    override fun onRefresh() {
        offset=0
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtils.limit,item_id,item_id)
    }
    override fun onLoadMore() {
        offset=list.size
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtils.limit,item_id, item_id)
    }
    fun notifyDataSetChanged(isRefresh: Boolean, count: Int, overtime: Boolean) =
            mMyRecyclerViewUtils.notifyDataSetChanged(count, "", overtime)

    override fun onNotifyData(status: ObserverListener.STATUS?, type: String?, mobject: Any?) {
        when (type) {
            Msg.Comment->{
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChanged(true, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mComment = (mobject as Comment)
                    if(mComment.isRefresh){
                        list.clear()
                    }
                    var list_data = ArrayList<Comment.DataBean>()
                    if (mComment != null && mComment.data != null) {
                        list_data.addAll(mComment.data)
                    }
                    list.addAll(list_data)
                    notifyDataSetChanged(true, list_data.size, false)
                }
            }
        }
    }
}