package com.yanxuwen.lib_common.Utils.video

import android.content.Context
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.TimeUtils
import java.text.DecimalFormat

/**
 * Created by yanxuwen on 2018/5/25.
 */
public class VideoInfoUtils{
    var df = DecimalFormat("#.0")
    /**多少播放*/
    fun setPlayCount(context:Context,video_watch_count:Long):String =
            String.format(context.resources.getString(R.string.common_play_count),if(video_watch_count/10000>0) String.format(context.resources.getString(R.string.common_wan,df.format(video_watch_count.toFloat()/10000))) else  video_watch_count)
    /**多少赞*/
    fun setDiggCount(context:Context,digg_count:Long):String =
            String.format(context.resources.getString(R.string.common_digg_count),if(digg_count/10000>0) String.format(context.resources.getString(R.string.common_wan,df.format(digg_count.toFloat()/10000))) else  digg_count)
    /**多少粉丝*/
    fun setFansCount(context:Context,fans_count:Long):String =
            String.format(context.resources.getString(R.string.common_fans_count),if(fans_count/10000>0) String.format(context.resources.getString(R.string.common_wan,df.format(fans_count.toFloat()/10000))) else  fans_count)
    /**多少*/
    fun setCount(context:Context,count:Long):String =
            if(count/10000>0) String.format(context.resources.getString(R.string.common_wan,df.format(count.toFloat()/10000))) else  count.toString()
    /**发布时间*/
    fun setPublishTime(context:Context,publish_time:Long): String =    String.format(context.resources.getString(R.string.common_publish_time), TimeUtils.getStrTime((publish_time*1000).toString(),"yyyy年MM月dd日"))
}