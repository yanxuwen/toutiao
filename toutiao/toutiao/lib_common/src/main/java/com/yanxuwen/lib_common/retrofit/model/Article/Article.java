package com.yanxuwen.lib_common.retrofit.model.Article;

import com.yanxuwen.lib_common.retrofit.MyBaseModel;
import com.yanxuwen.retrofit.Annotation.Description;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yanxuwen on 2018/6/6.
 */
@Description("获取文章详情代码片段")
public class Article extends MyBaseModel implements Serializable {

    /**
     * data : {"media_user_id":68642701416,"webp_image_detail":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp","width":587,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"}],"uri":"details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp","height":374},{"url":"http://p1.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp","width":629,"url_list":[{"url":"http://p1.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb3.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"}],"uri":"details/v0/w640/pgc-image/15323203101055013f08107.webp","height":334},{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp","width":403,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"}],"uri":"details/v0/w640/pgc-image/15323203098961422dd29a5.webp","height":268},{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp","width":415,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"}],"uri":"details/v0/w640/pgc-image/1532320310040fd16eb274d.webp","height":243}],"webp_thumb_image":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp","width":587,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"}],"uri":"thumb//pgc-image/15323203101548ecfc3e08e.webp","height":374},{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp","width":629,"url_list":[{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb3.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"}],"uri":"thumb//pgc-image/15323203101055013f08107.webp","height":334},{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp","width":403,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"}],"uri":"thumb//pgc-image/15323203098961422dd29a5.webp","height":268},{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp","width":415,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"}],"uri":"thumb//pgc-image/1532320310040fd16eb274d.webp","height":243}],"thumb_image":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"}],"uri":"thumb/pgc-image/15323203101548ecfc3e08e","height":374},{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/thumb/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101055013f08107"}],"uri":"thumb/pgc-image/15323203101055013f08107","height":334},{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"}],"uri":"thumb/pgc-image/15323203098961422dd29a5","height":268},{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"}],"uri":"thumb/pgc-image/1532320310040fd16eb274d","height":243}],"content":"\n\n\n<header><div class=\"tt-title\">台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！<\/div><\/header>\n\n\n<article>\n\n<p><a class=\"image\"  href=\"bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e&index=0\"\nwidth=\"587\" height=\"374\"\nthumb_width=\"120\" thumb_height=\"76\"\nzip_src_path=\"eJyt0tEKgyAYhuFbCY-31KzRupWIYc6VoEvK1kF073PB2GBB0zpKgv85ePlG0LSiEneQBSPoW2G_QNK24lBX7CgUtS-ckIhEiGCEkzjl7MYIRykHh8BeyM6e5KA2RmcQahLqzlCjQ9Yo6AC978vzVgD7AMVkiYGX-vKb48oNFbKDDwSHU4zWtfAFrdfxd5dj7eDhHbw5pal7VX5HnH_ssSkHaDmTD4B9gM-mfGv8OSRXbVOXldE4KcU0PQG3ZWGK\" ><\/a><\/p><p>萧蔷颜值巅峰《小李飞刀》林诗音，李寻欢指腹为婚的表妹，亦是他青梅竹马的恋人。当初金庸先生到访台湾，在和萧蔷谈过话后，都连连称这是全台湾最美丽最有智慧的美人儿。<\/p>\n\n<p><a class=\"image\"  href=\"bytedance://large_image?url=http://p1.pstatp.com/large/pgc-image/15323203101055013f08107&index=1\"\nwidth=\"629\" height=\"334\"\nthumb_width=\"120\" thumb_height=\"64\"\nzip_src_path=\"eJyt0t8KgjAYh-FbkR2X--ay0lsJiWlLB_4ZbuaBeO8tIQoSbNMjh_A9By-_ATWtyEWNYm9AXSvMF5WszTmWebYXFTMvEtKABkAJEAhDIPQOZwIntPPMRanMyQUVWssYY0l8qTTT0s-aCltA7_uUrgUiFyAZDdHzVF5_c9y4ZqJU-AG4Px5gWfNf0HIdd3c-1gZetIE3pdRFV6XfEacfW2zKAprP5AJELsBnU641_hySrbaqy8JorJRkHJ-_LFFa\" ><\/a><\/p><p>\u201c港姐中的港姐\u201d李嘉欣，是香港上流社会太太的\u201c公敌\u201d，她的美丽实在太具侵略性。李嘉欣她美得高贵冷傲，说句\u201c倾国倾城\u201d四个字也不为过。<\/p>\n\n<p><a class=\"image\"  href=\"bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5&index=2\"\nwidth=\"403\" height=\"268\"\nthumb_width=\"120\" thumb_height=\"80\"\nzip_src_path=\"eJyt0t0KgjAch-FbkR2X-1Jp3kpIbCo60Bw680B27y0hChJs0yOH8H8OXn4z6HpZyTtIgxmMvbRf0PC-KqGq8rNsuX3hmBJKEEXswhIcEVIUhPEYnAJ70Qz25ApqrVUKoaKhGjTXKsy7FjpA73vB9gLYB8iMJaZSqNtvjqLUXDYDfCA4JRHa1sIXtF3H312PdYCHD_CWlLoeW_EdcflxxKYcoPVMPgD2AT6b8q3x55BctV1dNkbjpGTGPAF961ka\" ><\/a><\/p><p>曾经媒体用到陈红身上的，都是\u201c沉鱼落雁，闭月羞花\u201d\u201c第一古装美女\u201d等称号，在当年美女如云的时代，陈红能别出一格，自然是有独特的魅力。颜值绝对是首屈一指的。<\/p>\n\n<p><a class=\"image\"  href=\"bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d&index=3\"\nwidth=\"415\" height=\"243\"\nthumb_width=\"120\" thumb_height=\"70\"\nzip_src_path=\"eJyt0tEKgyAYhuFbCY-31GyNdSsRQ8uVUEvK1kF473PB2GCB0zpKgv85ePlm0PWiEneQBjMYe2G-oKF9xaGsiqNoqXnhE4lIhAhGKEa3EiecRee4BIfAXDSDOclArZRMIZQklIOiSoZF10IH6H3PLlsB7APk2hATZ_L6m6PkiopmgA8EpyRGdi18QfY6_u56rB08vIO3pFT12LLviMuPPTblAK1n8gGwD_DZlG-NP4fkqm3qYhmNk5Jr_QTF8V3a\" ><\/a><\/p><p>现在萧蔷还时常出现在大家视线中，年龄渐老、皮肤松弛，再加上在脸上随意动刀子，面部偶尔僵硬也是常有的事。其实自然老去反而美得更从容。现在一提到萧蔷不是整容就是装嫩。比起同是第一美人的陈红和李嘉欣口碑，这差距一目了然。说说你心中的第一美女吧。<\/p>\n<\/article>\n\n\n<footer><\/footer>\n","image_detail":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}],"uri":"large/pgc-image/15323203101548ecfc3e08e","height":374},{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101055013f08107"}],"uri":"large/pgc-image/15323203101055013f08107","height":334},{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203098961422dd29a5"}],"uri":"large/pgc-image/15323203098961422dd29a5","height":268},{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/large/pgc-image/1532320310040fd16eb274d"}],"uri":"large/pgc-image/1532320310040fd16eb274d","height":243}],"h5_extra":{"publish_time":"07-23 12:32","is_original":false,"str_item_id":"6581265889906131469","title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","media":{"master_media_info":"","praise_data":{},"description":"坐看娱乐圈，天天看大戏","pgc_custom_menu":"","can_be_praised":false,"name":"娱乐圈董事长","creator_id":68642701416,"avatar_url":"http://p8.pstatp.com/large/6edf0000dcd22150219a","v":false,"id":1591014026987534,"auth_info":"","show_pgc_component":true,"user_verified":false,"user_auth_info":""},"media_user_id":"68642701416","src_link":"","source":"娱乐圈董事长","publish_stamp":"1532320373","str_group_id":"6581265889906131469"},"group_source":2,"item_id":6581265889906131469,"is_wenda":0,"group_id":6581265889906131469,"gallery":[{"sub_abstract":"萧蔷颜值巅峰《小李飞刀》林诗音，李寻欢指腹为婚的表妹，亦是他青梅竹马的恋人。当初金庸先生到访台湾，在和萧蔷谈过话后，都连连称这是全台湾最美丽最有智慧的美人儿。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}],"uri":"large/pgc-image/15323203101548ecfc3e08e","height":374}},{"sub_abstract":"\u201c港姐中的港姐\u201d李嘉欣，是香港上流社会太太的\u201c公敌\u201d，她的美丽实在太具侵略性。李嘉欣她美得高贵冷傲，说句\u201c倾国倾城\u201d四个字也不为过。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101055013f08107"}],"uri":"large/pgc-image/15323203101055013f08107","height":334}},{"sub_abstract":"曾经媒体用到陈红身上的，都是\u201c沉鱼落雁，闭月羞花\u201d\u201c第一古装美女\u201d等称号，在当年美女如云的时代，陈红能别出一格，自然是有独特的魅力。颜值绝对是首屈一指的。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203098961422dd29a5"}],"uri":"large/pgc-image/15323203098961422dd29a5","height":268}},{"sub_abstract":"现在萧蔷还时常出现在大家视线中，年龄渐老、皮肤松弛，再加上在脸上随意动刀子，面部偶尔僵硬也是常有的事。其实自然老去反而美得更从容。现在一提到萧蔷不是整容就是装嫩。比起同是第一美人的陈红和李嘉欣口碑，这差距一目了然。说说你心中的第一美女吧。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/large/pgc-image/1532320310040fd16eb274d"}],"uri":"large/pgc-image/1532320310040fd16eb274d","height":243}}],"aggr_type":1}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * media_user_id : 68642701416
         * webp_image_detail : [{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp","width":587,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"}],"uri":"details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp","height":374},{"url":"http://p1.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp","width":629,"url_list":[{"url":"http://p1.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb3.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203101055013f08107.webp"}],"uri":"details/v0/w640/pgc-image/15323203101055013f08107.webp","height":334},{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp","width":403,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/15323203098961422dd29a5.webp"}],"uri":"details/v0/w640/pgc-image/15323203098961422dd29a5.webp","height":268},{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp","width":415,"url_list":[{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/1532320310040fd16eb274d.webp"}],"uri":"details/v0/w640/pgc-image/1532320310040fd16eb274d.webp","height":243}]
         * webp_thumb_image : [{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp","width":587,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"}],"uri":"thumb//pgc-image/15323203101548ecfc3e08e.webp","height":374},{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp","width":629,"url_list":[{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb3.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101055013f08107.webp"}],"uri":"thumb//pgc-image/15323203101055013f08107.webp","height":334},{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp","width":403,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203098961422dd29a5.webp"}],"uri":"thumb//pgc-image/15323203098961422dd29a5.webp","height":268},{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp","width":415,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d.webp"}],"uri":"thumb//pgc-image/1532320310040fd16eb274d.webp","height":243}]
         * thumb_image : [{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"}],"uri":"thumb/pgc-image/15323203101548ecfc3e08e","height":374},{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/thumb/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/thumb/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101055013f08107"}],"uri":"thumb/pgc-image/15323203101055013f08107","height":334},{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203098961422dd29a5"}],"uri":"thumb/pgc-image/15323203098961422dd29a5","height":268},{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/1532320310040fd16eb274d"}],"uri":"thumb/pgc-image/1532320310040fd16eb274d","height":243}]
         * content :


         <header><div class="tt-title">台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！</div></header>


         <article>

         <p><a class="image"  href="bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e&index=0"
         width="587" height="374"
         thumb_width="120" thumb_height="76"
         zip_src_path="eJyt0tEKgyAYhuFbCY-31KzRupWIYc6VoEvK1kF073PB2GBB0zpKgv85ePlG0LSiEneQBSPoW2G_QNK24lBX7CgUtS-ckIhEiGCEkzjl7MYIRykHh8BeyM6e5KA2RmcQahLqzlCjQ9Yo6AC978vzVgD7AMVkiYGX-vKb48oNFbKDDwSHU4zWtfAFrdfxd5dj7eDhHbw5pal7VX5HnH_ssSkHaDmTD4B9gM-mfGv8OSRXbVOXldE4KcU0PQG3ZWGK" ></a></p><p>萧蔷颜值巅峰《小李飞刀》林诗音，李寻欢指腹为婚的表妹，亦是他青梅竹马的恋人。当初金庸先生到访台湾，在和萧蔷谈过话后，都连连称这是全台湾最美丽最有智慧的美人儿。</p>

         <p><a class="image"  href="bytedance://large_image?url=http://p1.pstatp.com/large/pgc-image/15323203101055013f08107&index=1"
         width="629" height="334"
         thumb_width="120" thumb_height="64"
         zip_src_path="eJyt0t8KgjAYh-FbkR2X--ay0lsJiWlLB_4ZbuaBeO8tIQoSbNMjh_A9By-_ATWtyEWNYm9AXSvMF5WszTmWebYXFTMvEtKABkAJEAhDIPQOZwIntPPMRanMyQUVWssYY0l8qTTT0s-aCltA7_uUrgUiFyAZDdHzVF5_c9y4ZqJU-AG4Px5gWfNf0HIdd3c-1gZetIE3pdRFV6XfEacfW2zKAprP5AJELsBnU641_hySrbaqy8JorJRkHJ-_LFFa" ></a></p><p>“港姐中的港姐”李嘉欣，是香港上流社会太太的“公敌”，她的美丽实在太具侵略性。李嘉欣她美得高贵冷傲，说句“倾国倾城”四个字也不为过。</p>

         <p><a class="image"  href="bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5&index=2"
         width="403" height="268"
         thumb_width="120" thumb_height="80"
         zip_src_path="eJyt0t0KgjAch-FbkR2X-1Jp3kpIbCo60Bw680B27y0hChJs0yOH8H8OXn4z6HpZyTtIgxmMvbRf0PC-KqGq8rNsuX3hmBJKEEXswhIcEVIUhPEYnAJ70Qz25ApqrVUKoaKhGjTXKsy7FjpA73vB9gLYB8iMJaZSqNtvjqLUXDYDfCA4JRHa1sIXtF3H312PdYCHD_CWlLoeW_EdcflxxKYcoPVMPgD2AT6b8q3x55BctV1dNkbjpGTGPAF961ka" ></a></p><p>曾经媒体用到陈红身上的，都是“沉鱼落雁，闭月羞花”“第一古装美女”等称号，在当年美女如云的时代，陈红能别出一格，自然是有独特的魅力。颜值绝对是首屈一指的。</p>

         <p><a class="image"  href="bytedance://large_image?url=http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d&index=3"
         width="415" height="243"
         thumb_width="120" thumb_height="70"
         zip_src_path="eJyt0tEKgyAYhuFbCY-31GyNdSsRQ8uVUEvK1kF473PB2GCB0zpKgv85ePlm0PWiEneQBjMYe2G-oKF9xaGsiqNoqXnhE4lIhAhGKEa3EiecRee4BIfAXDSDOclArZRMIZQklIOiSoZF10IH6H3PLlsB7APk2hATZ_L6m6PkiopmgA8EpyRGdi18QfY6_u56rB08vIO3pFT12LLviMuPPTblAK1n8gGwD_DZlG-NP4fkqm3qYhmNk5Jr_QTF8V3a" ></a></p><p>现在萧蔷还时常出现在大家视线中，年龄渐老、皮肤松弛，再加上在脸上随意动刀子，面部偶尔僵硬也是常有的事。其实自然老去反而美得更从容。现在一提到萧蔷不是整容就是装嫩。比起同是第一美人的陈红和李嘉欣口碑，这差距一目了然。说说你心中的第一美女吧。</p>
         </article>


         <footer></footer>

         * image_detail : [{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}],"uri":"large/pgc-image/15323203101548ecfc3e08e","height":374},{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101055013f08107"}],"uri":"large/pgc-image/15323203101055013f08107","height":334},{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203098961422dd29a5"}],"uri":"large/pgc-image/15323203098961422dd29a5","height":268},{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/large/pgc-image/1532320310040fd16eb274d"}],"uri":"large/pgc-image/1532320310040fd16eb274d","height":243}]
         * h5_extra : {"publish_time":"07-23 12:32","is_original":false,"str_item_id":"6581265889906131469","title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","media":{"master_media_info":"","praise_data":{},"description":"坐看娱乐圈，天天看大戏","pgc_custom_menu":"","can_be_praised":false,"name":"娱乐圈董事长","creator_id":68642701416,"avatar_url":"http://p8.pstatp.com/large/6edf0000dcd22150219a","v":false,"id":1591014026987534,"auth_info":"","show_pgc_component":true,"user_verified":false,"user_auth_info":""},"media_user_id":"68642701416","src_link":"","source":"娱乐圈董事长","publish_stamp":"1532320373","str_group_id":"6581265889906131469"}
         * group_source : 2
         * item_id : 6581265889906131469
         * is_wenda : 0
         * group_id : 6581265889906131469
         * gallery : [{"sub_abstract":"萧蔷颜值巅峰《小李飞刀》林诗音，李寻欢指腹为婚的表妹，亦是他青梅竹马的恋人。当初金庸先生到访台湾，在和萧蔷谈过话后，都连连称这是全台湾最美丽最有智慧的美人儿。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}],"uri":"large/pgc-image/15323203101548ecfc3e08e","height":374}},{"sub_abstract":"\u201c港姐中的港姐\u201d李嘉欣，是香港上流社会太太的\u201c公敌\u201d，她的美丽实在太具侵略性。李嘉欣她美得高贵冷傲，说句\u201c倾国倾城\u201d四个字也不为过。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107","width":629,"url_list":[{"url":"http://p1.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb3.pstatp.com/large/pgc-image/15323203101055013f08107"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101055013f08107"}],"uri":"large/pgc-image/15323203101055013f08107","height":334}},{"sub_abstract":"曾经媒体用到陈红身上的，都是\u201c沉鱼落雁，闭月羞花\u201d\u201c第一古装美女\u201d等称号，在当年美女如云的时代，陈红能别出一格，自然是有独特的魅力。颜值绝对是首屈一指的。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5","width":403,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203098961422dd29a5"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203098961422dd29a5"}],"uri":"large/pgc-image/15323203098961422dd29a5","height":268}},{"sub_abstract":"现在萧蔷还时常出现在大家视线中，年龄渐老、皮肤松弛，再加上在脸上随意动刀子，面部偶尔僵硬也是常有的事。其实自然老去反而美得更从容。现在一提到萧蔷不是整容就是装嫩。比起同是第一美人的陈红和李嘉欣口碑，这差距一目了然。说说你心中的第一美女吧。","sub_title":"台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！","sub_image":{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d","width":415,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb9.pstatp.com/large/pgc-image/1532320310040fd16eb274d"},{"url":"http://pb1.pstatp.com/large/pgc-image/1532320310040fd16eb274d"}],"uri":"large/pgc-image/1532320310040fd16eb274d","height":243}}]
         * aggr_type : 1
         */

