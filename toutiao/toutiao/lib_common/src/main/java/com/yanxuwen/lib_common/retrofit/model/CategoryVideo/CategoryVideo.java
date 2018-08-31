package com.yanxuwen.lib_common.retrofit.model.CategoryVideo;

import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.retrofit.Annotation.Description;

import java.util.List;

/**
 * Created by yanxuwen on 2018/7/4.
 */
@Description("视频分类")
public class CategoryVideo extends MyBaseModel {
    /**
     * data : [{"category":"关注","category_type":0,"flags":0,"icon_url":"","name":"关注","tip_new":0,"type":4,"web_url":""},{"category":"subv_voice","category_type":0,"flags":0,"icon_url":"","name":"音乐","tip_new":0,"type":4,"web_url":""},{"category":"subv_movie","category_type":0,"flags":0,"icon_url":"","name":"影视","tip_new":0,"type":4,"web_url":""},{"category":"subv_video_world_cup_new","category_type":0,"flags":0,"icon_url":"","name":"世界杯","tip_new":0,"type":4,"web_url":""},{"category":"subv_society","category_type":0,"flags":0,"icon_url":"","name":"社会","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_agriculture","category_type":0,"flags":0,"icon_url":"","name":"农人","tip_new":0,"type":4,"web_url":""},{"category":"subv_game","category_type":0,"flags":0,"icon_url":"","name":"游戏","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_food","category_type":0,"flags":0,"icon_url":"","name":"美食","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_child","category_type":0,"flags":0,"icon_url":"","name":"儿童","tip_new":0,"type":4,"web_url":""},{"category":"subv_life","category_type":0,"flags":0,"icon_url":"","name":"生活","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_sports","category_type":0,"flags":0,"icon_url":"","name":"体育","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_car","category_type":0,"flags":0,"icon_url":"","name":"懂车帝","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_culture","category_type":0,"flags":0,"icon_url":"","name":"文化","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_fashion","category_type":0,"flags":0,"icon_url":"","name":"时尚","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_tech","category_type":0,"flags":0,"icon_url":"","name":"科技","tip_new":0,"type":4,"web_url":""},{"category":"subv_tt_video_squaredance","category_type":0,"flags":0,"icon_url":"","name":"广场舞","tip_new":0,"type":4,"web_url":""},{"category":"subv_jmj","category_type":0,"flags":0,"icon_url":"","name":"金秒奖","tip_new":0,"type":4,"web_url":""}]
     * message : success
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * category : 关注
         * category_type : 0
         * flags : 0
         * icon_url :
         * name : 关注
         * tip_new : 0
         * type : 4
         * web_url :
         */

        private String category;
        private int category_type;
        private int flags;
        private String icon_url;
        private String name;
        private int tip_new;
        private int type;
        private String web_url;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getCategory_type() {
            return category_type;
        }

        public void setCategory_type(int category_type) {
            this.category_type = category_type;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTip_new() {
            return tip_new;
        }

        public void setTip_new(int tip_new) {
            this.tip_new = tip_new;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
