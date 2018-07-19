package com.zhengchen.weight.FlowLayout;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by yanxuwen on 2017/8/29.
 */

public class MyFlowLayout extends FlowLayout {
    public MyFlowLayout(Context context) {
        super(context);
    }
    public MyFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public MyFlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    protected void align() {
//        int childCount = this.getChildCount();
//        if (0 == childCount) {
//            //no need to sort if flowlayout has no child view
//            return;
//        }
//        int count = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            count++;
//        }
//        View[] childs = new View[count];
//        int[] spaces = new int[count+1];
//        int n = 0;
//        for (int i = 0; i < childCount; i++) {
//            View v = getChildAt(i);
//            if (v instanceof BlankView) {
//                //BlankView is just to make childs look in alignment, we should ignore them when we relayout
//                continue;
//            }
//            childs[n] = v;
//            LayoutParams childLp = v.getLayoutParams();
//            int childWidth = v.getMeasuredWidth();
//            if (childLp instanceof MarginLayoutParams) {
//                MarginLayoutParams mlp = (MarginLayoutParams) childLp ;
//                spaces[n] = mlp.leftMargin + childWidth + mlp.rightMargin;
//            } else {
//                spaces[n] = childWidth;
//            }
//            n++;
//        }
//        spaces[count] = spaces[count-1];
//        int lineTotal = 0;
//        int start = 0;
//        this.removeAllViews();
//        for (int i = 0; i < count+1; i++) {
//            if (lineTotal + spaces[i] > usefulWidth) {
//                int blankWidth = usefulWidth - lineTotal;
//                int end = i - 1;
//                int blankCount = end - start;
//                if (blankCount >= 0) {
//                    if (blankCount > 0) {
//                        int eachBlankWidth = blankWidth / blankCount;
//                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//                        lp.width=eachBlankWidth;
//                        lp.height=1;
//                        for (int j = start; j < end; j++) {
//                            this.addView(childs[j]);
//                            BlankView mBlankView = new BlankView(mContext);
//                            this.addView(mBlankView, lp);
//                        }
//                    }
//                    this.addView(childs[end]);
//                    start = i;
//                    i --;
//                    lineTotal = 0;
//                } else {
//                    if(i>=childs.length)return;
//                    this.addView(childs[i]);
//                    start = i + 1;
//                    lineTotal = 0;
//                }
//            } else {
//                lineTotal += spaces[i];
//            }
//        }
////        for (int i = start; i < count; i++) {
////            this.addView(childs[i]);
////        }
//    }
}
