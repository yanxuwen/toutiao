package com.yanxuwen.lib_common.retrofit.model.VideoRecommend;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/10.
 */

@Description("视频推荐")
public interface VideoRecommendApi {
    @value
    final String url ="2/article/information/v24/?aggr_type=1&context=1&flags=64&from_category=video&article_page=1&iid=32758433763&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=672&version_name=6.7.2&device_platform=android&ab_version=251132%2C314993%2C293032%2C271178%2C357706%2C353151%2C326524%2C326532%2C356608%2C295827%2C353306%2C339378%2C315438%2C239098%2C343508%2C170988%2C356839%2C341393%2C325200%2C355579%2C350902%2C349783%2C359526%2C330630%2C297059%2C358952%2C276203%2C286211%2C350193%2C338065%2C320832%2C359409%2C277718%2C350408%2C345642%2C353700%2C357530%2C353315%2C323233%2C341722%2C358510%2C346557%2C319958%2C344869%2C351512%2C345191%2C353567%2C350255%2C343439%2C214069%2C31207%2C351790%2C358598%2C350573%2C357056%2C247850%2C280449%2C281300%2C328218%2C325615%2C354803%2C357402%2C354996%2C288416%2C290195%2C353484%2C351836%2C353563%2C323962%2C358170&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=672&resolution=1080*2030&dpi=440&update_version_code=67209&_rticket=1527155941762&plugin=10603&pos=5r_88Pzt3vTp5L-nv3gTO3QKNXglH7-xv_zw_O3R8vP69Ono-fi_p6yspbOsqq6ppayxv_zw_O3R_On06ej5-L-nr6mzqaqtq6-r4A%3D%3D&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v9_8.5.17&ts=1527155941&as=a2d5584075be5bacc65761&mas=00b91a3a6687473098804540af8fd3c859a6a208622eaa42a5";
    @GET(url)
    public abstract Observable<String> onPostman(@Query("group_id") String group_id, @Query("item_id") String item_id);
}
