package com.example.app.myapplication.Activity.Guide;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.app.myapplication.R;
import com.yanxuwen.myutils.Utils.ViewPagerScroller;
import com.yanxuwen.sliding.PageFragment;
import com.yanxuwen.sliding.SimplePagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：严旭文 on 2016/6/20 10:30
 * 邮箱：420255048@qq.com
 */
public class CustomPresentationPagerFragment  extends SimplePagerFragment {
    public List<Integer> list;
    public void onViewCreated(View view, Bundle savedInstanceState) {
        list=new ArrayList<>();
//        list.add(R.mipmap.guide_1);
//        list.add(R.mipmap.guide_2);
//        list.add(R.mipmap.guide_3);
//        list.add(R.mipmap.guide_4);
        super.onViewCreated(view, savedInstanceState);
        getSkipButton().setVisibility(View.GONE);
        getSeparator().setVisibility(View.GONE);
        setOnIsCirculate(false);
        setScrollfinish(false);
        setOnPlayTime(3000);
        setCarousel(true);
        getPagerIndicator().setFillColor(getActivity().getResources().getColor(R.color.common_blue));
        getPagerIndicator().setPageColor(getActivity().getResources().getColor(R.color.common_gray));

        //设在滚动速度
        ViewPagerScroller scroller = new ViewPagerScroller(getActivity());
        scroller.setScrollDuration(1500);
        scroller.initViewPagerScroll(getViewPager());//这个是设置切换过渡时间为0.8秒
    }
    @Override
    protected int getPagesCount() {
        return list.size();
    }

    @Override
    protected PageFragment getPage(int position) {
        return  FirstCustomPageFragment.newInstance(list.get(position),position==list.size()-1);
    }
    @Override
    protected boolean onSkipButtonClicked(View skipButton) {
        Toast.makeText(getContext(), "Skip button clicked", Toast.LENGTH_SHORT).show();
        return true;
    }
}
