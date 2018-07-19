package com.zhengchen.weight.guideview;

/**
 * Created by linlongxin on 2016/7/22.
 */

public interface Direction {

    int LEFT = 10; //左边，默认上边对齐
    int LEFT_ABOVE = 11;  //左上方
    int LEFT_BOTTOM = 12; //左下方
    int LEFT_ALIGN_BOTTOM = 13; //左方并且下边对齐

    int RIGHT = 20; //右边
    int RIGHT_ABOVE = 21; //右上方
    int RIGHT_BOTTOM = 22; //右下方
    int RIGHT_ALIGN_BOTTOM = 23; //右方并且下边对齐

    int ABOVE = 30; //正上方
    int ABOVE_ALIGN_LEFT = 31; //上方并且左对齐
    int ABOVE_ALIGN_RIGHT = 32; //上方并且右对齐

    int BOTTOM = 40; //正下方
    int BOTTOM_ALIGN_LEFT = 41; //下方并且左对齐
    int BOTTOM_ALIGN_RIGHT = 42; //下方并且右对齐
}
