package com.yanxuwen.lib_common.retrofit.model.NewsList;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/4/26.
 */
@Description("新闻列表")
public class NewsListBuild extends MyBaseRequest {
    public NewsListBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private int refresh_reason;//1为刷新，加载不传
    private int session_refresh_idx;//刷新次数，加载不传
    private int count;//数量
    private int list_count;//当前列表数量
    private String category;//类别
    private String max_behot_time;//加载的上次时间，刷新不传
    private String min_behot_time;//刷新的上次时间，加载不传
    private String tt_from;//pre_load_more加载，pull刷新

    public int getRefresh_reason() {
        return refresh_reason;
    }

    public void setRefresh_reason(int refresh_reason) {
        this.refresh_reason = refresh_reason;
    }

    public int getSession_refresh_idx() {
        return session_refresh_idx;
    }

    public void setSession_refresh_idx(int session_refresh_idx) {
        this.session_refresh_idx = session_refresh_idx;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getList_count() {
        return list_count;
    }

    public void setList_count(int list_count) {
        this.list_count = list_count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMax_behot_time() {
        return max_behot_time;
    }

    public void setMax_behot_time(String max_behot_time) {
        this.max_behot_time = max_behot_time;
    }

    public String getMin_behot_time() {
        return min_behot_time;
    }

    public void setMin_behot_time(String min_behot_time) {
        this.min_behot_time = min_behot_time;
    }

    public String getTt_from() {
        return tt_from;
    }

    public void setTt_from(String tt_from) {
        this.tt_from = tt_from;
    }
}