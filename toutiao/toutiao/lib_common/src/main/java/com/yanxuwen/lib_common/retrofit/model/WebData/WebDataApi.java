package com.yanxuwen.lib_common.retrofit.model.WebData;

import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/6/1.
 */

public interface WebDataApi {
    @value
    public String baseUrl="https://www.toutiao.com/a6562933408341688839/";
    @value
    final String url=baseUrl;
    @GET("/")
    public abstract Observable<String> onPostman();
}
