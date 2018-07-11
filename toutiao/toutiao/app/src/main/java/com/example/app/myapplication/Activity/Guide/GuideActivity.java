package com.example.app.myapplication.Activity.Guide;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yanxuwen.lib_common.Base.BaseActivity;
import com.yanxuwen.lib_common.Bean.ARouterPath;
import com.yanxuwen.lib_common.Bean.Value;

/**
 * 作者：严旭文 on 2016/6/20 10:26
 * 邮箱：420255048@qq.com
 */

@Route(path= ARouterPath.App_GuideActivity)
public class GuideActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
            isChangeText=true;
            setContentView(0);
            super.onCreate(savedInstanceState);
            setSlideable(false);
            if (savedInstanceState == null) {
                replaceTutorialFragment();
            }
        }
        @Override
        public void initData() {

        }

        @Override
        public void initView(Value.ObservableStatus status) {

        }
        public void replaceTutorialFragment() {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(android.R.id.content, new CustomPresentationPagerFragment());
        fragmentTransaction.commit();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            return true;

        }
        return false;
    }
}
