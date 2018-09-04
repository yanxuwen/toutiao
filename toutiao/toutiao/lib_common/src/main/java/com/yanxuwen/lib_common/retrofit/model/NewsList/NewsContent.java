package com.yanxuwen.lib_common.retrofit.model.NewsList;

import com.google.gson.annotations.SerializedName;
import com.yanxuwen.lib_common.retrofit.model.Article.Article;
import com.yanxuwen.retrofit.Annotation.Description;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanxuwen on 2018/4/27.
 */
@Description("新闻内容")
public class NewsContent implements Serializable {

    private static final long serialVersionUID = -7060210544600464481L;
    /**
     * abstract :
     * action_extra : {"channel_id":5443492141}
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_sub_type : 0
     * article_type : 0
     * article_url : http://toutiao.com/group/6548775592802648584/
     * ban_comment : 0
     * behot_time : 1524793172
     * bury_count : 0
     * cell_flag : 262155
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 18
     * content_decoration :
     * cursor : 1524793172999
     * digg_count : 0
     * display_url : http://toutiao.com/group/6548775592802648584/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:2308868283","is_selected":false,"name":"拉黑作者:爱笑的小扒皮"},{"id":"1:1629","is_selected":false,"name":"不想看:娱乐"},{"id":"6:76461","is_selected":false,"name":"不想看:李丽珍"}]
     * forward_info : {"forward_count":4}
     * gallary_flag : 1
     * gallary_image_count : 4
     * group_flags : 131072
     * group_id : 6548775592802648584
     * has_image : true
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 0
     * image_list : [{"height":327,"uri":"list/640x360/pgc-image/1524755522513755f76a899","url":"http://p3.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899","url_list":[{"url":"http://p3.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"},{"url":"http://pb9.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"},{"url":"http://pb1.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"}],"width":583},{"height":416,"uri":"list/pgc-image/15247555222373390445d76","url":"http://p9.pstatp.com/list/pgc-image/15247555222373390445d76","url_list":[{"url":"http://p9.pstatp.com/list/pgc-image/15247555222373390445d76"},{"url":"http://pb1.pstatp.com/list/pgc-image/15247555222373390445d76"},{"url":"http://pb3.pstatp.com/list/pgc-image/15247555222373390445d76"}],"width":740},{"height":355,"uri":"list/pgc-image/1524755522381a57413daec","url":"http://p3.pstatp.com/list/pgc-image/1524755522381a57413daec","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1524755522381a57413daec"},{"url":"http://pb9.pstatp.com/list/pgc-image/1524755522381a57413daec"},{"url":"http://pb1.pstatp.com/list/pgc-image/1524755522381a57413daec"}],"width":632}]
     * is_subject : false
     * item_id : 6548775592802648584
     * item_version : 0
     * keywords : 水蜜桃,纯真,开心鬼,李丽珍,高志森,蜜桃成熟时,黄百鸣
     * level : 0
     * log_pb : {"impr_id":"20180427093932010015017083322A8C"}
     * media_info : {"avatar_url":"http://p3.pstatp.com/large/6ee6000356615c99573d","follow":false,"is_star_user":false,"media_id":1598821845594115,"name":"爱笑的小扒皮","recommend_reason":"","recommend_type":0,"user_id":97661666637,"user_verified":false,"verified_content":""}
     * media_name : 爱笑的小扒皮
     * middle_image : {"height":211,"uri":"list/pgc-image/1524755620818ef7da15a5a","url":"http://p3.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp","url_list":[{"url":"http://p3.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"},{"url":"http://pb9.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"},{"url":"http://pb1.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"}],"width":376}
     * need_client_impr_recycle : 1
     * preload_web : 1
     * publish_time : 1524755636
     * read_count : 49687
     * repin_count : 84
     * rid : 20180427093932010015017083322A8C
     * share_count : 43
     * share_info : {"cover_image":null,"description":null,"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"share_url":"","title":"18岁的李丽珍，25岁的李丽珍，52岁李丽珍，网友：差距真大啊！"}
     * share_url :
     * show_dislike : true
     * show_portrait : false
     * show_portrait_article : false
     * source : 爱笑的小扒皮
     * source_icon_style : 6
     * source_open_url : sslocal://profile?uid=97661666637
     * tag : news_entertainment
     * tag_id : 6548775592802648584
     * tip : 0
     * title : 18岁的李丽珍，25岁的李丽珍，52岁李丽珍，网友：差距真大啊！
     * ugc_recommend : {"activity":"","reason":""}
     * url : http://toutiao.com/group/6548775592802648584/
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/6ee6000356615c99573d","description":"你想要看的，我这里都有！","follow":false,"follower_count":0,"name":"爱笑的小扒皮","user_id":97661666637,"user_verified":false}
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     * video_style : 0
     */
    private String thumb_url;
    @SerializedName("abstract")
    private String abstractX;
    private int aggr_type;
    private boolean allow_download;
    private int article_sub_type;
    private int article_type;
    private String article_url;
    private int ban_comment;
    private int behot_time;
    private int bury_count;
    private int cell_flag;
    private int cell_layout_style;
    private int cell_type;
    private long comment_count;
    private String content_decoration;
    private long cursor;
    private int digg_count;
    private String display_url;
    private ForwardInfoBean forward_info;
    private int gallary_flag;
    private int gallary_image_count;
    private int group_flags;
    private long group_id;
    /**该mArticle值，是请求Article接口*/
    private Article article;
    private boolean has_image;
    private boolean has_m3u8_video;
    private int has_mp4_video;
    private boolean has_video;
    private int hot;
    private int ignore_web_transform;
    private boolean is_subject;
    private String item_id;
    private int item_version;
    private String keywords;
    private int level;
    private LogPbBean log_pb;
    private MediaInfoBean media_info;
    private String media_name;
    private MiddleImageBean middle_image;
    private int need_client_impr_recycle;
    private int preload_web;
    private long publish_time;
    private int read_count;
    private int repin_count;
    private String rid;
    private int share_count;
    private ShareInfoBean share_info;
    private String share_url;
    private boolean show_dislike;
    private boolean show_portrait;
    private boolean show_portrait_article;
    private String source;
    private int source_icon_style;
    private String source_open_url;
    private String tag;
    private long tag_id;
    private int tip;
    private String title;
    private UgcRecommendBean ugc_recommend;
    private String url;
    private UserInfoBean user_info;
    private int user_repin;
    private int user_verified;
    private String verified_content;
    private int video_style;
    private List<ActionListBean> action_list;
    private List<FilterWordsBean> filter_words;
    private List<ImageListBean> image_list;
    /**
     * action_extra : {"channel_id":3431225546}
     * ban_danmaku : false
     * danmaku_count : 0
     * large_image_list : [{"height":326,"uri":"video1609/pgc-image/1521621401470575e6a4a1e","url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb9.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb1.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"}],"width":580}]
     * share_info : {"cover_image":null,"description":null,"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"share_url":"https://m.365yg.com/a6535315123689488909/?iid=30852277705u0026app=news_article","title":"堕天使 当拳皇里的草薙京和八神同时出大招会如何？"}
     * share_type : 2
     * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/150e0010ea35afd5d08c","description":"本号每天发布自己的解说的游戏内容，喜欢街机和怀旧的朋友请关注","follow":false,"follower_count":0,"name":"堕天使格斗游戏解说","user_auth_info":{"auth_type":"0","other_auth":{"pgc":"头条号视频原创作者"},"auth_info":"西瓜视频游戏达人团 头条号视频原创作者"},"user_id":52334540699,"user_verified":true,"verified_content":"西瓜视频游戏达人团 头条号视频原创作者"}
     * video_detail_info : {"detail_video_large_image":{"height":326,"uri":"video1609/pgc-image/1521621401470575e6a4a1e","url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb9.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb1.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"}],"width":580},"direct_play":1,"group_flags":32832,"show_pgc_subscribe":1,"video_id":"fe67cdb7479d4472bb8bdb243d339d02","video_preloading_flag":1,"video_type":0,"video_watch_count":2098,"video_watching_count":0}
     * video_duration : 74
     * video_id : fe67cdb7479d4472bb8bdb243d339d02
     * video_proportion_article : 1.777
     */

