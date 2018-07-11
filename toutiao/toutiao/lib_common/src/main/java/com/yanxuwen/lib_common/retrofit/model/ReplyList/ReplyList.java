package com.yanxuwen.lib_common.retrofit.model.ReplyList;

import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.retrofit.Annotation.Description;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxuwen on 2018/5/30.
 */
@Description("回复列表")
public class ReplyList  extends MyBaseModel {

    /**
     * ban_face : false
     * data : {"has_more":false,"total_count":5,"stick_total_number":0,"offset":4,"stick_has_more":false,"group_id":6538255060583842318,"data":[{"reply_to_comment":{"is_followed":null,"is_pgc_author":false,"is_owner":false,"text":"你爸也是区长啊？","content_rich_span":"","user_verified":false,"verified_reason":"","is_following":null,"author_badge":[],"id":1599706141843470,"user_id":59379751563,"user_name":"一米八的大汉爱撒娇","user_relation":0,"user_auth_info":""},"text":"同九义吾不及汝秀","create_time":1526382257,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":59406383216,"name":"来者即是朋友","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p3.pstatp.com/thumb/3e7e001c7de0726fda11","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"来者即是朋友"},"user_digg":false,"id":1600527802059789,"is_owner":false,"digg_count":4,"content_rich_span":"","content":"同九义吾不及汝秀","repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1600527802059789,"repost_type":211}},{"reply_to_comment":{"is_followed":null,"is_pgc_author":false,"is_owner":false,"text":"你爸也是区长啊？","content_rich_span":"","user_verified":false,"verified_reason":"","is_following":null,"author_badge":[],"id":1599706141843470,"user_id":59379751563,"user_name":"一米八的大汉爱撒娇","user_relation":0,"user_auth_info":""},"text":"哈哈，笑死我了","create_time":1526404630,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":5969310901,"name":"丿沩凊丶葰涃73569252","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/289d0012ddb12f8da5a1","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"丿沩凊丶葰涃73569252"},"user_digg":false,"id":1600551261887491,"is_owner":false,"digg_count":3,"content_rich_span":"","content":"哈哈，笑死我了","repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1600551261887491,"repost_type":211}},{"content":"你爸也被双归了？","create_time":1526993597,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":67057552168,"name":"Kxl7766","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/834d001448e557010b4e","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"Kxl7766"},"text":"你爸也被双归了？","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1601168838868999,"repost_type":211},"id":1601168838868999,"content_rich_span":"","digg_count":2},{"content":"你也得啥那了啊\u2026\u2026","create_time":1527340150,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":3095131667,"name":"海蛎子嗨","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/549/263055833","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"海蛎子嗨"},"text":"你也得啥那了啊\u2026\u2026","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1601532225956867,"repost_type":211},"id":1601532225956867,"content_rich_span":"","digg_count":1}],"id":1599632183218180,"hot_comments":[{"content":"你爸也是区长啊？","create_time":1525598661,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":59379751563,"name":"一米八的大汉爱撒娇","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p3.pstatp.com/thumb/1a6d0016ad1919ccb524","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"一米八的大汉爱撒娇"},"text":"你爸也是区长啊？","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1599706141843470,"repost_type":211},"id":1599706141843470,"content_rich_span":"","digg_count":18}]}
     * stable : true
     */

    private boolean ban_face;
    private DataBeanX data;
    private boolean stable;

    public boolean isBan_face() {
        return ban_face;
    }

