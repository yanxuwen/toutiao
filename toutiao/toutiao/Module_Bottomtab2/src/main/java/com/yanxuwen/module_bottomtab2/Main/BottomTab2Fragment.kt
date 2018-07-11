package com.yanxuwen.module_bottomtab3.Main

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.yanxuwen.lib_common.Base.MyFragment
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.module_bottomtab2.R
import com.yanxuwen.retrofit.Msg.ObserverListener


/**
 * Created by yanxuwen on 2017/9/7.
 */
@Route(path = ARouterPath.Module_Bottomtab2_BottomTab2Fragment)
    class BottomTab2Fragment : MyFragment() ,View.OnClickListener{
    override fun getMainView(): View? {
        if (mainview == null) {
            mainview = inflater.inflate(R.layout.bt2_, null)

        }
        return mainview
    }
    override fun init() {
        super.init()
    }

    override fun onNotifyData(status: ObserverListener.STATUS, type: String, mobject: Any) {
    }

    override fun onClick(v: View?) {

    }

}