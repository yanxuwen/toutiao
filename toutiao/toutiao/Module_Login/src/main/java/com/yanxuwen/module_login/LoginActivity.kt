package com.yanxuwen.module_login

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.Bean.Value

/**
 * Created by yanxuwen on 2018/4/9.
 */

@Route(path= ARouterPath.Module_Login_LoginActivity)
class LoginActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.login_main)
        super.onCreate(savedInstanceState)
    }
    override fun initData() = Unit

    override fun initView(status: Value.ObservableStatus?)=Unit
}