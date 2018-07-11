package com.yanxuwen.lib_common.Base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yanxuwen.Base.MFragment;
import com.yanxuwen.Base.MStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxuwen on 2018/4/9.
 * 用阿里路由解析Fragemnt
 */

public class MyStatePagerAdapter extends MStatePagerAdapter {
    private List<String> list_fragment;
    public MyStatePagerAdapter(FragmentManager fm, List<String> list_fragment, List<String> list_title) {
        super(fm);
        this.list_fragment=list_fragment;
        this.list_title=list_title;
        listFragment=new ArrayList<>();
    }
    public Fragment getItem(int position) {
        if(listFragment!=null&&listFragment.size()>position&&listFragment.get(position)!=null){
            return listFragment.get(position);
        }
        try {

            if(listFragment.size()==position){

                Fragment fragment= (Fragment) ARouter.getInstance().build(list_fragment.get(position)).navigation();
                if(fragment instanceof MFragment){
                    ((MFragment)fragment).setBundlePosition(position);
                }
                listFragment.add(fragment);
                return listFragment.get(position);

            }else if(listFragment.size()>position){

                if(listFragment.get(position)==null){
                    listFragment.set(position,(Fragment) ARouter.getInstance().build(list_fragment.get(position)).navigation());
                    if(listFragment.get(position) instanceof MFragment){
                        ((MFragment)listFragment.get(position)).setBundlePosition(position);
                    }
                }
                return listFragment.get(position);
            }else{
                for(int i=listFragment.size();i<position;i++){
                    listFragment.add(null);
                }
                Fragment fragment= (Fragment) ARouter.getInstance().build(list_fragment.get(position)).navigation();
                if(fragment instanceof MFragment){
                    ((MFragment)fragment).setBundlePosition(position);
                }
                listFragment.add(fragment);
                return listFragment.get(position);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public int getCount() {
        return list_fragment.size();
    }
}
