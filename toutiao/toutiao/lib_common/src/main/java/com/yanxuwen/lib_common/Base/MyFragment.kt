package com.yanxuwen.lib_common.Base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import com.yanxuwen.Base.MFragment
import com.yanxuwen.lib_common.BaseApplication
import com.yanxuwen.lib_common.Bean.LogType
import com.yanxuwen.lib_common.Utils.RequestUtils
import com.yanxuwen.lib_common.retrofit.MyObserverListener
import com.yanxuwen.myutils.Utils.LogUtils
import com.yanxuwen.retrofit.Msg.ObserverListener
import com.yanxuwen.retrofit.Msg.Publisher


/**
 * Created by yanxuwen on 2018/1/22.
 */
open class MyFragment : MFragment , MyObserverListener {
    constructor():super(0){}
    constructor(position :Int):super(position){}
    open val mRequestUtils: RequestUtils by lazy {
        RequestUtils(activity, this)
    }
    private val mPublisher: Publisher by lazy {
        Publisher()
    }

    /**登录操作*/
    open fun initLogin() = Unit
    @CallSuper
    override fun init() = super.init()
    @CallSuper
    override fun initView() {
        super.initView()
        LogUtils.e(LogType.INIT, "初始化" + javaClass.name)
    }
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        //添加观察者
        mPublisher.setOb(this)
        super.onCreate(savedInstanceState)
    }
    @CallSuper
    override fun onDestroy() {
        mPublisher.removeOb()
        super.onDestroy()
        //监控 refWatcher 泄漏
        var refWatcher= BaseApplication.getRefWatcher(context)
        refWatcher.watch(this)
    }


    fun onFanhui() {}
    fun onStartActivity(intent: Intent) = (activity as BaseActivity).onStartActivity(intent)

    fun onStartActivity(intent: Intent, options: Bundle?) =
            (activity as BaseActivity).onStartActivity(intent, options)

    fun onStartActivityForResult(intent: Intent, code: Int) =
            (activity as BaseActivity).onStartActivityForResult(intent, code)

    fun onStartActivityForResult(intent: Intent, code: Int, options: Bundle?) =
            (activity as BaseActivity).onStartActivityForResult(intent, code, options)

    override fun onNotifyData(status: ObserverListener.STATUS, type: String, mobject: Any) = Unit

 }
