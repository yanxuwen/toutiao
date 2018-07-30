package com.yanxuwen.module_bottomtab1.Main

import android.content.Context
import android.content.Intent
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.yanxuwen.Base.MStatePagerAdapter
import com.yanxuwen.lib_common.Base.MyFragment
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.Fragment.TopTabRecommendFragment
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.model.CategoryVideo.CategoryVideo
import com.yanxuwen.lib_common.retrofit.model.SearchSuggest.SearchSuggest
import com.yanxuwen.lib_common.widget.titles.ScaleClipPagerTitleView
import com.yanxuwen.module_bottomtab1.R
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.bt1_.view.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import java.util.*
@Route(path = ARouterPath.Module_Bottomtab1_BottomTab1Fragment)
class BottomTab1Fragment : MyFragment(), View.OnClickListener, ViewPager.OnPageChangeListener {
    var list_category: List<CategoryVideo.DataBean>?=null

    private val dm: DisplayMetrics by lazy {
        activity.resources.displayMetrics
    }
    private lateinit var mMPagerAdapter: MStatePagerAdapter
    private val list_title = ArrayList<String>()
    override fun getMainView(): View? {
        if (mainview == null) {
            mainview = inflater.inflate(R.layout.bt1_, null)
        }
        return mainview
    }

    override fun initView() {
        super.initView()
        if(list_category!=null&& !list_category?.isEmpty()!!){
            list_category?.indices!!.mapTo(list_title) { list_category?.get(it)?.name?:"" }
        }else {
            if (list_title.isEmpty()) {
                list_title.addAll(context.resources.getStringArray(R.array.bt1_channel).toList())
            }
        }
        initViewPage()
//        flayout?.appBarLayout?.postDelayed({
//            flayout?.appBarLayout?.elevation = context.resources.getDimension(R.dimen.DIMEN_2DP)
//        }, 111)
    }

    override fun init() {
        super.init()
        //用于从其他页面切换回来的时候，重新加载该viewpage的当前项
        var currentItem = flayout?.viewPager?.currentItem ?: 1
        if (mMPagerAdapter != null && mMPagerAdapter.count > currentItem) {
            var mMyFragment: MyFragment = (mMPagerAdapter.getItem(currentItem) as MyFragment) ?: return
            if (mMyFragment?.isInit) {
                mMyFragment.init()
            }
        }
    }

    private fun initViewPage() {
        flayout?.viewPager?.removeAllViewsInLayout()
        initMagicIndicator()
        val listfragment = ArrayList<Class<*>>()
        for (i in list_title.indices) {
            listfragment.add(TopTabRecommendFragment::class.java)
        }
        mMPagerAdapter = MStatePagerAdapter(childFragmentManager, listfragment, list_title)
        flayout?.viewPager?.adapter = mMPagerAdapter
        flayout?.viewPager?.offscreenPageLimit = 3
        flayout?.viewPager?.noScroll = false
        var position: Int = 1
        flayout?.viewPager?.addOnPageChangeListener(this)
        flayout?.viewPager?.currentItem = position
        if(position==0){
            onPageSelected(position)
        }
    }

    fun initMagicIndicator() {
        val commonNavigator = CommonNavigator(context)
        commonNavigator.isSkimOver = true
        commonNavigator.scrollPivotX = 0.65f
        commonNavigator.isFollowTouch=false
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int = list_title.size

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val clipPagerTitleView = ScaleClipPagerTitleView(context)
                clipPagerTitleView.text = list_title[index]
                clipPagerTitleView.textSize = UIUtil.dip2px(context, 19.1).toFloat()
                clipPagerTitleView.setBackgroundDrawable(context.resources.getDrawable(R.drawable.common_selector_ripple))
                clipPagerTitleView.textColor = context.resources.getColor(R.color.common_black)
                clipPagerTitleView.clipColor = context.resources.getColor(R.color.bt1_tab)
                clipPagerTitleView.setOnClickListener { flayout?.viewPager?.currentItem = index }
                return clipPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator? = null
        }
        flayout?.magic_indicator?.navigator = commonNavigator
        ViewPagerHelper.bind(flayout?.magic_indicator, flayout?.viewPager)
    }

    override fun onPageScrollStateChanged(state: Int) = Unit

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) =
            Unit

    override fun onPageSelected(position: Int) {
//        flayout?.appBarLayout?.setExpanded(true)
        var category = if(list_category!=null&&!list_category?.isEmpty()!!){
            list_category?.get(position)?.category?:""
        }else {
            context.resources.getStringArray(R.array.bt1_channel_code)[position]
        }
        (mMPagerAdapter.getItem(position) as TopTabRecommendFragment).category= category
        mRequestUtils.requestSearchSuggest(category)

    }

    override fun onNotifyData(status: ObserverListener.STATUS, type: String, mobject: Any) {
        when (type) {
            Msg.SearchSuggest -> {
                if (mRequestUtils.isDataFail(status)) {
                    return
                }
                if (mobject != null) {
                    var mSearchSuggest = (mobject as SearchSuggest)
                    if (mSearchSuggest != null && mSearchSuggest.data != null) {
                        flayout?.tv_SearchSuggest?.setText(mSearchSuggest.data .homepage_search_suggest)
                    }

                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        (mMPagerAdapter.getItem(flayout?.viewPager?.currentItem ?: 1) as MyFragment).onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        super.onDestroy()
        list_title.clear()
    }

}