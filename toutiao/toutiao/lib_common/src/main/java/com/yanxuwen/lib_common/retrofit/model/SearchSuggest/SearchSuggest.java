package com.yanxuwen.lib_common.retrofit.model.SearchSuggest;

import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.retrofit.Annotation.Description;

import java.util.List;

/**
 * Created by yanxuwen on 2018/7/4.
 */
@Description("搜索建议")
public class SearchSuggest extends MyBaseModel {

    /**
     * data : {"call_per_refresh":1,"homepage_search_suggest":"手机壁纸 | 小熊猫表情包 | 繁衍后代","suggest_words":[{"id":0,"word":"手机壁纸"},{"id":0,"word":"小熊猫表情包"},{"id":0,"word":"繁衍后代"}]}
     * message : success
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }
    public static class DataBean {
        /**
         * call_per_refresh : 1
         * homepage_search_suggest : 手机壁纸 | 小熊猫表情包 | 繁衍后代
         * suggest_words : [{"id":0,"word":"手机壁纸"},{"id":0,"word":"小熊猫表情包"},{"id":0,"word":"繁衍后代"}]
         */

        private int call_per_refresh;
        private String homepage_search_suggest;
        private List<SuggestWordsBean> suggest_words;

        public int getCall_per_refresh() {
            return call_per_refresh;
        }

        public void setCall_per_refresh(int call_per_refresh) {
            this.call_per_refresh = call_per_refresh;
        }

        public String getHomepage_search_suggest() {
            return homepage_search_suggest;
        }

        public void setHomepage_search_suggest(String homepage_search_suggest) {
            this.homepage_search_suggest = homepage_search_suggest;
        }

        public List<SuggestWordsBean> getSuggest_words() {
            return suggest_words;
        }

        public void setSuggest_words(List<SuggestWordsBean> suggest_words) {
            this.suggest_words = suggest_words;
        }

        public static class SuggestWordsBean {
            /**
             * id : 0
             * word : 手机壁纸
             */

            private int id;
            private String word;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }
        }
    }
}
