package com.yanxuwen.lib_common.Fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
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
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.optionsRound
import com.yanxuwen.lib_common.Utils.MyGsonUtils
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.video.VideoInfoUtils
import com.yanxuwen.lib_common.Utils.video.VideoListUtils
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.model.Article.Article
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsList
import com.yanxuwen.lib_common.retrofit.model.NewsList.SoonVideo
import com.yanxuwen.lib_common.widget.Drawer.CommentDragLayout
import com.yanxuwen.lib_common.widget.Drawer.ReplyDragLayout
import com.yanxuwen.lib_common.Base.Key.VideoKey
import com.yanxuwen.retrofit.GsonUtils
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.common_activity_recyclerview.view.*
import kotlinx.android.synthetic.main.common_atlases.view.*
import kotlinx.android.synthetic.main.common_comment_menu.view.*
import kotlinx.android.synthetic.main.common_drag_comments.view.*
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
 * 推荐列表
 */
class TopTabRecommendFragment : MyFragment(), MyRecyclerView.LoadingListener {
    public val refreshLayout: MySwipeRefreshLayout by lazy {
        flayout?.refreshLayout!!
    }
     interface OnRefreshingListener{
        fun onRefreshing(refreshing: Boolean)
    }
        fun addOnRefreshingListener(l:OnRefreshingListener){
            if(lsitRefreshingListener==null)lsitRefreshingListener=ArrayList()
            if(!lsitRefreshingListener?.contains(l)!!){
                lsitRefreshingListener?.add(l)
            }
        }
    companion object {
        var  lsitRefreshingListener:ArrayList<OnRefreshingListener>  ?=null
        fun removeOnRefreshingListener(){
            lsitRefreshingListener?.clear()
            lsitRefreshingListener=null
        }
    }
    fun removeOnRefreshingListener(l:OnRefreshingListener){
        lsitRefreshingListener?.remove(l)
    }
    var isRefresh=false
    var isSoonVideo = false
    var page = 0
    var refresh_idx = 1
    var refresh_behot_time = ""
    var load_behot_time = ""
    var category: String = ""
    var list_Data: ArrayList<NewsContent> = ArrayList()
    var listDataSoonVideo: ArrayList<Any> = ArrayList()
    var listSoonVideoFragment: ArrayList<Class<*>> = ArrayList()

