package com.yanxuwen.lib_common.retrofit.model.NewsList;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

@Description("新闻列表")
public interface NewsListApi  {
    @value
    final String url="api/news/feed/v82/?refer=1&last_refresh_sub_entrance_interval=7795&loc_mode=0&plugin_enable=3&iid=30852277705&device_id=11328744622&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=666&version_name=6.6.6&device_platform=android&ab_version=304489%2C293033%2C325312%2C333792%2C297977%2C317498%2C295827%2C325048%2C239096%2C324283%2C170988%2C170989%2C325960%2C332078%2C325198%2C329298%2C281391%2C330633%2C297059%2C276206%2C286212%2C313219%2C328613%2C332039%2C334271%2C310595%2C329358%2C277718%2C322322%2C327534%2C328880%2C332561%2C333882%2C323233%2C328672%2C334397%2C324008%2C317076%2C280773%2C330107%2C319959%2C317210%2C331719%2C214069%2C333188%2C333968%2C332131%2C333887%2C333872%2C258356%2C247848%2C280449%2C281295%2C328218%2C322099%2C325617%2C333328%2C324095%2C334251%2C323427%2C327912%2C288417%2C290197%2C260648%2C333700%2C326194%2C327180%2C271178%2C326590%2C326524%2C326532&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_group=100170&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=vivo+X6D&device_brand=vivo&language=zh&os_api=22&os_version=5.1&uuid=860443037330777&openudid=1997060bf283658c&manifest_version_code=666&resolution=1080*1920&dpi=480&update_version_code=66611&_rticket=1524734891547&plugin=10607&fp=LrTqPlweJYwOFlGWcrU1FYwIcSme&rom_version=funtouch+os_2.5_pd1415d_a_1.21.0&ts=1524734891&as=a2d5a9fecbeaaacb216458&mas=00008ef9c752ba76e55e0aa7e637620edc222040ace266de8d&cp=57a3e31798babq1";
    @GET(url)
    public abstract Observable<String> onPostmanRefresh(@Query("tt_from")String tt_from,@Query("refresh_reason")int refresh_reason,@Query("session_refresh_idx")int session_refresh_idx,
                                                 @Query("count")int count,@Query("list_count")int list_count,@Query("category")String category,@Query("min_behot_time")String min_behot_time);

    @value
    final String url2="api/news/feed/v82/?refer=1&last_refresh_sub_entrance_interval=7795&loc_mode=0&plugin_enable=3&iid=30852277705&device_id=11328744622&ac=wifi&channel=update&aid=13&app_name=news_article&version_code=666&version_name=6.6.6&device_platform=android&ab_version=304489%2C293033%2C325312%2C333792%2C297977%2C317498%2C295827%2C325048%2C239096%2C324283%2C170988%2C170989%2C325960%2C332078%2C325198%2C329298%2C281391%2C330633%2C297059%2C276206%2C286212%2C313219%2C328613%2C332039%2C334271%2C310595%2C329358%2C277718%2C322322%2C327534%2C328880%2C332561%2C333882%2C323233%2C328672%2C334397%2C324008%2C317076%2C280773%2C330107%2C319959%2C317210%2C331719%2C214069%2C333188%2C333968%2C332131%2C333887%2C333872%2C258356%2C247848%2C280449%2C281295%2C328218%2C322099%2C325617%2C333328%2C324095%2C334251%2C323427%2C327912%2C288417%2C290197%2C260648%2C333700%2C326194%2C327180%2C271178%2C326590%2C326524%2C326532&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7&ab_group=100170&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=vivo+X6D&device_brand=vivo&language=zh&os_api=22&os_version=5.1&uuid=860443037330777&openudid=1997060bf283658c&manifest_version_code=666&resolution=1080*1920&dpi=480&update_version_code=66611&_rticket=1524734891547&plugin=10607&fp=LrTqPlweJYwOFlGWcrU1FYwIcSme&rom_version=funtouch+os_2.5_pd1415d_a_1.21.0&ts=1524734891&as=a2d5a9fecbeaaacb216458&mas=00008ef9c752ba76e55e0aa7e637620edc222040ace266de8d&cp=57a3e31798babq1";
    @GET(url2)
    public abstract Observable<String> onPostmanLoad(@Query("tt_from")String tt_from  ,
                                                 @Query("count")int count,@Query("list_count")int list_count,@Query("category")String category,@Query("max_behot_time")String max_behot_time);

    @GET(url)
    public abstract Observable<String> onPostmanRefreshRecommend(@Query("tt_from")String tt_from,@Query("refresh_reason")int refresh_reason,@Query("session_refresh_idx")int session_refresh_idx,
                                                        @Query("count")int count,@Query("list_count")int list_count,@Query("min_behot_time")String min_behot_time);

    @GET(url2)
    public abstract Observable<String> onPostmanLoadRecommend(@Query("tt_from")String tt_from  ,
                                                     @Query("count")int count,@Query("list_count")int list_count,@Query("max_behot_time")String max_behot_time);
}
