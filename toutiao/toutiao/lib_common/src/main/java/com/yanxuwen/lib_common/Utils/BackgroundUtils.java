package com.yanxuwen.lib_common.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.yanxuwen.lib_common.R;
import com.yanxuwen.myutils.widget.StatusBar.StatusBar;

/**
 * Created by YANXUWEN on 2016/3/18.
 */
public class BackgroundUtils {
    public static Bitmap createBackground(Context context,int corlor){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width=metrics.widthPixels;
        int height=metrics.heightPixels;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(context.getResources().getColor(R.color.common_background));
        Paint p=new Paint();
        p.setColor(context.getResources().getColor(corlor));

        canvas.drawRect(0,0,width,getTitileHeight(context)+ StatusBar.getStatusHeight(context),p);
        return bitmap;
    }
    /**
     * 由于执行了StatusBar.setTranslucentStatus(this, isChangeText);
     * 导致了frament没有状态栏，所以要获取状态栏，并且添加
     */
    public static View getStatusView(Activity context,int corlor){
        LayoutInflater inflater = LayoutInflater.from(context);
        RelativeLayout relativeLayout=(RelativeLayout)inflater.inflate(R.layout.layout_status, null);
        View v=(View)relativeLayout.findViewById(R.id.view_status);
        relativeLayout.setBackgroundColor(context.getResources().getColor(corlor));
        RelativeLayout.LayoutParams linearParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
        linearParams.height = StatusBar.getStatusHeight(context);
        DisplayMetrics metrics =context.getResources().getDisplayMetrics();
        linearParams.width = metrics.widthPixels;
        v.setLayoutParams(linearParams);
        return  relativeLayout;
    }
    /**
     * 暂时不准确，待调查
     */
    public static int getTitileHeight(Context context){
        int height=0;
        try {
            LayoutInflater inflater = LayoutInflater.from(context);
            View title_view = inflater.inflate(R.layout.title_layout, null);
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            title_view.measure(w, h);
            int width =title_view.getMeasuredWidth();
            height =title_view.getMeasuredHeight();
        }catch (Exception e){}

        return height;
    }
}
