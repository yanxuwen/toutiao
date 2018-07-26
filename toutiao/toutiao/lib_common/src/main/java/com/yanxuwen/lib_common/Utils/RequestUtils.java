package com.yanxuwen.lib_common.Utils;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.model.Category.CategoryTask;
import com.yanxuwen.lib_common.retrofit.model.CategoryVideo.CategoryVideoTask;
import com.yanxuwen.lib_common.retrofit.model.Comment.CommentTask;
import com.yanxuwen.lib_common.retrofit.model.Article.ArticleTask;
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsListTask;
import com.yanxuwen.lib_common.retrofit.model.ReplyList.ReplyListTask;
import com.yanxuwen.lib_common.retrofit.model.SearchSuggest.SearchSuggestTask;
import com.yanxuwen.lib_common.retrofit.model.Token.TokenTask;
import com.yanxuwen.lib_common.retrofit.model.VideoInfo.VideoInfoTask;
import com.yanxuwen.lib_common.retrofit.model.VideoRecommend.VideoRecommendTask;
import com.yanxuwen.lib_common.retrofit.model.WebData.WebDataTask;
import com.yanxuwen.myutils.Utils.ToastUtil;
import com.yanxuwen.retrofit.Msg.ObserverListener;

/**
 * 作者：严旭文 on 2017/1/4 09:26
 * 邮箱：420255048@qq.com
 * 网络请求
 */
public class RequestUtils {
    public Context context;
    public ObserverListener ob;
    public RequestUtils(Context context, ObserverListener ob){
        this.context=context;
        this.ob=ob;
    }
    /**
     * 判断数据请求是否是失败
     */
    public boolean isDataFail(ObserverListener.STATUS status){
        if(status== ObserverListener.STATUS.FAIL){
//            ToastUtil.showToast(context, "失败");
            return true;
        }else if(status== ObserverListener.STATUS.ERROR){
            ToastUtil.showToast(context, "网络异常");
            return true;
        }
        else if(status== ObserverListener.STATUS.SPECIAL){
            return true;
        }
        return false;
    }
    /**
     * 请求Token
     */
    public  void requestToken(){
        new TokenTask(context,ob).request();
    }

//    /**
//     * 获取版本
//     */
//    public  void requestVersion(){
//        new VersionTask(context,ob).request();
//    }
//    /**
//     * 请求Https
//     */
//    public  void requestHttps(){
//        new HttpsTask(context,ob).request();
//    }


    /**
     * 请求新闻列表
     */
    public  void requestNewsList(boolean refresh,int refresh_idx,int count,int list_count,String category,String behot_time){
        new NewsListTask(context,ob,refresh,refresh_idx,count,list_count,category,behot_time).request();
    }
    /**
     * 请求视频信息
     */
    public  void requestVideoInfo(String video_id,String item_id){
        new VideoInfoTask(context,ob,video_id,item_id).request();
    }
    /**
     * 请求视频推荐
     */
    public  void requestVideoRecommend(String video_id,String group_id,String item_id){
        new VideoRecommendTask(context,ob,video_id,group_id,item_id).request();
    }
    /**
     * 请求评论
     */
    public  void requestComment(int offset, int count,String group_id,String item_id){
        new CommentTask(context,ob,offset,count,group_id,item_id).request();
    }
    /**
     * 请求回复列表
     */
    public  void requestReplyList(int offset, int count,String id){
        new ReplyListTask(context,ob,offset,count,id).request();
    }
    /**
     * 获取网页信息
     */
    public  void requestWebData(){
        new WebDataTask(context,ob).request();
    }

    /**
     * 获取html代码片段
     */
    public  void requestHtml(String id){
        new ArticleTask(context,ob,id).request();
    }

    /**
     * 获取分类
     */
    public  void requestCategory(){
        new CategoryTask(context,ob).request();
    }
    /**
     * 获取视频分类
     */
    public  void requestCategoryVideo(){
        new CategoryVideoTask(context,ob).request();
    }
    /**
     * 获取搜索建议
     */
    public  void requestSearchSuggest(String category){
        new SearchSuggestTask(context,ob,category).request();
    }
}
