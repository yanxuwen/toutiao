package com.yanxuwen.lib_common.Utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yanxuwen.retrofit.JsonSerializer.DoubleDefault0Adapter;
import com.yanxuwen.retrofit.JsonSerializer.FloatDefault0Adapter;
import com.yanxuwen.retrofit.JsonSerializer.IntegerDefault0Adapter;
import com.yanxuwen.retrofit.JsonSerializer.LongDefault0Adapter;

import java.lang.reflect.Type;

/**
 * Created by yanxw on 2018/8/31.
 */

public class MyGsonUtils {
    /**
     * 转换为json
     */
    public static Object fromJson(String str, Type type, final String... filter){
        //处理gson字段为空，跟类型不匹配问题
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(Double.class, new DoubleDefault0Adapter())
                .registerTypeAdapter(double.class, new DoubleDefault0Adapter())
                .registerTypeAdapter(Long.class, new LongDefault0Adapter())
                .registerTypeAdapter(long.class, new LongDefault0Adapter())
                .registerTypeAdapter(Float.class, new FloatDefault0Adapter())
                .registerTypeAdapter(float.class, new FloatDefault0Adapter())
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        for(int i=0;i<filter.length;i++){
                            if(f.getName().equals(filter[i]))return true;
                        }
                        return false;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
        return  gson.fromJson(str, type);
    }
}