        private long media_user_id;
        private String content;
        private H5ExtraBean h5_extra;
        private int group_source;
        private long item_id;
        private int is_wenda;
        private long group_id;
        private int aggr_type;
        private List<WebpImageDetailBean> webp_image_detail;
        private List<WebpThumbImageBean> webp_thumb_image;
        private List<ThumbImageBean> thumb_image;
        private List<ImageDetailBean> image_detail;
        private List<GalleryBean> gallery;

        public long getMedia_user_id() {
            return media_user_id;
        }

        public void setMedia_user_id(long media_user_id) {
            this.media_user_id = media_user_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public H5ExtraBean getH5_extra() {
            return h5_extra;
        }

        public void setH5_extra(H5ExtraBean h5_extra) {
            this.h5_extra = h5_extra;
        }

        public int getGroup_source() {
            return group_source;
        }

        public void setGroup_source(int group_source) {
            this.group_source = group_source;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public int getIs_wenda() {
            return is_wenda;
        }

        public void setIs_wenda(int is_wenda) {
            this.is_wenda = is_wenda;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public int getAggr_type() {
            return aggr_type;
        }

        public void setAggr_type(int aggr_type) {
            this.aggr_type = aggr_type;
        }

        public List<WebpImageDetailBean> getWebp_image_detail() {
            return webp_image_detail;
        }

        public void setWebp_image_detail(List<WebpImageDetailBean> webp_image_detail) {
            this.webp_image_detail = webp_image_detail;
        }

        public List<WebpThumbImageBean> getWebp_thumb_image() {
            return webp_thumb_image;
        }

        public void setWebp_thumb_image(List<WebpThumbImageBean> webp_thumb_image) {
            this.webp_thumb_image = webp_thumb_image;
        }

        public List<ThumbImageBean> getThumb_image() {
            return thumb_image;
        }

        public void setThumb_image(List<ThumbImageBean> thumb_image) {
            this.thumb_image = thumb_image;
        }

        public List<ImageDetailBean> getImage_detail() {
            return image_detail;
        }

        public void setImage_detail(List<ImageDetailBean> image_detail) {
            this.image_detail = image_detail;
        }

        public List<GalleryBean> getGallery() {
            return gallery;
        }

        public void setGallery(List<GalleryBean> gallery) {
            this.gallery = gallery;
        }

        public static class H5ExtraBean implements Serializable {
            /**
             * publish_time : 07-23 12:32
             * is_original : false
             * str_item_id : 6581265889906131469
             * title : 台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！
             * media : {"master_media_info":"","praise_data":{},"description":"坐看娱乐圈，天天看大戏","pgc_custom_menu":"","can_be_praised":false,"name":"娱乐圈董事长","creator_id":68642701416,"avatar_url":"http://p8.pstatp.com/large/6edf0000dcd22150219a","v":false,"id":1591014026987534,"auth_info":"","show_pgc_component":true,"user_verified":false,"user_auth_info":""}
             * media_user_id : 68642701416
             * src_link :
             * source : 娱乐圈董事长
             * publish_stamp : 1532320373
             * str_group_id : 6581265889906131469
             */

            private String publish_time;
            private boolean is_original;
            private String str_item_id;
            private String title;
            private MediaBean media;
            private String media_user_id;
            private String src_link;
            private String source;
            private String publish_stamp;
            private String str_group_id;

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public boolean isIs_original() {
                return is_original;
            }

            public void setIs_original(boolean is_original) {
                this.is_original = is_original;
            }

            public String getStr_item_id() {
                return str_item_id;
            }

            public void setStr_item_id(String str_item_id) {
                this.str_item_id = str_item_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public MediaBean getMedia() {
                return media;
            }

            public void setMedia(MediaBean media) {
                this.media = media;
            }

            public String getMedia_user_id() {
                return media_user_id;
            }

            public void setMedia_user_id(String media_user_id) {
                this.media_user_id = media_user_id;
            }

            public String getSrc_link() {
                return src_link;
            }

            public void setSrc_link(String src_link) {
                this.src_link = src_link;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getPublish_stamp() {
                return publish_stamp;
            }

            public void setPublish_stamp(String publish_stamp) {
                this.publish_stamp = publish_stamp;
            }

            public String getStr_group_id() {
                return str_group_id;
            }

            public void setStr_group_id(String str_group_id) {
                this.str_group_id = str_group_id;
            }

            public static class MediaBean implements Serializable {
                /**
                 * master_media_info :
                 * praise_data : {}
                 * description : 坐看娱乐圈，天天看大戏
                 * pgc_custom_menu :
                 * can_be_praised : false
                 * name : 娱乐圈董事长
                 * creator_id : 68642701416
                 * avatar_url : http://p8.pstatp.com/large/6edf0000dcd22150219a
                 * v : false
                 * id : 1591014026987534
                 * auth_info :
                 * show_pgc_component : true
                 * user_verified : false
                 * user_auth_info :
                 */

                private String master_media_info;
                private PraiseDataBean praise_data;
                private String description;
                private String pgc_custom_menu;
                private boolean can_be_praised;
                private String name;
                private long creator_id;
                private String avatar_url;
                private boolean v;
                private long id;
                private String auth_info;
                private boolean show_pgc_component;
                private boolean user_verified;
                private String user_auth_info;

                public String getMaster_media_info() {
                    return master_media_info;
                }

                public void setMaster_media_info(String master_media_info) {
                    this.master_media_info = master_media_info;
                }

                public PraiseDataBean getPraise_data() {
                    return praise_data;
                }

                public void setPraise_data(PraiseDataBean praise_data) {
                    this.praise_data = praise_data;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getPgc_custom_menu() {
                    return pgc_custom_menu;
                }

                public void setPgc_custom_menu(String pgc_custom_menu) {
                    this.pgc_custom_menu = pgc_custom_menu;
                }

                public boolean isCan_be_praised() {
                    return can_be_praised;
                }

                public void setCan_be_praised(boolean can_be_praised) {
                    this.can_be_praised = can_be_praised;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public long getCreator_id() {
                    return creator_id;
                }

                public void setCreator_id(long creator_id) {
                    this.creator_id = creator_id;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public boolean isV() {
                    return v;
                }

                public void setV(boolean v) {
                    this.v = v;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getAuth_info() {
                    return auth_info;
                }

                public void setAuth_info(String auth_info) {
                    this.auth_info = auth_info;
                }

                public boolean isShow_pgc_component() {
                    return show_pgc_component;
                }

                public void setShow_pgc_component(boolean show_pgc_component) {
                    this.show_pgc_component = show_pgc_component;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public String getUser_auth_info() {
                    return user_auth_info;
                }

                public void setUser_auth_info(String user_auth_info) {
                    this.user_auth_info = user_auth_info;
                }

                public static class PraiseDataBean implements Serializable {
                }
            }
        }

        public static class WebpImageDetailBean implements Serializable {
            /**
             * url : http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp
             * width : 587
             * url_list : [{"url":"http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp"}]
             * uri : details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp
             * height : 374
             */

            private String url;
            private int width;
            private String uri;
            private int height;
            private List<UrlListBean> url_list;

            public String getUrl() {
                return url;
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

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<UrlListBean> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBean> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBean implements Serializable {
                /**
                 * url : http://p3.pstatp.com/details/v0/w640/pgc-image/15323203101548ecfc3e08e.webp
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

        public static class WebpThumbImageBean implements Serializable {
            /**
             * url : http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp
             * width : 587
             * url_list : [{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp"}]
             * uri : thumb//pgc-image/15323203101548ecfc3e08e.webp
             * height : 374
             */

            private String url;
            private int width;
            private String uri;
            private int height;
            private List<UrlListBeanX> url_list;

            public String getUrl() {
                return url;
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

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<UrlListBeanX> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBeanX> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBeanX implements Serializable {
                /**
                 * url : http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e.webp
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

        public static class ThumbImageBean implements Serializable {
            /**
             * url : http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e
             * width : 587
             * url_list : [{"url":"http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e"}]
             * uri : thumb/pgc-image/15323203101548ecfc3e08e
             * height : 374
             */

            private String url;
            private int width;
            private String uri;
            private int height;
            private List<UrlListBeanXX> url_list;

            public String getUrl() {
                return url;
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

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<UrlListBeanXX> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBeanXX> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBeanXX implements Serializable {
                /**
                 * url : http://p3.pstatp.com/thumb/pgc-image/15323203101548ecfc3e08e
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

        public static class ImageDetailBean implements Serializable {
            /**
             * url : http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e
             * width : 587
             * url_list : [{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}]
             * uri : large/pgc-image/15323203101548ecfc3e08e
             * height : 374
             */

            private String url;
            private int width;
            private String uri;
            private int height;
            private List<UrlListBeanXXX> url_list;

            public String getUrl() {
                return url;
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

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<UrlListBeanXXX> getUrl_list() {
                return url_list;
            }

            public void setUrl_list(List<UrlListBeanXXX> url_list) {
                this.url_list = url_list;
            }

            public static class UrlListBeanXXX implements Serializable {
                /**
                 * url : http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e
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

        public static class GalleryBean implements Serializable {
            /**
             * sub_abstract : 萧蔷颜值巅峰《小李飞刀》林诗音，李寻欢指腹为婚的表妹，亦是他青梅竹马的恋人。当初金庸先生到访台湾，在和萧蔷谈过话后，都连连称这是全台湾最美丽最有智慧的美人儿。
             * sub_title : 台湾第一美女，香港第一美女，大陆第一美女，差距一目了然！
             * sub_image : {"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e","width":587,"url_list":[{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}],"uri":"large/pgc-image/15323203101548ecfc3e08e","height":374}
             */

            private String sub_abstract;
            private String sub_title;
            private SubImageBean sub_image;

            public String getSub_abstract() {
                return sub_abstract;
            }

            public void setSub_abstract(String sub_abstract) {
                this.sub_abstract = sub_abstract;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public SubImageBean getSub_image() {
                return sub_image;
            }

            public void setSub_image(SubImageBean sub_image) {
                this.sub_image = sub_image;
            }

            public static class SubImageBean implements Serializable {
                /**
                 * url : http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e
                 * width : 587
                 * url_list : [{"url":"http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb9.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"},{"url":"http://pb1.pstatp.com/large/pgc-image/15323203101548ecfc3e08e"}]
                 * uri : large/pgc-image/15323203101548ecfc3e08e
                 * height : 374
                 */

                private String url;
                private int width;
                private String uri;
                private int height;
                private List<UrlListBeanXXXX> url_list;

                public String getUrl() {
                    return url;
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

                public String getUri() {
                    return uri;
                }

                public void setUri(String uri) {
                    this.uri = uri;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public List<UrlListBeanXXXX> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBeanXXXX> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBeanXXXX implements Serializable {
                    /**
                     * url : http://p3.pstatp.com/large/pgc-image/15323203101548ecfc3e08e
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
        }
    }
}