    val mAdapter: NewsListAdapter by lazy {
        NewsListAdapter(context, list_Data, mRequestUtils)
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
                DragViewActivity.startActivity(activity, position,object : DragViewActivity.OnDataListener{
                    override fun init() {
                    }

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
                        var mFragment=DragViewActivity.getInstance(context).mMPagerAdapter.getItem(DragViewActivity.getInstance(context).currentPosition) as SoonVideoFragment
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
             //直播
                mAdapter.ViewTypeLive -> {
                    //横屏直播
                    if(list_Data[position].raw_data?.live_info?.orientation==1){
                        MyARouter.getInstance().build(ARouterPath.Module_Bottomtab1_LiveActiviy)
                                .withSerializable(VideoKey.NewsContent, list_Data[position])
                                .navigation(context)
                    }
                    //竖屏直播
                    else if(list_Data[position].raw_data?.live_info?.orientation==0){
                        MyARouter.getInstance().build(ARouterPath.Module_Bottomtab1_LiveActiviy2)
                                .withSerializable(VideoKey.NewsContent, list_Data[position])
                                .navigation(context)
                    }

                }
            //视频
                mAdapter.ViewTypeVideo -> {
                    MyARouter.getInstance().build(ARouterPath.Module_Bottomtab0_VideoActiviy)
                            .withSerializable(VideoKey.NewsContent, list_Data[position])
                            .withLong(VideoKey.seek, (holder as NewsListAdapter.ViewHolder)?.itemView?.layout_player?.currentPositionWhenPlaying?.toLong() ?: 0)
                            .navigation(context)
                }
            //新闻,图片，图集
                mAdapter.ViewTypeImage, mAdapter.ViewTypeWords -> {
                    when(mAdapter.getItemViewType(position)){
                        //图集
                        mAdapter.type_image,mAdapter.type_image2->{
                            var listimage=ArrayList<Any>()
                            var listFragment: java.util.ArrayList<Class<*>> = java.util.ArrayList()
                            var data=list_Data[position].article
                            if(data==null||data.data==null||data.data.gallery==null)return@setOnItemClickListener
                            for(i in data.data.gallery.indices){
                                listimage.add(data?.data.gallery?.get(i)?.sub_image?.url?:"")
                                listFragment.add(AtlasesFragment::class.java)
                            }
                            //展开放大图片
                            DragViewActivity.startActivity(activity, 0,object : DragViewActivity.OnDataListener{
                                override fun init() {
                                    if(view_atlases==null){
                                        view_atlases=inflater.inflate(R.layout.common_atlases,null)
                                        DragViewActivity.getInstance(context).dragViewLayout.addView(view_atlases)
                                        Glide.with(context).load(data?.data?.h5_extra?.media?.avatar_url?:"").transition(DrawableTransitionOptions.withCrossFade()).apply(optionsRound).into(view_atlases?.iv_atlases_head!!)
                                        view_atlases?.tv_atlases_author?.text=data?.data?.h5_extra?.media?.name
                                        var comment_count= VideoInfoUtils().setCount(context,list_Data[position].comment_count)
                                        if(comment_count=="0"){
                                            view_atlases?.tv_comment_count?.visibility=View.GONE
                                        }else{
                                            view_atlases?.tv_comment_count?.visibility=View.VISIBLE
                                            view_atlases?.tv_comment_count?.text=comment_count.toString()

                                        }
                                        //找不到粉丝的数量哪里取，先随便取
                                        view_atlases?.tv_atlases_fans?.text= VideoInfoUtils().setFansCount(context, 542123)
                                        view_atlases?.tv_comment_icon?.setOnClickListener({
                                            if(comment_count=="0")return@setOnClickListener
                                            (view_atlases?.common_drag_comments as CommentDragLayout).item_id = data.data?.item_id.toString()
                                            (view_atlases?.common_drag_comments as CommentDragLayout)?.open()
                                        })

                                        DragViewActivity.getInstance(context).setOnDrawerOffsetListener { offset ->
                                            view_atlases?.layout_atlases_head?.alpha=offset-0.3f
                                            view_atlases?.layout_bottom?.alpha=offset-0.3f

                                        }
                                    }
                                }

                                var view_atlases:View?=null
                                override fun getListData(): java.util.ArrayList<Any> =
                                        listimage
                                override fun onBackPressed(): Boolean =
                                        when {
                                        //如过回复评论开着，则拦截DragViewActivity的onBackPressed
                                            (view_atlases?.common_drag_comments?.common_drag_reply as ReplyDragLayout).isOpen -> {
                                                (view_atlases?.common_drag_comments?.common_drag_reply as ReplyDragLayout).close()
                                                false
                                            }
                                        //如过评论开着，则拦截DragViewActivity的onBackPressed
                                            (view_atlases?.common_drag_comments as CommentDragLayout).isOpen -> {
                                                (view_atlases?.common_drag_comments as CommentDragLayout).close()
                                                false
                                            }
                                            else -> true
                                        }

                                override fun getListView(): java.util.ArrayList<View>?  = null

                                override fun getListFragmentClass(): java.util.ArrayList<Class<*>> = listFragment

                                override fun onPageSelected(selectedposition: Int) {
                                    view_atlases?.tv_atlases_content?.text=(selectedposition+1).toString()+"/"+data.data.gallery.size+" "+ data.data.gallery[selectedposition].sub_abstract
                                }
                            })
                        }
                        //图片或者新闻
                        else ->{
                            MyARouter.getInstance().build(ARouterPath.Module_Bottomtab0_NewActiviy)
                                    .withSerializable(VideoKey.Article, list_Data[position].article)
                                    .navigation(context)
                        }

                    }

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
                if(lsitRefreshingListener!=null&& lsitRefreshingListener?.isEmpty() == false){
                    for(i in lsitRefreshingListener?.indices!!){
                        lsitRefreshingListener?.get(i)?.onRefreshing(false)
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
                            list_Data.clear()
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
                                DragViewActivity.getInstance(context)?.notifyDataSetChanged()
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
                                    //如果是直播，则要过滤user_auth_info，这样写法写死，不提倡
                                    if(json.contains("live_info")){

                                        mNewsContent =  MyGsonUtils.fromJson(jsonObject.toString(), NewsContent::class.java,"user_auth_info") as NewsContent
                                    }else{
                                        mNewsContent = GsonUtils.fromJson(jsonObject.toString(), NewsContent::class.java) as NewsContent
                                    }
                                } catch (e: Exception) {
                                    Log.e("xxx",""+e.message)
                                }
                                //tag_id代表暂时没有设定这个类型，但是直播除外
                                if (mNewsContent?.tag_id == 0L && !json.contains("live_info")) {
                                    continue
                                }
                                list_Data.add(mNewsContent!!)
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
            Msg.Article -> {
                if (mRequestUtils.isDataFail(status)) {
                    return
                }
                if (mobject != null) {
                    var mArticle = (mobject as Article)
                    if (mArticle != null && mArticle.data != null && mArticle.data.content != null) {
                        list_Data.indices
                                .filter { list_Data[it]?.group_id == mArticle?.data?.group_id }
                                .forEach { list_Data[it].article = mArticle }
                    }
                }
            }
            else -> {
                super.onNotifyData(status, type, mobject)
            }
        }
    }


    override fun onRefresh() {
        if(lsitRefreshingListener!=null&& lsitRefreshingListener?.isEmpty() == false){
            for(i in lsitRefreshingListener?.indices!!){
                lsitRefreshingListener?.get(i)?.onRefreshing(true)
            }
        }
        isRefresh=true
        if (isSoonVideo) {
            mSoonVideoAdapter.list_viewholder.clear()
        }
        refresh_behot_time = (System.currentTimeMillis() / 1000).toString()
        mRequestUtils.requestNewsList(isRefresh, refresh_idx, mMyRecyclerViewUtils.limit, if (isSoonVideo) listDataSoonVideo.size else list_Data.size, category, refresh_behot_time)
    }

    override fun onLoadMore() {
        isRefresh=false
        load_behot_time = (System.currentTimeMillis() / 1000).toString()
        mRequestUtils.requestNewsList(isRefresh, 0, mMyRecyclerViewUtils.limit, if (isSoonVideo) listDataSoonVideo.size else list_Data.size, category, load_behot_time)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(lsitRefreshingListener!=null&& lsitRefreshingListener?.isEmpty() == false){
            for(i in lsitRefreshingListener?.indices!!){
                lsitRefreshingListener?.get(i)?.onRefreshing(false)
            }
        }
        GSYVideoManager.releaseAllVideos()
    }

}