package com.yanxuwen.lib_common.retrofit.model.VideoInfo;

import com.google.gson.annotations.SerializedName;
import com.yanxuwen.lib_common.Utils.DataEncrypt.DataEncrypt;
import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/5/10.
 */
@Description("视频信息")
public class VideoInfo extends MyBaseModel {

    /**
     * video_info : {"data":{"status":10,"user_id":"toutiao","video_id":"8d7ccccc60184da4a659dce91e03b14d","validate":"","enable_ssl":false,"poster_url":"http://p3.pstatp.com/origin/7c82000ff54522145023","video_duration":238.16,"auto_definition":"360p","video_list":{"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":181793,"size":7472147,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"e838468a80d3c01d2d27e226892601cf","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNmY2OThmODg0YzFlMzFmMmZhOGRlYjA2YmFlZGJjNTgvNWFmNDBiNDEvdmlkZW8vbS8yMjAzNTBjNmJlZmFjNjE0NGViYmQzNGM1MGMxMThjNTJmMTExNTY0YmI1MDAwMGNiMTg3NGY2NWQxNi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNWJlZGMyOGNiY2UxNWY5OTNjZTYzNmJkMWNlZTczMy81YWY0MGI0MS92aWRlby9tLzIyMDM1MGM2YmVmYWM2MTQ0ZWJiZDM0YzUwYzExOGM1MmYxMTE1NjRiYjUwMDAwY2IxODc0ZjY1ZDE2Lw==","user_video_proxy":1,"socket_buffer":4090320,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":281807,"size":10449533,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"dc73a826eade9031c5f56553b0baea8b","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGVjMTI5ZWU1MzdjOWZmNmEzOWFiYWQ1ZDNlMWUwOGEvNWFmNDBiNDEvdmlkZW8vbS8yMjBjODljNjE1OGI0OTg0MjM4OTRkZjY0YTlmNGJiNmE5NDExNTY0MGFiMDAwMGMyYWFhMzdkZjAxYy8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jZTE3NjhiMzViZjE1MGZmZjQ1NDBiODE4N2FjNmNhYS81YWY0MGI0MS92aWRlby9tLzIyMGM4OWM2MTU4YjQ5ODQyMzg5NGRmNjRhOWY0YmI2YTk0MTE1NjQwYWIwMDAwYzJhYWEzN2RmMDFjLw==","user_video_proxy":1,"socket_buffer":6340500,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":960,"vheight":540,"bitrate":408876,"size":14232364,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"c9998d24035b28bfe1da7d5d76333f64","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMWIyOGI1YTMwODE2YzhmZGJmNjg5MGQ1YmI2YTgzOTEvNWFmNDBiNDEvdmlkZW8vbS8yMjA5YmFlZTU3NDQzMTM0MWQ5OGVlNWQxMDJlMGVmZDlhZjExNTY4NzEzMDAwMDdmNDVkMjgxMWZmMi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8wYzQ2Y2JlNDBmN2IyOTdjYjM4NjliNjA2ZTUyNzMwMy81YWY0MGI0MS92aWRlby9tLzIyMDliYWVlNTc0NDMxMzQxZDk4ZWU1ZDEwMmUwZWZkOWFmMTE1Njg3MTMwMDAwN2Y0NWQyODExZmYyLw==","user_video_proxy":1,"socket_buffer":9199620,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}},"dynamic_video":null},"message":"success","code":0,"total":3}
     * code : 0
     */

    private VideoInfoBean video_info;
    private int code;

    public VideoInfoBean getVideo_info() {
        return video_info;
    }