    public void setBan_face(boolean ban_face) {
        this.ban_face = ban_face;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public boolean isStable() {
        return stable;
    }

    public void setStable(boolean stable) {
        this.stable = stable;
    }

    public static class DataBeanX {
        /**
         * has_more : false
         * total_count : 5
         * stick_total_number : 0
         * offset : 4
         * stick_has_more : false
         * group_id : 6538255060583842318
         * data : [{"reply_to_comment":{"is_followed":null,"is_pgc_author":false,"is_owner":false,"text":"你爸也是区长啊？","content_rich_span":"","user_verified":false,"verified_reason":"","is_following":null,"author_badge":[],"id":1599706141843470,"user_id":59379751563,"user_name":"一米八的大汉爱撒娇","user_relation":0,"user_auth_info":""},"text":"同九义吾不及汝秀","create_time":1526382257,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":59406383216,"name":"来者即是朋友","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p3.pstatp.com/thumb/3e7e001c7de0726fda11","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"来者即是朋友"},"user_digg":false,"id":1600527802059789,"is_owner":false,"digg_count":4,"content_rich_span":"","content":"同九义吾不及汝秀","repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1600527802059789,"repost_type":211}},{"reply_to_comment":{"is_followed":null,"is_pgc_author":false,"is_owner":false,"text":"你爸也是区长啊？","content_rich_span":"","user_verified":false,"verified_reason":"","is_following":null,"author_badge":[],"id":1599706141843470,"user_id":59379751563,"user_name":"一米八的大汉爱撒娇","user_relation":0,"user_auth_info":""},"text":"哈哈，笑死我了","create_time":1526404630,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":5969310901,"name":"丿沩凊丶葰涃73569252","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/289d0012ddb12f8da5a1","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"丿沩凊丶葰涃73569252"},"user_digg":false,"id":1600551261887491,"is_owner":false,"digg_count":3,"content_rich_span":"","content":"哈哈，笑死我了","repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1600551261887491,"repost_type":211}},{"content":"你爸也被双归了？","create_time":1526993597,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":67057552168,"name":"Kxl7766","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/834d001448e557010b4e","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"Kxl7766"},"text":"你爸也被双归了？","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1601168838868999,"repost_type":211},"id":1601168838868999,"content_rich_span":"","digg_count":2},{"content":"你也得啥那了啊\u2026\u2026","create_time":1527340150,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":3095131667,"name":"海蛎子嗨","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p1.pstatp.com/thumb/549/263055833","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"海蛎子嗨"},"text":"你也得啥那了啊\u2026\u2026","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1601532225956867,"repost_type":211},"id":1601532225956867,"content_rich_span":"","digg_count":1}]
         * id : 1599632183218180
         * hot_comments : [{"content":"你爸也是区长啊？","create_time":1525598661,"is_owner":false,"user":{"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":59379751563,"name":"一米八的大汉爱撒娇","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p3.pstatp.com/thumb/1a6d0016ad1919ccb524","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"一米八的大汉爱撒娇"},"text":"你爸也是区长啊？","user_digg":false,"repost_params":{"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1599706141843470,"repost_type":211},"id":1599706141843470,"content_rich_span":"","digg_count":18}]
         */

        private boolean has_more;
        private int total_count;
        private int stick_total_number;
        private int offset;
        private boolean stick_has_more;
        private long group_id;
        private long id;
        private List<DataBean> data;
        private List<DataBean> hot_comments;

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getStick_total_number() {
            return stick_total_number;
        }

        public void setStick_total_number(int stick_total_number) {
            this.stick_total_number = stick_total_number;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isStick_has_more() {
            return stick_has_more;
        }

        public void setStick_has_more(boolean stick_has_more) {
            this.stick_has_more = stick_has_more;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public List<DataBean> getHot_comments() {
            return hot_comments;
        }

        public void setHot_comments(List<DataBean> hot_comments) {
            this.hot_comments = hot_comments;
        }

        public static class DataBean {
            /**
             * reply_to_comment : {"is_followed":null,"is_pgc_author":false,"is_owner":false,"text":"你爸也是区长啊？","content_rich_span":"","user_verified":false,"verified_reason":"","is_following":null,"author_badge":[],"id":1599706141843470,"user_id":59379751563,"user_name":"一米八的大汉爱撒娇","user_relation":0,"user_auth_info":""}
             * text : 同九义吾不及汝秀
             * create_time : 1526382257
             * user : {"is_followed":null,"is_blocking":false,"is_pgc_author":false,"is_blocked":false,"user_id":59406383216,"name":"来者即是朋友","author_badge":[],"description":"","user_relation":0,"verified_reason":"","avatar_url":"http://p3.pstatp.com/thumb/3e7e001c7de0726fda11","is_following":null,"user_decoration":null,"user_auth_info":"","user_verified":false,"screen_name":"来者即是朋友"}
             * user_digg : false
             * id : 1600527802059789
             * is_owner : false
             * digg_count : 4
             * content_rich_span :
             * content : 同九义吾不及汝秀
             * repost_params : {"opt_id_type":3,"title":"沈腾化身知名创作歌手，竟能给刘德华写歌！","fw_id_type":4,"fw_id":6538255060583842318,"cover_url":"","opt_id":1600527802059789,"repost_type":211}
             */

            private ReplyToCommentBean reply_to_comment;
            private String text;
            private int create_time;
            private UserBean user;
            private boolean user_digg;
            private long id;
            private boolean is_owner;
            private int digg_count;
            private String content_rich_span;
            private String content;
            private RepostParamsBean repost_params;
            private ArrayList<ImageList> thumb_image_list;
            private ArrayList<ImageList> large_image_list;
            public ReplyToCommentBean getReply_to_comment() {
                return reply_to_comment;
            }

            public void setReply_to_comment(ReplyToCommentBean reply_to_comment) {
                this.reply_to_comment = reply_to_comment;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public boolean isUser_digg() {
                return user_digg;
            }

            public void setUser_digg(boolean user_digg) {
                this.user_digg = user_digg;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public boolean isIs_owner() {
                return is_owner;
            }

            public void setIs_owner(boolean is_owner) {
                this.is_owner = is_owner;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public String getContent_rich_span() {
                return content_rich_span;
            }

            public void setContent_rich_span(String content_rich_span) {
                this.content_rich_span = content_rich_span;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public RepostParamsBean getRepost_params() {
                return repost_params;
            }

            public void setRepost_params(RepostParamsBean repost_params) {
                this.repost_params = repost_params;
            }

            public ArrayList<ImageList> getThumb_image_list() {
                return thumb_image_list;
            }

            public void setThumb_image_list(ArrayList<ImageList> thumb_image_list) {
                this.thumb_image_list = thumb_image_list;
            }

            public ArrayList<ImageList> getLarge_image_list() {
                return large_image_list;
            }

            public void setLarge_image_list(ArrayList<ImageList> large_image_list) {
                this.large_image_list = large_image_list;
            }

            public static class  ImageList{
                /**
                 * url : http://p1.pstatp.com/list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865.webp
                 * url_list : [{"url":"http://p1.pstatp.com/list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865.webp"},{"url":"http://pb3.pstatp.com/list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865.webp"},{"url":"http://pb3.pstatp.com/list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865.webp"}]
                 * uri : list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865
                 * height : 250
                 * width : 250
                 * IsGIF : true
                 */

                private String url;
                private String uri;
                private int height;
                private int width;
                private boolean IsGIF;
                private List<UrlListBean> url_list;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public boolean isIsGIF() {
                    return IsGIF;
                }

                public void setIsGIF(boolean IsGIF) {
                    this.IsGIF = IsGIF;
                }

                public List<UrlListBean> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBean> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBean {
                    /**
                     * url : http://p1.pstatp.com/list/s250/tos-cn-i-0000/d8c1db969ced44f3aac45fc484902865.webp
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
            public static class ReplyToCommentBean {
                /**
                 * is_followed : null
                 * is_pgc_author : false
                 * is_owner : false
                 * text : 你爸也是区长啊？
                 * content_rich_span :
                 * user_verified : false
                 * verified_reason :
                 * is_following : null
                 * author_badge : []
                 * id : 1599706141843470
                 * user_id : 59379751563
                 * user_name : 一米八的大汉爱撒娇
                 * user_relation : 0
                 * user_auth_info :
                 */

                private Object is_followed;
                private boolean is_pgc_author;
                private boolean is_owner;
                private String text;
                private ArrayList<ImageList> thumb_image_list;
                private ArrayList<ImageList> large_image_list;

                private String content_rich_span;
                private boolean user_verified;
                private String verified_reason;
                private Object is_following;
                private long id;
                private long user_id;
                private String user_name;
                private int user_relation;
                private String user_auth_info;
                private List<?> author_badge;

                public Object getIs_followed() {
                    return is_followed;
                }

                public void setIs_followed(Object is_followed) {
                    this.is_followed = is_followed;
                }

                public boolean isIs_pgc_author() {
                    return is_pgc_author;
                }

                public void setIs_pgc_author(boolean is_pgc_author) {
                    this.is_pgc_author = is_pgc_author;
                }

                public boolean isIs_owner() {
                    return is_owner;
                }

                public void setIs_owner(boolean is_owner) {
                    this.is_owner = is_owner;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getContent_rich_span() {
                    return content_rich_span;
                }

                public void setContent_rich_span(String content_rich_span) {
                    this.content_rich_span = content_rich_span;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public String getVerified_reason() {
                    return verified_reason;
                }

                public void setVerified_reason(String verified_reason) {
                    this.verified_reason = verified_reason;
                }

                public Object getIs_following() {
                    return is_following;
                }

                public void setIs_following(Object is_following) {
                    this.is_following = is_following;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }

                public int getUser_relation() {
                    return user_relation;
                }

                public void setUser_relation(int user_relation) {
                    this.user_relation = user_relation;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public List<?> getAuthor_badge() {
                    return author_badge;
                }

                public void setAuthor_badge(List<?> author_badge) {
                    this.author_badge = author_badge;
                }

                public ArrayList<ImageList> getLarge_image_list() {
                    return large_image_list;
                }

                public void setLarge_image_list(ArrayList<ImageList> large_image_list) {
                    this.large_image_list = large_image_list;
                }

                public ArrayList<ImageList> getThumb_image_list() {
                    return thumb_image_list;
                }

                public void setThumb_image_list(ArrayList<ImageList> thumb_image_list) {
                    this.thumb_image_list = thumb_image_list;
                }
            }

            public static class UserBean {
                /**
                 * is_followed : null
                 * is_blocking : false
                 * is_pgc_author : false
                 * is_blocked : false
                 * user_id : 59406383216
                 * name : 来者即是朋友
                 * author_badge : []
                 * description :
                 * user_relation : 0
                 * verified_reason :
                 * avatar_url : http://p3.pstatp.com/thumb/3e7e001c7de0726fda11
                 * is_following : null
                 * user_decoration : null
                 * user_auth_info :
                 * user_verified : false
                 * screen_name : 来者即是朋友
                 */

                private Object is_followed;
                private boolean is_blocking;
                private boolean is_pgc_author;
                private boolean is_blocked;
                private long user_id;
                private String name;
                private String description;
                private int user_relation;
                private String verified_reason;
                private String avatar_url;
                private Object is_following;
                private Object user_decoration;
                private String user_auth_info;
                private boolean user_verified;
                private String screen_name;
                private List<?> author_badge;

                public Object getIs_followed() {
                    return is_followed;
                }

                public void setIs_followed(Object is_followed) {
                    this.is_followed = is_followed;
                }

                public boolean isIs_blocking() {
                    return is_blocking;
                }

                public void setIs_blocking(boolean is_blocking) {
                    this.is_blocking = is_blocking;
                }

                public boolean isIs_pgc_author() {
                    return is_pgc_author;
                }

                public void setIs_pgc_author(boolean is_pgc_author) {
                    this.is_pgc_author = is_pgc_author;
                }

                public boolean isIs_blocked() {
                    return is_blocked;
                }

                public void setIs_blocked(boolean is_blocked) {
                    this.is_blocked = is_blocked;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getUser_relation() {
                    return user_relation;
                }

                public void setUser_relation(int user_relation) {
                    this.user_relation = user_relation;
                }

                public String getVerified_reason() {
                    return verified_reason;
                }

                public void setVerified_reason(String verified_reason) {
                    this.verified_reason = verified_reason;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public Object getIs_following() {
                    return is_following;
                }

                public void setIs_following(Object is_following) {
                    this.is_following = is_following;
                }

                public Object getUser_decoration() {
                    return user_decoration;
                }

                public void setUser_decoration(Object user_decoration) {
                    this.user_decoration = user_decoration;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public String getScreen_name() {
                    return screen_name;
                }

                public void setScreen_name(String screen_name) {
                    this.screen_name = screen_name;
                }

                public List<?> getAuthor_badge() {
                    return author_badge;
                }

                public void setAuthor_badge(List<?> author_badge) {
                    this.author_badge = author_badge;
                }
            }

            public static class RepostParamsBean {
                /**
                 * opt_id_type : 3
                 * title : 沈腾化身知名创作歌手，竟能给刘德华写歌！
                 * fw_id_type : 4
                 * fw_id : 6538255060583842318
                 * cover_url :
                 * opt_id : 1600527802059789
                 * repost_type : 211
                 */

                private int opt_id_type;
                private String title;
                private int fw_id_type;
                private long fw_id;
                private String cover_url;
                private long opt_id;
                private int repost_type;

                public int getOpt_id_type() {
                    return opt_id_type;
                }

                public void setOpt_id_type(int opt_id_type) {
                    this.opt_id_type = opt_id_type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getFw_id_type() {
                    return fw_id_type;
                }

                public void setFw_id_type(int fw_id_type) {
                    this.fw_id_type = fw_id_type;
                }

                public long getFw_id() {
                    return fw_id;
                }

                public void setFw_id(long fw_id) {
                    this.fw_id = fw_id;
                }

                public String getCover_url() {
                    return cover_url;
                }

                public void setCover_url(String cover_url) {
                    this.cover_url = cover_url;
                }

                public long getOpt_id() {
                    return opt_id;
                }

                public void setOpt_id(long opt_id) {
                    this.opt_id = opt_id;
                }

                public int getRepost_type() {
                    return repost_type;
                }

                public void setRepost_type(int repost_type) {
                    this.repost_type = repost_type;
                }
            }
        }
    }
}
