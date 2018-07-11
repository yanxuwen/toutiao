package com.yanxuwen.lib_common.Fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.MyRecyclerview.MySwipeRefreshLayout
import com.yanxuwen.dragview.DragViewActivity
import com.yanxuwen.dragviewlayout.SoonVideoFragment
import com.yanxuwen.lib_common.ARouter.MyARouter
import com.yanxuwen.lib_common.Adapter.NewsListAdapter
import com.yanxuwen.lib_common.Adapter.SoonVideoAdapter
import com.yanxuwen.lib_common.Base.MyFragment
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Divider.DividerGridItemDecoration
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.video.VideoListUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.model.Html.Html
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsList
import com.yanxuwen.lib_common.retrofit.model.NewsList.SoonVideo
import com.yanxuwen.module_bottomtab0.Bean.Key.VideoKey
import com.yanxuwen.retrofit.GsonUtils
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.common_activity_recyclerview.view.*
import kotlinx.android.synthetic.main.common_newslist_video.view.*
import kotlinx.android.synthetic.main.common_soonvideo_item.view.*
import org.json.JSONObject
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*


/**
 * Created by yanxuwen on 2017/9/7.
 */
class TopTabRecommendFragment : MyFragment(), MyRecyclerView.LoadingListener {
    public val refreshLayout: MySwipeRefreshLayout by lazy {
        flayout?.refreshLayout!!
    }
     interface OnRefreshingListener{
        fun onRefreshing(refreshing: Boolean)
    }
    companion object {
        var  lsitRefreshingListener=ArrayList<OnRefreshingListener>()
        fun addOnRefreshingListener(l:OnRefreshingListener){
            if(!lsitRefreshingListener.contains(l)){
                lsitRefreshingListener.add(l)
            }
        }
        fun removeOnRefreshingListener(l:OnRefreshingListener){
            lsitRefreshingListener.remove(l)
        }
    }

    var isRefresh=false
    var isSoonVideo = false
    var page = 0
    var refresh_idx = 1
    var refresh_behot_time = ""
    var load_behot_time = ""
    var category: String = ""
    var listData: ArrayList<NewsContent> = ArrayList()
    var listDataSoonVideo: ArrayList<Any> = ArrayList()
    var listSoonVideoFragment: ArrayList<Class<*>> = ArrayList()

