package com.yanxuwen.lib_common.retrofit;

import android.content.Context;

import com.yanxuwen.myutils.Utils.SystemUtil;
import com.yanxuwen.retrofit.BaseRequest;


/**
 * 作者：严旭文 on 2016/7/4 17:28
 * 邮箱：420255048@qq.com
 */
public class MyBaseRequest extends BaseRequest{
    public String access_token;
    public String uid;
    public String app_version;//版本
    public String device_type_phone;//设备类型
    public String app_type;//app类型


    public MyBaseRequest() {
        super();
    }

    public MyBaseRequest(Context context) {
        app_version=SystemUtil.getAppVersionName(context);
        device_type_phone= SystemUtil.getBrand();
        app_type="appType";
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getApp_Version() {
        return app_version;
    }

    public void setApp_Version(String app_version) {
        this.app_version = app_version;
    }
    public String getDevice_type_phone() {
        return device_type_phone;
    }

    public void setDevice_type_phone(String device_type_phone) {
        this.device_type_phone = device_type_phone;
    }
    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }
}
