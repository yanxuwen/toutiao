package com.yanxuwen.module_bottomtab0.debug

import android.content.res.Configuration
import android.os.Bundle
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Bean.Value
import com.yanxuwen.module_bottomtab0.Main.BottomTab0Fragment
import com.yanxuwen.module_bottomtab0.R

/**
 * Created by yanxuwen on 2018/4/9.
 */
class MainActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {

        setContentView(R.layout.bt0_main)
        super.onCreate(savedInstanceState)
        setStatusFull(true)
        setSlideable(false)

    }
    override fun initData() = Unit

    override fun initView(status: Value.ObservableStatus?) = initFragment()
    var f1: BottomTab0Fragment?=null
    private fun initFragment(){
        var transaction = supportFragmentManager.beginTransaction()
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(f1 == null){
            f1 = BottomTab0Fragment::class.java.newInstance()
            transaction.add(R.id.frameLayout_main, f1)
        }
        f1?.execute_setUserVisibleHint=true
        //显示需要显示的fragment
        transaction.show(f1)

        transaction.commitAllowingStateLoss()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }
}