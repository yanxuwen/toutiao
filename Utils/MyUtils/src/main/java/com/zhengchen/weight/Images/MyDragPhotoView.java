//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhengchen.weight.Images;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.wc.dragphoto.photoview.PhotoView;

/**
 * 可拖动浏览图片
 */
public class MyDragPhotoView extends PhotoView {
    private Paint mPaint;
    private float mDownX;
    private float mDownY;
    private float mLastTranslateY;
    private float mLastTranslateX;
    private float mTranslateY;
    private float mTranslateX;
    private float mScaleX;
    private float mScaleY;
    private int mWidth;
    private int mHeight;
    private float mMinScale;
    private int mAlpha;
    private static final int MAX_TRANSLATE_Y = 500;
    private static final int MAX_EXIT_Y = 200;
    private static final long DURATION = 300L;
    private boolean canFinish;
    private boolean isAnimate;
    private boolean isTouchEvent;
    private OnTapListener mTapListener;
    private OnExitListener mExitListener;
    private OnDragListener mDragListener;
    private int mTouchSlop;
    private boolean isActivityAnimate;
    private boolean isFinshAnimate;
    private boolean isLongClick;

    public MyDragPhotoView(Context context) {
        this(context, (AttributeSet)null);
    }

    public MyDragPhotoView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public MyDragPhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        this.mScaleX = 1.0F;
        this.mScaleY = 1.0F;
        this.mMinScale = 0.5F;
        this.mAlpha = 0;
        this.canFinish = false;
        this.isAnimate = false;
        this.isTouchEvent = false;
        this.isActivityAnimate = false;
        this.isFinshAnimate = false;
        this.isLongClick = false;
        this.mPaint = new Paint();
//        this.mPaint.setColor(-16777216);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    protected void onDraw(Canvas canvas) {
        //取消透明度，由最外层来控制
        this.mPaint.setAlpha(0);
        canvas.drawRect(0.0F, 0.0F, 2000.0F, 3000.0F, this.mPaint);
        if(!this.isActivityAnimate) {
            canvas.translate(this.mTranslateX, this.mTranslateY);
            canvas.scale(this.mScaleX, this.mScaleY, (float)(this.mWidth / 2), (float)(this.mHeight / 2));
        }

        super.onDraw(canvas);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if(this.getScale() == 1.0F) {
            switch(event.getAction()) {
                case 0:
                    this.mDownX = event.getX();
                    this.mDownY = event.getY();
                    this.canFinish = !this.canFinish;
                    this.isActivityAnimate = false;
                    this.isAnimate = false;
                    this.isLongClick = false;
                    break;
                case 1:
                    if(event.getPointerCount() == 1) {
                        this.onActionUp(event);
                        this.isTouchEvent = false;
                        this.isLongClick = false;
                    }
                    break;
                case 2:
                    if(this.isLongClick) {
                        return super.dispatchTouchEvent(event);
                    }

                    float yDiff = event.getY() - this.mDownY;
                    if(this.isTouchEvent || this.mLastTranslateX != 0.0F || this.mLastTranslateY != 0.0F || yDiff > (float)this.mTouchSlop) {
                        if(this.mTranslateY == 0.0F && this.mTranslateX != 0.0F && yDiff < (float)this.mTouchSlop && !this.isTouchEvent) {
                            this.mScaleX = 1.0F;
                            this.mScaleY = 1.0F;
                            return super.dispatchTouchEvent(event);
                        }

                        if(this.mTranslateY >= 0.0F && event.getPointerCount() == 1) {
                            this.onActionMove(event);
                            if(this.mTranslateY != 0.0F) {
                                this.isTouchEvent = true;
                            }

                            return true;
                        }

                        if(this.mTranslateY >= 0.0F && (double)this.mScaleX < 0.95D) {
                            return true;
                        }
                    }
            }
        }

