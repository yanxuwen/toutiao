package com.yanxuwen.lib_common.Bean;

/**
 * 作者：严旭文 on 2016/5/31 15:11
 * 邮箱：420255048@qq.com
 * 设置是一些配置
 */
public class Config {
    public static Config ins;
    public static Config getInstance() {
        if (ins == null) {
            ins = new Config();
        }
        return ins;
    }
    /**
     * 0.开发
     * 1.测试
     * 2.正式
     */
    public int Env=1;
    public  String BASE_URL="";
    //防止多个域名
    public  String BASE_URL2="";
//    public  String BASE_URL3="";
//    public  String BASE_URL4="";
//    public  String BASE_URL5="";
    public Config() {
        switch(Env){
            case 0:
                BASE_URL= "http://lf.snssdk.com/";
                BASE_URL2= "http://lf.snssdk.com/";
                break;
            case 1:
                BASE_URL= "https://is.snssdk.com/";
                BASE_URL2= "https://is.snssdk.com/";
                break;
            case 2:
                BASE_URL= "http://bc.bbxpc.cn:12581/";
                BASE_URL2= "http://bc.bbxpc.cn:12581/";
                break;
        }
    }
    /**加载框几毫秒内不能弹出来*/
    public final int LOADDIALOGTIME=500;
    /**fragment跳转时间*/
    public  final int fragmentJumpTime=1000;
    /**fragment结束时间*/
    public  final int fragmentFinishTime=800;


}
