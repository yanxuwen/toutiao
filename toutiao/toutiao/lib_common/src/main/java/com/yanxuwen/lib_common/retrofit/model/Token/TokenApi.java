package com.yanxuwen.lib_common.retrofit.model.Token;

import com.yanxuwen.lib_common.Bean.Config;
import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Token接口
 * @Description("")尽量设置描述，以便方便查询已经log的打印
 * @HttpType 设置默认的请求类型，如果不设置，则根据ApiManager.initHttpsType设置的默认请求类型
 */
@Description("Token请求")
public interface TokenApi   {
    @value
    public String baseUrl= Config.getInstance().BASE_URL2;
    @value
    final String url="user/verify_token";
    @POST(url)
    public abstract Observable<String> postString(@Body RequestBody description);
    @POST(url)
    public abstract Call<String> postString2(@Body RequestBody description);
}
