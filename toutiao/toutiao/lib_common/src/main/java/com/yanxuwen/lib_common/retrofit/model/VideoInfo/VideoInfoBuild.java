package com.yanxuwen.lib_common.retrofit.model.VideoInfo;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("视频信息")
public class VideoInfoBuild extends MyBaseRequest {
    public VideoInfoBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private String video_id;
    private String item_id;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }
}
