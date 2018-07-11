package com.yanxuwen.lib_common.retrofit.model.Version;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 作者：严旭文 on 2016/7/4.
 * 邮箱：420255048@qq.com
 * 更新接口，由于更新接口需要加密，暂时不能加密，则请求报错
 * //@Description("")尽量设置描述，以便方便查询已经log的打印
 */
@Description("版本检测")
public interface VersionApi  {
    @value
    final String url="version/latest";
    @POST(url)
    public abstract Observable<String> postString(@Body RequestBody description);
    @POST(url)
    public abstract Call<String> postString2(@Body RequestBody description);
}
