package com.yanxuwen.module_bottomtab1.debug

import android.os.Bundle
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Bean.Value
import com.yanxuwen.module_bottomtab1.Main.BottomTab1Fragment
import com.yanxuwen.module_bottomtab1.R

/**
 * Created by yanxuwen on 2018/4/9.
 */
class MainActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.bt1_main)
        super.onCreate(savedInstanceState)
        setStatusFull(true)
        setSlideable(false)
    }
    override fun initData() = Unit
    override fun initView(status: Value.ObservableStatus?) = initFragment()
    var f1: BottomTab1Fragment?=null
    private fun initFragment(){
        var transaction = supportFragmentManager.beginTransaction()
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if(f1 == null){
            f1 = BottomTab1Fragment::class.java.newInstance()
            transaction.add(R.id.frameLayout_main, f1)
        }
        f1?.execute_setUserVisibleHint=true
        //显示需要显示的fragment
        transaction.show(f1)

        transaction.commitAllowingStateLoss()
    }
}