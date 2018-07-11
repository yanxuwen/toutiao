package com.yanxuwen.lib_common.retrofit.model.HTTPS;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.HttpType;
import com.yanxuwen.retrofit.Annotation.value;
import com.yanxuwen.retrofit.api.ApiManager;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 作者：严旭文 on 2017/2/10 17:55
 * 邮箱：420255048@qq.com
 */
@Description("HTTPS请求")
@HttpType(ApiManager.HttpType.HTTPS_SINGLE)
public interface HttpsApi   {
    @value
    public String baseUrl= "https://kyfw.12306.cn/otn/";//特定域名，注意一定要加注解value，且baseUrl要写对
    @GET("/")
    public abstract Observable<String> getString2();
}

