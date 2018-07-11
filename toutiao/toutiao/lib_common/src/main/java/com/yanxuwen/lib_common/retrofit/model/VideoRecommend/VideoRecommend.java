package com.yanxuwen.lib_common.retrofit.model.VideoRecommend;

import com.google.gson.annotations.SerializedName;
import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.lib_common.retrofit.model.NewsList.NewsContent;
import com.yanxuwen.retrofit.Annotation.Description;

import java.util.List;

/**
 * Created by yanxuwen on 2018/5/24.
 */
@Description("视频推荐")
public class VideoRecommend extends MyBaseModel {
    /**
     * data : {"ad":{"is_preview":false,"mixed":{"button_text":"立即下载","dislike":[{"name":"为什么看到此广告","open_url":"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike&hide_more=1&title=为什么看到此广告"}],"display_subtype":3,"filter_words":[{"id":"4:2","is_selected":false,"name":"看过了"},{"id":"2:0","is_selected":false,"name":"屏蔽:京东 的广告"}],"id":94112175398,"image":"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg","image_height":286,"image_width":690,"is_tongtou_ad":false,"label":"京东广告","log_extra":"{\"ad_price\":\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\",\"convert_component_suspend\":0,\"convert_id\":0,\"external_action\":0,\"item_id\":6545690546311004686,\"media_id\":1587845744613390,\"orit\":null,\"req_id\":\"201805241736340100150181521464BC\",\"rit\":3}","open_url":"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A","show_dislike":1,"source_name":"京东 ","title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","track_url":"","track_url_list":[],"type":"web","web_title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","web_url":"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x&log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8&v=404&p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA&bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398"}},"ban_bury":0,"ban_comment":0,"ban_danmaku":false,"ban_digg":0,"bury_count":0,"comment_count":3,"context":"{\"labels\":{\"labels_style\":2,\"labels_words\":[{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%8E%92%E5%90%8D\",\"word\":\"火影忍者排名\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%8D%9A%E4%BA%BA%E4%BC%A0\",\"word\":\"火影忍者博人传\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%BF%8D%E6%9C%AF\",\"word\":\"火影忍者忍术\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%89%8B%E6%B8%B8\",\"word\":\"火影忍者手游\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E9%9B%8F%E7%94%B0\",\"word\":\"火影忍者雏田\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E4%BD%90%E5%8A%A9\",\"word\":\"火影忍者佐助\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8\",\"word\":\"火影忍者壁纸\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%8D%A1%E5%8D%A1%E8%A5%BF\",\"word\":\"火影忍者卡卡西\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%86%99%E8%BD%AE%E7%9C%BC\",\"word\":\"火影忍者写轮眼\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%88%91%E7%88%B1%E7%BD%97\",\"word\":\"火影忍者我爱罗\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E4%B9%9D%E5%B0%BE\",\"word\":\"火影忍者九尾\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%AE%87%E6%99%BA%E6%B3%A2%E9%BC%AC\",\"word\":\"火影忍者宇智波鼬\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%9B%BE%E7%89%87\",\"word\":\"火影忍者图片\"},{\"link\":\"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\\u0026from=article_tag_wap_2\\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%B8%A6%E5%9C%9F\",\"word\":\"火影忍者带土\"}]},\"tip\":\"\"}","danmaku_count":0,"detail_show_flags":0,"digg_count":22,"display_url":"http://toutiao.com/group/6545690546311004686/","filter_words":[{"id":"5:2112582931","name":"拉黑作者:磁力影视"},{"id":"1:582095509","name":"不想看:动漫视频"},{"id":"6:2404885","name":"不想看:火影忍者"}],"group_flags":1,"group_id":6545690546311004686,"h5_extra":{"have_red_pack":0,"is_original":true,"is_subscribed":0,"media":{"avatar_url":"http://p4.pstatp.com/large/6eea00032201847d263f","can_be_praised":true,"description":"这里有最新的动漫新番，还有从小追到大的回忆","id":1587845744613390,"name":"磁力影视","pgc_custom_menu":"","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_decoration":"","user_verified":true}},"ignore_web_transform":0,"info_flag":7,"is_wenda":0,"like_count":22,"like_desc":"关心这篇文章，会推荐更多此类内容","log_pb":{"impr_id":"201805241736340100150181521464BC"},"media_info":{"avatar_url":"http://p4.pstatp.com/large/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","media_id":1587845744613390,"name":"磁力影视","special_column":[],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":true},"ordered_info":[{"ad_data":"{\"is_preview\":false,\"mixed\":{\"button_text\":\"立即下载\",\"dislike\":[{\"name\":\"为什么看到此广告\",\"open_url\":\"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike\\u0026hide_more=1\\u0026title=为什么看到此广告\"}],\"display_subtype\":3,\"filter_words\":[{\"id\":\"4:2\",\"is_selected\":false,\"name\":\"看过了\"},{\"id\":\"2:0\",\"is_selected\":false,\"name\":\"屏蔽:京东 的广告\"}],\"id\":94112175398,\"image\":\"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg\",\"image_height\":286,\"image_width\":690,\"is_tongtou_ad\":false,\"label\":\"京东广告\",\"log_extra\":\"{\\\"ad_price\\\":\\\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\\\",\\\"convert_component_suspend\\\":0,\\\"convert_id\\\":0,\\\"external_action\\\":0,\\\"item_id\\\":6545690546311004686,\\\"media_id\\\":1587845744613390,\\\"orit\\\":null,\\\"req_id\\\":\\\"201805241736340100150181521464BC\\\",\\\"rit\\\":3}\",\"open_url\":\"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A\",\"show_dislike\":1,\"source_name\":\"京东 \",\"title\":\"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！\",\"track_url\":\"\",\"track_url_list\":[],\"type\":\"web\",\"web_title\":\"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！\",\"web_url\":\"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x\\u0026log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8\\u0026v=404\\u0026p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA\\u0026bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398\"}}","name":"ad"}],"read_count":346,"recommend_sponsor":{"icon_url":"http://p3.pstatp.com/origin/13ef000096960314fff4","label":"帮上头条","target_url":"https://i.snssdk.com/ad/pgc_promotion/mobile/create/?group_id=6545690546311004686&item_id=6545690546311004686"},"related_video_section":8,"related_video_toutiao":[{"abstract":"这样买家具？上门量尺设计风格，欧派全屋定制仅1.","ad_id":1601336525302803,"aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/item/6559076033067221252/","ban_action":0,"ban_bury":0,"ban_comment":1,"ban_danmaku":0,"ban_download":0,"behot_time":1527153894,"bury_count":0,"card_type":"ad_video","comment_count":0,"danmaku_count":0,"digg_count":0,"display_title":"","display_url":"http://toutiao.com/item/6559076033067221252/","group_flags":36961,"group_id":6559076033067221252,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"id":1601336525302803,"image_count":0,"image_list":[],"is_article":true,"is_preview":false,"item_id":6559076033067221252,"keywords":"","level":0,"log_extra":"{\"rit\":9,\"orit\":1,\"req_id\":\"201805241736340100150181521464BC\",\"convert_id\":1599855812619320,\"external_action\":2,\"convert_component_suspend\":0,\"ad_price\":\"WwaHogAOveFbBoeiAA694b3aYeRig8ftWMA0ig\"}","log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"middle_image":{"day_mode":0,"height":720,"uri":"list/web.business.image/201805245d0dc105427ed90941ae88f4","url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg","url_list":[{"url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"}],"width":1280},"natant_level":2,"open_url":"","preload_web":0,"publish_time":1527153894,"repin_count":0,"share_count":0,"share_token":"","share_url":"http://toutiao.com/group/6559076033067221252/?iid=32758433763&app=news_article","show_tag":"广告","source":"欧派高端全屋定制","tag":"ad","tag_id":6559076033067221252,"text_count":0,"tip":0,"title":"这样买家具？上门量尺设计风格，欧派全屋定制仅1.98万","title_rich_span":"","track_url_list":[],"type":"web","url":"http://toutiao.com/item/6559076033067221252/","video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/86da000ded94cbc14fec","url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec","url_list":[{"url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://pb3.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://p.pstatp.com/video1609/86da000ded94cbc14fec"}],"width":580},"direct_play":1,"group_flags":36961,"show_pgc_subscribe":1,"video_id":"v03033c20000bc32u7dehji8cgidktmg","video_third_monitor_url":"","video_watch_count":186},"video_duration":15,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":15.96,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/86da000ded94cbc14fec\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/\",\"main_url\":\"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":323799,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":787710,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=\",\"user_video_proxy\":1,\"socket_buffer\":7285320,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":489240,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":1116954,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=\",\"user_video_proxy\":1,\"socket_buffer\":11007900,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":1044478,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":2221878,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=\",\"user_video_proxy\":1,\"socket_buffer\":23500620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_style":0,"web_url":"","media_name":"磁力影视","show_portrait_article":false,"user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_proportion_article":1.7777777777777777},{"abstract":"自来也的仙人模式果然不是盖的，但缺点是三张嘴巴好吵","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545603242405921288/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524017016,"bury_count":2,"card_type":"video","comment_count":16,"danmaku_count":0,"digg_count":200,"display_title":"","display_url":"http://toutiao.com/group/6545603242405921288/","group_flags":32865,"group_id":6545603242405921288,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545603242405921288,"keywords":"自来也,嘴巴,仙人模式,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524016857614b6aa01ef82","url":"http://p1.pstatp.com/list/pgc-image/1524016857614b6aa01ef82","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"},{"url":"http://p.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"}],"width":640},"preload_web":0,"publish_time":1524017016,"repin_count":94,"share_count":41,"share_token":"","share_url":"http://toutiao.com/group/6545603242405921288/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545603242405921288,"text_count":24,"tip":0,"title":"火影忍者：自来也的仙人模式果然不是盖的，但缺点是三张嘴巴好吵","title_rich_span":"","url":"http://toutiao.com/group/6545603242405921288/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524016857614b6aa01ef82","url":"http://p2.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"af517e17d71040d69e3f25d501f58e87","video_third_monitor_url":"","video_watch_count":35855},"video_duration":114,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":114.62,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c070012517cc586dfc8\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/66d0e000032f092941daa/\",\"main_url\":\"http://voffline.byted.org/download/m/66d0e000032f092941daa/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":149957,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3140776,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vODBlYzQxOGVkMjMyZGM5MThlZmEwOTY1ZDFmNDZiYjUvNWIwNjk2MjQvdmlkZW8vbS8yMjBhOGY2M2YyYWZlMTA0ZDFkYWEyY2EzY2JlNzkyNGEyZTExNTY3ZWZmMDAwMDI2NzRjNWNiZmUxNS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83MGU4OTJhMDlkOGJjZDVkNzY5MDU5MjZiNWMzM2YyZS81YjA2OTYyNC92aWRlby9tLzIyMGE4ZjYzZjJhZmUxMDRkMWRhYTJjYTNjYmU3OTI0YTJlMTE1NjdlZmYwMDAwMjY3NGM1Y2JmZTE1Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vODBlYzQxOGVkMjMyZGM5MThlZmEwOTY1ZDFmNDZiYjUvNWIwNjk2MjQvdmlkZW8vbS8yMjBhOGY2M2YyYWZlMTA0ZDFkYWEyY2EzY2JlNzkyNGEyZTExNTY3ZWZmMDAwMDI2NzRjNWNiZmUxNS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83MGU4OTJhMDlkOGJjZDVkNzY5MDU5MjZiNWMzM2YyZS81YjA2OTYyNC92aWRlby9tLzIyMGE4ZjYzZjJhZmUxMDRkMWRhYTJjYTNjYmU3OTI0YTJlMTE1NjdlZmYwMDAwMjY3NGM1Y2JmZTE1Lw==\",\"user_video_proxy\":1,\"socket_buffer\":3373920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":219487,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4136964,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMTE4YmNmODc2ZmUyMmExZDdhOTRmODRkYjA3YjE3MjQvNWIwNjk2MjQvdmlkZW8vbS8yMjBkNzAyZTVjYzk5ODY0OWZmODgwZjY0OTZmMTNlYzNlZTExNTY3ZWIwMDAwMGFiNjA1YTY2MThiMy8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNDA0Y2FkMWEzMzczYmI0ZDliYzNlZWZjNjlhMDc2MC81YjA2OTYyNC92aWRlby9tLzIyMGQ3MDJlNWNjOTk4NjQ5ZmY4ODBmNjQ5NmYxM2VjM2VlMTE1NjdlYjAwMDAwYWI2MDVhNjYxOGIzLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMTE4YmNmODc2ZmUyMmExZDdhOTRmODRkYjA3YjE3MjQvNWIwNjk2MjQvdmlkZW8vbS8yMjBkNzAyZTVjYzk5ODY0OWZmODgwZjY0OTZmMTNlYzNlZTExNTY3ZWIwMDAwMGFiNjA1YTY2MThiMy8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNDA0Y2FkMWEzMzczYmI0ZDliYzNlZWZjNjlhMDc2MC81YjA2OTYyNC92aWRlby9tLzIyMGQ3MDJlNWNjOTk4NjQ5ZmY4ODBmNjQ5NmYxM2VjM2VlMTE1NjdlYjAwMDAwYWI2MDVhNjYxOGIzLw==\",\"user_video_proxy\":1,\"socket_buffer\":4938300,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":442515,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7333405,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGUwZjUyMzUxNDAxMWUzNWNjYTZhNmUwMDliNmUxODMvNWIwNjk2MjQvdmlkZW8vbS8yMjBhNTY5ZjMwZWM2ODY0YWMzYTg3OGRlZDc5YzY0YmI5YzExNTY4MzE2MDAwMGE5YzJmZGNjYTNkMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9lNWNmNTZmZTdkZGNmYjg5MGMyNTM2YjVmYTc0MjY1MC81YjA2OTYyNC92aWRlby9tLzIyMGE1NjlmMzBlYzY4NjRhYzNhODc4ZGVkNzljNjRiYjljMTE1NjgzMTYwMDAwYTljMmZkY2NhM2QyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGUwZjUyMzUxNDAxMWUzNWNjYTZhNmUwMDliNmUxODMvNWIwNjk2MjQvdmlkZW8vbS8yMjBhNTY5ZjMwZWM2ODY0YWMzYTg3OGRlZDc5YzY0YmI5YzExNTY4MzE2MDAwMGE5YzJmZGNjYTNkMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9lNWNmNTZmZTdkZGNmYjg5MGMyNTM2YjVmYTc0MjY1MC81YjA2OTYyNC92aWRlby9tLzIyMGE1NjlmMzBlYzY4NjRhYzNhODc4ZGVkNzljNjRiYjljMTE1NjgzMTYwMDAwYTljMmZkY2NhM2QyLw==\",\"user_video_proxy\":1,\"socket_buffer\":9956520,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"自来也这个造型也太拉风了，三个蛤蟆仙人共用一体。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545598496571916814/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524015911,"bury_count":1,"card_type":"video","comment_count":22,"danmaku_count":0,"digg_count":84,"display_title":"","display_url":"http://toutiao.com/group/6545598496571916814/","group_flags":32865,"group_id":6545598496571916814,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545598496571916814,"keywords":"火影忍者,仙人,蛤蟆仙人,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524015779992596efdd73b","url":"http://p3.pstatp.com/list/pgc-image/1524015779992596efdd73b","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1524015779992596efdd73b"},{"url":"http://pb2.pstatp.com/list/pgc-image/1524015779992596efdd73b"},{"url":"http://p.pstatp.com/list/pgc-image/1524015779992596efdd73b"}],"width":640},"preload_web":0,"publish_time":1524015911,"repin_count":21,"share_count":20,"share_token":"","share_url":"http://toutiao.com/group/6545598496571916814/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545598496571916814,"text_count":51,"tip":0,"title":"火影忍者：自来也这个造型也太拉风了，三个蛤蟆仙人共用一体","title_rich_span":"","url":"http://toutiao.com/group/6545598496571916814/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524015779992596efdd73b","url":"http://p9.pstatp.com/video1609/pgc-image/1524015779992596efdd73b","url_list":[{"url":"http://p9.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"9a369a091cb948bf90c8339ad2bdd778","video_third_monitor_url":"","video_watch_count":20747},"video_duration":132,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":132.61,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c0600113eba5fcdf03e\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6360e000036dbbc54aed4/\",\"main_url\":\"http://voffline.byted.org/download/m/6360e000036dbbc54aed4/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":162475,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3841515,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vOTBlNjYyNWY4NGNiZjQ0ZDk3ZTExYWI2MDk3MmU3MmMvNWIwNjk2MzYvdmlkZW8vbS8yMjAzYTU1ZjFjNTRiMDc0ODQ3OTAxODdhN2RiZjliMGE1NTExNTYwYjU1MDAwMDE2ZTQ4ZDg2MmNhYS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS84Zjc2MDliYjIyNDkzZjA1ZDM2YWJlMGYwYzE2ODRhZS81YjA2OTYzNi92aWRlby9tLzIyMDNhNTVmMWM1NGIwNzQ4NDc5MDE4N2E3ZGJmOWIwYTU1MTE1NjBiNTUwMDAwMTZlNDhkODYyY2FhLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vOTBlNjYyNWY4NGNiZjQ0ZDk3ZTExYWI2MDk3MmU3MmMvNWIwNjk2MzYvdmlkZW8vbS8yMjAzYTU1ZjFjNTRiMDc0ODQ3OTAxODdhN2RiZjliMGE1NTExNTYwYjU1MDAwMDE2ZTQ4ZDg2MmNhYS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS84Zjc2MDliYjIyNDkzZjA1ZDM2YWJlMGYwYzE2ODRhZS81YjA2OTYzNi92aWRlby9tLzIyMDNhNTVmMWM1NGIwNzQ4NDc5MDE4N2E3ZGJmOWIwYTU1MTE1NjBiNTUwMDAwMTZlNDhkODYyY2FhLw==\",\"user_video_proxy\":1,\"socket_buffer\":3655620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":246376,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5232670,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjcwMzliYzEzNTBhMDE3NzViMmQ1N2ZmOGRlYjliNjYvNWIwNjk2MzYvdmlkZW8vbS8yMjA1MjYzMDJiNGYwMjc0Y2Q4YTc3OTY4OTBjNjU3ZTM4YjExNTY3NjYwMDAwMGFiNGNhYWZkYTFjMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS81YTM0MjVkNDNmMGZlNWQ1M2I4NTFkMjQ5MTBlMGU2NS81YjA2OTYzNi92aWRlby9tLzIyMDUyNjMwMmI0ZjAyNzRjZDhhNzc5Njg5MGM2NTdlMzhiMTE1Njc2NjAwMDAwYWI0Y2FhZmRhMWMyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjcwMzliYzEzNTBhMDE3NzViMmQ1N2ZmOGRlYjliNjYvNWIwNjk2MzYvdmlkZW8vbS8yMjA1MjYzMDJiNGYwMjc0Y2Q4YTc3OTY4OTBjNjU3ZTM4YjExNTY3NjYwMDAwMGFiNGNhYWZkYTFjMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS81YTM0MjVkNDNmMGZlNWQ1M2I4NTFkMjQ5MTBlMGU2NS81YjA2OTYzNi92aWRlby9tLzIyMDUyNjMwMmI0ZjAyNzRjZDhhNzc5Njg5MGM2NTdlMzhiMTE1Njc2NjAwMDAwYWI0Y2FhZmRhMWMyLw==\",\"user_video_proxy\":1,\"socket_buffer\":5543460,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":529559,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":9927930,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDcwYWQ1MzRjMjU0MDhiNjBmMWE5MWI3YzViYTAwMTcvNWIwNjk2MzYvdmlkZW8vbS8yMjA5OThlM2FlM2VjNDc0ZTQwOGQ3MTZlNDU0MmVhNmY0MzExNTY0Yzk2MDAwMDVhNmYyZWM2MWJjYi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83NTdjZjQ4NDViZjExNTBkYzdlY2MxNDFiM2QzZWE2ZS81YjA2OTYzNi92aWRlby9tLzIyMDk5OGUzYWUzZWM0NzRlNDA4ZDcxNmU0NTQyZWE2ZjQzMTE1NjRjOTYwMDAwNWE2ZjJlYzYxYmNiLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDcwYWQ1MzRjMjU0MDhiNjBmMWE5MWI3YzViYTAwMTcvNWIwNjk2MzYvdmlkZW8vbS8yMjA5OThlM2FlM2VjNDc0ZTQwOGQ3MTZlNDU0MmVhNmY0MzExNTY0Yzk2MDAwMDVhNmYyZWM2MWJjYi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83NTdjZjQ4NDViZjExNTBkYzdlY2MxNDFiM2QzZWE2ZS81YjA2OTYzNi92aWRlby9tLzIyMDk5OGUzYWUzZWM0NzRlNDA4ZDcxNmU0NTQyZWE2ZjQzMTE1NjRjOTYwMDAwNWE2ZjJlYzYxYmNiLw==\",\"user_video_proxy\":1,\"socket_buffer\":11914920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"鸣人和纲手得知自来也的死讯，火影中最感人的一段","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6546157157077746184/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524145984,"bury_count":0,"card_type":"video","comment_count":25,"danmaku_count":0,"digg_count":158,"display_title":"","display_url":"http://toutiao.com/group/6546157157077746184/","group_flags":32865,"group_id":6546157157077746184,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6546157157077746184,"keywords":"火影,火影忍者,纲手","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524145953496e1c81d1e5c","url":"http://p1.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://p.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"}],"width":640},"preload_web":0,"publish_time":1524145984,"repin_count":41,"share_count":21,"share_token":"","share_url":"http://toutiao.com/group/6546157157077746184/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6546157157077746184,"text_count":22,"tip":0,"title":"火影忍者：鸣人和纲手得知自来也的死讯，火影中最感人的一段","title_rich_span":"","url":"http://toutiao.com/group/6546157157077746184/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524145953496e1c81d1e5c","url":"http://p3.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://pb2.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"fe7bc92aebce4893afab40fb8290ae60","video_third_monitor_url":"","video_watch_count":19308},"video_duration":222,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":222.87,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c5a0002495d43ce7bf7\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6639300001fa4896ace3f/\",\"main_url\":\"http://voffline.byted.org/download/m/6639300001fa4896ace3f/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":123100,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5356741,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzVlZGJhY2YyMzNjMTI5M2Y4MGY5ZTA2ZmRiODM1MDMvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNGQzZmU3NjhiZWJiZTQ3YTk0MTI5ZWRmNzJiMjE2MmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzVlZGJhY2YyMzNjMTI5M2Y4MGY5ZTA2ZmRiODM1MDMvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNGQzZmU3NjhiZWJiZTQ3YTk0MTI5ZWRmNzJiMjE2MmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"user_video_proxy\":1,\"socket_buffer\":2769660,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":182819,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7020119,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vYmIzZDc3MmI5NzIxZTQ4YTc2OTYzNjBkZjQxZmJjZWUvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vODM1YWI1Mjk0YTE4NTMxODczMjE5ODczNDQyOWVkZWMvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vYmIzZDc3MmI5NzIxZTQ4YTc2OTYzNjBkZjQxZmJjZWUvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vODM1YWI1Mjk0YTE4NTMxODczMjE5ODczNDQyOWVkZWMvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"user_video_proxy\":1,\"socket_buffer\":4113360,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":387970,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12735347,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vMTM3Zjc3YzIwMGM0YjIyNDE3YTdiNzJiYTA5YTVkYmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTMwNjVlZDA0MzM2MTg2ZjIzMzc0ZTQ2MWI2MWM3MzIvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vMTM3Zjc3YzIwMGM0YjIyNDE3YTdiNzJiYTA5YTVkYmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTMwNjVlZDA0MzM2MTg2ZjIzMzc0ZTQ2MWI2MWM3MzIvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"user_video_proxy\":1,\"socket_buffer\":8729280,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"师徒间彻底决裂，轮回眼长门对决仙人自来也。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545693920880230926/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524038128,"bury_count":0,"card_type":"video","comment_count":6,"danmaku_count":0,"digg_count":41,"display_title":"","display_url":"http://toutiao.com/group/6545693920880230926/","group_flags":32865,"group_id":6545693920880230926,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545693920880230926,"keywords":"佩恩,轮回眼,自来也,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524038109753135a1fbcbe","url":"http://p3.pstatp.com/list/pgc-image/1524038109753135a1fbcbe","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"},{"url":"http://pb2.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"},{"url":"http://p.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"}],"width":640},"preload_web":0,"publish_time":1524038128,"repin_count":8,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6545693920880230926/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545693920880230926,"text_count":42,"tip":0,"title":"火影忍者：佩恩现出真身，原来是多年前自来也收的一个徒弟","title_rich_span":"","url":"http://toutiao.com/group/6545693920880230926/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524038109753135a1fbcbe","url":"http://p2.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"bc93baffc4a24c49a261eda8ea2ffd40","video_third_monitor_url":"","video_watch_count":9391},"video_duration":136,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":136.92,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c1a00038e3745996ee9\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/667ed0000066fb6299dc0/\",\"main_url\":\"http://voffline.byted.org/download/m/667ed0000066fb6299dc0/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":138582,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3556583,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNzM4Y2FhNTlmMjlhMWE5ZTJkZmViZDk1NjkxMTk4YzUvNWIwNjk2M2EvdmlkZW8vbS8yMjAzOTU3ZGExNzk3Zjc0NzJmOWViYTVlNDE1NDkwMGM0MzExNTY4MjQxMDAwMGI0ZjE0NmEzYTM4YS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS82ODI2Yjc0MzQ0NWY2NzcwODRhYTdhODdlZDE5MDZmNy81YjA2OTYzYS92aWRlby9tLzIyMDM5NTdkYTE3OTdmNzQ3MmY5ZWJhNWU0MTU0OTAwYzQzMTE1NjgyNDEwMDAwYjRmMTQ2YTNhMzhhLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNzM4Y2FhNTlmMjlhMWE5ZTJkZmViZDk1NjkxMTk4YzUvNWIwNjk2M2EvdmlkZW8vbS8yMjAzOTU3ZGExNzk3Zjc0NzJmOWViYTVlNDE1NDkwMGM0MzExNTY4MjQxMDAwMGI0ZjE0NmEzYTM4YS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS82ODI2Yjc0MzQ0NWY2NzcwODRhYTdhODdlZDE5MDZmNy81YjA2OTYzYS92aWRlby9tLzIyMDM5NTdkYTE3OTdmNzQ3MmY5ZWJhNWU0MTU0OTAwYzQzMTE1NjgyNDEwMDAwYjRmMTQ2YTNhMzhhLw==\",\"user_video_proxy\":1,\"socket_buffer\":3117960,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":199837,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4604890,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDc5YWY1ODAzMjZjYmE2MWFjZDNkMWY4MTI4Njk4NTUvNWIwNjk2M2EvdmlkZW8vbS8yMjAxOTZiMmU1MjMzNzA0MTMwYWM5MjQ4ZTA2NmNmMGVmNDExNTY4ODNlMDAwMGIzNmRkZTFkNDNkMS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jN2Y0OTdlYTI3NDEzMWM2MGVlZDBhYmZiMDdlMjg3Yi81YjA2OTYzYS92aWRlby9tLzIyMDE5NmIyZTUyMzM3MDQxMzBhYzkyNDhlMDY2Y2YwZWY0MTE1Njg4M2UwMDAwYjM2ZGRlMWQ0M2QxLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDc5YWY1ODAzMjZjYmE2MWFjZDNkMWY4MTI4Njk4NTUvNWIwNjk2M2EvdmlkZW8vbS8yMjAxOTZiMmU1MjMzNzA0MTMwYWM5MjQ4ZTA2NmNmMGVmNDExNTY4ODNlMDAwMGIzNmRkZTFkNDNkMS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jN2Y0OTdlYTI3NDEzMWM2MGVlZDBhYmZiMDdlMjg3Yi81YjA2OTYzYS92aWRlby9tLzIyMDE5NmIyZTUyMzM3MDQxMzBhYzkyNDhlMDY2Y2YwZWY0MTE1Njg4M2UwMDAwYjM2ZGRlMWQ0M2QxLw==\",\"user_video_proxy\":1,\"socket_buffer\":4496220,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":400756,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":8043744,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vYWFkMjZhOGMyYjBkYjkwZTU5MzhmMjUxNDcxZDk4NzcvNWIwNjk2M2EvdmlkZW8vbS8yMjA0YmM2MWNmODg0ZWM0NGE2ODI4ZjgyZDljNGY0MTkxYTExNTY3YjE1MDAwMDM1NmU1YTJjMTlhMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS85NmZmMjcxN2QxYTY3YzUyYWUzMGUyZTVkYWE0OWY1YS81YjA2OTYzYS92aWRlby9tLzIyMDRiYzYxY2Y4ODRlYzQ0YTY4MjhmODJkOWM0ZjQxOTFhMTE1NjdiMTUwMDAwMzU2ZTVhMmMxOWEyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vYWFkMjZhOGMyYjBkYjkwZTU5MzhmMjUxNDcxZDk4NzcvNWIwNjk2M2EvdmlkZW8vbS8yMjA0YmM2MWNmODg0ZWM0NGE2ODI4ZjgyZDljNGY0MTkxYTExNTY3YjE1MDAwMDM1NmU1YTJjMTlhMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS85NmZmMjcxN2QxYTY3YzUyYWUzMGUyZTVkYWE0OWY1YS81YjA2OTYzYS92aWRlby9tLzIyMDRiYzYxY2Y4ODRlYzQ0YTY4MjhmODJkOWM0ZjQxOTFhMTE1NjdiMTUwMDAwMzU2ZTVhMmMxOWEyLw==\",\"user_video_proxy\":1,\"socket_buffer\":9016920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"为获取情报自来也毅然赴死，蛤蟆大仙三忍之一就此剧中。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545678083985244675/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524034441,"bury_count":0,"card_type":"video","comment_count":17,"danmaku_count":0,"digg_count":142,"display_title":"","display_url":"http://toutiao.com/group/6545678083985244675/","group_flags":32865,"group_id":6545678083985244675,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545678083985244675,"keywords":"佩恩,通灵体,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/15240343361915b9bfad537","url":"http://p3.pstatp.com/list/pgc-image/15240343361915b9bfad537","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15240343361915b9bfad537"},{"url":"http://pb2.pstatp.com/list/pgc-image/15240343361915b9bfad537"},{"url":"http://p.pstatp.com/list/pgc-image/15240343361915b9bfad537"}],"width":640},"preload_web":0,"publish_time":1524034441,"repin_count":52,"share_count":34,"share_token":"","share_url":"http://toutiao.com/group/6545678083985244675/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545678083985244675,"text_count":54,"tip":0,"title":"佩恩的六具通灵体原来自来也全都认识，自来也死前终于掌握真相","title_rich_span":"","url":"http://toutiao.com/group/6545678083985244675/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15240343361915b9bfad537","url":"http://p2.pstatp.com/video1609/pgc-image/15240343361915b9bfad537","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"},{"url":"http://p.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"7ed9668e54ba44fdaa41cd7a24bb9a34","video_third_monitor_url":"","video_watch_count":25112},"video_duration":159,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":159.44,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c15000d75792a92c616\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/66e55000034ff5e40f360/\",\"main_url\":\"http://voffline.byted.org/download/m/66e55000034ff5e40f360/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":199819,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5361182,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2YzZjN2RjOGQyYzgxZTJkYmM5ZDRmYmI4Njk0NDdmLzViMDY5NjUxL3ZpZGVvL20vMjIwNDRjNDQyNTZjM2U0NGY1MmI2MjIzZGRmMWJkYjE2NzgxMTU2NzlkMDAwMDBiMzJkNDk0MzNkYmIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQxZmY4ZTdlOTkzYTczZjliNWJkYzNiOWZlZjkxNmYvNWIwNjk2NTEvdmlkZW8vbS8yMjA0NGM0NDI1NmMzZTQ0ZjUyYjYyMjNkZGYxYmRiMTY3ODExNTY3OWQwMDAwMGIzMmQ0OTQzM2RiYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2YzZjN2RjOGQyYzgxZTJkYmM5ZDRmYmI4Njk0NDdmLzViMDY5NjUxL3ZpZGVvL20vMjIwNDRjNDQyNTZjM2U0NGY1MmI2MjIzZGRmMWJkYjE2NzgxMTU2NzlkMDAwMDBiMzJkNDk0MzNkYmIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQxZmY4ZTdlOTkzYTczZjliNWJkYzNiOWZlZjkxNmYvNWIwNjk2NTEvdmlkZW8vbS8yMjA0NGM0NDI1NmMzZTQ0ZjUyYjYyMjNkZGYxYmRiMTY3ODExNTY3OWQwMDAwMGIzMmQ0OTQzM2RiYi8=\",\"user_video_proxy\":1,\"socket_buffer\":4495860,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":291293,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7184248,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzY4M2UxMThjZTE2YzcyNzhkZjhlNzEwMDUwNmIxMjE5LzViMDY5NjUxL3ZpZGVvL20vMjIwZDhlMDc4NWFjYTA0NGIzMzhjYzgyNTM1OTViNGY1ZjgxMTU2N2Y5ODAwMDBiNGI4ZDIxMDdjOWQv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vYjk4NTI0OWY1NjZjNTE2YWQxNGU5MzMzZDgzNjUzYmMvNWIwNjk2NTEvdmlkZW8vbS8yMjBkOGUwNzg1YWNhMDQ0YjMzOGNjODI1MzU5NWI0ZjVmODExNTY3Zjk4MDAwMGI0YjhkMjEwN2M5ZC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzY4M2UxMThjZTE2YzcyNzhkZjhlNzEwMDUwNmIxMjE5LzViMDY5NjUxL3ZpZGVvL20vMjIwZDhlMDc4NWFjYTA0NGIzMzhjYzgyNTM1OTViNGY1ZjgxMTU2N2Y5ODAwMDBiNGI4ZDIxMDdjOWQv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vYjk4NTI0OWY1NjZjNTE2YWQxNGU5MzMzZDgzNjUzYmMvNWIwNjk2NTEvdmlkZW8vbS8yMjBkOGUwNzg1YWNhMDQ0YjMzOGNjODI1MzU5NWI0ZjVmODExNTY3Zjk4MDAwMGI0YjhkMjEwN2M5ZC8=\",\"user_video_proxy\":1,\"socket_buffer\":6553980,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":580687,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12951834,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRlMzQ2MjlmYWVmZWE4MTlkYzE2MDU4M2QzMTFkYjNjLzViMDY5NjUxL3ZpZGVvL20vMjIwNjNhYjVlOTRlOGJhNDFiZDlkOTc2OTY0MTA1OGMyMTYxMTU2N2FlMzAwMDBiMzZhNTc3OGVkY2Mv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZDc0MjU0YWI4Njc3MmJiMGFlYTEwMTdmOGY3NzkxNWQvNWIwNjk2NTEvdmlkZW8vbS8yMjA2M2FiNWU5NGU4YmE0MWJkOWQ5NzY5NjQxMDU4YzIxNjExNTY3YWUzMDAwMGIzNmE1Nzc4ZWRjYy8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRlMzQ2MjlmYWVmZWE4MTlkYzE2MDU4M2QzMTFkYjNjLzViMDY5NjUxL3ZpZGVvL20vMjIwNjNhYjVlOTRlOGJhNDFiZDlkOTc2OTY0MTA1OGMyMTYxMTU2N2FlMzAwMDBiMzZhNTc3OGVkY2Mv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZDc0MjU0YWI4Njc3MmJiMGFlYTEwMTdmOGY3NzkxNWQvNWIwNjk2NTEvdmlkZW8vbS8yMjA2M2FiNWU5NGU4YmE0MWJkOWQ5NzY5NjQxMDU4YzIxNjExNTY3YWUzMDAwMGIzNmE1Nzc4ZWRjYy8=\",\"user_video_proxy\":1,\"socket_buffer\":13065300,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"仙人模式下发动蛤蟆功，颇有功夫里火云邪神的味道啊。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545601403790819848/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524016587,"bury_count":0,"card_type":"video","comment_count":18,"danmaku_count":0,"digg_count":66,"display_title":"","display_url":"http://toutiao.com/group/6545601403790819848/","group_flags":32865,"group_id":6545601403790819848,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545601403790819848,"keywords":"火影忍者,佩恩,忍术,火云邪神,仙人模式","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524016570759720be9e55a","url":"http://p1.pstatp.com/list/pgc-image/1524016570759720be9e55a","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524016570759720be9e55a"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524016570759720be9e55a"},{"url":"http://p.pstatp.com/list/pgc-image/1524016570759720be9e55a"}],"width":640},"preload_web":0,"publish_time":1524016587,"repin_count":24,"share_count":13,"share_token":"","share_url":"http://toutiao.com/group/6545601403790819848/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545601403790819848,"text_count":43,"tip":0,"title":"火影忍者：佩恩的饿鬼道能力是，吸收对方的忍术攻击","title_rich_span":"","url":"http://toutiao.com/group/6545601403790819848/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524016570759720be9e55a","url":"http://p10.pstatp.com/video1609/pgc-image/1524016570759720be9e55a","url_list":[{"url":"http://p10.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"04347c48f93d4c448f9ad05fb9815b43","video_third_monitor_url":"","video_watch_count":19203},"video_duration":128,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":128.53,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c09000d9e0f122aa92a\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/65d630000149ae7b451f6/\",\"main_url\":\"http://voffline.byted.org/download/m/65d630000149ae7b451f6/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":239208,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4956244,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2Q0MTUyNDkxYjNhMWFhNDU0ODg3OTFiOTZlOTU5NzgwLzViMDY5NjMyL3ZpZGVvL20vMjIwYWExMjBhZjc1YWZmNGUwM2I4N2MyN2JmMGM3MTY5ODAxMTU2ODBkNTAwMDBhOTU3YTM3NjlkZjgv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNjdkOGRlNjEwODdhYmViZGY2YmJlZTc4NWY5OGM2ZGEvNWIwNjk2MzIvdmlkZW8vbS8yMjBhYTEyMGFmNzVhZmY0ZTAzYjg3YzI3YmYwYzcxNjk4MDExNTY4MGQ1MDAwMGE5NTdhMzc2OWRmOC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2Q0MTUyNDkxYjNhMWFhNDU0ODg3OTFiOTZlOTU5NzgwLzViMDY5NjMyL3ZpZGVvL20vMjIwYWExMjBhZjc1YWZmNGUwM2I4N2MyN2JmMGM3MTY5ODAxMTU2ODBkNTAwMDBhOTU3YTM3NjlkZjgv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNjdkOGRlNjEwODdhYmViZGY2YmJlZTc4NWY5OGM2ZGEvNWIwNjk2MzIvdmlkZW8vbS8yMjBhYTEyMGFmNzVhZmY0ZTAzYjg3YzI3YmYwYzcxNjk4MDExNTY4MGQ1MDAwMGE5NTdhMzc2OWRmOC8=\",\"user_video_proxy\":1,\"socket_buffer\":5382180,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":356607,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":6843031,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzc2OGZmNTY2YjJiZWUxNWJiNjBkYTBmZjM5Zjc2OTJiLzViMDY5NjMyL3ZpZGVvL20vMjIwYThkZWIyZGQ4ZDM0NDMyNjhmYmQyZGY4ZWI3N2RkMjAxMTU2N2U2MjAwMDBhOTUxOTczNWU2OTMv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmYyYjY5ZWQ0OTc1ZmZjN2E3NTZjMzAwYjM0MTcwMDYvNWIwNjk2MzIvdmlkZW8vbS8yMjBhOGRlYjJkZDhkMzQ0MzI2OGZiZDJkZjhlYjc3ZGQyMDExNTY3ZTYyMDAwMGE5NTE5NzM1ZTY5My8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzc2OGZmNTY2YjJiZWUxNWJiNjBkYTBmZjM5Zjc2OTJiLzViMDY5NjMyL3ZpZGVvL20vMjIwYThkZWIyZGQ4ZDM0NDMyNjhmYmQyZGY4ZWI3N2RkMjAxMTU2N2U2MjAwMDBhOTUxOTczNWU2OTMv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmYyYjY5ZWQ0OTc1ZmZjN2E3NTZjMzAwYjM0MTcwMDYvNWIwNjk2MzIvdmlkZW8vbS8yMjBhOGRlYjJkZDhkMzQ0MzI2OGZiZDJkZjhlYjc3ZGQyMDExNTY3ZTYyMDAwMGE5NTE5NzM1ZTY5My8=\",\"user_video_proxy\":1,\"socket_buffer\":8023500,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":732877,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12889396,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRmODM2MTI2MGE3ZTJhNTcwNTI3M2U0ZWY5MDQzNjljLzViMDY5NjMyL3ZpZGVvL20vMjIwZmZjM2U3ZmMxYTE2NGM1MzhiYjBmN2FjMzQ5ZDIwMDYxMTU2NDYxZjAwMDAwYjZmOTBjZGQ2OGIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZjU4ODVjNWY2NWY4OWM3OWNiZWYzZTI2NDc0NzlmNTEvNWIwNjk2MzIvdmlkZW8vbS8yMjBmZmMzZTdmYzFhMTY0YzUzOGJiMGY3YWMzNDlkMjAwNjExNTY0NjFmMDAwMDBiNmY5MGNkZDY4Yi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRmODM2MTI2MGE3ZTJhNTcwNTI3M2U0ZWY5MDQzNjljLzViMDY5NjMyL3ZpZGVvL20vMjIwZmZjM2U3ZmMxYTE2NGM1MzhiYjBmN2FjMzQ5ZDIwMDYxMTU2NDYxZjAwMDAwYjZmOTBjZGQ2OGIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZjU4ODVjNWY2NWY4OWM3OWNiZWYzZTI2NDc0NzlmNTEvNWIwNjk2MzIvdmlkZW8vbS8yMjBmZmMzZTdmYzFhMTY0YzUzOGJiMGY3YWMzNDlkMjAwNjExNTY0NjFmMDAwMDBiNmY5MGNkZDY4Yi8=\",\"user_video_proxy\":1,\"socket_buffer\":16489620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543390078838768131/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523706385,"bury_count":5,"card_type":"video","comment_count":205,"danmaku_count":0,"digg_count":1263,"display_title":"","display_url":"http://toutiao.com/group/6543390078838768131/","group_flags":32865,"group_id":6543390078838768131,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6543390078838768131,"keywords":"依鲁卡,漩涡鸣人,九尾妖狐,火影忍者,鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/152375667394818f500a656","url":"http://p1.pstatp.com/list/pgc-image/152375667394818f500a656","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/152375667394818f500a656"},{"url":"http://pb3.pstatp.com/list/pgc-image/152375667394818f500a656"},{"url":"http://p.pstatp.com/list/pgc-image/152375667394818f500a656"}],"width":648},"preload_web":0,"publish_time":1523706385,"repin_count":385,"share_count":229,"share_token":"","share_url":"http://toutiao.com/group/6543390078838768131/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543390078838768131,"text_count":194,"tip":0,"title":"鸣人一招就废掉一个佩恩，佩恩懵逼：怎么可能，刚刚绝对躲过去了","title_rich_span":"","url":"http://toutiao.com/group/6543390078838768131/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152375667394818f500a656","url":"http://p3.pstatp.com/video1609/pgc-image/152375667394818f500a656","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/152375667394818f500a656"},{"url":"http://pb2.pstatp.com/video1609/pgc-image/152375667394818f500a656"},{"url":"http://p.pstatp.com/video1609/pgc-image/152375667394818f500a656"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"52079f49f2ec4070a483d50f2838aa9f","video_third_monitor_url":"","video_watch_count":258368},"video_duration":236,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":236.87,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/79fe000a970cc84b8740\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6307500002455123b8340/\",\"main_url\":\"http://voffline.byted.org/download/m/6307500002455123b8340/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":648,\"vheight\":360,\"bitrate\":342822,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12180628,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZTcxMTc5ZjBiYmVhYzUyODQzZjA1ZWVlNWNjODYxZDYvNWIwNjk2OWUvdmlkZW8vbS8yMjBkM2UxZDA2MDYzNjg0NTYzYjc1NjcxOGMxZWRkNTVhOTExNTYzZjY1MDAwMGQwNmZjODQ5ODkyMy8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9kOWEzMmYzOTdkNzE0ZGZiYmU5MTJhZmM1MGRmZmNiMi81YjA2OTY5ZS92aWRlby9tLzIyMGQzZTFkMDYwNjM2ODQ1NjNiNzU2NzE4YzFlZGQ1NWE5MTE1NjNmNjUwMDAwZDA2ZmM4NDk4OTIzLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZTcxMTc5ZjBiYmVhYzUyODQzZjA1ZWVlNWNjODYxZDYvNWIwNjk2OWUvdmlkZW8vbS8yMjBkM2UxZDA2MDYzNjg0NTYzYjc1NjcxOGMxZWRkNTVhOTExNTYzZjY1MDAwMGQwNmZjODQ5ODkyMy8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9kOWEzMmYzOTdkNzE0ZGZiYmU5MTJhZmM1MGRmZmNiMi81YjA2OTY5ZS92aWRlby9tLzIyMGQzZTFkMDYwNjM2ODQ1NjNiNzU2NzE4YzFlZGQ1NWE5MTE1NjNmNjUwMDAwZDA2ZmM4NDk4OTIzLw==\",\"user_video_proxy\":1,\"socket_buffer\":7713360,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":862,\"vheight\":480,\"bitrate\":508158,\"logo_type\":\"xigua_share\",\"codec_type\":\"h264\",\"size\":17068172,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZWE2MDYzYzE3ZTY0ZTE2NTY5ZjUyOTViOTAzNTIzZTcvNWIwNjk2OWUvdmlkZW8vbS8yMjA1YjU0MzFlNjgwZGM0NmM2YTA3NTQwODE4ZTM3MzllMzExNTVhNWUwMDAwMGExOGY1MTY2OTkzOS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9hZjQ0Y2Y3NDkzNzVhZmVkZDJiNTk5ZTA3N2FjY2M2MS81YjA2OTY5ZS92aWRlby9tLzIyMDViNTQzMWU2ODBkYzQ2YzZhMDc1NDA4MThlMzczOWUzMTE1NWE1ZTAwMDAwYTE4ZjUxNjY5OTM5Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZWE2MDYzYzE3ZTY0ZTE2NTY5ZjUyOTViOTAzNTIzZTcvNWIwNjk2OWUvdmlkZW8vbS8yMjA1YjU0MzFlNjgwZGM0NmM2YTA3NTQwODE4ZTM3MzllMzExNTVhNWUwMDAwMGExOGY1MTY2OTkzOS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9hZjQ0Y2Y3NDkzNzVhZmVkZDJiNTk5ZTA3N2FjY2M2MS81YjA2OTY5ZS92aWRlby9tLzIyMDViNTQzMWU2ODBkYzQ2YzZhMDc1NDA4MThlMzczOWUzMTE1NWE1ZTAwMDAwYTE4ZjUxNjY5OTM5Lw==\",\"user_video_proxy\":1,\"socket_buffer\":11433420,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":970,\"vheight\":540,\"bitrate\":658032,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":21498108,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjc5MGYzMmQ3MWNlZWVhZjI0ODQ5OTEzMDY1MmUxNzcvNWIwNjk2OWUvdmlkZW8vbS8yMjBhMTA0NzY4ZjkyMjI0OTg2OGE3ZDMzN2E4ZTUxNzM0ZDExNTY0MTQ0MDAwMDlhYWZmNDRiMzc2NC8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jOGYyMWE1MWZjMTA5ZTgwNzc3MDM3Zjc1MWJjYTkyYy81YjA2OTY5ZS92aWRlby9tLzIyMGExMDQ3NjhmOTIyMjQ5ODY4YTdkMzM3YThlNTE3MzRkMTE1NjQxNDQwMDAwOWFhZmY0NGIzNzY0Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjc5MGYzMmQ3MWNlZWVhZjI0ODQ5OTEzMDY1MmUxNzcvNWIwNjk2OWUvdmlkZW8vbS8yMjBhMTA0NzY4ZjkyMjI0OTg2OGE3ZDMzN2E4ZTUxNzM0ZDExNTY0MTQ0MDAwMDlhYWZmNDRiMzc2NC8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jOGYyMWE1MWZjMTA5ZTgwNzc3MDM3Zjc1MWJjYTkyYy81YjA2OTY5ZS92aWRlby9tLzIyMGExMDQ3NjhmOTIyMjQ5ODY4YTdkMzM3YThlNTE3MzRkMTE1NjQxNDQwMDAwOWFhZmY0NGIzNzY0Lw==\",\"user_video_proxy\":1,\"socket_buffer\":14805720,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 佩恩之卷 佩恩经典合集","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6542085408941933064/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523198541,"bury_count":0,"card_type":"video","comment_count":46,"danmaku_count":0,"digg_count":765,"display_title":"","display_url":"http://toutiao.com/group/6542085408941933064/","group_flags":32865,"group_id":6542085408941933064,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6542085408941933064,"keywords":"佩恩,仙人模式,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/7579000e23e6bf2c1583","url":"http://p2.pstatp.com/list/7579000e23e6bf2c1583","url_list":[{"url":"http://p2.pstatp.com/list/7579000e23e6bf2c1583"},{"url":"http://pb3.pstatp.com/list/7579000e23e6bf2c1583"},{"url":"http://p.pstatp.com/list/7579000e23e6bf2c1583"}],"width":644},"preload_web":0,"publish_time":1523198541,"repin_count":265,"share_count":117,"share_token":"","share_url":"http://toutiao.com/group/6542085408941933064/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6542085408941933064,"text_count":15,"tip":0,"title":"开启了仙人模式的鸣人就是不一样，一个人对打佩恩数人，强到炸","title_rich_span":"","url":"http://toutiao.com/group/6542085408941933064/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/7579000e23e6bf2c1583","url":"http://p8.pstatp.com/video1609/7579000e23e6bf2c1583","url_list":[{"url":"http://p8.pstatp.com/video1609/7579000e23e6bf2c1583"},{"url":"http://pb3.pstatp.com/video1609/7579000e23e6bf2c1583"},{"url":"http://p.pstatp.com/video1609/7579000e23e6bf2c1583"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"7a7f823f18f540f8b0d8cd5a1ccc9fca","video_third_monitor_url":"","video_watch_count":136827},"video_duration":226,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":226.74,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/794b000269d79c41f54e\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/639e600002f3c31abc536/\",\"main_url\":\"http://voffline.byted.org/download/m/639e600002f3c31abc536/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":644,\"vheight\":358,\"bitrate\":193367,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7431962,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vOWQ5MTMxMDc3YTQyMDVjY2I1MjU0OTU1NWMxY2ZhYmIvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQ4YWM0NThmYjI4MDdjMmFjMGQzYmExNjhhYjdlMzQvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vOWQ5MTMxMDc3YTQyMDVjY2I1MjU0OTU1NWMxY2ZhYmIvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQ4YWM0NThmYjI4MDdjMmFjMGQzYmExNjhhYjdlMzQvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"user_video_proxy\":1,\"socket_buffer\":4350600,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":860,\"vheight\":478,\"bitrate\":283405,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":9979715,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vZDk4OWNkMGQ4YjFhM2JkYTExYzdhMGUyMmE2MmZmNTcvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTY3M2VmZWQ4OGQ4ZDBmYzM4Y2VlYTI0MzhjMmZlZjgvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vZDk4OWNkMGQ4YjFhM2JkYTExYzdhMGUyMmE2MmZmNTcvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTY3M2VmZWQ4OGQ4ZDBmYzM4Y2VlYTI0MzhjMmZlZjgvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"user_video_proxy\":1,\"socket_buffer\":6376500,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":968,\"vheight\":538,\"bitrate\":370003,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12429949,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzY2OGFkMzU0YmQ4NmE3YmQzZmFkNGJlNDdjNjg2MjAvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZTI3NjQwZTBlZjFmY2EzYjFlYWI4OGIyZjFjNmU2NGMvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzY2OGFkMzU0YmQ4NmE3YmQzZmFkNGJlNDdjNjg2MjAvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZTI3NjQwZTBlZjFmY2EzYjFlYWI4OGIyZjFjNmU2NGMvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"user_video_proxy\":1,\"socket_buffer\":8325000,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 催泪之卷 精选火影TV动画中的催泪感人场景，按播出时间排序，值得火影迷们反复回味.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6544485591055073796/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523756792,"bury_count":5,"card_type":"video","comment_count":222,"danmaku_count":0,"digg_count":1153,"display_title":"","display_url":"http://toutiao.com/group/6544485591055073796/","group_flags":32865,"group_id":6544485591055073796,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6544485591055073796,"keywords":"鸣人,tv动画,火影忍者,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/1523756763974b15318242f","url":"http://p1.pstatp.com/list/pgc-image/1523756763974b15318242f","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1523756763974b15318242f"},{"url":"http://pb3.pstatp.com/list/pgc-image/1523756763974b15318242f"},{"url":"http://p.pstatp.com/list/pgc-image/1523756763974b15318242f"}],"width":634},"preload_web":0,"publish_time":1523756792,"repin_count":744,"share_count":172,"share_token":"","share_url":"http://toutiao.com/group/6544485591055073796/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6544485591055073796,"text_count":42,"tip":0,"title":"自来也去世后，鸣人一度陷入了沉思无法自拔，看的不禁一阵心酸","title_rich_span":"","url":"http://toutiao.com/group/6544485591055073796/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523756763974b15318242f","url":"http://p10.pstatp.com/video1609/pgc-image/1523756763974b15318242f","url_list":[{"url":"http://p10.pstatp.com/video1609/pgc-image/1523756763974b15318242f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523756763974b15318242f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523756763974b15318242f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"5aad53aa8e6b4167960bb620a189f15d","video_third_monitor_url":"","video_watch_count":126397},"video_duration":237,"video_proportion_article":1.770949720670391,"video_style":0},{"abstract":"奇拉比忍界里的灵魂歌手，和自来也卡卡西一样有本小本子。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545961186242855438/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524100356,"bury_count":0,"card_type":"video","comment_count":25,"danmaku_count":0,"digg_count":31,"display_title":"","display_url":"http://toutiao.com/group/6545961186242855438/","group_flags":32865,"group_id":6545961186242855438,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545961186242855438,"keywords":"卡卡西,奇拉比,灵魂歌手","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/152410032999490ee5781a0","url":"http://p2.pstatp.com/list/pgc-image/152410032999490ee5781a0","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/152410032999490ee5781a0"},{"url":"http://pb3.pstatp.com/list/pgc-image/152410032999490ee5781a0"},{"url":"http://p.pstatp.com/list/pgc-image/152410032999490ee5781a0"}],"width":640},"preload_web":0,"publish_time":1524100356,"repin_count":13,"share_count":15,"share_token":"","share_url":"http://toutiao.com/group/6545961186242855438/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545961186242855438,"text_count":52,"tip":0,"title":"奇拉比你确定你没入错行，被人踢了一脚却还想着创作歌词","title_rich_span":"","url":"http://toutiao.com/group/6545961186242855438/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152410032999490ee5781a0","url":"http://p2.pstatp.com/video1609/pgc-image/152410032999490ee5781a0","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"},{"url":"http://p.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"270200b54f8a4220953b0270fdba18e8","video_third_monitor_url":"","video_watch_count":11153},"video_duration":95,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者：自来也误入妙木山，从此与蛤蟆解下不解之缘","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545297464134468104/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523945821,"bury_count":2,"card_type":"video","comment_count":28,"danmaku_count":0,"digg_count":370,"display_title":"","display_url":"http://toutiao.com/group/6545297464134468104/","group_flags":32865,"group_id":6545297464134468104,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545297464134468104,"keywords":"火影忍者,妙木山","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1523945680961b307320cae","url":"http://p1.pstatp.com/list/pgc-image/1523945680961b307320cae","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1523945680961b307320cae"},{"url":"http://pb3.pstatp.com/list/pgc-image/1523945680961b307320cae"},{"url":"http://p.pstatp.com/list/pgc-image/1523945680961b307320cae"}],"width":640},"preload_web":0,"publish_time":1523945821,"repin_count":107,"share_count":61,"share_token":"","share_url":"http://toutiao.com/group/6545297464134468104/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545297464134468104,"text_count":24,"tip":0,"title":"火影忍者：自来也误入妙木山，从此与蛤蟆解下不解之缘","title_rich_span":"","url":"http://toutiao.com/group/6545297464134468104/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523945680961b307320cae","url":"http://p9.pstatp.com/video1609/pgc-image/1523945680961b307320cae","url_list":[{"url":"http://p9.pstatp.com/video1609/pgc-image/1523945680961b307320cae"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523945680961b307320cae"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523945680961b307320cae"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"173780bfa3ae4f6aba2da8df91758603","video_third_monitor_url":"","video_watch_count":67409},"video_duration":87,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6551945632498582023/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525493718,"bury_count":1,"card_type":"video","comment_count":22,"danmaku_count":0,"digg_count":356,"display_title":"","display_url":"http://toutiao.com/group/6551945632498582023/","group_flags":32865,"group_id":6551945632498582023,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6551945632498582023,"keywords":"依鲁卡,漩涡鸣人,鸣人,火影忍者,下护额","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/15254937038686190f9b31a","url":"http://p1.pstatp.com/list/pgc-image/15254937038686190f9b31a","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/15254937038686190f9b31a"},{"url":"http://pb3.pstatp.com/list/pgc-image/15254937038686190f9b31a"},{"url":"http://p.pstatp.com/list/pgc-image/15254937038686190f9b31a"}],"width":640},"preload_web":0,"publish_time":1525493718,"repin_count":152,"share_count":24,"share_token":"","share_url":"http://toutiao.com/group/6551945632498582023/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6551945632498582023,"text_count":193,"tip":0,"title":"自来也整理了下护额：从这里开始，就是通往地狱的第一个路口了","title_rich_span":"","url":"http://toutiao.com/group/6551945632498582023/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15254937038686190f9b31a","url":"http://p1.pstatp.com/video1609/pgc-image/15254937038686190f9b31a","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"},{"url":"http://p.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201ff50000bbmijgnl54d1btkblrmg","video_third_monitor_url":"","video_watch_count":75539},"video_duration":118,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6553093246208180744/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525760918,"bury_count":1,"card_type":"video","comment_count":32,"danmaku_count":0,"digg_count":223,"display_title":"","display_url":"http://toutiao.com/group/6553093246208180744/","group_flags":32865,"group_id":6553093246208180744,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6553093246208180744,"keywords":"","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"酷漫优咪","middle_image":{"height":360,"uri":"list/pgc-image/15257608953403a8ffa9f6a","url":"http://p3.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://pb2.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://p.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"}],"width":640},"preload_web":0,"publish_time":1525760918,"repin_count":87,"share_count":21,"share_token":"","share_url":"http://toutiao.com/group/6553093246208180744/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"酷漫优咪","tag":"video_comic","tag_id":6553093246208180744,"text_count":0,"tip":0,"title":"火影忍者：宇智波斑亲口承认，柱间比自己还要厉害！","title_rich_span":"","url":"http://toutiao.com/group/6553093246208180744/","user_info":{"avatar_url":"http://p1.pstatp.com/thumb/6ee8000148b9a2cddde0","description":"最新最及时的动漫新番,最棒的ACG氛围,独家的动漫内容推送","follow":false,"is_living":false,"media_id":0,"name":"酷漫优咪","screen_name":"酷漫优咪","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下帐号\"}","user_id":73317479422,"user_verified":1,"verified_content":"优酷旗下帐号","video_live_auth":true},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15257608953403a8ffa9f6a","url":"http://p1.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://p.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201f180000bbohtkiikatmh18a3u6g","video_third_monitor_url":"","video_watch_count":39181},"video_duration":89,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 佩恩之卷 佩恩经典合集","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6542069113693405710/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523194162,"bury_count":1,"card_type":"video","comment_count":37,"danmaku_count":0,"digg_count":330,"display_title":"","display_url":"http://toutiao.com/group/6542069113693405710/","group_flags":32865,"group_id":6542069113693405710,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6542069113693405710,"keywords":"卡卡西,火影忍者,佩恩","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/152319415220276f219d347","url":"http://p3.pstatp.com/list/pgc-image/152319415220276f219d347","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/152319415220276f219d347"},{"url":"http://pb2.pstatp.com/list/pgc-image/152319415220276f219d347"},{"url":"http://p.pstatp.com/list/pgc-image/152319415220276f219d347"}],"width":644},"preload_web":0,"publish_time":1523194162,"repin_count":75,"share_count":83,"share_token":"","share_url":"http://toutiao.com/group/6542069113693405710/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6542069113693405710,"text_count":15,"tip":0,"title":"卡卡西被佩恩欺负，关键时刻丁次父子的出现，成功逆转了局势","title_rich_span":"","url":"http://toutiao.com/group/6542069113693405710/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152319415220276f219d347","url":"http://p2.pstatp.com/video1609/pgc-image/152319415220276f219d347","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152319415220276f219d347"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152319415220276f219d347"},{"url":"http://p.pstatp.com/video1609/pgc-image/152319415220276f219d347"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"fb3a781cefa94e649891b316ef8558d1","video_third_monitor_url":"","video_watch_count":74464},"video_duration":200,"video_proportion_article":1.78,"video_style":0},{"abstract":"超然，妙木山全蛙出动，带队队长蛤蟆大仙漩涡鸣人","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6546872857152979460/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524312621,"bury_count":6,"card_type":"video","comment_count":90,"danmaku_count":0,"digg_count":559,"display_title":"","display_url":"http://toutiao.com/group/6546872857152979460/","group_flags":32865,"group_id":6546872857152979460,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6546872857152979460,"keywords":"漩涡鸣人,妙木山,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524312277539ecb4e5a09f","url":"http://p2.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://p.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"}],"width":640},"preload_web":0,"publish_time":1524312621,"repin_count":261,"share_count":107,"share_token":"","share_url":"http://toutiao.com/group/6546872857152979460/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6546872857152979460,"text_count":22,"tip":0,"title":"火影忍者：超燃，妙木山全蛙出动，带队队长蛤蟆大仙漩涡鸣人","title_rich_span":"","url":"http://toutiao.com/group/6546872857152979460/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524312277539ecb4e5a09f","url":"http://p2.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"56fceebc5b264a8d93894484c72c6893","video_third_monitor_url":"","video_watch_count":129428},"video_duration":160,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543151419455701507/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523791512,"bury_count":5,"card_type":"video","comment_count":156,"danmaku_count":0,"digg_count":520,"display_title":"","display_url":"http://toutiao.com/group/6543151419455701507/","group_flags":32865,"group_id":6543151419455701507,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6543151419455701507,"keywords":"依鲁卡,鸣人,纲手,火影忍者,漩涡鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/1523790583618d220d8ced5","url":"http://p3.pstatp.com/list/pgc-image/1523790583618d220d8ced5","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1523790583618d220d8ced5"},{"url":"http://pb2.pstatp.com/list/pgc-image/1523790583618d220d8ced5"},{"url":"http://p.pstatp.com/list/pgc-image/1523790583618d220d8ced5"}],"width":640},"preload_web":0,"publish_time":1523791512,"repin_count":381,"share_count":157,"share_token":"","share_url":"http://toutiao.com/group/6543151419455701507/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543151419455701507,"text_count":186,"tip":0,"title":"自来也战死前夕，泪目：为什么不向纲手表白，明明这次能成功的","title_rich_span":"","url":"http://toutiao.com/group/6543151419455701507/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523790583618d220d8ced5","url":"http://p1.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"40a7d131772a483eae560b982b5e4ecd","video_third_monitor_url":"","video_watch_count":66576},"video_duration":126,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"博人传 火影忍者新时代 经历漫长的战争之后以七代目火影漩涡鸣人治理的木叶村为中心，成立了新的忍者5大国，本作主要讲述鸣人的儿子、虽然有才能却把鸣人叫做臭老爸的漩涡博人；佐助的女儿、对鸣人抱持憧憬的宇智波佐良娜；以及充满了谜团的超级优秀忍者巳月三人一组，在村子里努力修炼成长的故事.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6557594011735949838/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1526812800,"bury_count":6,"card_type":"video","comment_count":15,"danmaku_count":0,"digg_count":86,"display_title":"","display_url":"http://toutiao.com/group/6557594011735949838/","group_flags":32865,"group_id":6557594011735949838,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6557594011735949838,"keywords":"漩涡鸣人,宇智波,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/1526808827514e0e0e78f3f","url":"http://p3.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://pb2.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://p.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"}],"width":640},"preload_web":0,"publish_time":1526812800,"repin_count":41,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6557594011735949838/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6557594011735949838,"text_count":135,"tip":0,"title":"面对敌人的猛烈进攻，巳月准备开启仙人化，对方一看吓得赶紧后退","title_rich_span":"","url":"http://toutiao.com/group/6557594011735949838/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1526808827514e0e0e78f3f","url":"http://p2.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201f180000bc0k20c9hq5lbckadno0","video_third_monitor_url":"","video_watch_count":22333},"video_duration":104,"video_proportion_article":1.78,"video_style":0},{"abstract":"六尾这实力不弱于自来也吧，还是被佩恩压倒性优势收服","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6551304975664808456/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525344554,"bury_count":0,"card_type":"video","comment_count":28,"danmaku_count":0,"digg_count":50,"display_title":"","display_url":"http://toutiao.com/group/6551304975664808456/","group_flags":32865,"group_id":6551304975664808456,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6551304975664808456,"keywords":"佩恩,六尾,自来也,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1525344156761d73eb3b0a7","url":"http://p3.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://pb2.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://p.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"}],"width":640},"preload_web":0,"publish_time":1525344554,"repin_count":16,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6551304975664808456/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6551304975664808456,"text_count":24,"tip":0,"title":"火影忍者：六尾这实力不弱于自来也吧，还是被佩恩压倒性优势收服","title_rich_span":"","url":"http://toutiao.com/group/6551304975664808456/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1525344156761d73eb3b0a7","url":"http://p1.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://p.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v02004180000bbleerd8n75uip0e6cag","video_third_monitor_url":"","video_watch_count":6766},"video_duration":188,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543390730394534407/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523791717,"bury_count":7,"card_type":"video","comment_count":84,"danmaku_count":0,"digg_count":699,"display_title":"","display_url":"http://toutiao.com/group/6543390730394534407/","group_flags":32865,"group_id":6543390730394534407,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6543390730394534407,"keywords":"依鲁卡,漩涡鸣人,佩恩六道,火影忍者,鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/152379152465260c1eced75","url":"http://p2.pstatp.com/list/pgc-image/152379152465260c1eced75","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/152379152465260c1eced75"},{"url":"http://pb3.pstatp.com/list/pgc-image/152379152465260c1eced75"},{"url":"http://p.pstatp.com/list/pgc-image/152379152465260c1eced75"}],"width":648},"preload_web":0,"publish_time":1523791717,"repin_count":165,"share_count":95,"share_token":"","share_url":"http://toutiao.com/group/6543390730394534407/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543390730394534407,"text_count":194,"tip":0,"title":"鸣人独战佩恩六道，这招直接撂倒一个佩恩，天道瞬间就慌了","title_rich_span":"","url":"http://toutiao.com/group/6543390730394534407/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152379152465260c1eced75","url":"http://p2.pstatp.com/video1609/pgc-image/152379152465260c1eced75","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152379152465260c1eced75"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152379152465260c1eced75"},{"url":"http://p.pstatp.com/video1609/pgc-image/152379152465260c1eced75"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"5c545478a19c4d0585879b0e85e05273","video_third_monitor_url":"","video_watch_count":145031},"video_duration":215,"video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 火影忍者：整部火影鸣人最帅瞬间，完全尾兽形态之力，燃！","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6549376716815467015/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525062720,"bury_count":9,"card_type":"video","comment_count":249,"danmaku_count":0,"digg_count":1273,"display_title":"","display_url":"http://toutiao.com/group/6549376716815467015/","group_flags":32865,"group_id":6549376716815467015,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6549376716815467015,"keywords":"火影忍者,鸣人,火影,尾兽","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"酷漫优咪","middle_image":{"height":360,"uri":"list/pgc-image/15249045019386e2da2bc4c","url":"http://p3.pstatp.com/list/pgc-image/15249045019386e2da2bc4c","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"},{"url":"http://pb2.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"},{"url":"http://p.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"}],"width":640},"preload_web":0,"publish_time":1525062720,"repin_count":710,"share_count":359,"share_token":"","share_url":"http://toutiao.com/group/6549376716815467015/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"酷漫优咪","tag":"video_comic","tag_id":6549376716815467015,"text_count":29,"tip":0,"title":"火影忍者：整部火影鸣人最帅瞬间，完全尾兽形态之力，燃！","title_rich_span":"","url":"http://toutiao.com/group/6549376716815467015/","user_info":{"avatar_url":"http://p1.pstatp.com/thumb/6ee8000148b9a2cddde0","description":"最新最及时的动漫新番,最棒的ACG氛围,独家的动漫内容推送","follow":false,"is_living":false,"media_id":0,"name":"酷漫优咪","screen_name":"酷漫优咪","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下帐号\"}","user_id":73317479422,"user_verified":1,"verified_content":"优酷旗下帐号","video_live_auth":true},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15249045019386e2da2bc4c","url":"http://p8.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c","url_list":[{"url":"http://p8.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"},{"url":"http://p.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"3d197fd103934705b11d26253ba0ec23","video_third_monitor_url":"","video_watch_count":284228},"video_duration":82,"video_proportion_article":1.7777777777777777,"video_style":0}],"related_wenda":[],"repin_count":1,"rewards":{"rewards_list":[],"rewards_list_url":"sslocal://webview?title=%E8%B5%9E%E8%B5%8F%E8%AF%A6%E6%83%85&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Farticle_praise_list%2F%3Farticle_id%3D6545690546311004686","rewards_num":0,"rewards_open_url":"sslocal://webview?title=%E8%B5%9E%E8%B5%8F&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Fselect_amount%2F%3Fmedia_id%3D1587845744613390%26article_id%3D6545690546311004686"},"script":"\n\t    if(typeof updateAppreciateCountByServer == 'function'){\n\t\tupdateAppreciateCountByServer(0);\n\t    }else{\n\t\twindow.updateAppreciateCountByServerCallback = function(){\n\t\t    updateAppreciateCountByServer(0);\n\t\t}\n\t    }\n\t    ","share_info":{"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"share_url":"http://m.toutiaoimg.cn/group/6545690546311004686/?iid=32758433763&app=news_article&timestamp=1527154594","title":"【今日头条】火影忍者：心疼自来也受了那么重的伤，一定要活下去拜托"},"share_type":2,"share_url":"http://m.toutiaoimg.cn/group/6545690546311004686/?iid=32758433763&app=news_article&timestamp=1527154594","show_pgc_subscibe":1,"source":"磁力影视","ug_install_aid":0,"url":"http://toutiao.com/group/6545690546311004686/","user_bury":0,"user_digg":0,"user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","fans_count":38750,"follow":0,"media_id":1587845744613390,"name":"磁力影视","special_column":[],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_decoration":"","user_id":82702459638,"user_verified":true},"user_like":0,"user_repin":0,"video_label_html":"","video_watch_count":3836}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ad : {"is_preview":false,"mixed":{"button_text":"立即下载","dislike":[{"name":"为什么看到此广告","open_url":"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike&hide_more=1&title=为什么看到此广告"}],"display_subtype":3,"filter_words":[{"id":"4:2","is_selected":false,"name":"看过了"},{"id":"2:0","is_selected":false,"name":"屏蔽:京东 的广告"}],"id":94112175398,"image":"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg","image_height":286,"image_width":690,"is_tongtou_ad":false,"label":"京东广告","log_extra":"{\"ad_price\":\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\",\"convert_component_suspend\":0,\"convert_id\":0,\"external_action\":0,\"item_id\":6545690546311004686,\"media_id\":1587845744613390,\"orit\":null,\"req_id\":\"201805241736340100150181521464BC\",\"rit\":3}","open_url":"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A","show_dislike":1,"source_name":"京东 ","title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","track_url":"","track_url_list":[],"type":"web","web_title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","web_url":"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x&log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8&v=404&p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA&bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398"}}
         * ban_bury : 0
         * ban_comment : 0
         * ban_danmaku : false
         * ban_digg : 0
         * bury_count : 0
         * comment_count : 3
         * context : {"labels":{"labels_style":2,"labels_words":[{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%8E%92%E5%90%8D","word":"火影忍者排名"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%8D%9A%E4%BA%BA%E4%BC%A0","word":"火影忍者博人传"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%BF%8D%E6%9C%AF","word":"火影忍者忍术"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%89%8B%E6%B8%B8","word":"火影忍者手游"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E9%9B%8F%E7%94%B0","word":"火影忍者雏田"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E4%BD%90%E5%8A%A9","word":"火影忍者佐助"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%A3%81%E7%BA%B8","word":"火影忍者壁纸"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%8D%A1%E5%8D%A1%E8%A5%BF","word":"火影忍者卡卡西"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%86%99%E8%BD%AE%E7%9C%BC","word":"火影忍者写轮眼"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E6%88%91%E7%88%B1%E7%BD%97","word":"火影忍者我爱罗"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E4%B9%9D%E5%B0%BE","word":"火影忍者九尾"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%AE%87%E6%99%BA%E6%B3%A2%E9%BC%AC","word":"火影忍者宇智波鼬"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%9B%BE%E7%89%87","word":"火影忍者图片"},{"link":"sslocal://search?extra=%7B%27entra_from%27%3A+%27click_related%27%2C+%27group_id%27%3A+6545690546311004686%7D\u0026from=article_tag_wap_2\u0026gd_ext_json=%7B%22enter_from%22%3A%22click_related%22%7D\u0026keyword=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85%E5%B8%A6%E5%9C%9F","word":"火影忍者带土"}]},"tip":""}
         * danmaku_count : 0
         * detail_show_flags : 0
         * digg_count : 22
         * display_url : http://toutiao.com/group/6545690546311004686/
         * filter_words : [{"id":"5:2112582931","name":"拉黑作者:磁力影视"},{"id":"1:582095509","name":"不想看:动漫视频"},{"id":"6:2404885","name":"不想看:火影忍者"}]
         * group_flags : 1
         * group_id : 6545690546311004686
         * h5_extra : {"have_red_pack":0,"is_original":true,"is_subscribed":0,"media":{"avatar_url":"http://p4.pstatp.com/large/6eea00032201847d263f","can_be_praised":true,"description":"这里有最新的动漫新番，还有从小追到大的回忆","id":1587845744613390,"name":"磁力影视","pgc_custom_menu":"","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_decoration":"","user_verified":true}}
         * ignore_web_transform : 0
         * info_flag : 7
         * is_wenda : 0
         * like_count : 22
         * like_desc : 关心这篇文章，会推荐更多此类内容
         * log_pb : {"impr_id":"201805241736340100150181521464BC"}
         * media_info : {"avatar_url":"http://p4.pstatp.com/large/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","media_id":1587845744613390,"name":"磁力影视","special_column":[],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":true}
         * ordered_info : [{"ad_data":"{\"is_preview\":false,\"mixed\":{\"button_text\":\"立即下载\",\"dislike\":[{\"name\":\"为什么看到此广告\",\"open_url\":\"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike\\u0026hide_more=1\\u0026title=为什么看到此广告\"}],\"display_subtype\":3,\"filter_words\":[{\"id\":\"4:2\",\"is_selected\":false,\"name\":\"看过了\"},{\"id\":\"2:0\",\"is_selected\":false,\"name\":\"屏蔽:京东 的广告\"}],\"id\":94112175398,\"image\":\"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg\",\"image_height\":286,\"image_width\":690,\"is_tongtou_ad\":false,\"label\":\"京东广告\",\"log_extra\":\"{\\\"ad_price\\\":\\\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\\\",\\\"convert_component_suspend\\\":0,\\\"convert_id\\\":0,\\\"external_action\\\":0,\\\"item_id\\\":6545690546311004686,\\\"media_id\\\":1587845744613390,\\\"orit\\\":null,\\\"req_id\\\":\\\"201805241736340100150181521464BC\\\",\\\"rit\\\":3}\",\"open_url\":\"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A\",\"show_dislike\":1,\"source_name\":\"京东 \",\"title\":\"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！\",\"track_url\":\"\",\"track_url_list\":[],\"type\":\"web\",\"web_title\":\"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！\",\"web_url\":\"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x\\u0026log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8\\u0026v=404\\u0026p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA\\u0026bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398\"}}","name":"ad"}]
         * read_count : 346
         * recommend_sponsor : {"icon_url":"http://p3.pstatp.com/origin/13ef000096960314fff4","label":"帮上头条","target_url":"https://i.snssdk.com/ad/pgc_promotion/mobile/create/?group_id=6545690546311004686&item_id=6545690546311004686"}
         * related_video_section : 8
         * related_video_toutiao : [{"abstract":"这样买家具？上门量尺设计风格，欧派全屋定制仅1.","ad_id":1601336525302803,"aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/item/6559076033067221252/","ban_action":0,"ban_bury":0,"ban_comment":1,"ban_danmaku":0,"ban_download":0,"behot_time":1527153894,"bury_count":0,"card_type":"ad_video","comment_count":0,"danmaku_count":0,"digg_count":0,"display_title":"","display_url":"http://toutiao.com/item/6559076033067221252/","group_flags":36961,"group_id":6559076033067221252,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"id":1601336525302803,"image_count":0,"image_list":[],"is_article":true,"is_preview":false,"item_id":6559076033067221252,"keywords":"","level":0,"log_extra":"{\"rit\":9,\"orit\":1,\"req_id\":\"201805241736340100150181521464BC\",\"convert_id\":1599855812619320,\"external_action\":2,\"convert_component_suspend\":0,\"ad_price\":\"WwaHogAOveFbBoeiAA694b3aYeRig8ftWMA0ig\"}","log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"middle_image":{"day_mode":0,"height":720,"uri":"list/web.business.image/201805245d0dc105427ed90941ae88f4","url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg","url_list":[{"url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"}],"width":1280},"natant_level":2,"open_url":"","preload_web":0,"publish_time":1527153894,"repin_count":0,"share_count":0,"share_token":"","share_url":"http://toutiao.com/group/6559076033067221252/?iid=32758433763&app=news_article","show_tag":"广告","source":"欧派高端全屋定制","tag":"ad","tag_id":6559076033067221252,"text_count":0,"tip":0,"title":"这样买家具？上门量尺设计风格，欧派全屋定制仅1.98万","title_rich_span":"","track_url_list":[],"type":"web","url":"http://toutiao.com/item/6559076033067221252/","video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/86da000ded94cbc14fec","url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec","url_list":[{"url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://pb3.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://p.pstatp.com/video1609/86da000ded94cbc14fec"}],"width":580},"direct_play":1,"group_flags":36961,"show_pgc_subscribe":1,"video_id":"v03033c20000bc32u7dehji8cgidktmg","video_third_monitor_url":"","video_watch_count":186},"video_duration":15,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":15.96,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/86da000ded94cbc14fec\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/\",\"main_url\":\"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":323799,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":787710,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=\",\"user_video_proxy\":1,\"socket_buffer\":7285320,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":489240,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":1116954,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=\",\"user_video_proxy\":1,\"socket_buffer\":11007900,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":1044478,\"logo_type\":\"\",\"codec_type\":\"h264\",\"size\":2221878,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=\",\"user_video_proxy\":1,\"socket_buffer\":23500620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_style":0,"web_url":""},{"abstract":"自来也的仙人模式果然不是盖的，但缺点是三张嘴巴好吵","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545603242405921288/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524017016,"bury_count":2,"card_type":"video","comment_count":16,"danmaku_count":0,"digg_count":200,"display_title":"","display_url":"http://toutiao.com/group/6545603242405921288/","group_flags":32865,"group_id":6545603242405921288,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545603242405921288,"keywords":"自来也,嘴巴,仙人模式,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524016857614b6aa01ef82","url":"http://p1.pstatp.com/list/pgc-image/1524016857614b6aa01ef82","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"},{"url":"http://p.pstatp.com/list/pgc-image/1524016857614b6aa01ef82"}],"width":640},"preload_web":0,"publish_time":1524017016,"repin_count":94,"share_count":41,"share_token":"","share_url":"http://toutiao.com/group/6545603242405921288/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545603242405921288,"text_count":24,"tip":0,"title":"火影忍者：自来也的仙人模式果然不是盖的，但缺点是三张嘴巴好吵","title_rich_span":"","url":"http://toutiao.com/group/6545603242405921288/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524016857614b6aa01ef82","url":"http://p2.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524016857614b6aa01ef82"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"af517e17d71040d69e3f25d501f58e87","video_third_monitor_url":"","video_watch_count":35855},"video_duration":114,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":114.62,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c070012517cc586dfc8\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/66d0e000032f092941daa/\",\"main_url\":\"http://voffline.byted.org/download/m/66d0e000032f092941daa/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":149957,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3140776,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vODBlYzQxOGVkMjMyZGM5MThlZmEwOTY1ZDFmNDZiYjUvNWIwNjk2MjQvdmlkZW8vbS8yMjBhOGY2M2YyYWZlMTA0ZDFkYWEyY2EzY2JlNzkyNGEyZTExNTY3ZWZmMDAwMDI2NzRjNWNiZmUxNS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83MGU4OTJhMDlkOGJjZDVkNzY5MDU5MjZiNWMzM2YyZS81YjA2OTYyNC92aWRlby9tLzIyMGE4ZjYzZjJhZmUxMDRkMWRhYTJjYTNjYmU3OTI0YTJlMTE1NjdlZmYwMDAwMjY3NGM1Y2JmZTE1Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vODBlYzQxOGVkMjMyZGM5MThlZmEwOTY1ZDFmNDZiYjUvNWIwNjk2MjQvdmlkZW8vbS8yMjBhOGY2M2YyYWZlMTA0ZDFkYWEyY2EzY2JlNzkyNGEyZTExNTY3ZWZmMDAwMDI2NzRjNWNiZmUxNS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83MGU4OTJhMDlkOGJjZDVkNzY5MDU5MjZiNWMzM2YyZS81YjA2OTYyNC92aWRlby9tLzIyMGE4ZjYzZjJhZmUxMDRkMWRhYTJjYTNjYmU3OTI0YTJlMTE1NjdlZmYwMDAwMjY3NGM1Y2JmZTE1Lw==\",\"user_video_proxy\":1,\"socket_buffer\":3373920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":219487,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4136964,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMTE4YmNmODc2ZmUyMmExZDdhOTRmODRkYjA3YjE3MjQvNWIwNjk2MjQvdmlkZW8vbS8yMjBkNzAyZTVjYzk5ODY0OWZmODgwZjY0OTZmMTNlYzNlZTExNTY3ZWIwMDAwMGFiNjA1YTY2MThiMy8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNDA0Y2FkMWEzMzczYmI0ZDliYzNlZWZjNjlhMDc2MC81YjA2OTYyNC92aWRlby9tLzIyMGQ3MDJlNWNjOTk4NjQ5ZmY4ODBmNjQ5NmYxM2VjM2VlMTE1NjdlYjAwMDAwYWI2MDVhNjYxOGIzLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMTE4YmNmODc2ZmUyMmExZDdhOTRmODRkYjA3YjE3MjQvNWIwNjk2MjQvdmlkZW8vbS8yMjBkNzAyZTVjYzk5ODY0OWZmODgwZjY0OTZmMTNlYzNlZTExNTY3ZWIwMDAwMGFiNjA1YTY2MThiMy8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS8xNDA0Y2FkMWEzMzczYmI0ZDliYzNlZWZjNjlhMDc2MC81YjA2OTYyNC92aWRlby9tLzIyMGQ3MDJlNWNjOTk4NjQ5ZmY4ODBmNjQ5NmYxM2VjM2VlMTE1NjdlYjAwMDAwYWI2MDVhNjYxOGIzLw==\",\"user_video_proxy\":1,\"socket_buffer\":4938300,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":442515,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7333405,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGUwZjUyMzUxNDAxMWUzNWNjYTZhNmUwMDliNmUxODMvNWIwNjk2MjQvdmlkZW8vbS8yMjBhNTY5ZjMwZWM2ODY0YWMzYTg3OGRlZDc5YzY0YmI5YzExNTY4MzE2MDAwMGE5YzJmZGNjYTNkMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9lNWNmNTZmZTdkZGNmYjg5MGMyNTM2YjVmYTc0MjY1MC81YjA2OTYyNC92aWRlby9tLzIyMGE1NjlmMzBlYzY4NjRhYzNhODc4ZGVkNzljNjRiYjljMTE1NjgzMTYwMDAwYTljMmZkY2NhM2QyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNGUwZjUyMzUxNDAxMWUzNWNjYTZhNmUwMDliNmUxODMvNWIwNjk2MjQvdmlkZW8vbS8yMjBhNTY5ZjMwZWM2ODY0YWMzYTg3OGRlZDc5YzY0YmI5YzExNTY4MzE2MDAwMGE5YzJmZGNjYTNkMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9lNWNmNTZmZTdkZGNmYjg5MGMyNTM2YjVmYTc0MjY1MC81YjA2OTYyNC92aWRlby9tLzIyMGE1NjlmMzBlYzY4NjRhYzNhODc4ZGVkNzljNjRiYjljMTE1NjgzMTYwMDAwYTljMmZkY2NhM2QyLw==\",\"user_video_proxy\":1,\"socket_buffer\":9956520,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"自来也这个造型也太拉风了，三个蛤蟆仙人共用一体。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545598496571916814/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524015911,"bury_count":1,"card_type":"video","comment_count":22,"danmaku_count":0,"digg_count":84,"display_title":"","display_url":"http://toutiao.com/group/6545598496571916814/","group_flags":32865,"group_id":6545598496571916814,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545598496571916814,"keywords":"火影忍者,仙人,蛤蟆仙人,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524015779992596efdd73b","url":"http://p3.pstatp.com/list/pgc-image/1524015779992596efdd73b","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1524015779992596efdd73b"},{"url":"http://pb2.pstatp.com/list/pgc-image/1524015779992596efdd73b"},{"url":"http://p.pstatp.com/list/pgc-image/1524015779992596efdd73b"}],"width":640},"preload_web":0,"publish_time":1524015911,"repin_count":21,"share_count":20,"share_token":"","share_url":"http://toutiao.com/group/6545598496571916814/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545598496571916814,"text_count":51,"tip":0,"title":"火影忍者：自来也这个造型也太拉风了，三个蛤蟆仙人共用一体","title_rich_span":"","url":"http://toutiao.com/group/6545598496571916814/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524015779992596efdd73b","url":"http://p9.pstatp.com/video1609/pgc-image/1524015779992596efdd73b","url_list":[{"url":"http://p9.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524015779992596efdd73b"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"9a369a091cb948bf90c8339ad2bdd778","video_third_monitor_url":"","video_watch_count":20747},"video_duration":132,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":132.61,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c0600113eba5fcdf03e\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6360e000036dbbc54aed4/\",\"main_url\":\"http://voffline.byted.org/download/m/6360e000036dbbc54aed4/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":162475,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3841515,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vOTBlNjYyNWY4NGNiZjQ0ZDk3ZTExYWI2MDk3MmU3MmMvNWIwNjk2MzYvdmlkZW8vbS8yMjAzYTU1ZjFjNTRiMDc0ODQ3OTAxODdhN2RiZjliMGE1NTExNTYwYjU1MDAwMDE2ZTQ4ZDg2MmNhYS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS84Zjc2MDliYjIyNDkzZjA1ZDM2YWJlMGYwYzE2ODRhZS81YjA2OTYzNi92aWRlby9tLzIyMDNhNTVmMWM1NGIwNzQ4NDc5MDE4N2E3ZGJmOWIwYTU1MTE1NjBiNTUwMDAwMTZlNDhkODYyY2FhLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vOTBlNjYyNWY4NGNiZjQ0ZDk3ZTExYWI2MDk3MmU3MmMvNWIwNjk2MzYvdmlkZW8vbS8yMjAzYTU1ZjFjNTRiMDc0ODQ3OTAxODdhN2RiZjliMGE1NTExNTYwYjU1MDAwMDE2ZTQ4ZDg2MmNhYS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS84Zjc2MDliYjIyNDkzZjA1ZDM2YWJlMGYwYzE2ODRhZS81YjA2OTYzNi92aWRlby9tLzIyMDNhNTVmMWM1NGIwNzQ4NDc5MDE4N2E3ZGJmOWIwYTU1MTE1NjBiNTUwMDAwMTZlNDhkODYyY2FhLw==\",\"user_video_proxy\":1,\"socket_buffer\":3655620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":246376,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5232670,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjcwMzliYzEzNTBhMDE3NzViMmQ1N2ZmOGRlYjliNjYvNWIwNjk2MzYvdmlkZW8vbS8yMjA1MjYzMDJiNGYwMjc0Y2Q4YTc3OTY4OTBjNjU3ZTM4YjExNTY3NjYwMDAwMGFiNGNhYWZkYTFjMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS81YTM0MjVkNDNmMGZlNWQ1M2I4NTFkMjQ5MTBlMGU2NS81YjA2OTYzNi92aWRlby9tLzIyMDUyNjMwMmI0ZjAyNzRjZDhhNzc5Njg5MGM2NTdlMzhiMTE1Njc2NjAwMDAwYWI0Y2FhZmRhMWMyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjcwMzliYzEzNTBhMDE3NzViMmQ1N2ZmOGRlYjliNjYvNWIwNjk2MzYvdmlkZW8vbS8yMjA1MjYzMDJiNGYwMjc0Y2Q4YTc3OTY4OTBjNjU3ZTM4YjExNTY3NjYwMDAwMGFiNGNhYWZkYTFjMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS81YTM0MjVkNDNmMGZlNWQ1M2I4NTFkMjQ5MTBlMGU2NS81YjA2OTYzNi92aWRlby9tLzIyMDUyNjMwMmI0ZjAyNzRjZDhhNzc5Njg5MGM2NTdlMzhiMTE1Njc2NjAwMDAwYWI0Y2FhZmRhMWMyLw==\",\"user_video_proxy\":1,\"socket_buffer\":5543460,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":529559,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":9927930,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDcwYWQ1MzRjMjU0MDhiNjBmMWE5MWI3YzViYTAwMTcvNWIwNjk2MzYvdmlkZW8vbS8yMjA5OThlM2FlM2VjNDc0ZTQwOGQ3MTZlNDU0MmVhNmY0MzExNTY0Yzk2MDAwMDVhNmYyZWM2MWJjYi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83NTdjZjQ4NDViZjExNTBkYzdlY2MxNDFiM2QzZWE2ZS81YjA2OTYzNi92aWRlby9tLzIyMDk5OGUzYWUzZWM0NzRlNDA4ZDcxNmU0NTQyZWE2ZjQzMTE1NjRjOTYwMDAwNWE2ZjJlYzYxYmNiLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDcwYWQ1MzRjMjU0MDhiNjBmMWE5MWI3YzViYTAwMTcvNWIwNjk2MzYvdmlkZW8vbS8yMjA5OThlM2FlM2VjNDc0ZTQwOGQ3MTZlNDU0MmVhNmY0MzExNTY0Yzk2MDAwMDVhNmYyZWM2MWJjYi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS83NTdjZjQ4NDViZjExNTBkYzdlY2MxNDFiM2QzZWE2ZS81YjA2OTYzNi92aWRlby9tLzIyMDk5OGUzYWUzZWM0NzRlNDA4ZDcxNmU0NTQyZWE2ZjQzMTE1NjRjOTYwMDAwNWE2ZjJlYzYxYmNiLw==\",\"user_video_proxy\":1,\"socket_buffer\":11914920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"鸣人和纲手得知自来也的死讯，火影中最感人的一段","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6546157157077746184/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524145984,"bury_count":0,"card_type":"video","comment_count":25,"danmaku_count":0,"digg_count":158,"display_title":"","display_url":"http://toutiao.com/group/6546157157077746184/","group_flags":32865,"group_id":6546157157077746184,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6546157157077746184,"keywords":"火影,火影忍者,纲手","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524145953496e1c81d1e5c","url":"http://p1.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://p.pstatp.com/list/pgc-image/1524145953496e1c81d1e5c"}],"width":640},"preload_web":0,"publish_time":1524145984,"repin_count":41,"share_count":21,"share_token":"","share_url":"http://toutiao.com/group/6546157157077746184/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6546157157077746184,"text_count":22,"tip":0,"title":"火影忍者：鸣人和纲手得知自来也的死讯，火影中最感人的一段","title_rich_span":"","url":"http://toutiao.com/group/6546157157077746184/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524145953496e1c81d1e5c","url":"http://p3.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://pb2.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524145953496e1c81d1e5c"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"fe7bc92aebce4893afab40fb8290ae60","video_third_monitor_url":"","video_watch_count":19308},"video_duration":222,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":222.87,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c5a0002495d43ce7bf7\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6639300001fa4896ace3f/\",\"main_url\":\"http://voffline.byted.org/download/m/6639300001fa4896ace3f/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":123100,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5356741,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzVlZGJhY2YyMzNjMTI5M2Y4MGY5ZTA2ZmRiODM1MDMvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNGQzZmU3NjhiZWJiZTQ3YTk0MTI5ZWRmNzJiMjE2MmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzVlZGJhY2YyMzNjMTI5M2Y4MGY5ZTA2ZmRiODM1MDMvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNGQzZmU3NjhiZWJiZTQ3YTk0MTI5ZWRmNzJiMjE2MmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAxZTM3NmQ3YWIwZDA0NzA0YjM5NzVkYWU5Y2QxNDlkODExNTY3YTFmMDAwMDMxNmRhZjIwNTIzMS8=\",\"user_video_proxy\":1,\"socket_buffer\":2769660,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":182819,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7020119,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vYmIzZDc3MmI5NzIxZTQ4YTc2OTYzNjBkZjQxZmJjZWUvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vODM1YWI1Mjk0YTE4NTMxODczMjE5ODczNDQyOWVkZWMvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vYmIzZDc3MmI5NzIxZTQ4YTc2OTYzNjBkZjQxZmJjZWUvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vODM1YWI1Mjk0YTE4NTMxODczMjE5ODczNDQyOWVkZWMvNWIwNjk2OTAvdmlkZW8vbS8yMjAzNzQwMTFlMDIxZmM0MDhkYTZmN2FlZDVjMDcwYThiODExNTY4NjdhMDAwMDJmZmJkN2Y4MTVhMC8=\",\"user_video_proxy\":1,\"socket_buffer\":4113360,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":387970,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12735347,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vMTM3Zjc3YzIwMGM0YjIyNDE3YTdiNzJiYTA5YTVkYmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTMwNjVlZDA0MzM2MTg2ZjIzMzc0ZTQ2MWI2MWM3MzIvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vMTM3Zjc3YzIwMGM0YjIyNDE3YTdiNzJiYTA5YTVkYmQvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTMwNjVlZDA0MzM2MTg2ZjIzMzc0ZTQ2MWI2MWM3MzIvNWIwNjk2OTAvdmlkZW8vbS8yMjAzYjM0NmVhYTJkOTY0ZjU4ODY5YjA0ZjBmNjhlMmM4NjExNTY4MjUxMDAwMDJmZDNhMTIyMzhiNy8=\",\"user_video_proxy\":1,\"socket_buffer\":8729280,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"师徒间彻底决裂，轮回眼长门对决仙人自来也。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545693920880230926/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524038128,"bury_count":0,"card_type":"video","comment_count":6,"danmaku_count":0,"digg_count":41,"display_title":"","display_url":"http://toutiao.com/group/6545693920880230926/","group_flags":32865,"group_id":6545693920880230926,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545693920880230926,"keywords":"佩恩,轮回眼,自来也,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524038109753135a1fbcbe","url":"http://p3.pstatp.com/list/pgc-image/1524038109753135a1fbcbe","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"},{"url":"http://pb2.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"},{"url":"http://p.pstatp.com/list/pgc-image/1524038109753135a1fbcbe"}],"width":640},"preload_web":0,"publish_time":1524038128,"repin_count":8,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6545693920880230926/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545693920880230926,"text_count":42,"tip":0,"title":"火影忍者：佩恩现出真身，原来是多年前自来也收的一个徒弟","title_rich_span":"","url":"http://toutiao.com/group/6545693920880230926/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524038109753135a1fbcbe","url":"http://p2.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524038109753135a1fbcbe"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"bc93baffc4a24c49a261eda8ea2ffd40","video_third_monitor_url":"","video_watch_count":9391},"video_duration":136,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":136.92,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c1a00038e3745996ee9\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/667ed0000066fb6299dc0/\",\"main_url\":\"http://voffline.byted.org/download/m/667ed0000066fb6299dc0/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":138582,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":3556583,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNzM4Y2FhNTlmMjlhMWE5ZTJkZmViZDk1NjkxMTk4YzUvNWIwNjk2M2EvdmlkZW8vbS8yMjAzOTU3ZGExNzk3Zjc0NzJmOWViYTVlNDE1NDkwMGM0MzExNTY4MjQxMDAwMGI0ZjE0NmEzYTM4YS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS82ODI2Yjc0MzQ0NWY2NzcwODRhYTdhODdlZDE5MDZmNy81YjA2OTYzYS92aWRlby9tLzIyMDM5NTdkYTE3OTdmNzQ3MmY5ZWJhNWU0MTU0OTAwYzQzMTE1NjgyNDEwMDAwYjRmMTQ2YTNhMzhhLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vNzM4Y2FhNTlmMjlhMWE5ZTJkZmViZDk1NjkxMTk4YzUvNWIwNjk2M2EvdmlkZW8vbS8yMjAzOTU3ZGExNzk3Zjc0NzJmOWViYTVlNDE1NDkwMGM0MzExNTY4MjQxMDAwMGI0ZjE0NmEzYTM4YS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS82ODI2Yjc0MzQ0NWY2NzcwODRhYTdhODdlZDE5MDZmNy81YjA2OTYzYS92aWRlby9tLzIyMDM5NTdkYTE3OTdmNzQ3MmY5ZWJhNWU0MTU0OTAwYzQzMTE1NjgyNDEwMDAwYjRmMTQ2YTNhMzhhLw==\",\"user_video_proxy\":1,\"socket_buffer\":3117960,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":199837,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4604890,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDc5YWY1ODAzMjZjYmE2MWFjZDNkMWY4MTI4Njk4NTUvNWIwNjk2M2EvdmlkZW8vbS8yMjAxOTZiMmU1MjMzNzA0MTMwYWM5MjQ4ZTA2NmNmMGVmNDExNTY4ODNlMDAwMGIzNmRkZTFkNDNkMS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jN2Y0OTdlYTI3NDEzMWM2MGVlZDBhYmZiMDdlMjg3Yi81YjA2OTYzYS92aWRlby9tLzIyMDE5NmIyZTUyMzM3MDQxMzBhYzkyNDhlMDY2Y2YwZWY0MTE1Njg4M2UwMDAwYjM2ZGRlMWQ0M2QxLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vMDc5YWY1ODAzMjZjYmE2MWFjZDNkMWY4MTI4Njk4NTUvNWIwNjk2M2EvdmlkZW8vbS8yMjAxOTZiMmU1MjMzNzA0MTMwYWM5MjQ4ZTA2NmNmMGVmNDExNTY4ODNlMDAwMGIzNmRkZTFkNDNkMS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jN2Y0OTdlYTI3NDEzMWM2MGVlZDBhYmZiMDdlMjg3Yi81YjA2OTYzYS92aWRlby9tLzIyMDE5NmIyZTUyMzM3MDQxMzBhYzkyNDhlMDY2Y2YwZWY0MTE1Njg4M2UwMDAwYjM2ZGRlMWQ0M2QxLw==\",\"user_video_proxy\":1,\"socket_buffer\":4496220,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":400756,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":8043744,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vYWFkMjZhOGMyYjBkYjkwZTU5MzhmMjUxNDcxZDk4NzcvNWIwNjk2M2EvdmlkZW8vbS8yMjA0YmM2MWNmODg0ZWM0NGE2ODI4ZjgyZDljNGY0MTkxYTExNTY3YjE1MDAwMDM1NmU1YTJjMTlhMi8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS85NmZmMjcxN2QxYTY3YzUyYWUzMGUyZTVkYWE0OWY1YS81YjA2OTYzYS92aWRlby9tLzIyMDRiYzYxY2Y4ODRlYzQ0YTY4MjhmODJkOWM0ZjQxOTFhMTE1NjdiMTUwMDAwMzU2ZTVhMmMxOWEyLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vYWFkMjZhOGMyYjBkYjkwZTU5MzhmMjUxNDcxZDk4NzcvNWIwNjk2M2EvdmlkZW8vbS8yMjA0YmM2MWNmODg0ZWM0NGE2ODI4ZjgyZDljNGY0MTkxYTExNTY3YjE1MDAwMDM1NmU1YTJjMTlhMi8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS85NmZmMjcxN2QxYTY3YzUyYWUzMGUyZTVkYWE0OWY1YS81YjA2OTYzYS92aWRlby9tLzIyMDRiYzYxY2Y4ODRlYzQ0YTY4MjhmODJkOWM0ZjQxOTFhMTE1NjdiMTUwMDAwMzU2ZTVhMmMxOWEyLw==\",\"user_video_proxy\":1,\"socket_buffer\":9016920,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"为获取情报自来也毅然赴死，蛤蟆大仙三忍之一就此剧中。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545678083985244675/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524034441,"bury_count":0,"card_type":"video","comment_count":17,"danmaku_count":0,"digg_count":142,"display_title":"","display_url":"http://toutiao.com/group/6545678083985244675/","group_flags":32865,"group_id":6545678083985244675,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545678083985244675,"keywords":"佩恩,通灵体,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/15240343361915b9bfad537","url":"http://p3.pstatp.com/list/pgc-image/15240343361915b9bfad537","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15240343361915b9bfad537"},{"url":"http://pb2.pstatp.com/list/pgc-image/15240343361915b9bfad537"},{"url":"http://p.pstatp.com/list/pgc-image/15240343361915b9bfad537"}],"width":640},"preload_web":0,"publish_time":1524034441,"repin_count":52,"share_count":34,"share_token":"","share_url":"http://toutiao.com/group/6545678083985244675/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545678083985244675,"text_count":54,"tip":0,"title":"佩恩的六具通灵体原来自来也全都认识，自来也死前终于掌握真相","title_rich_span":"","url":"http://toutiao.com/group/6545678083985244675/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15240343361915b9bfad537","url":"http://p2.pstatp.com/video1609/pgc-image/15240343361915b9bfad537","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"},{"url":"http://p.pstatp.com/video1609/pgc-image/15240343361915b9bfad537"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"7ed9668e54ba44fdaa41cd7a24bb9a34","video_third_monitor_url":"","video_watch_count":25112},"video_duration":159,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":159.44,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c15000d75792a92c616\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/66e55000034ff5e40f360/\",\"main_url\":\"http://voffline.byted.org/download/m/66e55000034ff5e40f360/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":199819,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":5361182,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2YzZjN2RjOGQyYzgxZTJkYmM5ZDRmYmI4Njk0NDdmLzViMDY5NjUxL3ZpZGVvL20vMjIwNDRjNDQyNTZjM2U0NGY1MmI2MjIzZGRmMWJkYjE2NzgxMTU2NzlkMDAwMDBiMzJkNDk0MzNkYmIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQxZmY4ZTdlOTkzYTczZjliNWJkYzNiOWZlZjkxNmYvNWIwNjk2NTEvdmlkZW8vbS8yMjA0NGM0NDI1NmMzZTQ0ZjUyYjYyMjNkZGYxYmRiMTY3ODExNTY3OWQwMDAwMGIzMmQ0OTQzM2RiYi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2YzZjN2RjOGQyYzgxZTJkYmM5ZDRmYmI4Njk0NDdmLzViMDY5NjUxL3ZpZGVvL20vMjIwNDRjNDQyNTZjM2U0NGY1MmI2MjIzZGRmMWJkYjE2NzgxMTU2NzlkMDAwMDBiMzJkNDk0MzNkYmIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQxZmY4ZTdlOTkzYTczZjliNWJkYzNiOWZlZjkxNmYvNWIwNjk2NTEvdmlkZW8vbS8yMjA0NGM0NDI1NmMzZTQ0ZjUyYjYyMjNkZGYxYmRiMTY3ODExNTY3OWQwMDAwMGIzMmQ0OTQzM2RiYi8=\",\"user_video_proxy\":1,\"socket_buffer\":4495860,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":291293,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7184248,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzY4M2UxMThjZTE2YzcyNzhkZjhlNzEwMDUwNmIxMjE5LzViMDY5NjUxL3ZpZGVvL20vMjIwZDhlMDc4NWFjYTA0NGIzMzhjYzgyNTM1OTViNGY1ZjgxMTU2N2Y5ODAwMDBiNGI4ZDIxMDdjOWQv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vYjk4NTI0OWY1NjZjNTE2YWQxNGU5MzMzZDgzNjUzYmMvNWIwNjk2NTEvdmlkZW8vbS8yMjBkOGUwNzg1YWNhMDQ0YjMzOGNjODI1MzU5NWI0ZjVmODExNTY3Zjk4MDAwMGI0YjhkMjEwN2M5ZC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzY4M2UxMThjZTE2YzcyNzhkZjhlNzEwMDUwNmIxMjE5LzViMDY5NjUxL3ZpZGVvL20vMjIwZDhlMDc4NWFjYTA0NGIzMzhjYzgyNTM1OTViNGY1ZjgxMTU2N2Y5ODAwMDBiNGI4ZDIxMDdjOWQv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vYjk4NTI0OWY1NjZjNTE2YWQxNGU5MzMzZDgzNjUzYmMvNWIwNjk2NTEvdmlkZW8vbS8yMjBkOGUwNzg1YWNhMDQ0YjMzOGNjODI1MzU5NWI0ZjVmODExNTY3Zjk4MDAwMGI0YjhkMjEwN2M5ZC8=\",\"user_video_proxy\":1,\"socket_buffer\":6553980,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":580687,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12951834,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRlMzQ2MjlmYWVmZWE4MTlkYzE2MDU4M2QzMTFkYjNjLzViMDY5NjUxL3ZpZGVvL20vMjIwNjNhYjVlOTRlOGJhNDFiZDlkOTc2OTY0MTA1OGMyMTYxMTU2N2FlMzAwMDBiMzZhNTc3OGVkY2Mv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZDc0MjU0YWI4Njc3MmJiMGFlYTEwMTdmOGY3NzkxNWQvNWIwNjk2NTEvdmlkZW8vbS8yMjA2M2FiNWU5NGU4YmE0MWJkOWQ5NzY5NjQxMDU4YzIxNjExNTY3YWUzMDAwMGIzNmE1Nzc4ZWRjYy8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRlMzQ2MjlmYWVmZWE4MTlkYzE2MDU4M2QzMTFkYjNjLzViMDY5NjUxL3ZpZGVvL20vMjIwNjNhYjVlOTRlOGJhNDFiZDlkOTc2OTY0MTA1OGMyMTYxMTU2N2FlMzAwMDBiMzZhNTc3OGVkY2Mv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZDc0MjU0YWI4Njc3MmJiMGFlYTEwMTdmOGY3NzkxNWQvNWIwNjk2NTEvdmlkZW8vbS8yMjA2M2FiNWU5NGU4YmE0MWJkOWQ5NzY5NjQxMDU4YzIxNjExNTY3YWUzMDAwMGIzNmE1Nzc4ZWRjYy8=\",\"user_video_proxy\":1,\"socket_buffer\":13065300,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"仙人模式下发动蛤蟆功，颇有功夫里火云邪神的味道啊。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545601403790819848/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524016587,"bury_count":0,"card_type":"video","comment_count":18,"danmaku_count":0,"digg_count":66,"display_title":"","display_url":"http://toutiao.com/group/6545601403790819848/","group_flags":32865,"group_id":6545601403790819848,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545601403790819848,"keywords":"火影忍者,佩恩,忍术,火云邪神,仙人模式","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524016570759720be9e55a","url":"http://p1.pstatp.com/list/pgc-image/1524016570759720be9e55a","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1524016570759720be9e55a"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524016570759720be9e55a"},{"url":"http://p.pstatp.com/list/pgc-image/1524016570759720be9e55a"}],"width":640},"preload_web":0,"publish_time":1524016587,"repin_count":24,"share_count":13,"share_token":"","share_url":"http://toutiao.com/group/6545601403790819848/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545601403790819848,"text_count":43,"tip":0,"title":"火影忍者：佩恩的饿鬼道能力是，吸收对方的忍术攻击","title_rich_span":"","url":"http://toutiao.com/group/6545601403790819848/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524016570759720be9e55a","url":"http://p10.pstatp.com/video1609/pgc-image/1524016570759720be9e55a","url_list":[{"url":"http://p10.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524016570759720be9e55a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"04347c48f93d4c448f9ad05fb9815b43","video_third_monitor_url":"","video_watch_count":19203},"video_duration":128,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":128.53,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/7c09000d9e0f122aa92a\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/65d630000149ae7b451f6/\",\"main_url\":\"http://voffline.byted.org/download/m/65d630000149ae7b451f6/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":640,\"vheight\":360,\"bitrate\":239208,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":4956244,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2Q0MTUyNDkxYjNhMWFhNDU0ODg3OTFiOTZlOTU5NzgwLzViMDY5NjMyL3ZpZGVvL20vMjIwYWExMjBhZjc1YWZmNGUwM2I4N2MyN2JmMGM3MTY5ODAxMTU2ODBkNTAwMDBhOTU3YTM3NjlkZjgv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNjdkOGRlNjEwODdhYmViZGY2YmJlZTc4NWY5OGM2ZGEvNWIwNjk2MzIvdmlkZW8vbS8yMjBhYTEyMGFmNzVhZmY0ZTAzYjg3YzI3YmYwYzcxNjk4MDExNTY4MGQ1MDAwMGE5NTdhMzc2OWRmOC8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2Q0MTUyNDkxYjNhMWFhNDU0ODg3OTFiOTZlOTU5NzgwLzViMDY5NjMyL3ZpZGVvL20vMjIwYWExMjBhZjc1YWZmNGUwM2I4N2MyN2JmMGM3MTY5ODAxMTU2ODBkNTAwMDBhOTU3YTM3NjlkZjgv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNjdkOGRlNjEwODdhYmViZGY2YmJlZTc4NWY5OGM2ZGEvNWIwNjk2MzIvdmlkZW8vbS8yMjBhYTEyMGFmNzVhZmY0ZTAzYjg3YzI3YmYwYzcxNjk4MDExNTY4MGQ1MDAwMGE5NTdhMzc2OWRmOC8=\",\"user_video_proxy\":1,\"socket_buffer\":5382180,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":854,\"vheight\":480,\"bitrate\":356607,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":6843031,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzc2OGZmNTY2YjJiZWUxNWJiNjBkYTBmZjM5Zjc2OTJiLzViMDY5NjMyL3ZpZGVvL20vMjIwYThkZWIyZGQ4ZDM0NDMyNjhmYmQyZGY4ZWI3N2RkMjAxMTU2N2U2MjAwMDBhOTUxOTczNWU2OTMv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmYyYjY5ZWQ0OTc1ZmZjN2E3NTZjMzAwYjM0MTcwMDYvNWIwNjk2MzIvdmlkZW8vbS8yMjBhOGRlYjJkZDhkMzQ0MzI2OGZiZDJkZjhlYjc3ZGQyMDExNTY3ZTYyMDAwMGE5NTE5NzM1ZTY5My8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzc2OGZmNTY2YjJiZWUxNWJiNjBkYTBmZjM5Zjc2OTJiLzViMDY5NjMyL3ZpZGVvL20vMjIwYThkZWIyZGQ4ZDM0NDMyNjhmYmQyZGY4ZWI3N2RkMjAxMTU2N2U2MjAwMDBhOTUxOTczNWU2OTMv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmYyYjY5ZWQ0OTc1ZmZjN2E3NTZjMzAwYjM0MTcwMDYvNWIwNjk2MzIvdmlkZW8vbS8yMjBhOGRlYjJkZDhkMzQ0MzI2OGZiZDJkZjhlYjc3ZGQyMDExNTY3ZTYyMDAwMGE5NTE5NzM1ZTY5My8=\",\"user_video_proxy\":1,\"socket_buffer\":8023500,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":1280,\"vheight\":720,\"bitrate\":732877,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12889396,\"main_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRmODM2MTI2MGE3ZTJhNTcwNTI3M2U0ZWY5MDQzNjljLzViMDY5NjMyL3ZpZGVvL20vMjIwZmZjM2U3ZmMxYTE2NGM1MzhiYjBmN2FjMzQ5ZDIwMDYxMTU2NDYxZjAwMDAwYjZmOTBjZGQ2OGIv\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZjU4ODVjNWY2NWY4OWM3OWNiZWYzZTI2NDc0NzlmNTEvNWIwNjk2MzIvdmlkZW8vbS8yMjBmZmMzZTdmYzFhMTY0YzUzOGJiMGY3YWMzNDlkMjAwNjExNTY0NjFmMDAwMDBiNmY5MGNkZDY4Yi8=\",\"main_http_url\":\"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzRmODM2MTI2MGE3ZTJhNTcwNTI3M2U0ZWY5MDQzNjljLzViMDY5NjMyL3ZpZGVvL20vMjIwZmZjM2U3ZmMxYTE2NGM1MzhiYjBmN2FjMzQ5ZDIwMDYxMTU2NDYxZjAwMDAwYjZmOTBjZGQ2OGIv\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZjU4ODVjNWY2NWY4OWM3OWNiZWYzZTI2NDc0NzlmNTEvNWIwNjk2MzIvdmlkZW8vbS8yMjBmZmMzZTdmYzFhMTY0YzUzOGJiMGY3YWMzNDlkMjAwNjExNTY0NjFmMDAwMDBiNmY5MGNkZDY4Yi8=\",\"user_video_proxy\":1,\"socket_buffer\":16489620,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543390078838768131/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523706385,"bury_count":5,"card_type":"video","comment_count":205,"danmaku_count":0,"digg_count":1263,"display_title":"","display_url":"http://toutiao.com/group/6543390078838768131/","group_flags":32865,"group_id":6543390078838768131,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6543390078838768131,"keywords":"依鲁卡,漩涡鸣人,九尾妖狐,火影忍者,鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/152375667394818f500a656","url":"http://p1.pstatp.com/list/pgc-image/152375667394818f500a656","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/152375667394818f500a656"},{"url":"http://pb3.pstatp.com/list/pgc-image/152375667394818f500a656"},{"url":"http://p.pstatp.com/list/pgc-image/152375667394818f500a656"}],"width":648},"preload_web":0,"publish_time":1523706385,"repin_count":385,"share_count":229,"share_token":"","share_url":"http://toutiao.com/group/6543390078838768131/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543390078838768131,"text_count":194,"tip":0,"title":"鸣人一招就废掉一个佩恩，佩恩懵逼：怎么可能，刚刚绝对躲过去了","title_rich_span":"","url":"http://toutiao.com/group/6543390078838768131/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152375667394818f500a656","url":"http://p3.pstatp.com/video1609/pgc-image/152375667394818f500a656","url_list":[{"url":"http://p3.pstatp.com/video1609/pgc-image/152375667394818f500a656"},{"url":"http://pb2.pstatp.com/video1609/pgc-image/152375667394818f500a656"},{"url":"http://p.pstatp.com/video1609/pgc-image/152375667394818f500a656"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"52079f49f2ec4070a483d50f2838aa9f","video_third_monitor_url":"","video_watch_count":258368},"video_duration":236,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":236.87,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/79fe000a970cc84b8740\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/6307500002455123b8340/\",\"main_url\":\"http://voffline.byted.org/download/m/6307500002455123b8340/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":648,\"vheight\":360,\"bitrate\":342822,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12180628,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZTcxMTc5ZjBiYmVhYzUyODQzZjA1ZWVlNWNjODYxZDYvNWIwNjk2OWUvdmlkZW8vbS8yMjBkM2UxZDA2MDYzNjg0NTYzYjc1NjcxOGMxZWRkNTVhOTExNTYzZjY1MDAwMGQwNmZjODQ5ODkyMy8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9kOWEzMmYzOTdkNzE0ZGZiYmU5MTJhZmM1MGRmZmNiMi81YjA2OTY5ZS92aWRlby9tLzIyMGQzZTFkMDYwNjM2ODQ1NjNiNzU2NzE4YzFlZGQ1NWE5MTE1NjNmNjUwMDAwZDA2ZmM4NDk4OTIzLw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZTcxMTc5ZjBiYmVhYzUyODQzZjA1ZWVlNWNjODYxZDYvNWIwNjk2OWUvdmlkZW8vbS8yMjBkM2UxZDA2MDYzNjg0NTYzYjc1NjcxOGMxZWRkNTVhOTExNTYzZjY1MDAwMGQwNmZjODQ5ODkyMy8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9kOWEzMmYzOTdkNzE0ZGZiYmU5MTJhZmM1MGRmZmNiMi81YjA2OTY5ZS92aWRlby9tLzIyMGQzZTFkMDYwNjM2ODQ1NjNiNzU2NzE4YzFlZGQ1NWE5MTE1NjNmNjUwMDAwZDA2ZmM4NDk4OTIzLw==\",\"user_video_proxy\":1,\"socket_buffer\":7713360,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":862,\"vheight\":480,\"bitrate\":508158,\"logo_type\":\"xigua_share\",\"codec_type\":\"h264\",\"size\":17068172,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZWE2MDYzYzE3ZTY0ZTE2NTY5ZjUyOTViOTAzNTIzZTcvNWIwNjk2OWUvdmlkZW8vbS8yMjA1YjU0MzFlNjgwZGM0NmM2YTA3NTQwODE4ZTM3MzllMzExNTVhNWUwMDAwMGExOGY1MTY2OTkzOS8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9hZjQ0Y2Y3NDkzNzVhZmVkZDJiNTk5ZTA3N2FjY2M2MS81YjA2OTY5ZS92aWRlby9tLzIyMDViNTQzMWU2ODBkYzQ2YzZhMDc1NDA4MThlMzczOWUzMTE1NWE1ZTAwMDAwYTE4ZjUxNjY5OTM5Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZWE2MDYzYzE3ZTY0ZTE2NTY5ZjUyOTViOTAzNTIzZTcvNWIwNjk2OWUvdmlkZW8vbS8yMjA1YjU0MzFlNjgwZGM0NmM2YTA3NTQwODE4ZTM3MzllMzExNTVhNWUwMDAwMGExOGY1MTY2OTkzOS8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9hZjQ0Y2Y3NDkzNzVhZmVkZDJiNTk5ZTA3N2FjY2M2MS81YjA2OTY5ZS92aWRlby9tLzIyMDViNTQzMWU2ODBkYzQ2YzZhMDc1NDA4MThlMzczOWUzMTE1NWE1ZTAwMDAwYTE4ZjUxNjY5OTM5Lw==\",\"user_video_proxy\":1,\"socket_buffer\":11433420,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":970,\"vheight\":540,\"bitrate\":658032,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":21498108,\"main_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjc5MGYzMmQ3MWNlZWVhZjI0ODQ5OTEzMDY1MmUxNzcvNWIwNjk2OWUvdmlkZW8vbS8yMjBhMTA0NzY4ZjkyMjI0OTg2OGE3ZDMzN2E4ZTUxNzM0ZDExNTY0MTQ0MDAwMDlhYWZmNDRiMzc2NC8=\",\"backup_url_1\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jOGYyMWE1MWZjMTA5ZTgwNzc3MDM3Zjc1MWJjYTkyYy81YjA2OTY5ZS92aWRlby9tLzIyMGExMDQ3NjhmOTIyMjQ5ODY4YTdkMzM3YThlNTE3MzRkMTE1NjQxNDQwMDAwOWFhZmY0NGIzNzY0Lw==\",\"main_http_url\":\"aHR0cDovL3YzLXR0Lml4aWd1YS5jb20vZjc5MGYzMmQ3MWNlZWVhZjI0ODQ5OTEzMDY1MmUxNzcvNWIwNjk2OWUvdmlkZW8vbS8yMjBhMTA0NzY4ZjkyMjI0OTg2OGE3ZDMzN2E4ZTUxNzM0ZDExNTY0MTQ0MDAwMDlhYWZmNDRiMzc2NC8=\",\"backup_http_url\":\"aHR0cDovL3YxLXR0Lml4aWd1YXZpZGVvLmNvbS9jOGYyMWE1MWZjMTA5ZTgwNzc3MDM3Zjc1MWJjYTkyYy81YjA2OTY5ZS92aWRlby9tLzIyMGExMDQ3NjhmOTIyMjQ5ODY4YTdkMzM3YThlNTE3MzRkMTE1NjQxNDQwMDAwOWFhZmY0NGIzNzY0Lw==\",\"user_video_proxy\":1,\"socket_buffer\":14805720,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 佩恩之卷 佩恩经典合集","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6542085408941933064/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523198541,"bury_count":0,"card_type":"video","comment_count":46,"danmaku_count":0,"digg_count":765,"display_title":"","display_url":"http://toutiao.com/group/6542085408941933064/","group_flags":32865,"group_id":6542085408941933064,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6542085408941933064,"keywords":"佩恩,仙人模式,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/7579000e23e6bf2c1583","url":"http://p2.pstatp.com/list/7579000e23e6bf2c1583","url_list":[{"url":"http://p2.pstatp.com/list/7579000e23e6bf2c1583"},{"url":"http://pb3.pstatp.com/list/7579000e23e6bf2c1583"},{"url":"http://p.pstatp.com/list/7579000e23e6bf2c1583"}],"width":644},"preload_web":0,"publish_time":1523198541,"repin_count":265,"share_count":117,"share_token":"","share_url":"http://toutiao.com/group/6542085408941933064/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6542085408941933064,"text_count":15,"tip":0,"title":"开启了仙人模式的鸣人就是不一样，一个人对打佩恩数人，强到炸","title_rich_span":"","url":"http://toutiao.com/group/6542085408941933064/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/7579000e23e6bf2c1583","url":"http://p8.pstatp.com/video1609/7579000e23e6bf2c1583","url_list":[{"url":"http://p8.pstatp.com/video1609/7579000e23e6bf2c1583"},{"url":"http://pb3.pstatp.com/video1609/7579000e23e6bf2c1583"},{"url":"http://p.pstatp.com/video1609/7579000e23e6bf2c1583"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"7a7f823f18f540f8b0d8cd5a1ccc9fca","video_third_monitor_url":"","video_watch_count":136827},"video_duration":226,"video_play_info":"{\"status\":10,\"message\":\"success\",\"video_duration\":226.74,\"validate\":\"\",\"enable_ssl\":false,\"poster_url\":\"http://p3.pstatp.com/origin/794b000269d79c41f54e\",\"auto_definition\":\"360p\",\"original_play_url\":{\"backup_url\":\"http://voffline.byted.org/download/m/639e600002f3c31abc536/\",\"main_url\":\"http://voffline.byted.org/download/m/639e600002f3c31abc536/\"},\"video_list\":{\"video_1\":{\"definition\":\"360p\",\"vtype\":\"mp4\",\"vwidth\":644,\"vheight\":358,\"bitrate\":193367,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":7431962,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vOWQ5MTMxMDc3YTQyMDVjY2I1MjU0OTU1NWMxY2ZhYmIvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQ4YWM0NThmYjI4MDdjMmFjMGQzYmExNjhhYjdlMzQvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vOWQ5MTMxMDc3YTQyMDVjY2I1MjU0OTU1NWMxY2ZhYmIvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vMmQ4YWM0NThmYjI4MDdjMmFjMGQzYmExNjhhYjdlMzQvNWIwNjk2OTQvdmlkZW8vbS8yMjBhZWNlNjZmMzdiYWE0NWM5OGM3MTU1ZjhlZjIxMmM2YTExNTYxMTZjMDAwMGFhZTRhYzc2OWRjMi8=\",\"user_video_proxy\":1,\"socket_buffer\":4350600,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_2\":{\"definition\":\"480p\",\"vtype\":\"mp4\",\"vwidth\":860,\"vheight\":478,\"bitrate\":283405,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":9979715,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vZDk4OWNkMGQ4YjFhM2JkYTExYzdhMGUyMmE2MmZmNTcvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTY3M2VmZWQ4OGQ4ZDBmYzM4Y2VlYTI0MzhjMmZlZjgvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vZDk4OWNkMGQ4YjFhM2JkYTExYzdhMGUyMmE2MmZmNTcvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vNTY3M2VmZWQ4OGQ4ZDBmYzM4Y2VlYTI0MzhjMmZlZjgvNWIwNjk2OTQvdmlkZW8vbS8yMjA3OTE0MTM3YzNhZWM0MTFlYjQ4MTc5NDBhOTQ2Njk0YjExNTYwYzcwMDAwMGFiODMwMzJmMzAyOC8=\",\"user_video_proxy\":1,\"socket_buffer\":6376500,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"},\"video_3\":{\"definition\":\"720p\",\"vtype\":\"mp4\",\"vwidth\":968,\"vheight\":538,\"bitrate\":370003,\"logo_type\":\"xigua\",\"codec_type\":\"h264\",\"size\":12429949,\"main_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzY2OGFkMzU0YmQ4NmE3YmQzZmFkNGJlNDdjNjg2MjAvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"backup_url_1\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZTI3NjQwZTBlZjFmY2EzYjFlYWI4OGIyZjFjNmU2NGMvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"main_http_url\":\"aHR0cDovL3Y5LXR0Lml4aWd1YS5jb20vNzY2OGFkMzU0YmQ4NmE3YmQzZmFkNGJlNDdjNjg2MjAvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"backup_http_url\":\"aHR0cDovL3Y3LnBzdGF0cC5jb20vZTI3NjQwZTBlZjFmY2EzYjFlYWI4OGIyZjFjNmU2NGMvNWIwNjk2OTQvdmlkZW8vbS8yMjA1YmZmOGFjYWMxZjc0YmNiODM5MDBhOGZlMTdmN2NhYzExNTY0MGFmMDAwMDdhNTM3YTNmOGRkYy8=\",\"user_video_proxy\":1,\"socket_buffer\":8325000,\"preload_size\":327680,\"preload_interval\":45,\"preload_min_step\":5,\"preload_max_step\":10,\"encryption_key\":\"\",\"player_access_key\":\"\"}},\"dns_info\":{}}","video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 催泪之卷 精选火影TV动画中的催泪感人场景，按播出时间排序，值得火影迷们反复回味.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6544485591055073796/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523756792,"bury_count":5,"card_type":"video","comment_count":222,"danmaku_count":0,"digg_count":1153,"display_title":"","display_url":"http://toutiao.com/group/6544485591055073796/","group_flags":32865,"group_id":6544485591055073796,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6544485591055073796,"keywords":"鸣人,tv动画,火影忍者,自来也","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/1523756763974b15318242f","url":"http://p1.pstatp.com/list/pgc-image/1523756763974b15318242f","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1523756763974b15318242f"},{"url":"http://pb3.pstatp.com/list/pgc-image/1523756763974b15318242f"},{"url":"http://p.pstatp.com/list/pgc-image/1523756763974b15318242f"}],"width":634},"preload_web":0,"publish_time":1523756792,"repin_count":744,"share_count":172,"share_token":"","share_url":"http://toutiao.com/group/6544485591055073796/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6544485591055073796,"text_count":42,"tip":0,"title":"自来也去世后，鸣人一度陷入了沉思无法自拔，看的不禁一阵心酸","title_rich_span":"","url":"http://toutiao.com/group/6544485591055073796/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523756763974b15318242f","url":"http://p10.pstatp.com/video1609/pgc-image/1523756763974b15318242f","url_list":[{"url":"http://p10.pstatp.com/video1609/pgc-image/1523756763974b15318242f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523756763974b15318242f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523756763974b15318242f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"5aad53aa8e6b4167960bb620a189f15d","video_third_monitor_url":"","video_watch_count":126397},"video_duration":237,"video_proportion_article":1.770949720670391,"video_style":0},{"abstract":"奇拉比忍界里的灵魂歌手，和自来也卡卡西一样有本小本子。","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545961186242855438/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524100356,"bury_count":0,"card_type":"video","comment_count":25,"danmaku_count":0,"digg_count":31,"display_title":"","display_url":"http://toutiao.com/group/6545961186242855438/","group_flags":32865,"group_id":6545961186242855438,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6545961186242855438,"keywords":"卡卡西,奇拉比,灵魂歌手","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/152410032999490ee5781a0","url":"http://p2.pstatp.com/list/pgc-image/152410032999490ee5781a0","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/152410032999490ee5781a0"},{"url":"http://pb3.pstatp.com/list/pgc-image/152410032999490ee5781a0"},{"url":"http://p.pstatp.com/list/pgc-image/152410032999490ee5781a0"}],"width":640},"preload_web":0,"publish_time":1524100356,"repin_count":13,"share_count":15,"share_token":"","share_url":"http://toutiao.com/group/6545961186242855438/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545961186242855438,"text_count":52,"tip":0,"title":"奇拉比你确定你没入错行，被人踢了一脚却还想着创作歌词","title_rich_span":"","url":"http://toutiao.com/group/6545961186242855438/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152410032999490ee5781a0","url":"http://p2.pstatp.com/video1609/pgc-image/152410032999490ee5781a0","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"},{"url":"http://p.pstatp.com/video1609/pgc-image/152410032999490ee5781a0"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"270200b54f8a4220953b0270fdba18e8","video_third_monitor_url":"","video_watch_count":11153},"video_duration":95,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者：自来也误入妙木山，从此与蛤蟆解下不解之缘","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6545297464134468104/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523945821,"bury_count":2,"card_type":"video","comment_count":28,"danmaku_count":0,"digg_count":370,"display_title":"","display_url":"http://toutiao.com/group/6545297464134468104/","group_flags":32865,"group_id":6545297464134468104,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6545297464134468104,"keywords":"火影忍者,妙木山","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1523945680961b307320cae","url":"http://p1.pstatp.com/list/pgc-image/1523945680961b307320cae","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/1523945680961b307320cae"},{"url":"http://pb3.pstatp.com/list/pgc-image/1523945680961b307320cae"},{"url":"http://p.pstatp.com/list/pgc-image/1523945680961b307320cae"}],"width":640},"preload_web":0,"publish_time":1523945821,"repin_count":107,"share_count":61,"share_token":"","share_url":"http://toutiao.com/group/6545297464134468104/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6545297464134468104,"text_count":24,"tip":0,"title":"火影忍者：自来也误入妙木山，从此与蛤蟆解下不解之缘","title_rich_span":"","url":"http://toutiao.com/group/6545297464134468104/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523945680961b307320cae","url":"http://p9.pstatp.com/video1609/pgc-image/1523945680961b307320cae","url_list":[{"url":"http://p9.pstatp.com/video1609/pgc-image/1523945680961b307320cae"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523945680961b307320cae"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523945680961b307320cae"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"173780bfa3ae4f6aba2da8df91758603","video_third_monitor_url":"","video_watch_count":67409},"video_duration":87,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6551945632498582023/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525493718,"bury_count":1,"card_type":"video","comment_count":22,"danmaku_count":0,"digg_count":356,"display_title":"","display_url":"http://toutiao.com/group/6551945632498582023/","group_flags":32865,"group_id":6551945632498582023,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6551945632498582023,"keywords":"依鲁卡,漩涡鸣人,鸣人,火影忍者,下护额","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/15254937038686190f9b31a","url":"http://p1.pstatp.com/list/pgc-image/15254937038686190f9b31a","url_list":[{"url":"http://p1.pstatp.com/list/pgc-image/15254937038686190f9b31a"},{"url":"http://pb3.pstatp.com/list/pgc-image/15254937038686190f9b31a"},{"url":"http://p.pstatp.com/list/pgc-image/15254937038686190f9b31a"}],"width":640},"preload_web":0,"publish_time":1525493718,"repin_count":152,"share_count":24,"share_token":"","share_url":"http://toutiao.com/group/6551945632498582023/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6551945632498582023,"text_count":193,"tip":0,"title":"自来也整理了下护额：从这里开始，就是通往地狱的第一个路口了","title_rich_span":"","url":"http://toutiao.com/group/6551945632498582023/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15254937038686190f9b31a","url":"http://p1.pstatp.com/video1609/pgc-image/15254937038686190f9b31a","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"},{"url":"http://p.pstatp.com/video1609/pgc-image/15254937038686190f9b31a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201ff50000bbmijgnl54d1btkblrmg","video_third_monitor_url":"","video_watch_count":75539},"video_duration":118,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6553093246208180744/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525760918,"bury_count":1,"card_type":"video","comment_count":32,"danmaku_count":0,"digg_count":223,"display_title":"","display_url":"http://toutiao.com/group/6553093246208180744/","group_flags":32865,"group_id":6553093246208180744,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6553093246208180744,"keywords":"","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"酷漫优咪","middle_image":{"height":360,"uri":"list/pgc-image/15257608953403a8ffa9f6a","url":"http://p3.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://pb2.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://p.pstatp.com/list/pgc-image/15257608953403a8ffa9f6a"}],"width":640},"preload_web":0,"publish_time":1525760918,"repin_count":87,"share_count":21,"share_token":"","share_url":"http://toutiao.com/group/6553093246208180744/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"酷漫优咪","tag":"video_comic","tag_id":6553093246208180744,"text_count":0,"tip":0,"title":"火影忍者：宇智波斑亲口承认，柱间比自己还要厉害！","title_rich_span":"","url":"http://toutiao.com/group/6553093246208180744/","user_info":{"avatar_url":"http://p1.pstatp.com/thumb/6ee8000148b9a2cddde0","description":"最新最及时的动漫新番,最棒的ACG氛围,独家的动漫内容推送","follow":false,"is_living":false,"media_id":0,"name":"酷漫优咪","screen_name":"酷漫优咪","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下帐号\"}","user_id":73317479422,"user_verified":1,"verified_content":"优酷旗下帐号","video_live_auth":true},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15257608953403a8ffa9f6a","url":"http://p1.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"},{"url":"http://p.pstatp.com/video1609/pgc-image/15257608953403a8ffa9f6a"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201f180000bbohtkiikatmh18a3u6g","video_third_monitor_url":"","video_watch_count":39181},"video_duration":89,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 佩恩之卷 佩恩经典合集","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6542069113693405710/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523194162,"bury_count":1,"card_type":"video","comment_count":37,"danmaku_count":0,"digg_count":330,"display_title":"","display_url":"http://toutiao.com/group/6542069113693405710/","group_flags":32865,"group_id":6542069113693405710,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6542069113693405710,"keywords":"卡卡西,火影忍者,佩恩","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/152319415220276f219d347","url":"http://p3.pstatp.com/list/pgc-image/152319415220276f219d347","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/152319415220276f219d347"},{"url":"http://pb2.pstatp.com/list/pgc-image/152319415220276f219d347"},{"url":"http://p.pstatp.com/list/pgc-image/152319415220276f219d347"}],"width":644},"preload_web":0,"publish_time":1523194162,"repin_count":75,"share_count":83,"share_token":"","share_url":"http://toutiao.com/group/6542069113693405710/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6542069113693405710,"text_count":15,"tip":0,"title":"卡卡西被佩恩欺负，关键时刻丁次父子的出现，成功逆转了局势","title_rich_span":"","url":"http://toutiao.com/group/6542069113693405710/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152319415220276f219d347","url":"http://p2.pstatp.com/video1609/pgc-image/152319415220276f219d347","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152319415220276f219d347"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152319415220276f219d347"},{"url":"http://p.pstatp.com/video1609/pgc-image/152319415220276f219d347"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"fb3a781cefa94e649891b316ef8558d1","video_third_monitor_url":"","video_watch_count":74464},"video_duration":200,"video_proportion_article":1.78,"video_style":0},{"abstract":"超然，妙木山全蛙出动，带队队长蛤蟆大仙漩涡鸣人","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6546872857152979460/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1524312621,"bury_count":6,"card_type":"video","comment_count":90,"danmaku_count":0,"digg_count":559,"display_title":"","display_url":"http://toutiao.com/group/6546872857152979460/","group_flags":32865,"group_id":6546872857152979460,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6546872857152979460,"keywords":"漩涡鸣人,妙木山,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1524312277539ecb4e5a09f","url":"http://p2.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://pb3.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://p.pstatp.com/list/pgc-image/1524312277539ecb4e5a09f"}],"width":640},"preload_web":0,"publish_time":1524312621,"repin_count":261,"share_count":107,"share_token":"","share_url":"http://toutiao.com/group/6546872857152979460/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6546872857152979460,"text_count":22,"tip":0,"title":"火影忍者：超燃，妙木山全蛙出动，带队队长蛤蟆大仙漩涡鸣人","title_rich_span":"","url":"http://toutiao.com/group/6546872857152979460/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1524312277539ecb4e5a09f","url":"http://p2.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1524312277539ecb4e5a09f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"56fceebc5b264a8d93894484c72c6893","video_third_monitor_url":"","video_watch_count":129428},"video_duration":160,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543151419455701507/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523791512,"bury_count":5,"card_type":"video","comment_count":156,"danmaku_count":0,"digg_count":520,"display_title":"","display_url":"http://toutiao.com/group/6543151419455701507/","group_flags":32865,"group_id":6543151419455701507,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6543151419455701507,"keywords":"依鲁卡,鸣人,纲手,火影忍者,漩涡鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/1523790583618d220d8ced5","url":"http://p3.pstatp.com/list/pgc-image/1523790583618d220d8ced5","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1523790583618d220d8ced5"},{"url":"http://pb2.pstatp.com/list/pgc-image/1523790583618d220d8ced5"},{"url":"http://p.pstatp.com/list/pgc-image/1523790583618d220d8ced5"}],"width":640},"preload_web":0,"publish_time":1523791512,"repin_count":381,"share_count":157,"share_token":"","share_url":"http://toutiao.com/group/6543151419455701507/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543151419455701507,"text_count":186,"tip":0,"title":"自来也战死前夕，泪目：为什么不向纲手表白，明明这次能成功的","title_rich_span":"","url":"http://toutiao.com/group/6543151419455701507/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1523790583618d220d8ced5","url":"http://p1.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"},{"url":"http://p.pstatp.com/video1609/pgc-image/1523790583618d220d8ced5"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"40a7d131772a483eae560b982b5e4ecd","video_third_monitor_url":"","video_watch_count":66576},"video_duration":126,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"博人传 火影忍者新时代 经历漫长的战争之后以七代目火影漩涡鸣人治理的木叶村为中心，成立了新的忍者5大国，本作主要讲述鸣人的儿子、虽然有才能却把鸣人叫做臭老爸的漩涡博人；佐助的女儿、对鸣人抱持憧憬的宇智波佐良娜；以及充满了谜团的超级优秀忍者巳月三人一组，在村子里努力修炼成长的故事.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6557594011735949838/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1526812800,"bury_count":6,"card_type":"video","comment_count":15,"danmaku_count":0,"digg_count":86,"display_title":"","display_url":"http://toutiao.com/group/6557594011735949838/","group_flags":32865,"group_id":6557594011735949838,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6557594011735949838,"keywords":"漩涡鸣人,宇智波,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":358,"uri":"list/pgc-image/1526808827514e0e0e78f3f","url":"http://p3.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://pb2.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://p.pstatp.com/list/pgc-image/1526808827514e0e0e78f3f"}],"width":640},"preload_web":0,"publish_time":1526812800,"repin_count":41,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6557594011735949838/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6557594011735949838,"text_count":135,"tip":0,"title":"面对敌人的猛烈进攻，巳月准备开启仙人化，对方一看吓得赶紧后退","title_rich_span":"","url":"http://toutiao.com/group/6557594011735949838/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1526808827514e0e0e78f3f","url":"http://p2.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"},{"url":"http://p.pstatp.com/video1609/pgc-image/1526808827514e0e0e78f3f"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v0201f180000bc0k20c9hq5lbckadno0","video_third_monitor_url":"","video_watch_count":22333},"video_duration":104,"video_proportion_article":1.78,"video_style":0},{"abstract":"六尾这实力不弱于自来也吧，还是被佩恩压倒性优势收服","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6551304975664808456/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525344554,"bury_count":0,"card_type":"video","comment_count":28,"danmaku_count":0,"digg_count":50,"display_title":"","display_url":"http://toutiao.com/group/6551304975664808456/","group_flags":32865,"group_id":6551304975664808456,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6551304975664808456,"keywords":"佩恩,六尾,自来也,火影忍者","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"磁力影视","middle_image":{"height":360,"uri":"list/pgc-image/1525344156761d73eb3b0a7","url":"http://p3.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://pb2.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://p.pstatp.com/list/pgc-image/1525344156761d73eb3b0a7"}],"width":640},"preload_web":0,"publish_time":1525344554,"repin_count":16,"share_count":6,"share_token":"","share_url":"http://toutiao.com/group/6551304975664808456/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"磁力影视","tag":"video_comic","tag_id":6551304975664808456,"text_count":24,"tip":0,"title":"火影忍者：六尾这实力不弱于自来也吧，还是被佩恩压倒性优势收服","title_rich_span":"","url":"http://toutiao.com/group/6551304975664808456/","user_info":{"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/1525344156761d73eb3b0a7","url":"http://p1.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7","url_list":[{"url":"http://p1.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"},{"url":"http://p.pstatp.com/video1609/pgc-image/1525344156761d73eb3b0a7"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"v02004180000bbleerd8n75uip0e6cag","video_third_monitor_url":"","video_watch_count":6766},"video_duration":188,"video_proportion_article":1.7777777777777777,"video_style":0},{"abstract":"火影忍者 故事从主人公漩涡鸣人的孤儿生活开始，他的父母为了保护村子，将攻击村子九尾妖狐封印到了他体内，鸣人因此受尽了村人的冷落，只是拼命用各种恶作剧试图吸引大家的注意力.好在还是有依鲁卡老师的关心，鸣人的性格才没有变得扭曲，他总是干劲十足、非常乐观.","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6543390730394534407/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1523791717,"bury_count":7,"card_type":"video","comment_count":84,"danmaku_count":0,"digg_count":699,"display_title":"","display_url":"http://toutiao.com/group/6543390730394534407/","group_flags":32865,"group_id":6543390730394534407,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":1,"image_count":0,"image_list":[],"is_article":true,"item_id":6543390730394534407,"keywords":"依鲁卡,漩涡鸣人,佩恩六道,火影忍者,鸣人","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"贰次元动漫社","middle_image":{"height":360,"uri":"list/pgc-image/152379152465260c1eced75","url":"http://p2.pstatp.com/list/pgc-image/152379152465260c1eced75","url_list":[{"url":"http://p2.pstatp.com/list/pgc-image/152379152465260c1eced75"},{"url":"http://pb3.pstatp.com/list/pgc-image/152379152465260c1eced75"},{"url":"http://p.pstatp.com/list/pgc-image/152379152465260c1eced75"}],"width":648},"preload_web":0,"publish_time":1523791717,"repin_count":165,"share_count":95,"share_token":"","share_url":"http://toutiao.com/group/6543390730394534407/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"贰次元动漫社","tag":"video_comic","tag_id":6543390730394534407,"text_count":194,"tip":0,"title":"鸣人独战佩恩六道，这招直接撂倒一个佩恩，天道瞬间就慌了","title_rich_span":"","url":"http://toutiao.com/group/6543390730394534407/","user_info":{"avatar_url":"http://p9.pstatp.com/thumb/403f000263ff240fce49","description":"这里有最及时的动漫新番,最棒的ACG氛围,独家动漫内容","follow":false,"is_living":false,"media_id":0,"name":"贰次元动漫社","screen_name":"贰次元动漫社","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":73287478587,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/152379152465260c1eced75","url":"http://p2.pstatp.com/video1609/pgc-image/152379152465260c1eced75","url_list":[{"url":"http://p2.pstatp.com/video1609/pgc-image/152379152465260c1eced75"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/152379152465260c1eced75"},{"url":"http://p.pstatp.com/video1609/pgc-image/152379152465260c1eced75"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"5c545478a19c4d0585879b0e85e05273","video_third_monitor_url":"","video_watch_count":145031},"video_duration":215,"video_proportion_article":1.78,"video_style":0},{"abstract":"火影忍者 火影忍者：整部火影鸣人最帅瞬间，完全尾兽形态之力，燃！","aggr_type":1,"article_sub_type":0,"article_type":0,"article_url":"http://toutiao.com/group/6549376716815467015/","ban_action":0,"ban_bury":0,"ban_comment":0,"ban_danmaku":0,"ban_download":0,"behot_time":1525062720,"bury_count":9,"card_type":"video","comment_count":249,"danmaku_count":0,"digg_count":1273,"display_title":"","display_url":"http://toutiao.com/group/6549376716815467015/","group_flags":32865,"group_id":6549376716815467015,"has_image":false,"has_m3u8_video":0,"has_mp4_video":0,"has_video":true,"hot":0,"image_count":0,"image_list":[],"is_article":true,"item_id":6549376716815467015,"keywords":"火影忍者,鸣人,火影,尾兽","level":0,"log_pb":{"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"},"media_name":"酷漫优咪","middle_image":{"height":360,"uri":"list/pgc-image/15249045019386e2da2bc4c","url":"http://p3.pstatp.com/list/pgc-image/15249045019386e2da2bc4c","url_list":[{"url":"http://p3.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"},{"url":"http://pb2.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"},{"url":"http://p.pstatp.com/list/pgc-image/15249045019386e2da2bc4c"}],"width":640},"preload_web":0,"publish_time":1525062720,"repin_count":710,"share_count":359,"share_token":"","share_url":"http://toutiao.com/group/6549376716815467015/?iid=32758433763&app=news_article","show_portrait_article":false,"source":"酷漫优咪","tag":"video_comic","tag_id":6549376716815467015,"text_count":29,"tip":0,"title":"火影忍者：整部火影鸣人最帅瞬间，完全尾兽形态之力，燃！","title_rich_span":"","url":"http://toutiao.com/group/6549376716815467015/","user_info":{"avatar_url":"http://p1.pstatp.com/thumb/6ee8000148b9a2cddde0","description":"最新最及时的动漫新番,最棒的ACG氛围,独家的动漫内容推送","follow":false,"is_living":false,"media_id":0,"name":"酷漫优咪","screen_name":"酷漫优咪","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下帐号\"}","user_id":73317479422,"user_verified":1,"verified_content":"优酷旗下帐号","video_live_auth":true},"video_detail_info":{"detail_video_large_image":{"height":327,"uri":"video1609/pgc-image/15249045019386e2da2bc4c","url":"http://p8.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c","url_list":[{"url":"http://p8.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"},{"url":"http://pb3.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"},{"url":"http://p.pstatp.com/video1609/pgc-image/15249045019386e2da2bc4c"}],"width":580},"direct_play":1,"group_flags":32865,"show_pgc_subscribe":1,"video_id":"3d197fd103934705b11d26253ba0ec23","video_third_monitor_url":"","video_watch_count":284228},"video_duration":82,"video_proportion_article":1.7777777777777777,"video_style":0}]
         * related_wenda : []
         * repin_count : 1
         * rewards : {"rewards_list":[],"rewards_list_url":"sslocal://webview?title=%E8%B5%9E%E8%B5%8F%E8%AF%A6%E6%83%85&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Farticle_praise_list%2F%3Farticle_id%3D6545690546311004686","rewards_num":0,"rewards_open_url":"sslocal://webview?title=%E8%B5%9E%E8%B5%8F&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Fselect_amount%2F%3Fmedia_id%3D1587845744613390%26article_id%3D6545690546311004686"}
         * script :
         if(typeof updateAppreciateCountByServer == 'function'){
         updateAppreciateCountByServer(0);
         }else{
         window.updateAppreciateCountByServerCallback = function(){
         updateAppreciateCountByServer(0);
         }
         }

         * share_info : {"share_type":{"pyq":2,"qq":0,"qzone":0,"wx":0},"share_url":"http://m.toutiaoimg.cn/group/6545690546311004686/?iid=32758433763&app=news_article&timestamp=1527154594","title":"【今日头条】火影忍者：心疼自来也受了那么重的伤，一定要活下去拜托"}
         * share_type : 2
         * share_url : http://m.toutiaoimg.cn/group/6545690546311004686/?iid=32758433763&app=news_article&timestamp=1527154594
         * show_pgc_subscibe : 1
         * source : 磁力影视
         * ug_install_aid : 0
         * url : http://toutiao.com/group/6545690546311004686/
         * user_bury : 0
         * user_digg : 0
         * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","fans_count":38750,"follow":0,"media_id":1587845744613390,"name":"磁力影视","special_column":[],"subcribed":0,"user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_decoration":"","user_id":82702459638,"user_verified":true}
         * user_like : 0
         * user_repin : 0
         * video_label_html :
         * video_watch_count : 3836
         */