    public void setVideo_info(VideoInfoBean video_info) {
        this.video_info = video_info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class VideoInfoBean {
        /**
         * data : {"status":10,"user_id":"toutiao","video_id":"8d7ccccc60184da4a659dce91e03b14d","validate":"","enable_ssl":false,"poster_url":"http://p3.pstatp.com/origin/7c82000ff54522145023","video_duration":238.16,"auto_definition":"360p","video_list":{"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":181793,"size":7472147,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"e838468a80d3c01d2d27e226892601cf","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNmY2OThmODg0YzFlMzFmMmZhOGRlYjA2YmFlZGJjNTgvNWFmNDBiNDEvdmlkZW8vbS8yMjAzNTBjNmJlZmFjNjE0NGViYmQzNGM1MGMxMThjNTJmMTExNTY0YmI1MDAwMGNiMTg3NGY2NWQxNi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNWJlZGMyOGNiY2UxNWY5OTNjZTYzNmJkMWNlZTczMy81YWY0MGI0MS92aWRlby9tLzIyMDM1MGM2YmVmYWM2MTQ0ZWJiZDM0YzUwYzExOGM1MmYxMTE1NjRiYjUwMDAwY2IxODc0ZjY1ZDE2Lw==","user_video_proxy":1,"socket_buffer":4090320,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":281807,"size":10449533,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"dc73a826eade9031c5f56553b0baea8b","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGVjMTI5ZWU1MzdjOWZmNmEzOWFiYWQ1ZDNlMWUwOGEvNWFmNDBiNDEvdmlkZW8vbS8yMjBjODljNjE1OGI0OTg0MjM4OTRkZjY0YTlmNGJiNmE5NDExNTY0MGFiMDAwMGMyYWFhMzdkZjAxYy8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jZTE3NjhiMzViZjE1MGZmZjQ1NDBiODE4N2FjNmNhYS81YWY0MGI0MS92aWRlby9tLzIyMGM4OWM2MTU4YjQ5ODQyMzg5NGRmNjRhOWY0YmI2YTk0MTE1NjQwYWIwMDAwYzJhYWEzN2RmMDFjLw==","user_video_proxy":1,"socket_buffer":6340500,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":960,"vheight":540,"bitrate":408876,"size":14232364,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"c9998d24035b28bfe1da7d5d76333f64","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMWIyOGI1YTMwODE2YzhmZGJmNjg5MGQ1YmI2YTgzOTEvNWFmNDBiNDEvdmlkZW8vbS8yMjA5YmFlZTU3NDQzMTM0MWQ5OGVlNWQxMDJlMGVmZDlhZjExNTY4NzEzMDAwMDdmNDVkMjgxMWZmMi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8wYzQ2Y2JlNDBmN2IyOTdjYjM4NjliNjA2ZTUyNzMwMy81YWY0MGI0MS92aWRlby9tLzIyMDliYWVlNTc0NDMxMzQxZDk4ZWU1ZDEwMmUwZWZkOWFmMTE1Njg3MTMwMDAwN2Y0NWQyODExZmYyLw==","user_video_proxy":1,"socket_buffer":9199620,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}},"dynamic_video":null}
         * message : success
         * code : 0
         * total : 3
         */

        private DataBean data;
        @SerializedName("message")
        private String messageX;
        private int code;
        private int total;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getMessageX() {
            return messageX;
        }

        public void setMessageX(String messageX) {
            this.messageX = messageX;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public static class DataBean {
            /**
             * status : 10
             * user_id : toutiao
             * video_id : 8d7ccccc60184da4a659dce91e03b14d
             * validate :
             * enable_ssl : false
             * poster_url : http://p3.pstatp.com/origin/7c82000ff54522145023
             * video_duration : 238.16
             * auto_definition : 360p
             * video_list : {"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":181793,"size":7472147,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"e838468a80d3c01d2d27e226892601cf","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNmY2OThmODg0YzFlMzFmMmZhOGRlYjA2YmFlZGJjNTgvNWFmNDBiNDEvdmlkZW8vbS8yMjAzNTBjNmJlZmFjNjE0NGViYmQzNGM1MGMxMThjNTJmMTExNTY0YmI1MDAwMGNiMTg3NGY2NWQxNi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNWJlZGMyOGNiY2UxNWY5OTNjZTYzNmJkMWNlZTczMy81YWY0MGI0MS92aWRlby9tLzIyMDM1MGM2YmVmYWM2MTQ0ZWJiZDM0YzUwYzExOGM1MmYxMTE1NjRiYjUwMDAwY2IxODc0ZjY1ZDE2Lw==","user_video_proxy":1,"socket_buffer":4090320,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":281807,"size":10449533,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"dc73a826eade9031c5f56553b0baea8b","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGVjMTI5ZWU1MzdjOWZmNmEzOWFiYWQ1ZDNlMWUwOGEvNWFmNDBiNDEvdmlkZW8vbS8yMjBjODljNjE1OGI0OTg0MjM4OTRkZjY0YTlmNGJiNmE5NDExNTY0MGFiMDAwMGMyYWFhMzdkZjAxYy8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jZTE3NjhiMzViZjE1MGZmZjQ1NDBiODE4N2FjNmNhYS81YWY0MGI0MS92aWRlby9tLzIyMGM4OWM2MTU4YjQ5ODQyMzg5NGRmNjRhOWY0YmI2YTk0MTE1NjQwYWIwMDAwYzJhYWEzN2RmMDFjLw==","user_video_proxy":1,"socket_buffer":6340500,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":960,"vheight":540,"bitrate":408876,"size":14232364,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"c9998d24035b28bfe1da7d5d76333f64","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMWIyOGI1YTMwODE2YzhmZGJmNjg5MGQ1YmI2YTgzOTEvNWFmNDBiNDEvdmlkZW8vbS8yMjA5YmFlZTU3NDQzMTM0MWQ5OGVlNWQxMDJlMGVmZDlhZjExNTY4NzEzMDAwMDdmNDVkMjgxMWZmMi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8wYzQ2Y2JlNDBmN2IyOTdjYjM4NjliNjA2ZTUyNzMwMy81YWY0MGI0MS92aWRlby9tLzIyMDliYWVlNTc0NDMxMzQxZDk4ZWU1ZDEwMmUwZWZkOWFmMTE1Njg3MTMwMDAwN2Y0NWQyODExZmYyLw==","user_video_proxy":1,"socket_buffer":9199620,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}}
             * dynamic_video : null
             */

            @SerializedName("status")
            private int statusX;
            private String user_id;
            private String video_id;
            private String validate;
            private boolean enable_ssl;
            private String poster_url;
            private double video_duration;
            private String auto_definition;
            private VideoListBean video_list;
            private Object dynamic_video;

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public String getValidate() {
                return validate;
            }

            public void setValidate(String validate) {
                this.validate = validate;
            }

            public boolean isEnable_ssl() {
                return enable_ssl;
            }

            public void setEnable_ssl(boolean enable_ssl) {
                this.enable_ssl = enable_ssl;
            }

            public String getPoster_url() {
                return poster_url;
            }

            public void setPoster_url(String poster_url) {
                this.poster_url = poster_url;
            }

            public double getVideo_duration() {
                return video_duration;
            }

            public void setVideo_duration(double video_duration) {
                this.video_duration = video_duration;
            }

            public String getAuto_definition() {
                return auto_definition;
            }

            public void setAuto_definition(String auto_definition) {
                this.auto_definition = auto_definition;
            }

            public VideoListBean getVideo_list() {
                return video_list;
            }

            public void setVideo_list(VideoListBean video_list) {
                this.video_list = video_list;
            }

            public Object getDynamic_video() {
                return dynamic_video;
            }

            public void setDynamic_video(Object dynamic_video) {
                this.dynamic_video = dynamic_video;
            }

            public static class VideoListBean {
                /**
                 * video_1 : {"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":181793,"size":7472147,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"e838468a80d3c01d2d27e226892601cf","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNmY2OThmODg0YzFlMzFmMmZhOGRlYjA2YmFlZGJjNTgvNWFmNDBiNDEvdmlkZW8vbS8yMjAzNTBjNmJlZmFjNjE0NGViYmQzNGM1MGMxMThjNTJmMTExNTY0YmI1MDAwMGNiMTg3NGY2NWQxNi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNWJlZGMyOGNiY2UxNWY5OTNjZTYzNmJkMWNlZTczMy81YWY0MGI0MS92aWRlby9tLzIyMDM1MGM2YmVmYWM2MTQ0ZWJiZDM0YzUwYzExOGM1MmYxMTE1NjRiYjUwMDAwY2IxODc0ZjY1ZDE2Lw==","user_video_proxy":1,"socket_buffer":4090320,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}
                 * video_2 : {"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":281807,"size":10449533,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"dc73a826eade9031c5f56553b0baea8b","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGVjMTI5ZWU1MzdjOWZmNmEzOWFiYWQ1ZDNlMWUwOGEvNWFmNDBiNDEvdmlkZW8vbS8yMjBjODljNjE1OGI0OTg0MjM4OTRkZjY0YTlmNGJiNmE5NDExNTY0MGFiMDAwMGMyYWFhMzdkZjAxYy8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jZTE3NjhiMzViZjE1MGZmZjQ1NDBiODE4N2FjNmNhYS81YWY0MGI0MS92aWRlby9tLzIyMGM4OWM2MTU4YjQ5ODQyMzg5NGRmNjRhOWY0YmI2YTk0MTE1NjQwYWIwMDAwYzJhYWEzN2RmMDFjLw==","user_video_proxy":1,"socket_buffer":6340500,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}
                 * video_3 : {"definition":"720p","vtype":"mp4","vwidth":960,"vheight":540,"bitrate":408876,"size":14232364,"codec_type":"h265","logo_type":"xigua","encrypt":false,"file_hash":"c9998d24035b28bfe1da7d5d76333f64","main_url":"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMWIyOGI1YTMwODE2YzhmZGJmNjg5MGQ1YmI2YTgzOTEvNWFmNDBiNDEvdmlkZW8vbS8yMjA5YmFlZTU3NDQzMTM0MWQ5OGVlNWQxMDJlMGVmZDlhZjExNTY4NzEzMDAwMDdmNDVkMjgxMWZmMi8=","backup_url_1":"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8wYzQ2Y2JlNDBmN2IyOTdjYjM4NjliNjA2ZTUyNzMwMy81YWY0MGI0MS92aWRlby9tLzIyMDliYWVlNTc0NDMxMzQxZDk4ZWU1ZDEwMmUwZWZkOWFmMTE1Njg3MTMwMDAwN2Y0NWQyODExZmYyLw==","user_video_proxy":1,"socket_buffer":9199620,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"spade_a":""}
                 */

                private Video1Bean video_1;
                private Video2Bean video_2;
                private Video3Bean video_3;

                public Video1Bean getVideo_1() {
                    return video_1;
                }

                public void setVideo_1(Video1Bean video_1) {
                    this.video_1 = video_1;
                }

                public Video2Bean getVideo_2() {
                    return video_2;
                }

                public void setVideo_2(Video2Bean video_2) {
                    this.video_2 = video_2;
                }

                public Video3Bean getVideo_3() {
                    return video_3;
                }

                public void setVideo_3(Video3Bean video_3) {
                    this.video_3 = video_3;
                }

                public static class Video1Bean {
                    /**
                     * definition : 360p
                     * vtype : mp4
                     * vwidth : 640
                     * vheight : 360
                     * bitrate : 181793
                     * size : 7472147
                     * codec_type : h265
                     * logo_type : xigua
                     * encrypt : false
                     * file_hash : e838468a80d3c01d2d27e226892601cf
                     * main_url : aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNmY2OThmODg0YzFlMzFmMmZhOGRlYjA2YmFlZGJjNTgvNWFmNDBiNDEvdmlkZW8vbS8yMjAzNTBjNmJlZmFjNjE0NGViYmQzNGM1MGMxMThjNTJmMTExNTY0YmI1MDAwMGNiMTg3NGY2NWQxNi8=
                     * backup_url_1 : aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNWJlZGMyOGNiY2UxNWY5OTNjZTYzNmJkMWNlZTczMy81YWY0MGI0MS92aWRlby9tLzIyMDM1MGM2YmVmYWM2MTQ0ZWJiZDM0YzUwYzExOGM1MmYxMTE1NjRiYjUwMDAwY2IxODc0ZjY1ZDE2Lw==
                     * user_video_proxy : 1
                     * socket_buffer : 4090320
                     * preload_size : 327680
                     * preload_interval : 45
                     * preload_min_step : 5
                     * preload_max_step : 10
                     * spade_a :
                     */

                    private String definition;
                    private String vtype;
                    private int vwidth;
                    private int vheight;
                    private int bitrate;
                    private int size;
                    private String codec_type;
                    private String logo_type;
                    private boolean encrypt;
                    private String file_hash;
                    private String main_url;
                    private String backup_url_1;
                    private int user_video_proxy;
                    private int socket_buffer;
                    private int preload_size;
                    private int preload_interval;
                    private int preload_min_step;
                    private int preload_max_step;
                    private String spade_a;

                    public String getDefinition() {
                        return definition;
                    }

                    public void setDefinition(String definition) {
                        this.definition = definition;
                    }

                    public String getVtype() {
                        return vtype;
                    }

                    public void setVtype(String vtype) {
                        this.vtype = vtype;
                    }

                    public int getVwidth() {
                        return vwidth;
                    }

                    public void setVwidth(int vwidth) {
                        this.vwidth = vwidth;
                    }

                    public int getVheight() {
                        return vheight;
                    }

                    public void setVheight(int vheight) {
                        this.vheight = vheight;
                    }

                    public int getBitrate() {
                        return bitrate;
                    }

                    public void setBitrate(int bitrate) {
                        this.bitrate = bitrate;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public String getCodec_type() {
                        return codec_type;
                    }

                    public void setCodec_type(String codec_type) {
                        this.codec_type = codec_type;
                    }

                    public String getLogo_type() {
                        return logo_type;
                    }

                    public void setLogo_type(String logo_type) {
                        this.logo_type = logo_type;
                    }

                    public boolean isEncrypt() {
                        return encrypt;
                    }

                    public void setEncrypt(boolean encrypt) {
                        this.encrypt = encrypt;
                    }

                    public String getFile_hash() {
                        return file_hash;
                    }

                    public void setFile_hash(String file_hash) {
                        this.file_hash = file_hash;
                    }

                    public String getMain_url() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(main_url);
                    }

                    public void setMain_url(String main_url) {
                        this.main_url = main_url;
                    }

                    public String getBackup_url_1() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(backup_url_1);
                    }

                    public void setBackup_url_1(String backup_url_1) {
                        this.backup_url_1 = backup_url_1;
                    }

                    public int getUser_video_proxy() {
                        return user_video_proxy;
                    }

                    public void setUser_video_proxy(int user_video_proxy) {
                        this.user_video_proxy = user_video_proxy;
                    }

                    public int getSocket_buffer() {
                        return socket_buffer;
                    }

                    public void setSocket_buffer(int socket_buffer) {
                        this.socket_buffer = socket_buffer;
                    }

                    public int getPreload_size() {
                        return preload_size;
                    }

                    public void setPreload_size(int preload_size) {
                        this.preload_size = preload_size;
                    }

                    public int getPreload_interval() {
                        return preload_interval;
                    }

                    public void setPreload_interval(int preload_interval) {
                        this.preload_interval = preload_interval;
                    }

                    public int getPreload_min_step() {
                        return preload_min_step;
                    }

                    public void setPreload_min_step(int preload_min_step) {
                        this.preload_min_step = preload_min_step;
                    }

                    public int getPreload_max_step() {
                        return preload_max_step;
                    }

                    public void setPreload_max_step(int preload_max_step) {
                        this.preload_max_step = preload_max_step;
                    }

                    public String getSpade_a() {
                        return spade_a;
                    }

                    public void setSpade_a(String spade_a) {
                        this.spade_a = spade_a;
                    }
                }

                public static class Video2Bean {
                    /**
                     * definition : 480p
                     * vtype : mp4
                     * vwidth : 854
                     * vheight : 480
                     * bitrate : 281807
                     * size : 10449533
                     * codec_type : h265
                     * logo_type : xigua
                     * encrypt : false
                     * file_hash : dc73a826eade9031c5f56553b0baea8b
                     * main_url : aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGVjMTI5ZWU1MzdjOWZmNmEzOWFiYWQ1ZDNlMWUwOGEvNWFmNDBiNDEvdmlkZW8vbS8yMjBjODljNjE1OGI0OTg0MjM4OTRkZjY0YTlmNGJiNmE5NDExNTY0MGFiMDAwMGMyYWFhMzdkZjAxYy8=
                     * backup_url_1 : aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jZTE3NjhiMzViZjE1MGZmZjQ1NDBiODE4N2FjNmNhYS81YWY0MGI0MS92aWRlby9tLzIyMGM4OWM2MTU4YjQ5ODQyMzg5NGRmNjRhOWY0YmI2YTk0MTE1NjQwYWIwMDAwYzJhYWEzN2RmMDFjLw==
                     * user_video_proxy : 1
                     * socket_buffer : 6340500
                     * preload_size : 327680
                     * preload_interval : 45
                     * preload_min_step : 5
                     * preload_max_step : 10
                     * spade_a :
                     */

                    private String definition;
                    private String vtype;
                    private int vwidth;
                    private int vheight;
                    private int bitrate;
                    private int size;
                    private String codec_type;
                    private String logo_type;
                    private boolean encrypt;
                    private String file_hash;
                    private String main_url;
                    private String backup_url_1;
                    private int user_video_proxy;
                    private int socket_buffer;
                    private int preload_size;
                    private int preload_interval;
                    private int preload_min_step;
                    private int preload_max_step;
                    private String spade_a;

                    public String getDefinition() {
                        return definition;
                    }

                    public void setDefinition(String definition) {
                        this.definition = definition;
                    }

                    public String getVtype() {
                        return vtype;
                    }

                    public void setVtype(String vtype) {
                        this.vtype = vtype;
                    }

                    public int getVwidth() {
                        return vwidth;
                    }

                    public void setVwidth(int vwidth) {
                        this.vwidth = vwidth;
                    }

                    public int getVheight() {
                        return vheight;
                    }

                    public void setVheight(int vheight) {
                        this.vheight = vheight;
                    }

                    public int getBitrate() {
                        return bitrate;
                    }

                    public void setBitrate(int bitrate) {
                        this.bitrate = bitrate;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public String getCodec_type() {
                        return codec_type;
                    }

                    public void setCodec_type(String codec_type) {
                        this.codec_type = codec_type;
                    }

                    public String getLogo_type() {
                        return logo_type;
                    }

                    public void setLogo_type(String logo_type) {
                        this.logo_type = logo_type;
                    }

                    public boolean isEncrypt() {
                        return encrypt;
                    }

                    public void setEncrypt(boolean encrypt) {
                        this.encrypt = encrypt;
                    }

                    public String getFile_hash() {
                        return file_hash;
                    }

                    public void setFile_hash(String file_hash) {
                        this.file_hash = file_hash;
                    }

                    public String getMain_url() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(main_url);
                    }

                    public void setMain_url(String main_url) {
                        this.main_url = main_url;
                    }

                    public String getBackup_url_1() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(backup_url_1);
                    }

                    public void setBackup_url_1(String backup_url_1) {
                        this.backup_url_1 = backup_url_1;
                    }

                    public int getUser_video_proxy() {
                        return user_video_proxy;
                    }

                    public void setUser_video_proxy(int user_video_proxy) {
                        this.user_video_proxy = user_video_proxy;
                    }

                    public int getSocket_buffer() {
                        return socket_buffer;
                    }

                    public void setSocket_buffer(int socket_buffer) {
                        this.socket_buffer = socket_buffer;
                    }

                    public int getPreload_size() {
                        return preload_size;
                    }

                    public void setPreload_size(int preload_size) {
                        this.preload_size = preload_size;
                    }

                    public int getPreload_interval() {
                        return preload_interval;
                    }

                    public void setPreload_interval(int preload_interval) {
                        this.preload_interval = preload_interval;
                    }

                    public int getPreload_min_step() {
                        return preload_min_step;
                    }

                    public void setPreload_min_step(int preload_min_step) {
                        this.preload_min_step = preload_min_step;
                    }

                    public int getPreload_max_step() {
                        return preload_max_step;
                    }

                    public void setPreload_max_step(int preload_max_step) {
                        this.preload_max_step = preload_max_step;
                    }

                    public String getSpade_a() {
                        return spade_a;
                    }

                    public void setSpade_a(String spade_a) {
                        this.spade_a = spade_a;
                    }
                }

                public static class Video3Bean {
                    /**
                     * definition : 720p
                     * vtype : mp4
                     * vwidth : 960
                     * vheight : 540
                     * bitrate : 408876
                     * size : 14232364
                     * codec_type : h265
                     * logo_type : xigua
                     * encrypt : false
                     * file_hash : c9998d24035b28bfe1da7d5d76333f64
                     * main_url : aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMWIyOGI1YTMwODE2YzhmZGJmNjg5MGQ1YmI2YTgzOTEvNWFmNDBiNDEvdmlkZW8vbS8yMjA5YmFlZTU3NDQzMTM0MWQ5OGVlNWQxMDJlMGVmZDlhZjExNTY4NzEzMDAwMDdmNDVkMjgxMWZmMi8=
                     * backup_url_1 : aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8wYzQ2Y2JlNDBmN2IyOTdjYjM4NjliNjA2ZTUyNzMwMy81YWY0MGI0MS92aWRlby9tLzIyMDliYWVlNTc0NDMxMzQxZDk4ZWU1ZDEwMmUwZWZkOWFmMTE1Njg3MTMwMDAwN2Y0NWQyODExZmYyLw==
                     * user_video_proxy : 1
                     * socket_buffer : 9199620
                     * preload_size : 327680
                     * preload_interval : 45
                     * preload_min_step : 5
                     * preload_max_step : 10
                     * spade_a :
                     */

                    private String definition;
                    private String vtype;
                    private int vwidth;
                    private int vheight;
                    private int bitrate;
                    private int size;
                    private String codec_type;
                    private String logo_type;
                    private boolean encrypt;
                    private String file_hash;
                    private String main_url;
                    private String backup_url_1;
                    private int user_video_proxy;
                    private int socket_buffer;
                    private int preload_size;
                    private int preload_interval;
                    private int preload_min_step;
                    private int preload_max_step;
                    private String spade_a;

                    public String getDefinition() {
                        return definition;
                    }

                    public void setDefinition(String definition) {
                        this.definition = definition;
                    }

                    public String getVtype() {
                        return vtype;
                    }

                    public void setVtype(String vtype) {
                        this.vtype = vtype;
                    }

                    public int getVwidth() {
                        return vwidth;
                    }

                    public void setVwidth(int vwidth) {
                        this.vwidth = vwidth;
                    }

                    public int getVheight() {
                        return vheight;
                    }

                    public void setVheight(int vheight) {
                        this.vheight = vheight;
                    }

                    public int getBitrate() {
                        return bitrate;
                    }

                    public void setBitrate(int bitrate) {
                        this.bitrate = bitrate;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }

                    public String getCodec_type() {
                        return codec_type;
                    }

                    public void setCodec_type(String codec_type) {
                        this.codec_type = codec_type;
                    }

                    public String getLogo_type() {
                        return logo_type;
                    }

                    public void setLogo_type(String logo_type) {
                        this.logo_type = logo_type;
                    }

                    public boolean isEncrypt() {
                        return encrypt;
                    }

                    public void setEncrypt(boolean encrypt) {
                        this.encrypt = encrypt;
                    }

                    public String getFile_hash() {
                        return file_hash;
                    }

                    public void setFile_hash(String file_hash) {
                        this.file_hash = file_hash;
                    }

                    public String getMain_url() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(main_url);
                    }

                    public void setMain_url(String main_url) {
                        this.main_url = main_url;
                    }

                    public String getBackup_url_1() {
                        //使用Base64位解密
                        return DataEncrypt.Base64ToString(backup_url_1);
                    }

                    public void setBackup_url_1(String backup_url_1) {
                        this.backup_url_1 = backup_url_1;
                    }

                    public int getUser_video_proxy() {
                        return user_video_proxy;
                    }

                    public void setUser_video_proxy(int user_video_proxy) {
                        this.user_video_proxy = user_video_proxy;
                    }

                    public int getSocket_buffer() {
                        return socket_buffer;
                    }

                    public void setSocket_buffer(int socket_buffer) {
                        this.socket_buffer = socket_buffer;
                    }

                    public int getPreload_size() {
                        return preload_size;
                    }

                    public void setPreload_size(int preload_size) {
                        this.preload_size = preload_size;
                    }

                    public int getPreload_interval() {
                        return preload_interval;
                    }

                    public void setPreload_interval(int preload_interval) {
                        this.preload_interval = preload_interval;
                    }

                    public int getPreload_min_step() {
                        return preload_min_step;
                    }

                    public void setPreload_min_step(int preload_min_step) {
                        this.preload_min_step = preload_min_step;
                    }

                    public int getPreload_max_step() {
                        return preload_max_step;
                    }

                    public void setPreload_max_step(int preload_max_step) {
                        this.preload_max_step = preload_max_step;
                    }

                    public String getSpade_a() {
                        return spade_a;
                    }

                    public void setSpade_a(String spade_a) {
                        this.spade_a = spade_a;
                    }
                }
            }
        }
    }
}
