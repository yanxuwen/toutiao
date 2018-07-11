package com.yanxuwen.lib_common.retrofit.model.Comment;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/5/29.
 */
@Description("评论")
public class CommentBuild extends MyBaseRequest {
    public CommentBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private String group_id;
    private String item_id;
    private int offset;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }
}
