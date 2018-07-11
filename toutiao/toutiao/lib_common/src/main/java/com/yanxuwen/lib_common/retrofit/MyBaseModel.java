package com.yanxuwen.lib_common.retrofit;

import com.yanxuwen.retrofit.BaseModel;

/**
 * Created by bbxpc on 2016/3/11.
 * 最基本的，每个接口都需要用到的，
 */
public class MyBaseModel extends BaseModel {
    /**判断是否是刷新*/
    private boolean isRefresh;
    /**
     * error : TheUsernameFieldIsRequired
     */

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
}
