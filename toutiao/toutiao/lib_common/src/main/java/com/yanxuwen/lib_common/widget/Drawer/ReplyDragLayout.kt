package com.yanxuwen.lib_common.widget.Drawer

import android.content.Context
import android.util.AttributeSet
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.lib_common.Adapter.ReplyListAdapter
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.RequestUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.MyObserverListener
import com.yanxuwen.lib_common.retrofit.model.ReplyList.ReplyList
import com.yanxuwen.mydrawer.BaseDragLayout
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.common_drag_reply.view.*

/**
 * Created by yanxuwen on 2018/5/30.
 * 回复列表
 */
class ReplyDragLayout : BaseDragLayout , MyObserverListener, MyRecyclerView.LoadingListener {
    var offset=0
    lateinit var id: String
    val mRequestUtils: RequestUtils by lazy {
        RequestUtils(context,this)
     }
    var list: ArrayList<ReplyList.DataBeanX.DataBean> = ArrayList()
    val mAdapter: ReplyListAdapter by lazy {
        ReplyListAdapter(context, list)
    }
    val mMyRecyclerViewUtils: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, null, rv_reply, mAdapter)
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
        contentView = findViewById(R.id.layout_reply)
        isEdgeSlide = false
        initListView()
        iv_close.setOnClickListener({
            close()
        })
    }

    fun initListView() {
        rv_reply?.setLoadingListener(this)
        mMyRecyclerViewUtils.setRecyclerView()
        rv_reply?.adapter = mAdapter
        setRecyclerView(rv_reply)
    }

    override fun onRefresh() {
        offset=0
        mRequestUtils.requestReplyList(offset,mMyRecyclerViewUtils.limit,id)
    }
    override fun onLoadMore() {
        offset=list.size
        mRequestUtils.requestReplyList(offset,mMyRecyclerViewUtils.limit,id)
    }
    fun notifyDataSetChanged(isRefresh: Boolean, count: Int, overtime: Boolean) =
            mMyRecyclerViewUtils.notifyDataSetChanged(count, "", overtime)
    
    override fun onNotifyData(status: ObserverListener.STATUS?, type: String?, mobject: Any?) {
        when (type) {
            Msg.ReplyList -> {
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChanged(true, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mReplyList = (mobject as ReplyList)
                    if(mReplyList.isRefresh){
                        list.clear()
                    }
                    var list_data = ArrayList<ReplyList.DataBeanX.DataBean>()
                    if (mReplyList != null && mReplyList.data != null&& mReplyList.data.data != null) {

                        list_data.addAll(mReplyList.data.data)
                        //将热门评论加到列表中
                        if (mReplyList != null && mReplyList.data != null&& mReplyList.data.hot_comments != null) {
                            list_data.addAll(0,mReplyList.data.hot_comments)
                        }
                    }

                    list.addAll(list_data)


                    notifyDataSetChanged(true, list_data.size, false)
                }
            }
        }
    }
}