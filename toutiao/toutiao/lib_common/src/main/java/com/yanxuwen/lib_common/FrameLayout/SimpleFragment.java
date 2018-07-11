package com.yanxuwen.lib_common.FrameLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yanxuwen.lib_common.Bean.Extra.fragment.SimpleFragmentMsg;
import com.yanxuwen.lib_common.Bean.Value;
import com.yanxuwen.lib_common.FrameLayout.Base.BaseFragment;
import com.yanxuwen.lib_common.R;
import com.yanxuwen.lib_common.R2;
import com.yanxuwen.lib_common.retrofit.Msg.Msg;
import com.yanxuwen.myutils.Utils.ToastUtil;
import com.yanxuwen.retrofit.Msg.ObserverListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：严旭文 on 2016/5/25 15:26
 * 邮箱：420255048@qq.com
 */
public class SimpleFragment extends BaseFragment {
    @BindView(R2.id.iv_icon)
    ImageView ivIcon;
    @BindView(R2.id.layout_simple)
    RelativeLayout layoutSimple;
    @BindView(R2.id.btn_finish)
    Button btnFinish;
    @BindView(R2.id.btn_finish2)
    Button btnFinish2;
    @BindView(R2.id.btn_jump)
    Button btnJump;
    @BindView(R2.id.btn_jump2)
    Button btnJump2;
    @BindView(R2.id.tv_msg)
    TextView tvMsg;
    int backcolor;
    @BindView(R2.id.btn_net)
    Button btnNet;
    @BindView(R2.id.tv_result)
    TextView tvResult;
    @Override
    public void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.common_simple_fragment);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Value.ObservableStatus status) {
        backcolor = getArguments().getInt(SimpleFragmentMsg.color);
        if(backcolor!=0){
            //注意这里只是测试，设置标题跟不设置标题，，通常情况标题最好放在onCreateView
            setTitle("SimpleFragment");
            layoutSimple.setBackgroundColor(activity.getResources().getColor(backcolor));
        }

    }

    @OnClick({R2.id.iv_icon,R2.id.btn_jump,R2.id.btn_jump2,R2.id.btn_finish,R2.id.btn_finish2,R2.id.btn_net})
    public void onClick(View v) {
        super.onClick(v);
        if(!isClick()){
            return;
        }
        SimpleFragment mSimpleFragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt(SimpleFragmentMsg.color, R.color.common_colorPrimary);
        mSimpleFragment.setArguments(args);
        switch (v.getId()) {
            case R2.id.btn_jump:
                onStartFragemnt(mSimpleFragment,v);
                break;
            case R2.id.btn_jump2:
                onStartFragemntForResult(mSimpleFragment, v,Value.requestCode2);
                break;
            case R2.id.btn_finish:
                onBackPressed();
                break;
            case R2.id.btn_finish2:
                if(backcolor==R.color.common_colorPrimary){
                    args.putString("test","我是从fragment返回到fragment的");
                }else{
                    args.putString("test","我是从fragment返回到Activity的");
                }
                onBackPressed(Value.resultCode,args);
                break;
            case R2.id.iv_icon:
                activity.onStartFragmentMain();
                break;
            case R2.id.btn_net:
                mRequestUtils.requestToken();
                break;
            default:
                break;
        }
    }
    public void onFragmentResult(int requestCode, int resultCode, Intent data){
        super.onFragmentResult(requestCode, resultCode, data);
        if(Value.requestCode2==requestCode&&Value.resultCode==resultCode){
            if(data!=null&&data.getExtras()!=null) {
                Bundle args=data.getExtras();
                tvMsg.setVisibility(View.VISIBLE);
                tvMsg.setText(args.getString("test"));
            }
        }

    }
    /**
     * 请求数据返回结果
     * @param status 请求成功还是失败
     * @param type
     * @param object 类型
     */
    public void onNotifyData(ObserverListener.STATUS status, String type, Object object){
        if(status== ObserverListener.STATUS.FAIL){
            ToastUtil.showToast(activity, "失败");
            return;
        }
        switch(type){
            case Msg.TOKEN:
                ToastUtil.showToast(activity, "成功");
                tvResult.setText((String)object);
                return;
            default:break;
        }
        super.onNotifyData(status,type,object);
    }
}