        private AdBean ad;
        private int ban_bury;
        private int ban_comment;
        private boolean ban_danmaku;
        private int ban_digg;
        private int bury_count;
        private int comment_count;
        private String context;
        private int danmaku_count;
        private int detail_show_flags;
        private int digg_count;
        private String display_url;
        private int group_flags;
        private long group_id;
        private H5ExtraBean h5_extra;
        private int ignore_web_transform;
        private int info_flag;
        private int is_wenda;
        private int like_count;
        private String like_desc;
        private LogPbBean log_pb;
        private MediaInfoBean media_info;
        private int read_count;
        private RecommendSponsorBean recommend_sponsor;
        private int related_video_section;
        private int repin_count;
        private RewardsBean rewards;
        private String script;
        private ShareInfoBean share_info;
        private int share_type;
        private String share_url;
        private int show_pgc_subscibe;
        private String source;
        private int ug_install_aid;
        private String url;
        private int user_bury;
        private int user_digg;
        private UserInfoBean user_info;
        private int user_like;
        private int user_repin;
        private String video_label_html;
        private int video_watch_count;
        private List<FilterWordsBeanX> filter_words;
        private List<OrderedInfoBean> ordered_info;
        private List<RelatedVideoToutiaoBean> related_video_toutiao;
        private List<?> related_wenda;

