package com.yanxuwen.lib_common.retrofit.model.ReplyList;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/30.
 */

@Description("回复列表")
public interface ReplyListApi {
    @value
    final String url="/2/comment/v3/reply_list/?iid=32758433763&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=672&version_name=6.7.2&device_platform=android&ab_version=251132%2C314993%2C359945%2C293032%2C271178%2C357706%2C353151%2C326524%2C326532%2C356608%2C295827%2C353306%2C339378%2C315438%2C239098%2C360541%2C343508%2C170988%2C361290%2C341393%2C362615%2C355579%2C363573%2C349783%2C359526%2C330630%2C297059%2C358952%2C276203%2C286211%2C350193%2C363517%2C320832%2C359409%2C364265%2C277718%2C350408%2C345642%2C363467%2C364280%2C353315%2C363939%2C323233%2C341722%2C358510%2C346557%2C361337%2C319958%2C362512%2C351512%2C345191%2C361541%2C362317%2C362185%2C362908%2C364563%2C343439%2C214069%2C31207%2C338062%2C358598%2C350573%2C358489%2C357056%2C247850%2C280449%2C364349%2C281300%2C364328%2C325615%2C360849%2C354803%2C357402%2C361072%2C288416%2C290195%2C361349%2C353484%2C362582%2C323962%2C358170&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=672&resolution=1080*2030&dpi=440&update_version_code=67209&_rticket=1527666484967&plugin=10603&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v9_8.5.17&ts=1527666484&as=a2059540c483fbc74e6817&mas=00962ad96d24f504601e35ba076a91caf488ea6c0ed2452cd7";
    @GET(url)
    public abstract Observable<String> onPostman(@Query("offset")int offset, @Query("count")int count, @Query("id") String id);
}
