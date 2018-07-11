package com.example.app.myapplication.Activity.Guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.app.myapplication.Activity.Main.MainActivity;
import com.example.app.myapplication.Bean.ShareKey;
import com.example.app.myapplication.R;
import com.yanxuwen.myutils.Utils.SPUtils;
import com.yanxuwen.sliding.PageFragment;
import com.yanxuwen.sliding.TransformItem;


public class FirstCustomPageFragment extends PageFragment {
	public int id;
	public boolean islast;
	public static final FirstCustomPageFragment newInstance(int id, boolean islast){
		FirstCustomPageFragment fragment =new FirstCustomPageFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("id",id);
		bundle.putBoolean("islast", islast);
		fragment.setArguments(bundle);
		return fragment ;
	}
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		id=getArguments().getInt("id");
		islast=getArguments().getBoolean("islast");


	}
	@Override
	protected int getLayoutResId() {
		return R.layout.fragment_page_first;
	}

	@Override
	protected void initView() {
		if(view!=null){
			RelativeLayout	layout_guide=(RelativeLayout)view.findViewById(R.id.layout_guide);
			layout_guide.setBackgroundDrawable(getActivity().getResources().getDrawable(id));
			if(islast){
				Button btn_experience = (Button) view.findViewById(R.id.btn_experience);
				btn_experience.setVisibility(View.VISIBLE);
				btn_experience.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						final GuideActivity activity=(GuideActivity)getActivity();
						//存储数据
						SPUtils.put(activity, ShareKey.isFirstIn, false);
						// 跳转
						Intent intent = new Intent(activity, MainActivity.class);
						activity.onStartActivityFinish(intent);

					}
				});
			}
		}

	}

	@Override
	protected TransformItem[] provideTransformItems(){
		return new TransformItem[0];
	}
}