    val mAdapter: NewsListAdapter by lazy {
        NewsListAdapter(context, listData, mRequestUtils)
    }
    val mSoonVideoAdapter: SoonVideoAdapter by lazy {
        SoonVideoAdapter(context, listDataSoonVideo)
    }
    val mMyRecyclerViewUtils: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, flayout?.refreshLayout!!, flayout?.recyclerview!!, mAdapter)
    }
    val mMyRecyclerViewUtilsSoonVideo: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, flayout?.refreshLayout!!, flayout?.recyclerview!!, mSoonVideoAdapter)
    }

    override fun getMainView(): View? {
        if (mainview == null) {
            mainview = inflater.inflate(R.layout.common_activity_recyclerview, null)
        }
        return mainview
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun init() {
        super.init()
    }

    override fun initView() {
        super.initView()
        //由于传递加载多少数量无效，所以修改默认加载数量为1，但是返回还是会很多数据。
        mMyRecyclerViewUtils.limit = 1
        initListView()
        flayout?.refreshLayout?.isRefreshing = true
    }

    override fun onPause() {
        super.onResume()
        try {
            GSYVideoManager.onPause()
        } catch (e: Exception) {
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            GSYVideoManager.onResume()
        } catch (e: Exception) {
        }
    }

    override fun stopLoad() =
            try {
                GSYVideoManager.releaseAllVideos()
                mAdapter.notifyDataSetChanged()
            } catch (e: Exception) {
            }

    fun initListView() {
        flayout?.recyclerview?.setLoadingListener(this)
        if (isSoonVideo) {
            mMyRecyclerViewUtilsSoonVideo.setRecyclerViewGrid(2, R.color.black)
            flayout?.recyclerview?.adapter = mSoonVideoAdapter
            flayout?.recyclerview?.addItemDecoration(DividerGridItemDecoration(context, DividerGridItemDecoration.GRID_DIVIDER_VERTICAL, R.drawable.common_grid_divider))
            mSoonVideoAdapter.setOnItemClickListener { holder, view, position ->
                DragViewActivity.startActivity(activity, position)
                DragViewActivity.setOnDataListener(object : DragViewActivity.OnDataListener{
                    override fun getListData(): ArrayList<Any> = listDataSoonVideo

                    override fun getListView(): ArrayList<View> =
                            (0 until mSoonVideoAdapter.list_viewholder.size).mapTo(ArrayList<View>()) { mSoonVideoAdapter.list_viewholder[it]?.itemView?.iv_thumb!! }

                    override fun getListFragmentClass(): ArrayList<Class<*>> = listSoonVideoFragment

                    override fun onPageSelected(position: Int) {
                        if(position<flayout?.recyclerview?.firstVisiblePosition?:0||position>flayout?.recyclerview?.lastVisiblePosition?:0){
                            flayout?.recyclerview?.smoothScrollToPosition(position)
                        }
                    }
                    override fun onBackPressed(): Boolean {
                        var mFragment=DragViewActivity.instance.mMPagerAdapter.getItem(DragViewActivity.instance.currentPosition) as SoonVideoFragment
                        return mFragment.onBackPressed()
                    }
                })
            }
        } else {
            mMyRecyclerViewUtils.setRecyclerView()
            flayout?.recyclerview?.adapter = mAdapter
            if (category == "组图")
                mAdapter.pictures = true
        }
        flayout?.recyclerview?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var firstVisibleItem: Int = 0
            var lastVisibleItem: Int = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                firstVisibleItem = (flayout?.recyclerview?.layoutManager as LinearLayoutManager)?.findFirstVisibleItemPosition()
                lastVisibleItem = (flayout?.recyclerview?.layoutManager as LinearLayoutManager)?.findLastVisibleItemPosition()
                //大于0说明有播放
                if (GSYVideoManager.instance().playPosition >= 0) {
                    //当前播放的位置
                    val position = GSYVideoManager.instance().playPosition
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().playTag == VideoListUtils.TAG && (position < firstVisibleItem || position > lastVisibleItem)) {

                        //如果滑出去了上面和下面就是否，和今日头条一样
                        //是否全屏
                        if (!GSYVideoManager.isFullState(activity)) {
                            GSYVideoManager.releaseAllVideos()
                            mAdapter.notifyDataSetChanged()
                        }
                    }
                }
            }
        })
        mAdapter.setOnItemClickListener { holder, view, position ->
            when (mAdapter.getType(position)) {
            //视频
                mAdapter.ViewTypeVideo -> {
                    MyARouter.getInstance().build(ARouterPath.Module_Bottomtab0_VideoActiviy)
                            .withSerializable(VideoKey.NewsContent, listData[position])
                            .withLong(VideoKey.seek, (holder as NewsListAdapter.ViewHolder)?.itemView?.layout_player?.currentPositionWhenPlaying?.toLong() ?: 0)
                            .navigation(context)
                }
            //新闻
                mAdapter.ViewTypeImage, mAdapter.ViewTypeWords -> {
                    MyARouter.getInstance().build(ARouterPath.Module_Bottomtab0_NewActiviy)
                            .withSerializable(VideoKey.NewsContent, listData[position])
                            .navigation(context)
                }
            }
            GSYVideoManager.releaseAllVideos()
        }


    }

    fun notifyDataSetChanged(isRefresh: Boolean, count: Int, overtime: Boolean) =
            if (isSoonVideo) {
                mMyRecyclerViewUtilsSoonVideo.notifyDataSetChanged(count, overtime)
            } else {
                mMyRecyclerViewUtils.notifyDataSetChanged(count, overtime)
            }

    override fun onNotifyData(status: ObserverListener.STATUS, type: String, mobject: Any) {
        when (type) {
            Msg.NewsList -> {
                if(lsitRefreshingListener!=null&&!lsitRefreshingListener.isEmpty()){
                    for(i in lsitRefreshingListener.indices){
                        lsitRefreshingListener[i].onRefreshing(false)
                    }
                }
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChanged(page == 0, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mNewsList = (mobject as NewsList)
                    if (isRefresh) {
                        refresh_idx++
                        if (isSoonVideo) {
                            listDataSoonVideo.clear()
                            listSoonVideoFragment.clear()
                        } else {
                            listData.clear()
                        }
                        refresh_behot_time = (System.currentTimeMillis() / 1000).toString()
                    } else {
                        load_behot_time = (System.currentTimeMillis() / 1000).toString()
                    }
                    var list_data = ArrayList<NewsList.DataBean>()
                    if (mNewsList != null && mNewsList.data != null) {
                        list_data.addAll(mNewsList?.data)
                    }
                    //小视频
                    if (isSoonVideo) {
                        Observable.create(Observable.OnSubscribe<Void> { subscriber ->
                            for (i in list_data.indices) {
                                val jsonObject = JSONObject(list_data[i].content)
                                var mSoonVideo: SoonVideo? = null
                                try {
                                    mSoonVideo = GsonUtils.fromJson(jsonObject.toString(), SoonVideo::class.java) as SoonVideo
                                } catch (e: Exception) {
                                }
                                listDataSoonVideo.add(mSoonVideo!!)
                                listSoonVideoFragment.add(SoonVideoFragment::class.java)
                                DragViewActivity.instance?.notifyDataSetChanged()
                            }

                            subscriber.onNext(null)
                            subscriber.onCompleted()
                        })
                                .subscribeOn(Schedulers.io()) //事件发送，即图片加载在IO线程
                                .observeOn(AndroidSchedulers.mainThread())  //事件处理，即图片显示在UI线程
                                .subscribe(object : Subscriber<Void>() {
                                    override fun onCompleted() = Unit

                                    override fun onError(e: Throwable) =
                                            notifyDataSetChanged(page == 0, 0, false)

                                    override fun onNext(aVoid: Void?) =
                                            notifyDataSetChanged(page == 0, list_data.size, false)
                                })
                    }
                    //新闻
                    else {
                        Observable.create(Observable.OnSubscribe<Void?> { subscriber ->
                            for (i in list_data.indices) {
                                var json = list_data[i].content.replace("\"{", "{").replace("}\"", "}").replace("\\", "")
                                val jsonObject = JSONObject(json)
                                var mNewsContent: NewsContent? = null
                                try {
                                    mNewsContent = GsonUtils.fromJson(jsonObject.toString(), NewsContent::class.java) as NewsContent
                                } catch (e: Exception) {
                                }
                                if (mNewsContent?.tag_id == 0L) {
                                    continue
                                }
                                listData.add(mNewsContent!!)
                            }

                            subscriber.onNext(null)
                            subscriber.onCompleted()
                        })
                                .subscribeOn(Schedulers.io()) //事件发送，即图片加载在IO线程
                                .observeOn(AndroidSchedulers.mainThread())  //事件处理，即图片显示在UI线程
                                .subscribe(object : Subscriber<Void?>() {
                                    override fun onCompleted() = Unit

                                    override fun onError(e: Throwable) =
                                            notifyDataSetChanged(page == 0, 0, false)

                                    override fun onNext(aVoid: Void?) =
                                            notifyDataSetChanged(page == 0, list_data.size, false)
                                })
                    }

                }
            }
            Msg.Html -> {
                if (mRequestUtils.isDataFail(status)) {
                    return
                }
                if (mobject != null) {
                    var mHtml = (mobject as Html)
                    if (mHtml != null && mHtml.data != null && mHtml.data.content != null) {
                        listData.indices
                                .filter { listData[it]?.group_id == mHtml?.data?.group_id }
                                .forEach { listData[it].html = mHtml?.data?.content }
                    }
                }
            }
            else -> {
                super.onNotifyData(status, type, mobject)
            }
        }
    }


    override fun onRefresh() {
        if(lsitRefreshingListener!=null&&!lsitRefreshingListener.isEmpty()){
            for(i in lsitRefreshingListener.indices){
                lsitRefreshingListener[i].onRefreshing(true)
            }
        }
        isRefresh=true
        if (isSoonVideo) {
            mSoonVideoAdapter.list_viewholder.clear()
        }
        refresh_behot_time = (System.currentTimeMillis() / 1000).toString()
        mRequestUtils.requestNewsList(isRefresh, refresh_idx, mMyRecyclerViewUtils.limit, if (isSoonVideo) listDataSoonVideo.size else listData.size, category, refresh_behot_time)
    }

    override fun onLoadMore() {
        isRefresh=false
        load_behot_time = (System.currentTimeMillis() / 1000).toString()
        mRequestUtils.requestNewsList(isRefresh, 0, mMyRecyclerViewUtils.limit, if (isSoonVideo) listDataSoonVideo.size else listData.size, category, load_behot_time)
    }

    override fun onDestroy() {
        super.onDestroy()
        lsitRefreshingListener.clear()
        GSYVideoManager.releaseAllVideos()
    }

}