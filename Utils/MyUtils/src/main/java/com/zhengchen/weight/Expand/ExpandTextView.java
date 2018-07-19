package com.zhengchen.weight.Expand;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;


import com.zhengchen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 缩放展开的动画简单Textview
 *
 * Created by igeek on 2016/9/1.
 * @author igeek2014@hotmail.com
 */
public class ExpandTextView extends View implements View.OnClickListener {

    //行文本记录集
    private List<LineText> lineTexts = new ArrayList<LineText>();
    //最大显示文本行数
    private int maxLines;
    //目标文本行
    private int targetLine;
    //收缩收起时候的提示图标
    private Drawable expandDrawable;
    //展开时候的提示图标
    private Drawable shrinkDrawable;
    //提示图标的宽度
    private int drawableWidth;
    //提示图标的高度
    private int drawableHeight;
    //最大显示文本行对应的本视图高度
    private int maxLinesHeight;
    //展开时候的视图高度
    private int expandHeight;
    //当前视图的高度
    private int viewHeight;
    //收缩行结尾提示语文本宽度
    private float ellipsizWidth;
    //收缩行结尾提示语文本绘制水平起点
    private float ellipsizStartX;

    //文本字体大小
    private int textSize;
    //文本颜色
    private int textColor;
    //当前文本
    private String text;
    private String ellipsizText = "...";
    //收缩行文本
    private String shrinkLineText;
    //动画显示时间
    private int animDuration;
    //是否能够显示 ellipsizText 【需要收缩行当前文本的宽度】
    private boolean showEllipsizText = false;
    private boolean showTipDrawalbe = false;
    private boolean needMeasure = true;

    private StaticLayout layout;
    private TextPaint textPaint;


    public ExpandTextView(Context context) {
        this(context, null);
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ExpandTextView);

        maxLines = ta.getInt(R.styleable.ExpandTextView_expandmaxLines, -1);
        animDuration = ta.getInt(R.styleable.ExpandTextView_expandanimDuration, 300);
        textSize = ta.getDimensionPixelSize(R.styleable.ExpandTextView_expandtextSize, 14);
        textColor = ta.getColor(R.styleable.ExpandTextView_expandtextColor, 14);
        drawableWidth = ta.getDimensionPixelSize(R.styleable.ExpandTextView_expanddrawableWidth, 14);
        drawableHeight = ta.getDimensionPixelSize(R.styleable.ExpandTextView_expanddrawableHeight, 14);
        expandDrawable = ta.getDrawable(R.styleable.ExpandTextView_expandDrawable);
        shrinkDrawable = ta.getDrawable(R.styleable.ExpandTextView_expandshrinkDrawable);

