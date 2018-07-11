package com.yanxuwen.lib_common.Utils

import android.content.Context
import android.view.View
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.MyRecyclerview.MySwipeRefreshLayout
import com.yanxuwen.RecyclerViewUtils
import kotlinx.android.synthetic.main.common_empty_data.view.*
import kotlinx.android.synthetic.main.common_empty_network.view.*

/**
 * Created by yanxuwen on 2018/1/26.
 */

class MyRecyclerViewUtils: RecyclerViewUtils {
    constructor(context: Context, mSwipeRefreshLayout: MySwipeRefreshLayout, mRecyclerView: MyRecyclerView, mAdapter: MyBaseAdapter,limit:Int) : super(context,mSwipeRefreshLayout,mRecyclerView,mAdapter) {
       this.limit=limit
    }
    constructor(context: Context, mSwipeRefreshLayout: MySwipeRefreshLayout?, mRecyclerView: MyRecyclerView?, mAdapter: MyBaseAdapter) : super(context,mSwipeRefreshLayout,mRecyclerView!!,mAdapter) {
    }
    /**
     * @param count 当前刷新的数量
     * *
     * @param timeout 超时
     */
    fun notifyDataSetChanged(count: Int, timeout: Boolean) {
        super.notifyDataSetChanged(count, "没有更多了", timeout, mSwipeRefreshLayout?.empty_data,mSwipeRefreshLayout?.emptyview_network)
    }
    fun notifyDataSetChanged(count: Int,nomore: String, timeout: Boolean) {
        super.notifyDataSetChanged(count, nomore, timeout, mSwipeRefreshLayout?.empty_data,mSwipeRefreshLayout?.emptyview_network)
    }
    /**
     * @param count 当前刷新的数量
     * *
     * @param timeout 超时
     * *
     * @param empty_data 由于会有很多界面的空数据都不一样，，所以要单独传
     */
    fun notifyDataSetChanged(count: Int, timeout: Boolean, empty_data: View) {

        super.notifyDataSetChanged(count, "没有更多了", timeout, empty_data, mSwipeRefreshLayout?.emptyview_network)
    }
}
