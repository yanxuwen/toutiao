package com.yanxuwen.lib_common.retrofit.model.NewsList;

import com.yanxuwen.retrofit.Annotation.Description;
import com.yanxuwen.retrofit.Annotation.value;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

@Description("新闻列表")
public interface NewsListApi  {
    @value
    final String url="api/news/feed/v88/?support_rn=4&refer=1&list_entrance=main_tab&last_refresh_sub_entrance_interval=1535706597&loc_mode=0&loc_time=1534468829&latitude=24.494147674827158&longitude=118.19091326586596&city=%E5%8E%A6%E9%97%A8%E5%B8%82&lac=302&cid=11889&plugin_enable=3&iid=41004251804&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=685&version_name=6.8.5&device_platform=android&ab_version=484806%2C345191%2C472973%2C484745%2C377631%2C454982%2C482808%2C424606%2C479486%2C455644%2C449327%2C458725%2C424176%2C214069%2C482577%2C443793%2C442255%2C478956%2C480317%2C481984%2C280448%2C281295%2C482252%2C325617%2C482555%2C481567%2C386891%2C431144%2C485061%2C467515%2C252782%2C470727%2C444465%2C454354%2C469373%2C468378%2C477134%2C425537%2C483197%2C391820%2C443357%2C479281%2C442427%2C480751%2C467899%2C484677%2C239095%2C478797%2C170988%2C465102%2C480872%2C442120%2C374119%2C478529%2C484335%2C479387%2C471337%2C443150%2C451672%2C276206%2C471720%2C435213%2C431683%2C459645%2C459994%2C277718%2C469540%2C478363%2C377573%2C416055%2C392461%2C484504%2C444653%2C479370%2C469347%2C378450%2C457329%2C471407%2C470859%2C485037%2C484264%2C468954%2C271178%2C424178%2C460472%2C467949%2C326524%2C326532%2C460896%2C251132%2C261581%2C403270%2C460173%2C293032%2C457480&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=685&resolution=1080*2030&dpi=440&update_version_code=68509&_rticket=1535706597330&plugin=26991&pos=5r_-9Onkv6e_eBM7dAo1eCUfv7G_8fLz-vTp6Pn4v6esrKWzrKStpKyur6uopauopKuxv_H86fTp6Pn4v6evqbOppKmsqaqrqqmlr6qsqKWxv_zw_O3e9Onkv6e_eBM7dAo1eCUfv7G__PD87dHy8_r06ej5-L-nrKyls6ylqa6kqrG__PD87dH86fTp6Pn4v6evqbOppaqqpKXg&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v10_8.8.3&ts=1535706597&as=a2e5b0e8457efbf5d96890&mas=007d8aa9e83810729b6b28b9990a6a5321c2e4f6add255cd8b&cp=51bd8699045e5q1";
    @GET(url)
    public abstract Observable<String> onPostmanRefresh(@Query("tt_from")String tt_from,@Query("refresh_reason")int refresh_reason,@Query("session_refresh_idx")int session_refresh_idx,
                                                 @Query("count")int count,@Query("list_count")int list_count,@Query("category")String category,@Query("min_behot_time")String min_behot_time);
    @value
    final String url2="api/news/feed/v88/?support_rn=4&refer=1&list_entrance=main_tab&last_refresh_sub_entrance_interval=1535706931&loc_mode=0&loc_time=1534468829&latitude=24.494147674827158&longitude=118.19091326586596&city=%E5%8E%A6%E9%97%A8%E5%B8%82&lac=302&cid=11889&plugin_enable=3&iid=41004251804&device_id=51992606471&ac=wifi&channel=xiaomi&aid=13&app_name=news_article&version_code=685&version_name=6.8.5&device_platform=android&ab_version=484806%2C345191%2C472973%2C484745%2C377631%2C454982%2C482808%2C424606%2C479486%2C455644%2C449327%2C458725%2C424176%2C214069%2C482577%2C443793%2C442255%2C478956%2C480317%2C481984%2C280448%2C281295%2C482252%2C325617%2C482555%2C481567%2C386891%2C431144%2C485061%2C467515%2C252782%2C470727%2C444465%2C454354%2C469373%2C468378%2C477134%2C425537%2C483197%2C391820%2C443357%2C479281%2C442427%2C480751%2C467899%2C484677%2C239095%2C478797%2C170988%2C465102%2C480872%2C442120%2C374119%2C478529%2C484335%2C479387%2C471337%2C443150%2C451672%2C276206%2C471720%2C435213%2C431683%2C459645%2C459994%2C277718%2C469540%2C478363%2C377573%2C416055%2C392461%2C484504%2C444653%2C479370%2C469347%2C378450%2C457329%2C471407%2C470859%2C485037%2C484264%2C468954%2C271178%2C424178%2C460472%2C467949%2C326524%2C326532%2C460896%2C251132%2C261581%2C403270%2C460173%2C293032%2C457480&ab_client=a1%2Cc4%2Ce1%2Cf1%2Cg2%2Cf7&ab_feature=94563%2C102749&abflag=3&ssmix=a&device_type=MIX+2S&device_brand=Xiaomi&language=zh&os_api=26&os_version=8.0.0&uuid=99001115032811&openudid=8e06160a8be93b7a&manifest_version_code=685&resolution=1080*2030&dpi=440&update_version_code=68509&_rticket=1535706931741&plugin=26991&pos=5r_-9Onkv6e_eBM7dAo1eCUfv7G_8fLz-vTp6Pn4v6esrKWzrKStpKyur6uopauopKuxv_H86fTp6Pn4v6evqbOppKmsqaqrqqmlr6qsqKWxv_zw_O3e9Onkv6e_eBM7dAo1eCUfv7G__PD87dHy8_r06ej5-L-nrKyls6ylqa6kqrG__PD87dH86fTp6Pn4v6evqbOppaqqpKXg&fp=RrTqPzPMLMw7FlctF2U1FYwIJ2K7&rom_version=miui_v10_8.8.3&ts=1535706931&as=a2a5f008a3c3bb17a93252&mas=004772a9ef95dc3c148ba64379699401252c40fc0d88608ef8&cp=52b8809505733q1";
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
