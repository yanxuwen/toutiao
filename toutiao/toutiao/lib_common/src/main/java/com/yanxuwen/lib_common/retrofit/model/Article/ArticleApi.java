package com.yanxuwen.lib_common.retrofit.model.Article;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/6/6.
 */
@Description("获取html代码片段")
public interface ArticleApi {
    @value
    public String baseUrl= "https://a3.pstatp.com/";
    @value
    final String url="/article/content/21/1/{id}/{id2}/1/0/?iid=34623462137&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=675&version_name=6.7.5&device_platform=android&ab_version=251132%2C261581%2C367052%2C360500%2C293032%2C369111%2C367259%2C271178%2C357706%2C326524%2C326532%2C370373%2C295827%2C353306%2C368535%2C239098%2C360541%2C343508%2C170988%2C368831%2C368829%2C366065%2C341393%2C365856%2C365055%2C363573%2C368303%2C367790%2C330630%2C297059%2C358952%2C276203%2C286211%2C350193%2C365026%2C320832%2C359409%2C367077%2C277718%2C350408%2C367178%2C364453%2C364280%2C369501%2C369164%2C368839%2C368936%2C369662%2C366036%2C370650%2C323233%2C341722%2C346557%2C351091%2C319958%2C369784%2C345191%2C362185%2C362908%2C365959%2C214069%2C31207%2C338062%2C366871%2C350573%2C366766%2C280449%2C281300%2C368509%2C325615%2C360849%2C354803%2C357402%2C361072%2C288416%2C370021%2C290195%2C361349%2C370014%2C353484%2C323962%2C370270%2C369906&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=675&resolution=1080*2030&dpi=440&update_version_code=67505&_rticket=1528250234078&plugin=10603&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v10_8.6.5&ts=1528250234&as=a2f553017ad72b8fe73707&mas=00ba32ef68a4810c6bb21bc1c739defc97afc88e0a28ca2433";
    @POST(url)
    public abstract Observable<String> postString(@Path("id") String id,@Path("id2") String id2);
}
