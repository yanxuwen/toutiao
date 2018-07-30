package com.yanxuwen.lib_common.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yanxuwen on 2017/6/14.
 */

public class TimeUtils {
    /**
     * 转换指定格式，如yyyy-MM-dd HH:mm,单位毫秒
     * 注意：HH为大写的话，则是24小时，hh为小写，则12小时
     */
    public static String getStrTime(String cc_time,String geshi) {
        String re_StrTime = null;
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat(geshi);
        long lcc_time = Long.valueOf(cc_time);
        try {
            re_StrTime = sdf.format(new Date(lcc_time));
        }catch (Exception e){
            re_StrTime = sdf.format(new Date(lcc_time*1000));

        }
        return re_StrTime;
    }

    /**
     * 时长转换为字符串，比如视频时长。
     */
    public static String millisToString(String cc_time){
        double time=0.0;
        try{ time=Double.valueOf(cc_time);
        }catch (Exception e) {}
        String geshi="";
        if(time>=(1000*60*60)){
            geshi="HH:mm:ss";
        }else{
            geshi="mm:ss";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(geshi);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return formatter.format(time);
    }
    /**
     * 时长转换为字符串，比如视频时长。
     */
    public static String millisToString(double cc_time){
        String geshi="";
        if(cc_time>=(1000*60*60)){
            geshi="HH:mm:ss";
        }else{
            geshi="mm:ss";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(geshi);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        return formatter.format(cc_time);
    }
    public static String millisToString2(String cc_time){
        String geshi="";
        geshi="mm:ss";
        double c_time=0;
        try{c_time= Double.valueOf(cc_time);}catch (Exception e){}
        SimpleDateFormat formatter = new SimpleDateFormat(geshi);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String time=formatter.format(c_time);
        time=time.replaceAll(":","′");
        time=time+"″";
        return time;
    }

        /**
         * 获取时间相差，如，几分钟前，几小时前，限制12小时，超过则显示月份，不显示年
         */
    public static String getTimeDifference(String time){
        if(time==null)return "";
        Date currentDate = new Date();
        long lcc_time = Long.valueOf(time);
        Date date = new Date(lcc_time);

        long diffTime=currentDate.getTime()-date.getTime();
        if(diffTime<=24*60*60*1000){//几小时前
            if(diffTime<=24*60*60*1000&&diffTime>=1*60*60*1000){
                long diff_time = diffTime/(1*60*60*1000);
                if(diff_time<0){
                    diff_time=0;
                }
                return diff_time+"小时前";
            }
            else if(diffTime<1*60*60*1000&&diffTime>=1*60*1000){
                long diff_time = diffTime/(1*60*1000);
                if(diff_time<0){
                    diff_time=0;
                }
                return diff_time+"分钟前";
            }
            else{
                long diff_time = diffTime/(1000);
                if(diff_time<0){
                    diff_time=0;
                }
                return diff_time+"秒前";
            }
        }
        else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
//
//            Calendar current = Calendar.getInstance();
//            current.setTimeInMillis(System.currentTimeMillis());
//            if(diffTime<=7*24*60*60*1000){
//                return diffTime/(24*60*60*1000)+"天前";
//            }else{
                //去掉年份
                return getStrTime(time+"","MM-dd HH:mm");
//            }
        }
    }
}