        return super.dispatchTouchEvent(event);
    }

    private void onActionUp(MotionEvent event) {
        if(this.mTranslateY > 200.0F) {
            if(this.mExitListener == null) {
                throw new RuntimeException("MyDragPhotoView: onExitLister can\'t be null ! call setOnExitListener() ");
            }

            this.mExitListener.onExit(this, this.mTranslateX, this.mTranslateY, (float)this.mWidth, (float)this.mHeight, 500,mAlpha);
        } else {
            this.performAnimation();
        }

    }

    private void onActionMove(MotionEvent event) {
        float moveY = event.getY();
        float moveX = event.getX();
        this.mTranslateX = moveX - this.mDownX + this.mLastTranslateX;
        this.mTranslateY = moveY - this.mDownY + this.mLastTranslateY;
        if(this.mTranslateY < 0.0F) {
            this.mTranslateY = 0.0F;
        }

        float percent = this.mTranslateY / 500.0F;
        if(this.mScaleX >= this.mMinScale && this.mScaleX <= 1.0F) {
            this.mScaleX = 1.0F - percent;
            this.mScaleY = 1.0F - percent;
            this.mAlpha = (int)(255.0F * (1.0F - percent));
            if(this.mAlpha > 255) {
                this.mAlpha = 255;
            } else if(this.mAlpha < 0) {
                this.mAlpha = 0;
            }
        }

        if(this.mScaleX < this.mMinScale) {
            this.mScaleX = this.mMinScale;
            this.mScaleY = this.mMinScale;
        } else if(this.mScaleX > 1.0F) {
            this.mScaleX = 1.0F;
            this.mScaleY = 1.0F;
        }

        if(this.mDragListener != null) {
            this.mDragListener.onDrag(this, moveX, moveY,mAlpha);
        }
        this.invalidate();
    }

    private void performAnimation() {
        if(this.mScaleX != 1.0F || this.mScaleY != 1.0F || this.mTranslateX != 0.0F) {
            ValueAnimator animator = ValueAnimator.ofInt(new int[]{this.mAlpha, 255});
            animator.setDuration(300L);
            animator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if(MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mAlpha = ((Integer)valueAnimator.getAnimatedValue()).intValue();
                    }

                }
            });
            animator.start();
            animator = ValueAnimator.ofFloat(new float[]{this.mTranslateX, 0.0F});
            animator.setDuration(300L);
            animator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if(MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mTranslateX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                        MyDragPhotoView.this.mLastTranslateX = MyDragPhotoView.this.mTranslateX;
                    }

                }
            });
            animator.start();
            animator = ValueAnimator.ofFloat(new float[]{this.mTranslateY, 0.0F});
            animator.setDuration(300L);
            animator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if(MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mTranslateY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                        MyDragPhotoView.this.mLastTranslateY = MyDragPhotoView.this.mTranslateY;
                    }

                }
            });
            animator.start();
            animator = ValueAnimator.ofFloat(new float[]{this.mScaleX, 1.0F});
            animator.setDuration(300L);
            animator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if(MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mScaleX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                        MyDragPhotoView.this.mScaleY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                        MyDragPhotoView.this.invalidate();
                    }

                }
            });
            animator.addListener(new AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    MyDragPhotoView.this.isAnimate = true;
                }

                public void onAnimationEnd(Animator animator) {
                    if(MyDragPhotoView.this.mTapListener != null && MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mTapListener.onTap(MyDragPhotoView.this,mAlpha);
                    }

                    if(MyDragPhotoView.this.isAnimate) {
                        MyDragPhotoView.this.mScaleX = 1.0F;
                        MyDragPhotoView.this.mScaleY = 1.0F;
                        MyDragPhotoView.this.mTranslateX = 0.0F;
                        MyDragPhotoView.this.mTranslateY = 0.0F;
                        MyDragPhotoView.this.invalidate();
                    }

                    MyDragPhotoView.this.isAnimate = false;
                    animator.removeAllListeners();
                }

                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }
            });
            animator.start();
        }
    }

    public void setOnClickListener(final OnClickListener l) {
        super.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if(!MyDragPhotoView.this.isAnimate && !MyDragPhotoView.this.isFinshAnimate) {
                    l.onClick(v);
                }

            }
        });
    }

    public void setOnLongClickListener(final OnLongClickListener l) {
        super.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                if(!MyDragPhotoView.this.isAnimate && !MyDragPhotoView.this.isFinshAnimate && MyDragPhotoView.this.mScaleX == 1.0F && MyDragPhotoView.this.mScaleY == 1.0F && MyDragPhotoView.this.mTranslateX == 0.0F) {
                    MyDragPhotoView.this.isLongClick = true;
                    return l.onLongClick(v);
                } else {
                    return false;
                }
            }
        });
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public void setMinScale(float minScale) {
        this.mMinScale = minScale;
    }

    public void setOnTapListener(OnTapListener listener) {
        this.mTapListener = listener;
    }

    public void setOnExitListener(OnExitListener listener) {
        this.mExitListener = listener;
    }

    public void setOnDragListener(OnDragListener listener) {
        this.mDragListener = listener;
    }

    public void setBackgroundAlpha(int alpha) {
        this.mAlpha = alpha;
        this.invalidate();
    }

    public void setActivityAnimate(boolean isActivityAnimate) {
        this.isActivityAnimate = isActivityAnimate;
    }

    public void performEnterAnimation(float scaleX, float scaleY) {
        ValueAnimator translateXAnimator = ValueAnimator.ofFloat(new float[]{this.getX(), 0.0F});
        translateXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.setX(((Float)valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        translateXAnimator.setDuration(300L);
        translateXAnimator.start();
        ValueAnimator translateYAnimator = ValueAnimator.ofFloat(new float[]{this.getY(), 0.0F});
        translateYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.setY(((Float)valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        translateYAnimator.setDuration(300L);
        translateYAnimator.start();
        ValueAnimator scaleYAnimator = ValueAnimator.ofFloat(new float[]{scaleY, 1.0F});
        scaleYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.setScaleY(((Float)valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        scaleYAnimator.setDuration(300L);
        scaleYAnimator.start();
        ValueAnimator scaleXAnimator = ValueAnimator.ofFloat(new float[]{scaleX, 1.0F});
        scaleXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.setScaleX(((Float)valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        scaleXAnimator.setDuration(300L);
        scaleXAnimator.start();

    }

    public void finishWithAnimation(final Activity activity, int left, int top, int width, int height) {
        this.isFinshAnimate = true;
        int[] locationPhoto = new int[2];
        this.getLocationOnScreen(locationPhoto);
        float targetHeight = (float)this.getHeight();
        float targetWidth = (float)this.getWidth();
        float scaleX = (float)width / targetWidth;
        float imageHeight = targetHeight;
        if(this.getDrawable() != null) {
            imageHeight = (float)this.getDrawable().getIntrinsicHeight();
        }

        float scaleY = (float)height / imageHeight;
        float targetCenterX = (float)locationPhoto[0] + targetWidth / 2.0F;
        float targetCenterY = (float)locationPhoto[1] + targetHeight / 2.0F;
        float translationX = (float)(left + width / 2) - targetCenterX;
        float translationY = (float)(top + height / 2) - targetCenterY;
        ValueAnimator alphaAnimator = ValueAnimator.ofInt(new int[]{255, 0});
        alphaAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mAlpha = ((Integer)valueAnimator.getAnimatedValue()).intValue();
            }
        });
        alphaAnimator.setDuration(300L);
        alphaAnimator.start();
        ValueAnimator translateXAnimator = ValueAnimator.ofFloat(new float[]{0.0F, translationX});
        translateXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mTranslateX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        translateXAnimator.setDuration(300L);
        translateXAnimator.start();
        ValueAnimator translateYAnimator = ValueAnimator.ofFloat(new float[]{0.0F, translationY});
        translateYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mTranslateY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        translateYAnimator.setDuration(300L);
        translateYAnimator.start();
        ValueAnimator scaleYAnimator = ValueAnimator.ofFloat(new float[]{1.0F, scaleY});
        scaleYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mScaleY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        scaleYAnimator.setDuration(300L);
        scaleYAnimator.start();
        ValueAnimator scaleXAnimator = ValueAnimator.ofFloat(new float[]{1.0F, scaleX});
        scaleXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mScaleX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                MyDragPhotoView.this.invalidate();
            }
        });
        scaleXAnimator.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
        scaleXAnimator.setDuration(300L);
        scaleXAnimator.start();
    }

    public void performExitAnimation(final Activity activity, int left, int top, int width, int height) {
        this.isFinshAnimate = true;
        int[] locationPhoto = new int[2];
        this.getLocationOnScreen(locationPhoto);
        float targetHeight = (float)this.getHeight();
        float targetWidth = (float)this.getWidth();
        float scaleX = (float)width / targetWidth;
        float imageHeight = targetHeight;
        if(this.getDrawable() != null) {
            imageHeight = (float)this.getDrawable().getIntrinsicHeight();
        }

        float scaleY = (float)height / imageHeight;
        float targetCenterX = (float)locationPhoto[0] + targetWidth / 2.0F;
        float targetCenterY = (float)locationPhoto[1] + targetHeight / 2.0F;
        float translationX = (float)(left + width / 2) - targetCenterX;
        float translationY = (float)(top + height / 2) - targetCenterY;
        ValueAnimator alphaAnimator = ValueAnimator.ofInt(new int[]{this.mAlpha, 0});
        alphaAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mAlpha = ((Integer)valueAnimator.getAnimatedValue()).intValue();
            }
        });
        alphaAnimator.setDuration(300L);
        alphaAnimator.start();
        ValueAnimator translateXAnimator = ValueAnimator.ofFloat(new float[]{this.mTranslateX, translationX});
        translateXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mTranslateX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        translateXAnimator.setDuration(300L);
        translateXAnimator.start();
        ValueAnimator translateYAnimator = ValueAnimator.ofFloat(new float[]{this.mTranslateY, translationY});
        translateYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mTranslateY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        translateYAnimator.setDuration(300L);
        translateYAnimator.start();
        ValueAnimator scaleYAnimator = ValueAnimator.ofFloat(new float[]{this.mScaleY, scaleY});
        scaleYAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mScaleY = ((Float)valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        scaleYAnimator.setDuration(300L);
        scaleYAnimator.start();
        ValueAnimator scaleXAnimator = ValueAnimator.ofFloat(new float[]{this.mScaleX, scaleX});
        scaleXAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyDragPhotoView.this.mScaleX = ((Float)valueAnimator.getAnimatedValue()).floatValue();
                MyDragPhotoView.this.invalidate();
            }
        });
        scaleXAnimator.addListener(new AnimatorListener() {
            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
        scaleXAnimator.setDuration(300L);
        scaleXAnimator.start();
    }

    public interface OnDragListener {
        void onDrag(MyDragPhotoView var1, float var2, float var3,int mAlpha);
    }

    public interface OnExitListener {
        void onExit(MyDragPhotoView var1, float var2, float var3, float var4, float var5, int var6,int mAlpha);
    }

    public interface OnTapListener {
        void onTap(MyDragPhotoView var1,int mAlpha);
    }
}