        ta.recycle();

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        textPaint.density = context.getResources().getDisplayMetrics().density;
        textPaint.setColor(textColor);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize(textSize);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);

        if (needMeasure && (!TextUtils.isEmpty(text))) {
            needMeasure = false;
            measureHeightState(text, width);
            startDrawAnim(0, viewHeight);
        }else{
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(viewHeight, MeasureSpec.EXACTLY);
            setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        }

    }

    public void updateText(String text) {
        if (!TextUtils.isEmpty(text)) {
            viewHeight=0;
            maxLinesHeight=0;
            expandHeight=0;
            this.text = text;
            needMeasure = true;
            requestLayout();
        }
    }

    private synchronized void measureHeightState(String text, int width) {

        layout = new StaticLayout(text, textPaint, width - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0f, true);
        final int lineCount = layout.getLineCount();
        maxLines = (maxLines == -1 || maxLines > lineCount) ? lineCount : maxLines;

        int text_Height = 0;

        List<LineText> tempLines = new ArrayList<LineText>();

        for (int index = 0; index < lineCount; index++) {
            int start = layout.getLineStart(index);
            int end = layout.getLineEnd(index);
            LineText lineText = new LineText();
            lineText.setStartIndex(start);
            lineText.setEndIndex(end - 1);
            lineText.setText(text.substring(start, end));
            lineText.setTopOffset(layout.getLineTop(index));
            lineText.setBottomOffset(layout.getLineBottom(index));
            lineText.setBaseLine(layout.getLineBaseline(index)+getPaddingTop());
            lineText.setWidth(layout.getLineWidth(index));
            lineText.setHeight(lineText.getBottomOffset() - lineText.getTopOffset());
            tempLines.add(lineText);

            if (index < maxLines) {
                maxLinesHeight += lineText.getHeight();
            }

            text_Height += lineText.getHeight();
        }

        maxLinesHeight+=getPaddingTop()+getPaddingBottom();
        expandHeight+=getPaddingTop()+getPaddingBottom();

        ellipsizWidth = textPaint.measureText(ellipsizText);

        if (maxLines < lineCount) {

            showTipDrawalbe = expandDrawable != null && shrinkDrawable != null;

            float textWidth = tempLines.get(maxLines - 1).getWidth();
            float contentWidth = width - getPaddingLeft() - getPaddingRight();
            float toMarginRight = ellipsizWidth + (showTipDrawalbe ? drawableWidth : 0);

            String ellipsizLineText = tempLines.get(maxLines - 1).getText();

            if (contentWidth - textWidth < toMarginRight) {
                showEllipsizText = true;
                String subString = null;
                for (int index = ellipsizLineText.length() - 1; index > 0; index--) {
                    subString = ellipsizLineText.substring(0, index);
                    float subStrWidth = textPaint.measureText(subString);
                    if (contentWidth - subStrWidth >= toMarginRight) {
                        ellipsizStartX = subStrWidth + getPaddingLeft();
                        shrinkLineText = subString;
                        break;
                    }
                }
            } else {
                shrinkLineText = ellipsizLineText;
                showEllipsizText = false;
            }
        } else {
            showTipDrawalbe = false;
            showEllipsizText = false;
        }

        expandHeight += text_Height + ((expandDrawable != null && showTipDrawalbe) ? drawableHeight : 0);

        viewHeight = maxLines == lineCount ? expandHeight : maxLinesHeight;

        targetLine = maxLines;

        lineTexts = tempLines;


        if (viewHeight < expandHeight) {
            setClickable(true);
            setOnClickListener(this);
        } else {
            setClickable(false);
        }

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (lineTexts.size() == 0) return;

        for (int index = 0; index < targetLine; index++) {

            LineText lineText = lineTexts.get(index);

            if (index < targetLine - 1) {
                canvas.drawText(lineText.getText(), getPaddingLeft(), lineText.getBaseLine(), textPaint);
            } else {
                if (targetLine == maxLines && maxLines < lineTexts.size()) {
                    //收缩转态
                    if (showEllipsizText)
                        canvas.drawText(ellipsizText, ellipsizStartX, lineText.getBaseLine(), textPaint);
                    canvas.drawText(shrinkLineText, getPaddingLeft(), lineText.getBaseLine(), textPaint);
                    if (showTipDrawalbe){
                        int left=getWidth() - drawableWidth - getPaddingRight();
                        int top=getHeight() - drawableHeight-getPaddingBottom();
                        canvas.drawBitmap(drawabletoZoomBitmap(shrinkDrawable, drawableWidth, drawableHeight), left, top+10, null);
                    }
                } else if (targetLine == lineTexts.size()) {
                    //展开状态
                    canvas.drawText(lineText.getText(), getPaddingLeft(), lineText.getBaseLine(), textPaint);
                    if (showTipDrawalbe){
                        int left=getWidth() - drawableWidth - getPaddingRight();
                        int top=getHeight() - drawableHeight-getPaddingBottom();
                        canvas.drawBitmap(drawabletoZoomBitmap(expandDrawable, drawableWidth, drawableHeight), left, top, null);
                    }
                }
            }
        }

    }


    @Override
    public void onClick(View view) {

        if (maxLines == lineTexts.size())
            return;

        if (targetLine == maxLines) {
            enpand();
        } else if (targetLine == lineTexts.size()) {
            close();

        }
    }
    public void enpand(){
        if (targetLine == maxLines) {
            targetLine = lineTexts.size();
            startDrawAnim(maxLinesHeight, expandHeight);
        }
    }
    public void close(){
        if (targetLine == lineTexts.size()) {
            targetLine = maxLines;
            startDrawAnim(expandHeight, maxLinesHeight);
        }
    }

    private void startDrawAnim(int startHeight, int endHeight) {
        ObjectAnimator animator = ObjectAnimator.ofInt(this, "viewHeight", startHeight, endHeight);
        animator.setDuration(animDuration);
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }


    public  int getViewHeight() {
        return viewHeight;
    }

    public  void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
        requestLayout();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * drawlable 缩放
     *
     * @return
     */
    public static Bitmap drawabletoZoomBitmap(Drawable drawable, int w, int h) {
        // 取 drawable 的长宽
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        // drawable转换成bitmap
        Bitmap oldbmp = drawabletoBitmap(drawable);
        // 创建操作图片用的Matrix对象
        Matrix matrix = new Matrix();
        // 计算缩放比例
        float sx = ((float) w / width);
        float sy = ((float) h / height);
        // 设置缩放比例
        matrix.postScale(sx, sy);
        // 建立新的bitmap，其内容是对原bitmap的缩放后的图
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return newbmp;
    }

    /**
     * Drawable转换成Bitmap
     */
    public static Bitmap drawabletoBitmap(Drawable drawable) {
        // 取 drawable 的长宽
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        // 取 drawable 的颜色格式
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }


}