    private ActionExtraBean action_extra;
    private boolean ban_danmaku;
    private int danmaku_count;
    private int share_type;
    private VideoDetailInfoBean video_detail_info;
    private int video_duration;
    private String video_id;
    private double video_proportion_article;
    private List<LargeImageListBean> large_image_list;
    /**
     * label : 广告
     * label_style : 3
     * raw_ad_data : {"alert_text":"","app_name":"脉脉","button_icon":0,"display_type":7,"download_url":"https://ad.toutiao.com/advertiser_package/dl/f1108297_93990556108_1523601690233","expire_seconds":315647445,"hide_if_exists":1,"id":1598711296585742,"log_extra":{"ad_price":"WuPVYAAYxjJa49VgABjGMtMrDpBjseaKQvjTVw","convert_component_suspend":0,"convert_id":1598710481079367,"external_action":13,"req_id":"20180428095855010020036224908CD4","rit":1},"package":"com.taou.maimai","rate":-1,"sub_title":"发现更多人脉","type":"app","web_title":"脉脉","web_url":"https://ad.toutiao.com/tetris/page/1598556048363524/"}
     * share_info : null
     */

    private String label;
    private int label_style;
    private RawAdDataBean raw_ad_data;
    private RawDataBean raw_data;


    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public int getAggr_type() {
        return aggr_type;
    }

    public void setAggr_type(int aggr_type) {
        this.aggr_type = aggr_type;
    }

    public boolean isAllow_download() {
        return allow_download;
    }

    public void setAllow_download(boolean allow_download) {
        this.allow_download = allow_download;
    }

    public int getArticle_sub_type() {
        return article_sub_type;
    }

