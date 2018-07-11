package com.yanxuwen.lib_common.retrofit.model.Category;


import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/29.
 */
@Description("分类")
public interface CategoryApi {
    @value
    final String url="/article/category/get_subscribed/v4/?iid=36853889122&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=678&version_name=6.7.8&device_platform=android&ab_version=251132%2C261581%2C383832%2C374618%2C378196%2C293032%2C398420%2C398546%2C271178%2C357706%2C326524%2C326532%2C398608%2C295827%2C392668%2C398477%2C385982%2C239098%2C170988%2C397676%2C397291%2C386293%2C374117%2C395347%2C392453%2C330630%2C297059%2C386973%2C276203%2C350193%2C394653%2C320832%2C379688%2C367077%2C391250%2C277718%2C350408%2C395306%2C386343%2C389398%2C381406%2C385745%2C369501%2C369164%2C393861%2C373124%2C385725%2C376443%2C396499%2C385962%2C378450%2C392717%2C384082%2C395879%2C323233%2C391816%2C392656%2C346557%2C351091%2C390939%2C345191%2C398083%2C387371%2C396166%2C397386%2C31207%2C396897%2C398458%2C396184%2C388527%2C280449%2C281300%2C389221%2C325615%2C397515%2C357402%2C380768%2C386888%2C382678%2C361349%2C398430%2C396154%2C376994%2C393020&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=678&resolution=1080*2030&dpi=440&update_version_code=67807&plugin=10603&pos=5r_88Pzt3vTp5L-nv3gTO3QKNXglH7-xv_zw_O3R8vP69Ono-fi_p6yspbOsqqWkqqmxv_zw_O3R_On06ej5-L-nr6mzqaSvqq2u4A%3D%3D&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v10_8.7.2&as=a24585035ccadbe9fc7456&mas=00e9060068ff0f0f8c18bb655fb4b44cf8fea7a888ea66aeb1";
    @GET(url)
    public abstract Observable<String> onPostman(@Query("_rticket")long _rticket, @Query("ts")long ts);//_rticket毫秒，ts秒
}
