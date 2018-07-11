package com.yanxuwen.lib_common.retrofit.model.VideoRecommend;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/5/24.
 */
@Description("视频推荐")
public class VideoRecommendBuild  extends MyBaseRequest {
    public VideoRecommendBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private String video_id;
    private String group_id;
    private String item_id;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
