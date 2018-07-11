package com.yanxuwen.lib_common.Utils.video

import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent
import com.yanxuwen.lib_common.retrofit.model.VideoRecommend.VideoRecommend

/**
 * Created by yanxuwen on 2018/7/10.
 */
public class TypeConver{
    companion object {
        fun  onVideoRecommendToNewContent(data: VideoRecommend.DataBean.RelatedVideoToutiaoBean): NewsContent{
            var mNewsContent=NewsContent()
            mNewsContent?.source=data?.source
            var mUserInfoBean= NewsContent.UserInfoBean()
            mUserInfoBean.avatar_url=data?.user_info?.avatar_url
            mUserInfoBean.description=data?.user_info?.description
            mUserInfoBean.isFollow = data?.user_info?.isFollow == true

            mUserInfoBean.name=data.user_info?.name
            mUserInfoBean.user_id=data?.user_info?.user_id?:0
            mUserInfoBean.isUser_verified=data?.user_info?.user_verified==1
            mUserInfoBean.verified_content=data?.user_info?.verified_content
            mNewsContent.user_info=mUserInfoBean
            mNewsContent?.title=data?.title
            mNewsContent?.video_detail_info=data?.video_detail_info
            mNewsContent?.publish_time=data?.publish_time
            mNewsContent.abstractX=data?.abstractX
            mNewsContent?.item_id=data?.item_id
            var mlist=ArrayList<NewsContent.LargeImageListBean>()
            mlist.add(data?.video_detail_info?.detail_video_large_image!!)
            mNewsContent?.large_image_list=mlist
            return mNewsContent
        }
    }
}