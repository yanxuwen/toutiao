package com.yanxuwen.lib_common.retrofit.model.SearchSuggest;


import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/29.
 */
@Description("搜索建议")
public interface SearchSuggestApi {
    @value
    final String url="https://is.snssdk.com/search/suggest/homepage_suggest/?iid=36853889122&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=678&version_name=6.7.8&device_platform=android&ab_version=251132,261581,383832,374618,378196,293032,398420,398546,271178,357706,326524,326532,398608,295827,392668,398477,385982,239098,170988,397676,397291,386293,374117,395347,392453,330630,297059,386973,276203,350193,394653,320832,379688,367077,391250,277718,350408,395306,386343,389398,381406,385745,369501,369164,393861,373124,385725,376443,396499,385962,378450,392717,384082,395879,323233,391816,392656,346557,351091,390939,345191,398083,387371,396166,397386,31207,396897,398458,396184,388527,280449,281300,389221,325615,397515,357402,380768,386888,382678,361349,398430,396154,376994,393020&ab_client=a1,c4,e1,f1,g2,f7&ab_feature=94563,102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=678&resolution=1080*2030&dpi=440&update_version_code=67807&_rticket=1530683554430&plugin=10603&pos=5r_88Pzt3vTp5L-nv3gTO3QKNXglH7-xv_zw_O3R8vP69Ono-fi_p6yspbOsqqWkqqmxv_zw_O3R_On06ej5-L-nr6mzqaSvqq2u4A==&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v10_8.7.2&ts=1530683554&as=a215d673524adb003c0668&mas=00d050588b9d054c92cf228f2c8b970256c4040268a4a2d2ea";
    @GET(url)
    public abstract Observable<String> onPostman(@Query("suggest_params")String suggest_params,@Query("recom_cnt")int recom_cnt);
}
