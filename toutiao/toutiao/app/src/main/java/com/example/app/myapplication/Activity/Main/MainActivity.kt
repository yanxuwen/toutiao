package com.example.app.myapplication.Activity.Main

/**
 * Created by yanxuwen on 2017/9/6.
 */

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import android.view.animation.Animation
import android.widget.ImageView
import com.example.app.myapplication.R
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Base.MyFragment
import com.yanxuwen.lib_common.Base.MyPagerAdapter
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.Bean.Value
import com.yanxuwen.lib_common.Fragment.TopTabRecommendFragment
import com.yanxuwen.lib_common.retrofit.model.Category.Category
import com.yanxuwen.lib_common.retrofit.model.CategoryVideo.CategoryVideo
import com.yanxuwen.module_bottomtab0.Main.BottomTab0Fragment
import com.yanxuwen.module_bottomtab1.Main.BottomTab1Fragment
import com.yanxuwen.myutils.Utils.DateFormat
import com.yanxuwen.myutils.Utils.ToastUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


public class MainActivity : BaseActivity() , ViewPager.OnPageChangeListener,TopTabRecommendFragment.OnRefreshingListener {
     companion object {
           var dataBeenCategory: List<Category.DataBeanX.DataBean>?=null
           var dataBeenCategoryVideo: List<CategoryVideo.DataBean>?=null
     }

    var isRefresh=false
    var lastPosition=0
    private val list_title = ArrayList<String>()
    private val mMyPagerAdapter: MyPagerAdapter by lazy {
        val list_fragment=ArrayList<String>()
        for(i in 0 until list_title.size){
            when (i) {
                0 -> list_fragment.add(ARouterPath.Module_Bottomtab0_BottomTab0Fragment)
                1 -> list_fragment.add(ARouterPath.Module_Bottomtab1_BottomTab1Fragment)
                2 -> list_fragment.add(ARouterPath.Module_Bottomtab2_BottomTab2Fragment)
                3 -> list_fragment.add(ARouterPath.Module_Bottomtab3_BottomTab3Fragment)
                4 -> list_fragment.add(ARouterPath.Module_Bottomtab4_BottomTab4Fragment)
                else ->   list_fragment.add(ARouterPath.Module_Bottomtab0_BottomTab0Fragment)
            }
        }
        MyPagerAdapter(supportFragmentManager, list_fragment, list_title)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
//        title = "首页"
//        setAppBarLayoutChild(R.layout.tablayout)
        list_title.add(getString(R.string.menu_1))
        list_title.add(getString(R.string.menu_2))
        list_title.add(getString(R.string.menu_3))
        list_title.add(getString(R.string.menu_4))
//        list_title.add("5")
        viewpager.addOnPageChangeListener(this)
        viewpager.adapter = mMyPagerAdapter
        viewpager.offscreenPageLimit=4
        var position=0
        viewpager.currentItem = position
        if(position==0){
            onPageSelected(0)
        }
        var mFragment0=  mMyPagerAdapter.getItem(0)
        if(mFragment0 is BottomTab0Fragment){
            mFragment0.list_category= dataBeenCategory
        }
        var mFragment1=  mMyPagerAdapter.getItem(1)
        if(mFragment1 is BottomTab1Fragment){
            mFragment1.list_category= dataBeenCategoryVideo
        }
        viewpager.noScroll=true
        val image = intArrayOf(R.mipmap.tab_home_normal,
                R.mipmap.tab_video_normal,
                R.mipmap.tab_micro_normal,
                R.mipmap.tab_soonvideo_normal)
        val image2 = intArrayOf(R.mipmap.tab_home_selected,
                R.mipmap.tab_video_selected,
                R.mipmap.tab_micro_selected,
                R.mipmap.tab_soonvideo_selected)
        val color = intArrayOf(ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.white),
                ContextCompat.getColor(this, R.color.white),
//                ContextCompat.getColor(this, R.color.common_blue),
                ContextCompat.getColor(this, R.color.white))

        bottomNavigationView.setOnBottomNavigationItemClickListener {
            index ->
            onRefresh(lastPosition,false)
            lastPosition=index
        }
        //禁止viewpager切换动画
        bottomNavigationView.disableViewPagerSlide()
        bottomNavigationView.disableShadow()
        bottomNavigationView.setUpWithViewPager(viewpager , color , image,image2)
        super.onCreate(savedInstanceState)
        setStatusFull(true)
        setSlideable(false)
        TopTabRecommendFragment.addOnRefreshingListener(this)

    }
    override fun initData() {
    }
    override fun initView(status: Value.ObservableStatus?) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        (mMyPagerAdapter.getItem(viewpager.currentItem) as MyFragment).onActivityResult(requestCode,resultCode,data)

    }
    var animator :ObjectAnimator?= null
    var view:ImageView?=null
    fun onRefresh(index:Int,isBack: Boolean):Boolean{
        if(lastPosition==0&&lastPosition==index&&!isRefresh&&viewpager.currentItem==0){
            var mFragment=mMyPagerAdapter.getItem(viewpager.currentItem)
            if(mFragment is BottomTab0Fragment){
                var mTopTabRecommendFragment=  mFragment.mMPagerAdapter?.getItem(mFragment.viewpager.currentItem)
                if(mTopTabRecommendFragment is TopTabRecommendFragment){
                    isRefresh=true
                    if(!isBack) {
                         view = bottomNavigationView.getItemIcon(lastPosition)
                        view?.setImageResource(R.mipmap.tab_loading)
                         animator = ObjectAnimator.ofFloat(view, "rotation", 0f, (360*3).toFloat())
                        animator?.duration = 800*3
                        animator?.repeatCount = Animation.INFINITE
                        animator?.start()
                    }else{
                        animator=null
                    }
                    mTopTabRecommendFragment.refreshLayout.isRefreshing = true
                    return true
                }
            }

        }
        return false
    }
    override fun onRefreshing(refreshing: Boolean) {
        isRefresh = refreshing
        if (!refreshing) {
            animator?.cancel()
            view?.setImageResource(R.mipmap.tab_home_selected)
            view?.rotation = 0f
        }
    }

    override fun onDestroy() {
        bottomNavigationView?.selectTab(0)
        TopTabRecommendFragment.removeOnRefreshingListener(this)

        super.onDestroy()

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
    private var mkeyTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (GSYVideoManager.backFromWindowFull(this)) {

            }
            else if (DateFormat.getTime() - mkeyTime > 2000) {
                mkeyTime = DateFormat.getTime()
                ToastUtil.showToast(context, R.string.agin_exit)
                onRefresh(viewpager.currentItem,true)
            } else {
                finish()
            }
            return true

        }
        return false
    }
}
