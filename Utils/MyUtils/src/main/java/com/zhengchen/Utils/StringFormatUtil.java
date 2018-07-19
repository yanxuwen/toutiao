package com.zhengchen.Utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

/**
 * Created by yanxuwen on 2017/12/5.
 */

public class StringFormatUtil {
    private SpannableStringBuilder spBuilder;
    private String wholeStr, highlightStr;
    private Context mContext;
    private int color;
    private int start = 0, end = 0;


    /**
     *
     * @param context
     * @param wholeStr 全部文字
     * @param highlightStr 改变颜色的文字
     * @param color 颜色
     */
    public StringFormatUtil(Context context,String wholeStr,String highlightStr,int color){
        this.mContext=context;
        this.wholeStr=wholeStr;
        this.highlightStr=highlightStr;
        this.color=color;


    }


    public StringFormatUtil fillColor(){
        if(!TextUtils.isEmpty(wholeStr)&&!TextUtils.isEmpty(highlightStr)){
            if(wholeStr.contains(highlightStr)){
                /*
                 *  返回highlightStr字符串wholeStr字符串中第一次出现处的索引。
                 */
                start=wholeStr.indexOf(highlightStr);
                end=start+highlightStr.length();
            }else{
                return null;
            }
        }else{
            return null;
        }
        spBuilder=new SpannableStringBuilder(wholeStr);
        color=mContext.getResources().getColor(color);
        CharacterStyle charaStyle=new ForegroundColorSpan(color);
        spBuilder.setSpan(charaStyle, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return this;
    }


    public SpannableStringBuilder getResult(){
        if (spBuilder != null) {
            return spBuilder;
        }
        return null;
    }
}
