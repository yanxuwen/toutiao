package com.yanxuwen.lib_common.retrofit.model.ReplyList;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/5/30.
 */
@Description("回复列表")
public class ReplyListBuild extends MyBaseRequest {
    public ReplyListBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private String id;
    private int offset;
    private int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