        public AdBean getAd() {
            return ad;
        }

        public void setAd(AdBean ad) {
            this.ad = ad;
        }

        public int getBan_bury() {
            return ban_bury;
        }

        public void setBan_bury(int ban_bury) {
            this.ban_bury = ban_bury;
        }

        public int getBan_comment() {
            return ban_comment;
        }

        public void setBan_comment(int ban_comment) {
            this.ban_comment = ban_comment;
        }

        public boolean isBan_danmaku() {
            return ban_danmaku;
        }

        public void setBan_danmaku(boolean ban_danmaku) {
            this.ban_danmaku = ban_danmaku;
        }

        public int getBan_digg() {
            return ban_digg;
        }

        public void setBan_digg(int ban_digg) {
            this.ban_digg = ban_digg;
        }

        public int getBury_count() {
            return bury_count;
        }

        public void setBury_count(int bury_count) {
            this.bury_count = bury_count;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public int getDanmaku_count() {
            return danmaku_count;
        }

        public void setDanmaku_count(int danmaku_count) {
            this.danmaku_count = danmaku_count;
        }

        public int getDetail_show_flags() {
            return detail_show_flags;
        }

        public void setDetail_show_flags(int detail_show_flags) {
            this.detail_show_flags = detail_show_flags;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public String getDisplay_url() {
            return display_url;
        }

        public void setDisplay_url(String display_url) {
            this.display_url = display_url;
        }

        public int getGroup_flags() {
            return group_flags;
        }

        public void setGroup_flags(int group_flags) {
            this.group_flags = group_flags;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public H5ExtraBean getH5_extra() {
            return h5_extra;
        }

        public void setH5_extra(H5ExtraBean h5_extra) {
            this.h5_extra = h5_extra;
        }

        public int getIgnore_web_transform() {
            return ignore_web_transform;
        }

        public void setIgnore_web_transform(int ignore_web_transform) {
            this.ignore_web_transform = ignore_web_transform;
        }

        public int getInfo_flag() {
            return info_flag;
        }

        public void setInfo_flag(int info_flag) {
            this.info_flag = info_flag;
        }

        public int getIs_wenda() {
            return is_wenda;
        }

        public void setIs_wenda(int is_wenda) {
            this.is_wenda = is_wenda;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getLike_desc() {
            return like_desc;
        }

        public void setLike_desc(String like_desc) {
            this.like_desc = like_desc;
        }

        public LogPbBean getLog_pb() {
            return log_pb;
        }

        public void setLog_pb(LogPbBean log_pb) {
            this.log_pb = log_pb;
        }

        public MediaInfoBean getMedia_info() {
            return media_info;
        }

        public void setMedia_info(MediaInfoBean media_info) {
            this.media_info = media_info;
        }

        public int getRead_count() {
            return read_count;
        }

        public void setRead_count(int read_count) {
            this.read_count = read_count;
        }

        public RecommendSponsorBean getRecommend_sponsor() {
            return recommend_sponsor;
        }

        public void setRecommend_sponsor(RecommendSponsorBean recommend_sponsor) {
            this.recommend_sponsor = recommend_sponsor;
        }

        public int getRelated_video_section() {
            return related_video_section;
        }

        public void setRelated_video_section(int related_video_section) {
            this.related_video_section = related_video_section;
        }

        public int getRepin_count() {
            return repin_count;
        }

        public void setRepin_count(int repin_count) {
            this.repin_count = repin_count;
        }

        public RewardsBean getRewards() {
            return rewards;
        }

        public void setRewards(RewardsBean rewards) {
            this.rewards = rewards;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }

        public ShareInfoBean getShare_info() {
            return share_info;
        }

        public void setShare_info(ShareInfoBean share_info) {
            this.share_info = share_info;
        }

        public int getShare_type() {
            return share_type;
        }

        public void setShare_type(int share_type) {
            this.share_type = share_type;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getShow_pgc_subscibe() {
            return show_pgc_subscibe;
        }

        public void setShow_pgc_subscibe(int show_pgc_subscibe) {
            this.show_pgc_subscibe = show_pgc_subscibe;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getUg_install_aid() {
            return ug_install_aid;
        }

        public void setUg_install_aid(int ug_install_aid) {
            this.ug_install_aid = ug_install_aid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUser_bury() {
            return user_bury;
        }

        public void setUser_bury(int user_bury) {
            this.user_bury = user_bury;
        }

        public int getUser_digg() {
            return user_digg;
        }

        public void setUser_digg(int user_digg) {
            this.user_digg = user_digg;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public int getUser_like() {
            return user_like;
        }

        public void setUser_like(int user_like) {
            this.user_like = user_like;
        }

        public int getUser_repin() {
            return user_repin;
        }

        public void setUser_repin(int user_repin) {
            this.user_repin = user_repin;
        }

        public String getVideo_label_html() {
            return video_label_html;
        }

        public void setVideo_label_html(String video_label_html) {
            this.video_label_html = video_label_html;
        }

        public int getVideo_watch_count() {
            return video_watch_count;
        }

        public void setVideo_watch_count(int video_watch_count) {
            this.video_watch_count = video_watch_count;
        }

        public List<FilterWordsBeanX> getFilter_words() {
            return filter_words;
        }

        public void setFilter_words(List<FilterWordsBeanX> filter_words) {
            this.filter_words = filter_words;
        }

        public List<OrderedInfoBean> getOrdered_info() {
            return ordered_info;
        }

        public void setOrdered_info(List<OrderedInfoBean> ordered_info) {
            this.ordered_info = ordered_info;
        }

        public List<RelatedVideoToutiaoBean> getRelated_video_toutiao() {
            return related_video_toutiao;
        }

        public void setRelated_video_toutiao(List<RelatedVideoToutiaoBean> related_video_toutiao) {
            this.related_video_toutiao = related_video_toutiao;
        }

        public List<?> getRelated_wenda() {
            return related_wenda;
        }

        public void setRelated_wenda(List<?> related_wenda) {
            this.related_wenda = related_wenda;
        }

        public static class AdBean {

            /**
             * is_preview : false
             * mixed : {"button_text":"立即下载","dislike":[{"name":"为什么看到此广告","open_url":"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike&hide_more=1&title=为什么看到此广告"}],"display_subtype":3,"filter_words":[{"id":"4:2","is_selected":false,"name":"看过了"},{"id":"2:0","is_selected":false,"name":"屏蔽:京东 的广告"}],"id":94112175398,"image":"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg","image_height":286,"image_width":690,"is_tongtou_ad":false,"label":"京东广告","log_extra":"{\"ad_price\":\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\",\"convert_component_suspend\":0,\"convert_id\":0,\"external_action\":0,\"item_id\":6545690546311004686,\"media_id\":1587845744613390,\"orit\":null,\"req_id\":\"201805241736340100150181521464BC\",\"rit\":3}","open_url":"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A","show_dislike":1,"source_name":"京东 ","title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","track_url":"","track_url_list":[],"type":"web","web_title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","web_url":"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x&log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8&v=404&p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA&bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398"}
             */

            private boolean is_preview;
            private MixedBean mixed;

            public boolean isIs_preview() {
                return is_preview;
            }

            public void setIs_preview(boolean is_preview) {
                this.is_preview = is_preview;
            }

            public MixedBean getMixed() {
                return mixed;
            }

            public void setMixed(MixedBean mixed) {
                this.mixed = mixed;
            }

            public static class MixedBean {
                /**
                 * button_text : 立即下载
                 * dislike : [{"name":"为什么看到此广告","open_url":"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike&hide_more=1&title=为什么看到此广告"}]
                 * display_subtype : 3
                 * filter_words : [{"id":"4:2","is_selected":false,"name":"看过了"},{"id":"2:0","is_selected":false,"name":"屏蔽:京东 的广告"}]
                 * id : 94112175398
                 * image : https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg
                 * image_height : 286
                 * image_width : 690
                 * is_tongtou_ad : false
                 * label : 京东广告
                 * log_extra : {"ad_price":"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw","convert_component_suspend":0,"convert_id":0,"external_action":0,"item_id":6545690546311004686,"media_id":1587845744613390,"orit":null,"req_id":"201805241736340100150181521464BC","rit":3}
                 * open_url : openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A
                 * show_dislike : 1
                 * source_name : 京东
                 * title : 羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！
                 * track_url :
                 * track_url_list : []
                 * type : web
                 * web_title : 羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！
                 * web_url : https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x&log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8&v=404&p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA&bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398
                 */

                private String button_text;
                private int display_subtype;
                private long id;
                private String image;
                private List<NewsContent.ImageListBean> image_list;
                private int image_height;
                private int image_width;
                private boolean is_tongtou_ad;
                private String label;
                private String log_extra;
                private String open_url;
                private int show_dislike;
                private String source_name;
                private String title;
                private String track_url;
                private String type;
                private String web_title;
                private String web_url;
                private List<DislikeBean> dislike;
                private List<FilterWordsBean> filter_words;
                private List<?> track_url_list;

                public String getButton_text() {
                    return button_text;
                }

                public void setButton_text(String button_text) {
                    this.button_text = button_text;
                }

                public int getDisplay_subtype() {
                    return display_subtype;
                }

                public void setDisplay_subtype(int display_subtype) {
                    this.display_subtype = display_subtype;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public int getImage_height() {
                    return image_height;
                }

                public void setImage_height(int image_height) {
                    this.image_height = image_height;
                }

                public int getImage_width() {
                    return image_width;
                }

                public void setImage_width(int image_width) {
                    this.image_width = image_width;
                }

                public boolean isIs_tongtou_ad() {
                    return is_tongtou_ad;
                }

                public void setIs_tongtou_ad(boolean is_tongtou_ad) {
                    this.is_tongtou_ad = is_tongtou_ad;
                }

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getLog_extra() {
                    return log_extra;
                }

                public void setLog_extra(String log_extra) {
                    this.log_extra = log_extra;
                }

                public String getOpen_url() {
                    return open_url;
                }

                public void setOpen_url(String open_url) {
                    this.open_url = open_url;
                }

                public int getShow_dislike() {
                    return show_dislike;
                }

                public void setShow_dislike(int show_dislike) {
                    this.show_dislike = show_dislike;
                }

                public String getSource_name() {
                    return source_name;
                }

                public void setSource_name(String source_name) {
                    this.source_name = source_name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTrack_url() {
                    return track_url;
                }

                public void setTrack_url(String track_url) {
                    this.track_url = track_url;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getWeb_title() {
                    return web_title;
                }

                public void setWeb_title(String web_title) {
                    this.web_title = web_title;
                }

                public String getWeb_url() {
                    return web_url;
                }

                public void setWeb_url(String web_url) {
                    this.web_url = web_url;
                }

                public List<DislikeBean> getDislike() {
                    return dislike;
                }

                public void setDislike(List<DislikeBean> dislike) {
                    this.dislike = dislike;
                }

                public List<FilterWordsBean> getFilter_words() {
                    return filter_words;
                }

                public void setFilter_words(List<FilterWordsBean> filter_words) {
                    this.filter_words = filter_words;
                }

                public List<?> getTrack_url_list() {
                    return track_url_list;
                }

                public void setTrack_url_list(List<?> track_url_list) {
                    this.track_url_list = track_url_list;
                }

                public List<NewsContent.ImageListBean> getImage_list() {
                    return image_list;
                }

                public void setImage_list(List<NewsContent.ImageListBean> image_list) {
                    this.image_list = image_list;
                }

                public static class DislikeBean {
                    /**
                     * name : 为什么看到此广告
                     * open_url : sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike&hide_more=1&title=为什么看到此广告
                     */

                    private String name;
                    private String open_url;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getOpen_url() {
                        return open_url;
                    }

                    public void setOpen_url(String open_url) {
                        this.open_url = open_url;
                    }
                }

                public static class FilterWordsBean {
                    /**
                     * id : 4:2
                     * is_selected : false
                     * name : 看过了
                     */

                    private String id;
                    private boolean is_selected;
                    private String name;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public boolean isIs_selected() {
                        return is_selected;
                    }

                    public void setIs_selected(boolean is_selected) {
                        this.is_selected = is_selected;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }

        public static class H5ExtraBean {
            /**
             * have_red_pack : 0
             * is_original : true
             * is_subscribed : 0
             * media : {"avatar_url":"http://p4.pstatp.com/large/6eea00032201847d263f","can_be_praised":true,"description":"这里有最新的动漫新番，还有从小追到大的回忆","id":1587845744613390,"name":"磁力影视","pgc_custom_menu":"","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_decoration":"","user_verified":true}
             */

            private int have_red_pack;
            private boolean is_original;
            private int is_subscribed;
            private MediaBean media;

            public int getHave_red_pack() {
                return have_red_pack;
            }

            public void setHave_red_pack(int have_red_pack) {
                this.have_red_pack = have_red_pack;
            }

            public boolean isIs_original() {
                return is_original;
            }

            public void setIs_original(boolean is_original) {
                this.is_original = is_original;
            }

            public int getIs_subscribed() {
                return is_subscribed;
            }

            public void setIs_subscribed(int is_subscribed) {
                this.is_subscribed = is_subscribed;
            }

            public MediaBean getMedia() {
                return media;
            }

            public void setMedia(MediaBean media) {
                this.media = media;
            }

            public static class MediaBean {
                /**
                 * avatar_url : http://p4.pstatp.com/large/6eea00032201847d263f
                 * can_be_praised : true
                 * description : 这里有最新的动漫新番，还有从小追到大的回忆
                 * id : 1587845744613390
                 * name : 磁力影视
                 * pgc_custom_menu :
                 * user_auth_info : {"auth_type": "0", "auth_info": "优酷旗下头条号"}
                 * user_decoration :
                 * user_verified : true
                 */

                private String avatar_url;
                private boolean can_be_praised;
                private String description;
                private long id;
                private String name;
                private String pgc_custom_menu;
                private String user_auth_info;
                private String user_decoration;
                private boolean user_verified;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public boolean isCan_be_praised() {
                    return can_be_praised;
                }

                public void setCan_be_praised(boolean can_be_praised) {
                    this.can_be_praised = can_be_praised;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPgc_custom_menu() {
                    return pgc_custom_menu;
                }

                public void setPgc_custom_menu(String pgc_custom_menu) {
                    this.pgc_custom_menu = pgc_custom_menu;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public String getUser_decoration() {
                    return user_decoration;
                }

                public void setUser_decoration(String user_decoration) {
                    this.user_decoration = user_decoration;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }
            }
        }

        public static class LogPbBean {
            /**
             * impr_id : 201805241736340100150181521464BC
             */

            private String impr_id;

            public String getImpr_id() {
                return impr_id;
            }

            public void setImpr_id(String impr_id) {
                this.impr_id = impr_id;
            }
        }

        public static class MediaInfoBean {
            /**
             * avatar_url : http://p4.pstatp.com/large/6eea00032201847d263f
             * description : 这里有最新的动漫新番，还有从小追到大的回忆
             * media_id : 1587845744613390
             * name : 磁力影视
             * special_column : []
             * subcribed : 0
             * user_auth_info : {"auth_type": "0", "auth_info": "优酷旗下头条号"}
             * user_id : 82702459638
             * user_verified : true
             */

            private String avatar_url;
            private String description;
            private long media_id;
            private String name;
            private int subcribed;
            private String user_auth_info;
            private long user_id;
            private boolean user_verified;
            private List<?> special_column;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public long getMedia_id() {
                return media_id;
            }

            public void setMedia_id(long media_id) {
                this.media_id = media_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSubcribed() {
                return subcribed;
            }

            public void setSubcribed(int subcribed) {
                this.subcribed = subcribed;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public List<?> getSpecial_column() {
                return special_column;
            }

            public void setSpecial_column(List<?> special_column) {
                this.special_column = special_column;
            }
        }

        public static class RecommendSponsorBean {
            /**
             * icon_url : http://p3.pstatp.com/origin/13ef000096960314fff4
             * label : 帮上头条
             * target_url : https://i.snssdk.com/ad/pgc_promotion/mobile/create/?group_id=6545690546311004686&item_id=6545690546311004686
             */

            private String icon_url;
            private String label;
            private String target_url;

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getTarget_url() {
                return target_url;
            }

            public void setTarget_url(String target_url) {
                this.target_url = target_url;
            }
        }

        public static class RewardsBean {
            /**
             * rewards_list : []
             * rewards_list_url : sslocal://webview?title=%E8%B5%9E%E8%B5%8F%E8%AF%A6%E6%83%85&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Farticle_praise_list%2F%3Farticle_id%3D6545690546311004686
             * rewards_num : 0
             * rewards_open_url : sslocal://webview?title=%E8%B5%9E%E8%B5%8F&url=http%3A%2F%2Fic.snssdk.com%2Fpgcapi%2Fpraise%2Fselect_amount%2F%3Fmedia_id%3D1587845744613390%26article_id%3D6545690546311004686
             */

            private String rewards_list_url;
            private int rewards_num;
            private String rewards_open_url;
            private List<?> rewards_list;

            public String getRewards_list_url() {
                return rewards_list_url;
            }

            public void setRewards_list_url(String rewards_list_url) {
                this.rewards_list_url = rewards_list_url;
            }

            public int getRewards_num() {
                return rewards_num;
            }

            public void setRewards_num(int rewards_num) {
                this.rewards_num = rewards_num;
            }

            public String getRewards_open_url() {
                return rewards_open_url;
            }

            public void setRewards_open_url(String rewards_open_url) {
                this.rewards_open_url = rewards_open_url;
            }

            public List<?> getRewards_list() {
                return rewards_list;
            }

            public void setRewards_list(List<?> rewards_list) {
                this.rewards_list = rewards_list;
            }
        }

        public static class ShareInfoBean {
            /**
             * share_type : {"pyq":2,"qq":0,"qzone":0,"wx":0}
             * share_url : http://m.toutiaoimg.cn/group/6545690546311004686/?iid=32758433763&app=news_article&timestamp=1527154594
             * title : 【今日头条】火影忍者：心疼自来也受了那么重的伤，一定要活下去拜托
             */

            private ShareTypeBean share_type;
            private String share_url;
            private String title;

            public ShareTypeBean getShare_type() {
                return share_type;
            }

            public void setShare_type(ShareTypeBean share_type) {
                this.share_type = share_type;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class ShareTypeBean {
                /**
                 * pyq : 2
                 * qq : 0
                 * qzone : 0
                 * wx : 0
                 */

                private int pyq;
                private int qq;
                private int qzone;
                private int wx;

                public int getPyq() {
                    return pyq;
                }

                public void setPyq(int pyq) {
                    this.pyq = pyq;
                }

                public int getQq() {
                    return qq;
                }

                public void setQq(int qq) {
                    this.qq = qq;
                }

                public int getQzone() {
                    return qzone;
                }

                public void setQzone(int qzone) {
                    this.qzone = qzone;
                }

                public int getWx() {
                    return wx;
                }

                public void setWx(int wx) {
                    this.wx = wx;
                }
            }
        }

        public static class UserInfoBean {
            /**
             * avatar_url : http://p3.pstatp.com/thumb/6eea00032201847d263f
             * description : 这里有最新的动漫新番，还有从小追到大的回忆
             * fans_count : 38750
             * follow : 0
             * media_id : 1587845744613390
             * name : 磁力影视
             * special_column : []
             * subcribed : 0
             * user_auth_info : {"auth_type": "0", "auth_info": "优酷旗下头条号"}
             * user_decoration :
             * user_id : 82702459638
             * user_verified : true
             */

            private String avatar_url;
            private String description;
            private int fans_count;
            private int follow;
            private long media_id;
            private String name;
            private int subcribed;
            private String user_auth_info;
            private String user_decoration;
            private long user_id;
            private boolean user_verified;
            private List<?> special_column;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getFans_count() {
                return fans_count;
            }

            public void setFans_count(int fans_count) {
                this.fans_count = fans_count;
            }

            public int getFollow() {
                return follow;
            }

            public void setFollow(int follow) {
                this.follow = follow;
            }

            public long getMedia_id() {
                return media_id;
            }

            public void setMedia_id(long media_id) {
                this.media_id = media_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSubcribed() {
                return subcribed;
            }

            public void setSubcribed(int subcribed) {
                this.subcribed = subcribed;
            }

            public String getUser_auth_info() {
                return user_auth_info;
            }

            public void setUser_auth_info(String user_auth_info) {
                this.user_auth_info = user_auth_info;
            }

            public String getUser_decoration() {
                return user_decoration;
            }

            public void setUser_decoration(String user_decoration) {
                this.user_decoration = user_decoration;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public List<?> getSpecial_column() {
                return special_column;
            }

            public void setSpecial_column(List<?> special_column) {
                this.special_column = special_column;
            }
        }

        public static class FilterWordsBeanX {
            /**
             * id : 5:2112582931
             * name : 拉黑作者:磁力影视
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class OrderedInfoBean {
            /**
             * ad_data : {"is_preview":false,"mixed":{"button_text":"立即下载","dislike":[{"name":"为什么看到此广告","open_url":"sslocal://webview?url=https%3a%2f%2fi.snssdk.com%2fapi%2fad%2ffeedback%2fprivacy%2fpage%3ftype%3dadx_dislike\u0026hide_more=1\u0026title=为什么看到此广告"}],"display_subtype":3,"filter_words":[{"id":"4:2","is_selected":false,"name":"看过了"},{"id":"2:0","is_selected":false,"name":"屏蔽:京东 的广告"}],"id":94112175398,"image":"https://img1.360buyimg.com/pop/jfs/t13174/81/2695780680/48333/de0f3c5a/5aa8d865N2d9b7efa.jpg","image_height":286,"image_width":690,"is_tongtou_ad":false,"label":"京东广告","log_extra":"{\"ad_price\":\"WwaHogAOJ_9bBoeiAA4n_1G0qOUrhyWUESNMVw\",\"convert_component_suspend\":0,\"convert_id\":0,\"external_action\":0,\"item_id\":6545690546311004686,\"media_id\":1587845744613390,\"orit\":null,\"req_id\":\"201805241736340100150181521464BC\",\"rit\":3}","open_url":"openapp.jdmobile://virtual?params=%7B%22SE%22%3A%22ADC_w5R%2FcMGewM8bU1Qe12MJ%2F80bTEokDE6WuyQ2cgFLjoGzjCehAQTHmc5jLgDiUL0NtLnsaxfGcabCeB3he2U43JFsJTL%2BNfOu7Z51aWlPLI0IOH4teQXMukqqwCU5GQknDAnbaeCk0xczQHmLo%2FNljtbf1blnOm%2BjAmIvkEngTHY%3D%22%2C%22action%22%3A%22to%22%2C%22category%22%3A%22jump%22%2C%22des%22%3A%22getCoupon%22%2C%22ext%22%3A%22%7B%5C%22ad%5C%22%3A%5C%222536%5C%22%2C%5C%22ch%5C%22%3A%5C%223%5C%22%2C%5C%22shop%5C%22%3A%5C%2258881%5C%22%2C%5C%22ts%5C%22%3A%5C%221527154594%5C%22%7D%22%2C%22keplerFrom%22%3A%221%22%2C%22keplerID%22%3A%22snssdk143%22%2C%22kepler_param%22%3A%7B%22channel%22%3A%2220f80cdfab5349a1bfc7bfbda2b59836%22%2C%22source%22%3A%22kepler-open%22%7D%2C%22m_param%22%3A%7B%22jdv%22%3A%22238571484%7Ctoutiao%7Ct_1000067282_208224171_2536%7Cadrealizable%7C_2_app_0_86044ab9a9b24621852498f96f3733af-p_2536%22%7D%2C%22sourceType%22%3A%22adx%22%2C%22sourceValue%22%3A%22toutiao_99%22%2C%22url%22%3A%22https%3A%2F%2Fccc-x.jd.com%2Fdsp%2Fnc%3Fp%3DWwaHogAN9hlbBoeiAA32GVchWfm1VRCyQfs1-w%26bid%3D94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398%26ext%3DaHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x%26log%3DzE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NXFY8R12N2kkFcdRyLQrpq3BMxVjA89tG4tmJgse1tihLxcrtIK3lCoyRBqYHwyTGhnbQt7ZNghznPTNPuQUVGMKS6tGIw0MoPWpEE9zxn-w_tUKqgDIbzqkliKRhIqqI6neO9bgT0skqhMy3YUwqaEfyzXv-g0U74N1b6bEmT9A8Qc4S0kgwRJ2VW3J8ZVyPf7RPfIMldeDrqrxGrZTz9gGzfN03xbs3vXkZAJy_fsr8vPXE8lodXfLI5O5LmDUDXHfq9K4bL1iijvKNemn1TcYgz6txP01qigPt233J1O_fG9zhkVtNYnr120CUBNPEJopSqp-R2VJ8aeYxZyFsnOD6k9sVNn9zSzGYpwbliHO%26v%3D404%26SE%3D1%22%7D%0A","show_dislike":1,"source_name":"京东 ","title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","track_url":"","track_url_list":[],"type":"web","web_title":"羽毛球鞋都是花里胡哨的？这里有双清新脱俗的亚瑟士！","web_url":"https://ccc-x.jd.com/dsp/nc?ext=aHR0cHM6Ly9pdGVtLm0uamQuY29tL3Byb2R1Y3QvMjY2MDQ5NzEyNzcuaHRtbD9QVEFHPTE3MDUxLjkuMSZhZF9vZD0x\u0026log=zE7nFXeUC1wIQgfW0bXPggmUYl7vMt-JHsa9kiPgSknIb6uhT07sBAluY-G_KeG8UzSDdRCHH74G_khEkt5jQ5v5lDi1B0R9r4T5MyWQRpeutxJxEM17JfT1sPKvj5oD2BZutyie6-ziQ6yblRS1dD4lbZDslQ4ZgDkbVHHQ553F03rO4Z_h4PK50LAXtK0hrdIlZw5VlLUYCzehW8L2NcvtQ7HWr221Ycl7gP3cCM_faCwdZeHOUJO-rhdqePakr0UurFcmozM8TFGtwqEVWYyjLIwknhtqmMGxBmljwB6CKJooYO2iESBqgegis99JDcdzsz7czDl5sNCgSMHTGKCmwFN_bXmjzMvbAWwOhODoZnLIDEjGD4kbpiXQ4hcJxo8vyuyNYRIkRgKlAJfkUN4b4DTmMXEfrlKgRTheDKALoYb27-hWnMeOVu91qsyrzXhQGLkcs7I76frV2Tp35N9FeoM9Q-g2li-K-RsztbJ6OnuF4d8EsVtVl2Jp5hb8\u0026v=404\u0026p=WwaHogAN9gJbBoeiAA32AvHIs5Od4im7TYg3DA\u0026bid=94112175398v62939645791v12x201805241736340100150181521464BCv3v94112175398"}}
             * name : ad
             */

            private String ad_data;
            private String name;

            public String getAd_data() {
                return ad_data;
            }

            public void setAd_data(String ad_data) {
                this.ad_data = ad_data;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class RelatedVideoToutiaoBean {
            /**
             * abstract : 这样买家具？上门量尺设计风格，欧派全屋定制仅1.
             * ad_id : 1601336525302803
             * aggr_type : 1
             * article_sub_type : 0
             * article_type : 0
             * article_url : http://toutiao.com/item/6559076033067221252/
             * ban_action : 0
             * ban_bury : 0
             * ban_comment : 1
             * ban_danmaku : 0
             * ban_download : 0
             * behot_time : 1527153894
             * bury_count : 0
             * card_type : ad_video
             * comment_count : 0
             * danmaku_count : 0
             * digg_count : 0
             * display_title :
             * display_url : http://toutiao.com/item/6559076033067221252/
             * group_flags : 36961
             * group_id : 6559076033067221252
             * has_image : false
             * has_m3u8_video : 0
             * has_mp4_video : 0
             * has_video : true
             * hot : 0
             * id : 1601336525302803
             * image_count : 0
             * image_list : []
             * is_article : true
             * is_preview : false
             * item_id : 6559076033067221252
             * keywords :
             * level : 0
             * log_extra : {"rit":9,"orit":1,"req_id":"201805241736340100150181521464BC","convert_id":1599855812619320,"external_action":2,"convert_component_suspend":0,"ad_price":"WwaHogAOveFbBoeiAA694b3aYeRig8ftWMA0ig"}
             * log_pb : {"from_gid":"6545690546311004686","impr_id":"201805241736340100150181521464BC"}
             * middle_image : {"day_mode":0,"height":720,"uri":"list/web.business.image/201805245d0dc105427ed90941ae88f4","url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg","url_list":[{"url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"}],"width":1280}
             * natant_level : 2
             * open_url :
             * preload_web : 0
             * publish_time : 1527153894
             * repin_count : 0
             * share_count : 0
             * share_token :
             * share_url : http://toutiao.com/group/6559076033067221252/?iid=32758433763&app=news_article
             * show_tag : 广告
             * source : 欧派高端全屋定制
             * tag : ad
             * tag_id : 6559076033067221252
             * text_count : 0
             * tip : 0
             * title : 这样买家具？上门量尺设计风格，欧派全屋定制仅1.98万
             * title_rich_span :
             * track_url_list : []
             * type : web
             * url : http://toutiao.com/item/6559076033067221252/
             * video_detail_info : {"detail_video_large_image":{"height":327,"uri":"video1609/86da000ded94cbc14fec","url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec","url_list":[{"url":"http://p2.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://pb3.pstatp.com/video1609/86da000ded94cbc14fec"},{"url":"http://p.pstatp.com/video1609/86da000ded94cbc14fec"}],"width":580},"direct_play":1,"group_flags":36961,"show_pgc_subscribe":1,"video_id":"v03033c20000bc32u7dehji8cgidktmg","video_third_monitor_url":"","video_watch_count":186}
             * video_duration : 15
             * video_play_info : {"status":10,"message":"success","video_duration":15.96,"validate":"","enable_ssl":false,"poster_url":"http://p3.pstatp.com/origin/86da000ded94cbc14fec","auto_definition":"360p","original_play_url":{"backup_url":"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/","main_url":"http://voffline.byted.org/download/m/78561000008ea8ffec5ae/"},"video_list":{"video_1":{"definition":"360p","vtype":"mp4","vwidth":640,"vheight":360,"bitrate":323799,"logo_type":"","codec_type":"h264","size":787710,"main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=","main_http_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzAxOGQ0MjkxNGU4Njg2NmI0OWY0ZWY0MDc5NmM1MDcyLzViMDY5NWIyL3ZpZGVvL20vMjIwMzgwODkwMjYwZjczNGU5ZGJiYTZlY2VhOTg2OWI1NTYxMTU3ODAzNDAwMDAzMTI5YWM2Njg3ZGIv","backup_http_url":"aHR0cDovL3Y3LnBzdGF0cC5jb20vMGU3N2FhYzI5MDU0MzIwNTI4OTU4ZTg0OTA0ZjA4YzcvNWIwNjk1YjIvdmlkZW8vbS8yMjAzODA4OTAyNjBmNzM0ZTlkYmJhNmVjZWE5ODY5YjU1NjExNTc4MDM0MDAwMDMxMjlhYzY2ODdkYi8=","user_video_proxy":1,"socket_buffer":7285320,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"encryption_key":"","player_access_key":""},"video_2":{"definition":"480p","vtype":"mp4","vwidth":854,"vheight":480,"bitrate":489240,"logo_type":"","codec_type":"h264","size":1116954,"main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=","main_http_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tL2E2NTk3MWZiZjFiMmQzMWFjMTViNDQ5ZjA3YjYzOGQ3LzViMDY5NWIyL3ZpZGVvL20vMjIwM2MyMzI1NDVhMDRiNDViZGE5NTZlNzU2NGU4YWVkMDIxMTU3N2ZmOTAwMDAzMTUyZTEzZDVjNTAv","backup_http_url":"aHR0cDovL3Y3LnBzdGF0cC5jb20vNmRhMGU0ZWYxNWU3N2FiZWFlNDMxNGIzOWNlODkxMDkvNWIwNjk1YjIvdmlkZW8vbS8yMjAzYzIzMjU0NWEwNGI0NWJkYTk1NmU3NTY0ZThhZWQwMjExNTc3ZmY5MDAwMDMxNTJlMTNkNWM1MC8=","user_video_proxy":1,"socket_buffer":11007900,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"encryption_key":"","player_access_key":""},"video_3":{"definition":"720p","vtype":"mp4","vwidth":1280,"vheight":720,"bitrate":1044478,"logo_type":"","codec_type":"h264","size":2221878,"main_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv","backup_url_1":"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=","main_http_url":"aHR0cDovL3YxMS10dC5peGlndWEuY29tLzM1NDg4ZWI2N2IwYzExNTliNjc1NTM5YTdjZmNjYmI3LzViMDY5NWIyL3ZpZGVvL20vMjIwNDEzYmU2OGU3ZDBlNDFmYmEyZjY2ZTg1OTc1NmE0MDMxMTU3N2ViZDAwMDAzNzNjNGZlODkwMWIv","backup_http_url":"aHR0cDovL3Y3LnBzdGF0cC5jb20vOThiNjU1MjYwODlmOTA0MWQyMGUyODkxN2JmMGU1ZWYvNWIwNjk1YjIvdmlkZW8vbS8yMjA0MTNiZTY4ZTdkMGU0MWZiYTJmNjZlODU5NzU2YTQwMzExNTc3ZWJkMDAwMDM3M2M0ZmU4OTAxYi8=","user_video_proxy":1,"socket_buffer":23500620,"preload_size":327680,"preload_interval":45,"preload_min_step":5,"preload_max_step":10,"encryption_key":"","player_access_key":""}},"dns_info":{}}
             * video_style : 0
             * web_url :
             * media_name : 磁力影视
             * show_portrait_article : false
             * user_info : {"avatar_url":"http://p3.pstatp.com/thumb/6eea00032201847d263f","description":"这里有最新的动漫新番，还有从小追到大的回忆","follow":false,"is_living":false,"media_id":0,"name":"磁力影视","screen_name":"磁力影视","user_auth_info":"{\"auth_type\": \"0\", \"auth_info\": \"优酷旗下头条号\"}","user_id":82702459638,"user_verified":1,"verified_content":"优酷旗下头条号","video_live_auth":false}
             * video_proportion_article : 1.7777777777777777
             */

            @SerializedName("abstract")
            private String abstractX;
            private long ad_id;
            private int aggr_type;
            private int article_sub_type;
            private int article_type;
            private String article_url;
            private int ban_action;
            private int ban_bury;
            private int ban_comment;
            private int ban_danmaku;
            private int ban_download;
            private int behot_time;
            private int bury_count;
            private String card_type;
            private int comment_count;
            private int danmaku_count;
            private int digg_count;
            private String display_title;
            private String display_url;
            private int group_flags;
            private long group_id;
            private boolean has_image;
            private int has_m3u8_video;
            private int has_mp4_video;
            private boolean has_video;
            private int hot;
            private long id;
            private int image_count;
            private boolean is_article;
            private boolean is_preview;
            private String item_id;
            private String keywords;
            private int level;
            private String log_extra;
            private LogPbBeanX log_pb;
            private MiddleImageBean middle_image;
            private int natant_level;
            private String open_url;
            private int preload_web;
            private long publish_time;
            private int repin_count;
            private int share_count;
            private String share_token;
            private String share_url;
            private String show_tag;
            private String source;
            private String tag;
            private long tag_id;
            private int text_count;
            private int tip;
            private String title;
            private String title_rich_span;
            private String type;
            private String url;
            private NewsContent.VideoDetailInfoBean video_detail_info;
            private int video_duration;
            private String video_play_info;
            private int video_style;
            private String web_url;
            private String media_name;
            private boolean show_portrait_article;
            private UserInfoBeanX user_info;
            private double video_proportion_article;
            private List<?> image_list;
            private List<?> track_url_list;

            public String getAbstractX() {
                return abstractX;
            }

            public void setAbstractX(String abstractX) {
                this.abstractX = abstractX;
            }

            public long getAd_id() {
                return ad_id;
            }

            public void setAd_id(long ad_id) {
                this.ad_id = ad_id;
            }

            public int getAggr_type() {
                return aggr_type;
            }

            public void setAggr_type(int aggr_type) {
                this.aggr_type = aggr_type;
            }

            public int getArticle_sub_type() {
                return article_sub_type;
            }

            public void setArticle_sub_type(int article_sub_type) {
                this.article_sub_type = article_sub_type;
            }

            public int getArticle_type() {
                return article_type;
            }

            public void setArticle_type(int article_type) {
                this.article_type = article_type;
            }

            public String getArticle_url() {
                return article_url;
            }

            public void setArticle_url(String article_url) {
                this.article_url = article_url;
            }

            public int getBan_action() {
                return ban_action;
            }

            public void setBan_action(int ban_action) {
                this.ban_action = ban_action;
            }

            public int getBan_bury() {
                return ban_bury;
            }

            public void setBan_bury(int ban_bury) {
                this.ban_bury = ban_bury;
            }

            public int getBan_comment() {
                return ban_comment;
            }

            public void setBan_comment(int ban_comment) {
                this.ban_comment = ban_comment;
            }

            public int getBan_danmaku() {
                return ban_danmaku;
            }

            public void setBan_danmaku(int ban_danmaku) {
                this.ban_danmaku = ban_danmaku;
            }

            public int getBan_download() {
                return ban_download;
            }

            public void setBan_download(int ban_download) {
                this.ban_download = ban_download;
            }

            public int getBehot_time() {
                return behot_time;
            }

            public void setBehot_time(int behot_time) {
                this.behot_time = behot_time;
            }

            public int getBury_count() {
                return bury_count;
            }

            public void setBury_count(int bury_count) {
                this.bury_count = bury_count;
            }

            public String getCard_type() {
                return card_type;
            }

            public void setCard_type(String card_type) {
                this.card_type = card_type;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }

            public int getDanmaku_count() {
                return danmaku_count;
            }

            public void setDanmaku_count(int danmaku_count) {
                this.danmaku_count = danmaku_count;
            }

            public int getDigg_count() {
                return digg_count;
            }

            public void setDigg_count(int digg_count) {
                this.digg_count = digg_count;
            }

            public String getDisplay_title() {
                return display_title;
            }

            public void setDisplay_title(String display_title) {
                this.display_title = display_title;
            }

            public String getDisplay_url() {
                return display_url;
            }

            public void setDisplay_url(String display_url) {
                this.display_url = display_url;
            }

            public int getGroup_flags() {
                return group_flags;
            }

            public void setGroup_flags(int group_flags) {
                this.group_flags = group_flags;
            }

            public long getGroup_id() {
                return group_id;
            }

            public void setGroup_id(long group_id) {
                this.group_id = group_id;
            }

            public boolean isHas_image() {
                return has_image;
            }

            public void setHas_image(boolean has_image) {
                this.has_image = has_image;
            }

            public int getHas_m3u8_video() {
                return has_m3u8_video;
            }

            public void setHas_m3u8_video(int has_m3u8_video) {
                this.has_m3u8_video = has_m3u8_video;
            }

            public int getHas_mp4_video() {
                return has_mp4_video;
            }

            public void setHas_mp4_video(int has_mp4_video) {
                this.has_mp4_video = has_mp4_video;
            }

            public boolean isHas_video() {
                return has_video;
            }

            public void setHas_video(boolean has_video) {
                this.has_video = has_video;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getImage_count() {
                return image_count;
            }

            public void setImage_count(int image_count) {
                this.image_count = image_count;
            }

            public boolean isIs_article() {
                return is_article;
            }

            public void setIs_article(boolean is_article) {
                this.is_article = is_article;
            }

            public boolean isIs_preview() {
                return is_preview;
            }

            public void setIs_preview(boolean is_preview) {
                this.is_preview = is_preview;
            }

            public String getItem_id() {
                return item_id;
            }

            public void setItem_id(String item_id) {
                this.item_id = item_id;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getLog_extra() {
                return log_extra;
            }

            public void setLog_extra(String log_extra) {
                this.log_extra = log_extra;
            }

            public LogPbBeanX getLog_pb() {
                return log_pb;
            }

            public void setLog_pb(LogPbBeanX log_pb) {
                this.log_pb = log_pb;
            }

            public MiddleImageBean getMiddle_image() {
                return middle_image;
            }

            public void setMiddle_image(MiddleImageBean middle_image) {
                this.middle_image = middle_image;
            }

            public int getNatant_level() {
                return natant_level;
            }

            public void setNatant_level(int natant_level) {
                this.natant_level = natant_level;
            }

            public String getOpen_url() {
                return open_url;
            }

            public void setOpen_url(String open_url) {
                this.open_url = open_url;
            }

            public int getPreload_web() {
                return preload_web;
            }

            public void setPreload_web(int preload_web) {
                this.preload_web = preload_web;
            }

            public long getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(long publish_time) {
                this.publish_time = publish_time;
            }

            public int getRepin_count() {
                return repin_count;
            }

            public void setRepin_count(int repin_count) {
                this.repin_count = repin_count;
            }

            public int getShare_count() {
                return share_count;
            }

            public void setShare_count(int share_count) {
                this.share_count = share_count;
            }

            public String getShare_token() {
                return share_token;
            }

            public void setShare_token(String share_token) {
                this.share_token = share_token;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getShow_tag() {
                return show_tag;
            }

            public void setShow_tag(String show_tag) {
                this.show_tag = show_tag;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public long getTag_id() {
                return tag_id;
            }

            public void setTag_id(long tag_id) {
                this.tag_id = tag_id;
            }

            public int getText_count() {
                return text_count;
            }

            public void setText_count(int text_count) {
                this.text_count = text_count;
            }

            public int getTip() {
                return tip;
            }

            public void setTip(int tip) {
                this.tip = tip;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTitle_rich_span() {
                return title_rich_span;
            }

            public void setTitle_rich_span(String title_rich_span) {
                this.title_rich_span = title_rich_span;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public NewsContent.VideoDetailInfoBean getVideo_detail_info() {
                return video_detail_info;
            }

            public void setVideo_detail_info(NewsContent.VideoDetailInfoBean video_detail_info) {
                this.video_detail_info = video_detail_info;
            }

            public int getVideo_duration() {
                return video_duration;
            }

            public void setVideo_duration(int video_duration) {
                this.video_duration = video_duration;
            }

            public String getVideo_play_info() {
                return video_play_info;
            }

            public void setVideo_play_info(String video_play_info) {
                this.video_play_info = video_play_info;
            }

            public int getVideo_style() {
                return video_style;
            }

            public void setVideo_style(int video_style) {
                this.video_style = video_style;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public String getMedia_name() {
                return media_name;
            }

            public void setMedia_name(String media_name) {
                this.media_name = media_name;
            }

            public boolean isShow_portrait_article() {
                return show_portrait_article;
            }

            public void setShow_portrait_article(boolean show_portrait_article) {
                this.show_portrait_article = show_portrait_article;
            }

            public UserInfoBeanX getUser_info() {
                return user_info;
            }

            public void setUser_info(UserInfoBeanX user_info) {
                this.user_info = user_info;
            }

            public double getVideo_proportion_article() {
                return video_proportion_article;
            }

            public void setVideo_proportion_article(double video_proportion_article) {
                this.video_proportion_article = video_proportion_article;
            }

            public List<?> getImage_list() {
                return image_list;
            }

            public void setImage_list(List<?> image_list) {
                this.image_list = image_list;
            }

            public List<?> getTrack_url_list() {
                return track_url_list;
            }

            public void setTrack_url_list(List<?> track_url_list) {
                this.track_url_list = track_url_list;
            }

            public static class LogPbBeanX {
                /**
                 * from_gid : 6545690546311004686
                 * impr_id : 201805241736340100150181521464BC
                 */

                private String from_gid;
                private String impr_id;

                public String getFrom_gid() {
                    return from_gid;
                }

                public void setFrom_gid(String from_gid) {
                    this.from_gid = from_gid;
                }

                public String getImpr_id() {
                    return impr_id;
                }

                public void setImpr_id(String impr_id) {
                    this.impr_id = impr_id;
                }
            }

            public static class MiddleImageBean {
                /**
                 * day_mode : 0
                 * height : 720
                 * uri : list/web.business.image/201805245d0dc105427ed90941ae88f4
                 * url : http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg
                 * url_list : [{"url":"http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf6-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"},{"url":"http://sf1-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg"}]
                 * width : 1280
                 */

                private int day_mode;
                private int height;
                private String uri;
                private String url;
                private int width;
                private List<UrlListBean> url_list;

                public int getDay_mode() {
                    return day_mode;
                }

                public void setDay_mode(int day_mode) {
                    this.day_mode = day_mode;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public String getUrl() {
                    return url==null?uri:url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public List<UrlListBean> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBean> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBean {
                    /**
                     * url : http://sf3-ttcdn-tos.pstatp.com/img/web.business.image/201805245d0dc105427ed90941ae88f4~172x120_cs.jpeg
                     */

                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            public static class UserInfoBeanX {
                /**
                 * avatar_url : http://p3.pstatp.com/thumb/6eea00032201847d263f
                 * description : 这里有最新的动漫新番，还有从小追到大的回忆
                 * follow : false
                 * is_living : false
                 * media_id : 0
                 * name : 磁力影视
                 * screen_name : 磁力影视
                 * user_auth_info : {"auth_type": "0", "auth_info": "优酷旗下头条号"}
                 * user_id : 82702459638
                 * user_verified : 1
                 * verified_content : 优酷旗下头条号
                 * video_live_auth : false
                 */

                private String avatar_url;
                private String description;
                private boolean follow;
                private boolean is_living;
                private int media_id;
                private String name;
                private String screen_name;
                private String user_auth_info;
                private long user_id;
                private int user_verified;
                private String verified_content;
                private boolean video_live_auth;

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public boolean isFollow() {
                    return follow;
                }

                public void setFollow(boolean follow) {
                    this.follow = follow;
                }

                public boolean isIs_living() {
                    return is_living;
                }

                public void setIs_living(boolean is_living) {
                    this.is_living = is_living;
                }

                public int getMedia_id() {
                    return media_id;
                }

                public void setMedia_id(int media_id) {
                    this.media_id = media_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getScreen_name() {
                    return screen_name;
                }

                public void setScreen_name(String screen_name) {
                    this.screen_name = screen_name;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public int getUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(int user_verified) {
                    this.user_verified = user_verified;
                }

                public String getVerified_content() {
                    return verified_content;
                }

                public void setVerified_content(String verified_content) {
                    this.verified_content = verified_content;
                }

                public boolean isVideo_live_auth() {
                    return video_live_auth;
                }

                public void setVideo_live_auth(boolean video_live_auth) {
                    this.video_live_auth = video_live_auth;
                }
            }
        }
    }
}
