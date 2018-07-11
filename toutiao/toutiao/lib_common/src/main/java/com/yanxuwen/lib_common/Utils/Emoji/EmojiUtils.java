package com.yanxuwen.lib_common.Utils.Emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanxuwen on 2018/5/30.
 */

public class EmojiUtils {
    public static SpannableString getEmotionContent(final Context context, final TextView tv, String source) throws PinyinException {
        SpannableString spannableString = new SpannableString(source);
        Resources res = context.getResources();

        String regexEmotion = "\\[([\u4e00-\u9fa5\\w])+\\]" ;
        Pattern patternEmotion = Pattern. compile(regexEmotion);
        Matcher matcherEmotion = patternEmotion.matcher(spannableString);

        while (matcherEmotion.find()) {
            // 获取匹配到的具体字符
            String key = matcherEmotion.group();
            String pinyinName = "d_" + PinyinHelper.convertToPinyinString(key, "", PinyinFormat.WITHOUT_TONE).replace("[", "").replace("]", "");

            // 匹配字符串的开始位置
            int start = matcherEmotion.start();
            // 利用表情名字获取到对应的图片
            Integer imgRes =context.getResources().getIdentifier(pinyinName , "mipmap", context.getPackageName());
//            Integer imgRes = EmotionUtils. getImgByName(key);
            if (imgRes != null) {
                try{
                // 压缩表情图片
                int size = ( int) tv.getTextSize()+25;
                Bitmap bitmap = BitmapFactory.decodeResource(res, imgRes);
                Bitmap scaleBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);

                ImageSpan span = new ImageSpan(context, scaleBitmap);
                spannableString.setSpan(span, start, start + key.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE );
                }catch (Exception e){}
            }
        }
        return spannableString;
    }
}
