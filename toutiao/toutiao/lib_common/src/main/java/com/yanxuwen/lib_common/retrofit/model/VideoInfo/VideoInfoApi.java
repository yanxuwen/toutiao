package com.yanxuwen.lib_common.retrofit.model.VideoInfo;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yanxuwen on 2018/5/10.
 */

@Description("视频信息")
public interface VideoInfoApi {
    //1525939266 时间戳
    @value
    final String url = "video/play/1/toutiao/1525939266/b6984ca9a18a91ffd3b7e17d4f3049ec/mp4/{video_id}?play_type=1&category=video&player_version=2.8.1.177&wifi_identify=2f99e6386585dc9db1c2baeae7f97ef2&codec_type=1&device_type=MIX+2S&iid=31987580677&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=670&version_name=6.7.0&device_platform=android&ab_version=251132%2C314993%2C293032%2C337371%2C271178%2C345487%2C326591%2C326524%2C326532%2C336927%2C295827%2C339378%2C315438%2C239098%2C345297%2C343508%2C170988%2C343820%2C336121%2C341393%2C325200%2C331423%2C344837%2C265179%2C341136%2C330630%2C297059%2C345286%2C276203%2C286211%2C313219%2C338065%2C341522%2C320832%2C343625%2C333437%2C310595%2C331503%2C322321%2C342418%2C324209%2C339206%2C342253%2C342261%2C339352%2C323233%2C328672%2C341722%2C317076%2C280773%2C340664%2C319958%2C344869%2C345191%2C338246%2C337089%2C343439%2C214069%2C31207%2C344607%2C344652%2C340805%2C339076%2C247850%2C280449%2C341657%2C281300%2C328218%2C322099%2C325615%2C330455%2C336198%2C335863%2C340567%2C288416%2C290195%2C326187%2C339901%2C323962%2C345202&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=670&resolution=1080*2030&dpi=440&update_version_code=67006&_rticket=1525939266112&plugin=10603&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v9_8.5.4&ts=1525939266&as=a2555f8f92643a4c533847&mas=0050cc01ce2833fd48de3f8f391d8864b00cc80e08d8e526f6";

    @GET(url)
    public abstract Observable<String> onPostman(@Path("video_id") String video_id, @Query("item_id")String item_id);
}
