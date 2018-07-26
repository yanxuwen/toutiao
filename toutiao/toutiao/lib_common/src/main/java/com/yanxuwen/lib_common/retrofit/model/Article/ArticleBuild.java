package com.yanxuwen.lib_common.retrofit.model.Article;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/6/6.
 */
@Description("获取html代码片段")
public class ArticleBuild extends MyBaseRequest {
    public ArticleBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
