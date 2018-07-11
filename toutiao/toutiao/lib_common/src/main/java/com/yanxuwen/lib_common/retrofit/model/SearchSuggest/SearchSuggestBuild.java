package com.yanxuwen.lib_common.retrofit.model.SearchSuggest;

import android.content.Context;

import com.yanxuwen.lib_common.retrofit.MyBaseRequest;
import com.yanxuwen.retrofit.Annotation.Description;

/**
 * Created by yanxuwen on 2018/7/4.
 */
@Description("搜索建议")
public class SearchSuggestBuild extends MyBaseRequest {
    /**
     * suggest_word : {"from":"feed","sug_category":"news_hot"}
     */
    private String suggest_params;
    private int recom_cnt;
    /**
     * suggest_word : {"suggest_word":{"from":"feed","sug_category":"news_hot"}}
     */


    public String getSuggest_params() {
        return suggest_params;
    }

    public void setSuggest_params(String suggest_params) {
        this.suggest_params =suggest_params;
    }

    public int getRecom_cnt() {
        return recom_cnt;
    }

    public void setRecom_cnt(int recom_cnt) {
        this.recom_cnt = recom_cnt;
    }
    public SearchSuggestBuild(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    private SuggestWordBeanX suggest_word;

    public SuggestWordBeanX getSuggest_word() {
        return suggest_word;
    }

    public void setSuggest_word(SuggestWordBeanX suggest_word) {
        this.suggest_word = suggest_word;
    }

    public static class SuggestWordBeanX {
        /**
         * suggest_word : {"from":"feed","sug_category":"news_hot"}
         */

        private SuggestWordBean suggest_word;

        public SuggestWordBean getSuggest_word() {
            return suggest_word;
        }

        public void setSuggest_word(SuggestWordBean suggest_word) {
            this.suggest_word = suggest_word;
        }

        public static class SuggestWordBean {
            /**
             * from : feed
             * sug_category : news_hot
             */

            private String from;
            private String sug_category;

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getSug_category() {
                return sug_category;
            }

            public void setSug_category(String sug_category) {
                this.sug_category = sug_category;
            }
        }
    }
}