    public void setArticle_sub_type(int article_sub_type) {
        this.article_sub_type = article_sub_type;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public int getBan_comment() {
        return ban_comment;
    }

    public void setBan_comment(int ban_comment) {
        this.ban_comment = ban_comment;
    }

    public int getBehot_time() {
        return behot_time;
    }

    public void setBehot_time(int behot_time) {
        this.behot_time = behot_time;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getCell_flag() {
        return cell_flag;
    }

    public void setCell_flag(int cell_flag) {
        this.cell_flag = cell_flag;
    }

    public int getCell_layout_style() {
        return cell_layout_style;
    }

    public void setCell_layout_style(int cell_layout_style) {
        this.cell_layout_style = cell_layout_style;
    }

    public int getCell_type() {
        return cell_type;
    }

    public void setCell_type(int cell_type) {
        this.cell_type = cell_type;
    }

    public long getComment_count() {
        return comment_count;
    }

    public void setComment_count(long comment_count) {
        this.comment_count = comment_count;
    }

    public String getContent_decoration() {
        return content_decoration;
    }

    public void setContent_decoration(String content_decoration) {
        this.content_decoration = content_decoration;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

    public ForwardInfoBean getForward_info() {
        return forward_info;
    }

    public void setForward_info(ForwardInfoBean forward_info) {
        this.forward_info = forward_info;
    }

    public int getGallary_flag() {
        return gallary_flag;
    }

    public void setGallary_flag(int gallary_flag) {
        this.gallary_flag = gallary_flag;
    }

    public int getGallary_image_count() {
        return gallary_image_count;
    }

    public void setGallary_image_count(int gallary_image_count) {
        this.gallary_image_count = gallary_image_count;
    }

    public int getGroup_flags() {
        return group_flags;
    }

    public void setGroup_flags(int group_flags) {
        this.group_flags = group_flags;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public boolean isHas_image() {
        return has_image;
    }

    public void setHas_image(boolean has_image) {
        this.has_image = has_image;
    }

    public boolean isHas_m3u8_video() {
        return has_m3u8_video;
    }

    public void setHas_m3u8_video(boolean has_m3u8_video) {
        this.has_m3u8_video = has_m3u8_video;
    }

    public int getHas_mp4_video() {
        return has_mp4_video;
    }

    public void setHas_mp4_video(int has_mp4_video) {
        this.has_mp4_video = has_mp4_video;
    }

    public boolean isHas_video() {
        return has_video;
    }

    public void setHas_video(boolean has_video) {
        this.has_video = has_video;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnore_web_transform() {
        return ignore_web_transform;
    }

    public void setIgnore_web_transform(int ignore_web_transform) {
        this.ignore_web_transform = ignore_web_transform;
    }

    public boolean isIs_subject() {
        return is_subject;
    }

    public void setIs_subject(boolean is_subject) {
        this.is_subject = is_subject;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public int getItem_version() {
        return item_version;
    }

    public void setItem_version(int item_version) {
        this.item_version = item_version;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLog_pb() {
        return log_pb;
    }

    public void setLog_pb(LogPbBean log_pb) {
        this.log_pb = log_pb;
    }

    public MediaInfoBean getMedia_info() {
        return media_info;
    }

    public void setMedia_info(MediaInfoBean media_info) {
        this.media_info = media_info;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public MiddleImageBean getMiddle_image() {
        return middle_image;
    }

    public void setMiddle_image(MiddleImageBean middle_image) {
        this.middle_image = middle_image;
    }

    public int getNeed_client_impr_recycle() {
        return need_client_impr_recycle;
    }

    public void setNeed_client_impr_recycle(int need_client_impr_recycle) {
        this.need_client_impr_recycle = need_client_impr_recycle;
    }

    public int getPreload_web() {
        return preload_web;
    }

    public void setPreload_web(int preload_web) {
        this.preload_web = preload_web;
    }

    public long getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(long publish_time) {
        this.publish_time = publish_time;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public int getRepin_count() {
        return repin_count;
    }

    public void setRepin_count(int repin_count) {
        this.repin_count = repin_count;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isShow_dislike() {
        return show_dislike;
    }

    public void setShow_dislike(boolean show_dislike) {
        this.show_dislike = show_dislike;
    }

    public boolean isShow_portrait() {
        return show_portrait;
    }

    public void setShow_portrait(boolean show_portrait) {
        this.show_portrait = show_portrait;
    }

    public boolean isShow_portrait_article() {
        return show_portrait_article;
    }

    public void setShow_portrait_article(boolean show_portrait_article) {
        this.show_portrait_article = show_portrait_article;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSource_icon_style() {
        return source_icon_style;
    }

    public void setSource_icon_style(int source_icon_style) {
        this.source_icon_style = source_icon_style;
    }

    public String getSource_open_url() {
        return source_open_url;
    }

    public void setSource_open_url(String source_open_url) {
        this.source_open_url = source_open_url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgc_recommend() {
        return ugc_recommend;
    }

    public void setUgc_recommend(UgcRecommendBean ugc_recommend) {
        this.ugc_recommend = ugc_recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfoBean user_info) {
        this.user_info = user_info;
    }

    public int getUser_repin() {
        return user_repin;
    }

    public void setUser_repin(int user_repin) {
        this.user_repin = user_repin;
    }

    public int getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(int user_verified) {
        this.user_verified = user_verified;
    }

    public String getVerified_content() {
        return verified_content;
    }

    public void setVerified_content(String verified_content) {
        this.verified_content = verified_content;
    }

    public int getVideo_style() {
        return video_style;
    }

    public void setVideo_style(int video_style) {
        this.video_style = video_style;
    }

    public List<ActionListBean> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionListBean> action_list) {
        this.action_list = action_list;
    }

    public List<FilterWordsBean> getFilter_words() {
        return filter_words;
    }

    public void setFilter_words(List<FilterWordsBean> filter_words) {
        this.filter_words = filter_words;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    public ActionExtraBean getAction_extra() {
        return action_extra;
    }

    public void setAction_extra(ActionExtraBean action_extra) {
        this.action_extra = action_extra;
    }

    public boolean isBan_danmaku() {
        return ban_danmaku;
    }

    public void setBan_danmaku(boolean ban_danmaku) {
        this.ban_danmaku = ban_danmaku;
    }

    public int getDanmaku_count() {
        return danmaku_count;
    }

    public void setDanmaku_count(int danmaku_count) {
        this.danmaku_count = danmaku_count;
    }

    public int getShare_type() {
        return share_type;
    }

    public void setShare_type(int share_type) {
        this.share_type = share_type;
    }

    public VideoDetailInfoBean getVideo_detail_info() {
        return video_detail_info;
    }

    public void setVideo_detail_info(VideoDetailInfoBean video_detail_info) {
        this.video_detail_info = video_detail_info;
    }

    public int getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(int video_duration) {
        this.video_duration = video_duration;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public double getVideo_proportion_article() {
        return video_proportion_article;
    }

    public void setVideo_proportion_article(double video_proportion_article) {
        this.video_proportion_article = video_proportion_article;
    }

    public List<LargeImageListBean> getLarge_image_list() {
        return large_image_list;
    }

    public void setLarge_image_list(List<LargeImageListBean> large_image_list) {
        this.large_image_list = large_image_list;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLabel_style() {
        return label_style;
    }

    public void setLabel_style(int label_style) {
        this.label_style = label_style;
    }

    public RawAdDataBean getRaw_ad_data() {
        return raw_ad_data;
    }

    public void setRaw_ad_data(RawAdDataBean raw_ad_data) {
        this.raw_ad_data = raw_ad_data;
    }

    public RawDataBean getRaw_data() {
        return raw_data;
    }

    public void setRaw_data(RawDataBean raw_data) {
        this.raw_data = raw_data;
    }

    public String getThumb_url() {
        if(getLarge_image_list()!=null){
            return getLarge_image_list().get(getLarge_image_list().size()-1).getUrl();
        }else if(getImage_list()!=null){
            return getImage_list().get(0).getUrl_list().get( getImage_list().get(0).getUrl_list().size()-1).getUrl();
        }else if(getMiddle_image()!=null){
            return getMiddle_image().getUrl_list().get(getMiddle_image().getUrl_list().size()-1).getUrl();
        }else if (getVideo_detail_info()!=null&&getVideo_detail_info().getDetail_video_large_image()!=null){
            return getVideo_detail_info().getDetail_video_large_image().getUrl_list().get(getVideo_detail_info().getDetail_video_large_image().getUrl_list().size()-1).getUrl();
        }
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

     /**该mArticle值，是请求Article接口*/
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public static class ActionExtraBean implements Serializable {
        /**
         * channel_id : 5443492141
         */

        private long channel_id;

        public long getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(long channel_id) {
            this.channel_id = channel_id;
        }
    }

    public static class ForwardInfoBean implements Serializable {
        /**
         * forward_count : 4
         */

        private int forward_count;

        public int getForward_count() {
            return forward_count;
        }

        public void setForward_count(int forward_count) {
            this.forward_count = forward_count;
        }
    }

    public static class LogPbBean implements Serializable {
        /**
         * impr_id : 20180427093932010015017083322A8C
         */

        private String impr_id;

        public String getImpr_id() {
            return impr_id;
        }

        public void setImpr_id(String impr_id) {
            this.impr_id = impr_id;
        }
    }

    public static class MediaInfoBean implements Serializable {
        /**
         * avatar_url : http://p3.pstatp.com/large/6ee6000356615c99573d
         * follow : false
         * is_star_user : false
         * media_id : 1598821845594115
         * name : 爱笑的小扒皮
         * recommend_reason :
         * recommend_type : 0
         * user_id : 97661666637
         * user_verified : false
         * verified_content :
         */

        private String avatar_url;
        private boolean follow;
        private boolean is_star_user;
        private long media_id;
        private String name;
        private String recommend_reason;
        private int recommend_type;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isIs_star_user() {
            return is_star_user;
        }

        public void setIs_star_user(boolean is_star_user) {
            this.is_star_user = is_star_user;
        }

        public long getMedia_id() {
            return media_id;
        }

        public void setMedia_id(long media_id) {
            this.media_id = media_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommend_reason() {
            return recommend_reason;
        }

        public void setRecommend_reason(String recommend_reason) {
            this.recommend_reason = recommend_reason;
        }

        public int getRecommend_type() {
            return recommend_type;
        }

        public void setRecommend_type(int recommend_type) {
            this.recommend_type = recommend_type;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }
    }

    public static class MiddleImageBean implements Serializable {
        /**
         * height : 211
         * uri : list/pgc-image/1524755620818ef7da15a5a
         * url : http://p3.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp
         * url_list : [{"url":"http://p3.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"},{"url":"http://pb9.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"},{"url":"http://pb1.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp"}]
         * width : 376
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBean> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return (url==null||url.equals(""))?uri:url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBean> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBean implements Serializable {
            /**
             * url : http://p3.pstatp.com/list/300x196/pgc-image/1524755620818ef7da15a5a.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class ShareInfoBean implements Serializable {
        /**
         * cover_image : null
         * description : null
         * share_type : {"pyq":2,"qq":0,"qzone":0,"wx":0}
         * share_url :
         * title : 18岁的李丽珍，25岁的李丽珍，52岁李丽珍，网友：差距真大啊！
         */

        private Object cover_image;
        private Object description;
        private ShareTypeBean share_type;
        private String share_url;
        private String title;

        public Object getCover_image() {
            return cover_image;
        }

        public void setCover_image(Object cover_image) {
            this.cover_image = cover_image;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public ShareTypeBean getShare_type() {
            return share_type;
        }

        public void setShare_type(ShareTypeBean share_type) {
            this.share_type = share_type;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class ShareTypeBean implements Serializable {
            /**
             * pyq : 2
             * qq : 0
             * qzone : 0
             * wx : 0
             */

            private int pyq;
            private int qq;
            private int qzone;
            private int wx;

            public int getPyq() {
                return pyq;
            }

            public void setPyq(int pyq) {
                this.pyq = pyq;
            }

            public int getQq() {
                return qq;
            }

            public void setQq(int qq) {
                this.qq = qq;
            }

            public int getQzone() {
                return qzone;
            }

            public void setQzone(int qzone) {
                this.qzone = qzone;
            }

            public int getWx() {
                return wx;
            }

            public void setWx(int wx) {
                this.wx = wx;
            }
        }
    }

    public static class UgcRecommendBean implements Serializable {
        /**
         * activity :
         * reason :
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class ActionListBean implements Serializable {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean implements Serializable {
        }
    }

    public static class FilterWordsBean implements Serializable {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ImageListBean implements Serializable {
        /**
         * height : 327
         * uri : list/640x360/pgc-image/1524755522513755f76a899
         * url : http://p3.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899
         * url_list : [{"url":"http://p3.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"},{"url":"http://pb9.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"},{"url":"http://pb1.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899"}]
         * width : 583
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<UrlListBeanX> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return (url==null||url.equals(""))?uri:url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<UrlListBeanX> url_list) {
            this.url_list = url_list;
        }

        public static class UrlListBeanX implements Serializable {
            /**
             * url : http://p3.pstatp.com/list/640x360/pgc-image/1524755522513755f76a899
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class UserInfoBean implements Serializable {
        /**
         * avatar_url : http://p3.pstatp.com/thumb/150e0010ea35afd5d08c
         * description : 本号每天发布自己的解说的游戏内容，喜欢街机和怀旧的朋友请关注
         * follow : false
         * follower_count : 0
         * name : 堕天使格斗游戏解说
         * user_auth_info : {"auth_type":"0","other_auth":{"pgc":"头条号视频原创作者"},"auth_info":"西瓜视频游戏达人团 头条号视频原创作者"}
         * user_id : 52334540699
         * user_verified : true
         * verified_content : 西瓜视频游戏达人团 头条号视频原创作者
         */

        private String avatar_url;
        private String description;
        private boolean follow;
        private long follower_count;
        private String name;
        private UserAuthInfoBean user_auth_info;
        private long user_id;
        private boolean user_verified;
        private String verified_content;

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public long getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(long follower_count) {
            this.follower_count = follower_count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public UserAuthInfoBean getUser_auth_info() {
            return user_auth_info;
        }

        public void setUser_auth_info(UserAuthInfoBean user_auth_info) {
            this.user_auth_info = user_auth_info;
        }

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public static class UserAuthInfoBean implements Serializable {
            /**
             * auth_type : 0
             * other_auth : {"pgc":"头条号视频原创作者"}
             * auth_info : 西瓜视频游戏达人团 头条号视频原创作者
             */

            private String auth_type;
            private OtherAuthBean other_auth;
            private String auth_info;

            public String getAuth_type() {
                return auth_type;
            }

            public void setAuth_type(String auth_type) {
                this.auth_type = auth_type;
            }

            public OtherAuthBean getOther_auth() {
                return other_auth;
            }

            public void setOther_auth(OtherAuthBean other_auth) {
                this.other_auth = other_auth;
            }

            public String getAuth_info() {
                return auth_info;
            }

            public void setAuth_info(String auth_info) {
                this.auth_info = auth_info;
            }

            public static class OtherAuthBean implements Serializable {
                /**
                 * pgc : 头条号视频原创作者
                 */

                private String pgc;

                public String getPgc() {
                    return pgc;
                }

                public void setPgc(String pgc) {
                    this.pgc = pgc;
                }
            }
        }
    }

    public static class VideoDetailInfoBean implements Serializable {
        /**
         * detail_video_large_image : {"height":326,"uri":"video1609/pgc-image/1521621401470575e6a4a1e","url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb9.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb1.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"}],"width":580}
         * direct_play : 1
         * group_flags : 32832
         * show_pgc_subscribe : 1
         * video_id : fe67cdb7479d4472bb8bdb243d339d02
         * video_preloading_flag : 1
         * video_type : 0
         * video_watch_count : 2098
         * video_watching_count : 0
         */

        private LargeImageListBean detail_video_large_image;
        private int direct_play;
        private int group_flags;
        private int show_pgc_subscribe;
        private String video_id;
        private int video_preloading_flag;
        private int video_type;
        private Long video_watch_count;
        private int video_watching_count;

        public LargeImageListBean getDetail_video_large_image() {
            return detail_video_large_image;
        }

        public void setDetail_video_large_image(LargeImageListBean detail_video_large_image) {
            this.detail_video_large_image = detail_video_large_image;
        }

        public int getDirect_play() {
            return direct_play;
        }

        public void setDirect_play(int direct_play) {
            this.direct_play = direct_play;
        }

        public int getGroup_flagsX() {
            return group_flags;
        }

        public void setGroup_flags(int group_flags) {
            this.group_flags = group_flags;
        }

        public int getShow_pgc_subscribe() {
            return show_pgc_subscribe;
        }

        public void setShow_pgc_subscribe(int show_pgc_subscribe) {
            this.show_pgc_subscribe = show_pgc_subscribe;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public int getVideo_preloading_flag() {
            return video_preloading_flag;
        }

        public void setVideo_preloading_flag(int video_preloading_flag) {
            this.video_preloading_flag = video_preloading_flag;
        }

        public int getVideo_type() {
            return video_type;
        }

        public void setVideo_type(int video_type) {
            this.video_type = video_type;
        }

        public Long getVideo_watch_count() {
            return video_watch_count;
        }

        public void setVideo_watch_count(Long video_watch_count) {
            this.video_watch_count = video_watch_count;
        }

        public int getVideo_watching_count() {
            return video_watching_count;
        }

        public void setVideo_watching_count(int video_watching_count) {
            this.video_watching_count = video_watching_count;
        }

        public static class DetailVideoLargeImageBean implements Serializable {
            /**
             * height : 326
             * uri : video1609/pgc-image/1521621401470575e6a4a1e
             * url : http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e
             * url_list : [{"url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb9.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb1.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"}]
             * width : 580
             */

            private int height;
            private String uri;
            private String url;
            private int width;
            private List<NewsContent> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrl() {
                return url;
            }

            public void setUrlX(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<NewsContent> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<NewsContent> url_list) {
                this.url_list = url_list;
            }
        }
    }

    public static class LargeImageListBean implements Serializable {
        /**
         * height : 326
         * uri : video1609/pgc-image/1521621401470575e6a4a1e
         * url : http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e
         * url_list : [{"url":"http://p3.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb9.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"},{"url":"http://pb1.pstatp.com/video1609/pgc-image/1521621401470575e6a4a1e"}]
         * width : 580
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        private List<NewsContent> url_list;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return (url==null||url.equals(""))?uri:url;
        }

        public void setUrlX(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<NewsContent> getUrl_list() {
            return url_list;
        }

        public void setUrl_list(List<NewsContent> url_list) {
            this.url_list = url_list;
        }
    }

    public static class RawAdDataBean implements Serializable {
        /**
         * alert_text :
         * app_name : 脉脉
         * button_icon : 0
         * display_type : 7
         * download_url : https://ad.toutiao.com/advertiser_package/dl/f1108297_93990556108_1523601690233
         * expire_seconds : 315647445
         * hide_if_exists : 1
         * id : 1598711296585742
         * log_extra : {"ad_price":"WuPVYAAYxjJa49VgABjGMtMrDpBjseaKQvjTVw","convert_component_suspend":0,"convert_id":1598710481079367,"external_action":13,"req_id":"20180428095855010020036224908CD4","rit":1}
         * package : com.taou.maimai
         * rate : -1
         * sub_title : 发现更多人脉
         * type : app
         * web_title : 脉脉
         * web_url : https://ad.toutiao.com/tetris/page/1598556048363524/
         */

        private String alert_text;
        private String app_name;
        private int button_icon;
        private int display_type;
        private String download_url;
        private int expire_seconds;
        private int hide_if_exists;
        private long id;
        private LogExtraBean log_extra;
        @SerializedName("package")
        private String packageX;
        private int rate;
        private String sub_title;
        private String type;
        private String web_title;
        private String web_url;
        /**
         * appleid :
         * button_style : 1
         * button_text : 立即下载
         */

        private String appleid;
        private int button_style;
        private String button_text;

        public String getAlert_text() {
            return alert_text;
        }

        public void setAlert_text(String alert_text) {
            this.alert_text = alert_text;
        }

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public int getButton_icon() {
            return button_icon;
        }

        public void setButton_icon(int button_icon) {
            this.button_icon = button_icon;
        }

        public int getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(int display_type) {
            this.display_type = display_type;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public int getExpire_seconds() {
            return expire_seconds;
        }

        public void setExpire_seconds(int expire_seconds) {
            this.expire_seconds = expire_seconds;
        }

        public int getHide_if_exists() {
            return hide_if_exists;
        }

        public void setHide_if_exists(int hide_if_exists) {
            this.hide_if_exists = hide_if_exists;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public LogExtraBean getLog_extra() {
            return log_extra;
        }

        public void setLog_extra(LogExtraBean log_extra) {
            this.log_extra = log_extra;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWeb_title() {
            return web_title;
        }

        public void setWeb_title(String web_title) {
            this.web_title = web_title;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getAppleid() {
            return appleid;
        }

        public void setAppleid(String appleid) {
            this.appleid = appleid;
        }

        public int getButton_style() {
            return button_style;
        }

        public void setButton_style(int button_style) {
            this.button_style = button_style;
        }

        public String getButton_text() {
            return button_text;
        }

        public void setButton_text(String button_text) {
            this.button_text = button_text;
        }

        public static class LogExtraBean implements Serializable {
            /**
             * ad_price : WuPVYAAYxjJa49VgABjGMtMrDpBjseaKQvjTVw
             * convert_component_suspend : 0
             * convert_id : 1598710481079367
             * external_action : 13
             * req_id : 20180428095855010020036224908CD4
             * rit : 1
             */

            private String ad_price;
            private int convert_component_suspend;
            private long convert_id;
            private int external_action;
            private String req_id;
            private int rit;

            public String getAd_price() {
                return ad_price;
            }

            public void setAd_price(String ad_price) {
                this.ad_price = ad_price;
            }

            public int getConvert_component_suspend() {
                return convert_component_suspend;
            }

            public void setConvert_component_suspend(int convert_component_suspend) {
                this.convert_component_suspend = convert_component_suspend;
            }

            public long getConvert_id() {
                return convert_id;
            }

            public void setConvert_id(long convert_id) {
                this.convert_id = convert_id;
            }

            public int getExternal_action() {
                return external_action;
            }

            public void setExternal_action(int external_action) {
                this.external_action = external_action;
            }

            public String getReq_id() {
                return req_id;
            }

            public void setReq_id(String req_id) {
                this.req_id = req_id;
            }

            public int getRit() {
                return rit;
            }

            public void setRit(int rit) {
                this.rit = rit;
            }
        }
    }
    public static class RawDataBean implements Serializable{
        /**
         * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:1440579744","is_selected":false,"name":"拉黑作者:农村小妹爱唱歌"}]
         * group_id : 6595776229264067332
         * group_source : 22
         * impression_extra : null
         * large_image : {"height":327,"uri":"video1609/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7","url":"http://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg","url_list":[{"url":"http://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"},{"url":"http://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"},{"url":"http://sf6-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"}],"width":580}
         * live_info : {"create_time":1535698825,"orientation":0,"room_id":6595776229264067332,"schema":"sslocal://xigua_live?room_id=6595776229264067332&orientation=0","stream_url":{"PullURL":{"FULL_HD1":{"Flv":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","Hls":"http://pull-hls-l1-hs.pstatp.com/hudong/stream-6595775508368444167/playlist.m3u8","Rtmp":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167"}},"alternate_pull_url":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167","create_time":1535698824,"flv_pull_url":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","stream_id":6595775508368444167},"watching_count":1397,"watching_count_str":"1397人气"}
         * lottery_info : null
         * share_url : https://m.toutiaoimg.cn/item/6595776229264067332/?iid=41004251804&app=news_article&timestamp=1535700662
         * short_id : 102676
         * title : 专治各种不开心，不来你后悔
         * user_info : {"author_info":null,"avatar_url":"http://p3-xg.pstatp.com/large/2c6d000c5955477657e4","description":"一边干农活  一边唱唱歌","extend_info":null,"follow":false,"followers_count":360249,"following_count":0,"is_living":false,"live_info":null,"live_orientation":"","media_id":0,"name":"农村小妹爱唱歌","ugc_publish_media_id":0,"user_auth_info":"{\"auth_type\": \"0\", \"other_auth\": {\"pgc\": \"优质音乐领域创作者\"}, \"auth_info\": \"优质音乐领域创作者\"}","user_id":65763950475,"user_verified":false,"verified_content":"","video_live_auth":false}
         */

        @SerializedName("group_id")
        private long group_idX;
        private int group_source;
        private Object impression_extra;
        private LargeImageBean large_image;
        private LiveInfoBean live_info;
        private Object lottery_info;
        @SerializedName("share_url")
        private String share_urlX;
        private int short_id;
        @SerializedName("title")
        private String titleX;
        @SerializedName("user_info")
        private UserInfoBean user_infoX;
        @SerializedName("filter_words")
        private List<FilterWordsBean> filter_wordsX;

        public long getGroup_idX() {
            return group_idX;
        }

        public void setGroup_idX(long group_idX) {
            this.group_idX = group_idX;
        }

        public int getGroup_source() {
            return group_source;
        }

        public void setGroup_source(int group_source) {
            this.group_source = group_source;
        }

        public Object getImpression_extra() {
            return impression_extra;
        }

        public void setImpression_extra(Object impression_extra) {
            this.impression_extra = impression_extra;
        }

        public LargeImageBean getLarge_image() {
            return large_image;
        }

        public void setLarge_image(LargeImageBean large_image) {
            this.large_image = large_image;
        }

        public LiveInfoBean getLive_info() {
            return live_info;
        }

        public void setLive_info(LiveInfoBean live_info) {
            this.live_info = live_info;
        }

        public Object getLottery_info() {
            return lottery_info;
        }

        public void setLottery_info(Object lottery_info) {
            this.lottery_info = lottery_info;
        }

        public String getShare_urlX() {
            return share_urlX;
        }

        public void setShare_urlX(String share_urlX) {
            this.share_urlX = share_urlX;
        }

        public int getShort_id() {
            return short_id;
        }

        public void setShort_id(int short_id) {
            this.short_id = short_id;
        }

        public String getTitleX() {
            return titleX;
        }

        public void setTitleX(String titleX) {
            this.titleX = titleX;
        }

        public UserInfoBean getUser_infoX() {
            return user_infoX;
        }

        public void setUser_infoX(UserInfoBean user_infoX) {
            this.user_infoX = user_infoX;
        }

        public List<FilterWordsBean> getFilter_wordsX() {
            return filter_wordsX;
        }

        public void setFilter_wordsX(List<FilterWordsBean> filter_wordsX) {
            this.filter_wordsX = filter_wordsX;
        }

        public static class LargeImageBean implements Serializable{
            /**
             * height : 327
             * uri : video1609/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7
             * url : http://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg
             * url_list : [{"url":"http://sf1-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"},{"url":"http://sf3-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"},{"url":"http://sf6-xgcdn-tos.pstatp.com/img/tos-cn-i-0000/e593c6de53294093a2c79b054eb564f7~c5_580x327.jpeg"}]
             * width : 580
             */

            private int height;
            private String uri;
            @SerializedName("url")
            private String urlX;
            private int width;
            private List<Article.DataBean.ImageDetailBean> url_list;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getUrlX() {
                return urlX;
            }

            public void setUrlX(String urlX) {
                this.urlX = urlX;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<Article.DataBean.ImageDetailBean> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<Article.DataBean.ImageDetailBean> url_list) {
                this.url_list = url_list;
            }
        }

        public static class LiveInfoBean implements Serializable{
            /**
             * create_time : 1535698825
             * orientation : 0
             * room_id : 6595776229264067332
             * schema : sslocal://xigua_live?room_id=6595776229264067332&orientation=0
             * stream_url : {"PullURL":{"FULL_HD1":{"Flv":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","Hls":"http://pull-hls-l1-hs.pstatp.com/hudong/stream-6595775508368444167/playlist.m3u8","Rtmp":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167"}},"alternate_pull_url":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167","create_time":1535698824,"flv_pull_url":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","stream_id":6595775508368444167}
             * watching_count : 1397
             * watching_count_str : 1397人气
             */

            private int create_time;
            private int orientation;
            private long room_id;
            private String schema;
            private StreamUrlBean stream_url;
            private int watching_count;
            private String watching_count_str;

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getOrientation() {
                return orientation;
            }

            public void setOrientation(int orientation) {
                this.orientation = orientation;
            }

            public long getRoom_id() {
                return room_id;
            }

            public void setRoom_id(long room_id) {
                this.room_id = room_id;
            }

            public String getSchema() {
                return schema;
            }

            public void setSchema(String schema) {
                this.schema = schema;
            }

            public StreamUrlBean getStream_url() {
                return stream_url;
            }

            public void setStream_url(StreamUrlBean stream_url) {
                this.stream_url = stream_url;
            }

            public int getWatching_count() {
                return watching_count;
            }

            public void setWatching_count(int watching_count) {
                this.watching_count = watching_count;
            }

            public String getWatching_count_str() {
                return watching_count_str;
            }

            public void setWatching_count_str(String watching_count_str) {
                this.watching_count_str = watching_count_str;
            }

            public static class StreamUrlBean implements Serializable{
                /**
                 * PullURL : {"FULL_HD1":{"Flv":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","Hls":"http://pull-hls-l1-hs.pstatp.com/hudong/stream-6595775508368444167/playlist.m3u8","Rtmp":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167"}}
                 * alternate_pull_url : rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167
                 * create_time : 1535698824
                 * flv_pull_url : http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv
                 * stream_id : 6595775508368444167
                 */

                private PullURLBean PullURL;
                private String alternate_pull_url;
                private int create_time;
                private String flv_pull_url;
                private long stream_id;

                public PullURLBean getPullURL() {
                    return PullURL;
                }

                public void setPullURL(PullURLBean PullURL) {
                    this.PullURL = PullURL;
                }

                public String getAlternate_pull_url() {
                    return alternate_pull_url;
                }

                public void setAlternate_pull_url(String alternate_pull_url) {
                    this.alternate_pull_url = alternate_pull_url;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public String getFlv_pull_url() {
                    return flv_pull_url;
                }

                public void setFlv_pull_url(String flv_pull_url) {
                    this.flv_pull_url = flv_pull_url;
                }

                public long getStream_id() {
                    return stream_id;
                }

                public void setStream_id(long stream_id) {
                    this.stream_id = stream_id;
                }

                public static class PullURLBean implements Serializable{
                    /**
                     * FULL_HD1 : {"Flv":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv","Hls":"http://pull-hls-l1-hs.pstatp.com/hudong/stream-6595775508368444167/playlist.m3u8","Rtmp":"rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167"}
                     */

                    private FULLHD1Bean FULL_HD1;

                    public FULLHD1Bean getFULL_HD1() {
                        return FULL_HD1;
                    }

                    public void setFULL_HD1(FULLHD1Bean FULL_HD1) {
                        this.FULL_HD1 = FULL_HD1;
                    }

                    public static class FULLHD1Bean implements Serializable{
                        /**
                         * Flv : http://pull-flv-l1-hs.pstatp.com/hudong/stream-6595775508368444167.flv
                         * Hls : http://pull-hls-l1-hs.pstatp.com/hudong/stream-6595775508368444167/playlist.m3u8
                         * Rtmp : rtmp://pull-rtmp-l1-hs.pstatp.com/hudong/stream-6595775508368444167
                         */

                        private String Flv;
                        private String Hls;
                        private String Rtmp;

                        public String getFlv() {
                            return Flv;
                        }

                        public void setFlv(String Flv) {
                            this.Flv = Flv;
                        }

                        public String getHls() {
                            return Hls;
                        }

                        public void setHls(String Hls) {
                            this.Hls = Hls;
                        }

                        public String getRtmp() {
                            return Rtmp;
                        }

                        public void setRtmp(String Rtmp) {
                            this.Rtmp = Rtmp;
                        }
                    }
                }
            }
        }
    }



}
