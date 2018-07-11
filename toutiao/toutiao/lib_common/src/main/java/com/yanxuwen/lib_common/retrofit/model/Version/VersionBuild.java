package com.yanxuwen.lib_common.retrofit.model.Version;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;


/**
 * 作者：严旭文 on 2016/7/4 17:28
 * 邮箱：420255048@qq.com
 */
public class VersionBuild  extends MyBaseRequest {
    public VersionBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public int platform;
    public String channel;
    public String version;
}
