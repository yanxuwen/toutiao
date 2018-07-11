
# 前言 该抽屉实现了可以定义4边的抽屉，大小随意控制。可实现（仿今日头条的评论抽屉功能）
#### 博客地址：https://www.jianshu.com/p/2abb8c20817f

## 先看下效果图	
![GIF.gif](http://upload-images.jianshu.io/upload_images/6835615-d55e8a1d4b96d8e2.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



## 依赖：	
   compile 'com.yanxuwen.mydrawer:mydrawer:1.1.4’
## 实现：	
#### 1.首先自定义类。TextDragLayout 
~~~
public class TextDragLayout extends BaseDragLayout {
    ImageView iv_cover;
    public TextDragLayout(Context context) {
        super(context);
    }

    public TextDragLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public TextDragLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onViewStatus(boolean isOpen) {
    }

    @Override
    public void onViewOffset(float mOffset) {
        if(iv_cover!=null){
            iv_cover.setAlpha((float) (mOffset*0.8));
        }
    }

    @Override
    public void initView() {
        setContentView(findViewById(R.id.layout_drag));
        iv_cover= (ImageView) findViewById(R.id.iv_cover);
    }
}
~~~
其实就是继承BaseDragLayout，onViewStatus开关回调，onViewOffset是偏移量回调，initView不想说了。其实没什么东西，这里可以实现你自己的逻辑。
【主要讲的是 setContentView(findViewById(R.id.layout_drag));】一看就知道是设置抽屉类的视图

#### 2.xml设置(在你需要的界面上加上该布局)
~~~
<com.yanxuwen.drawer.TextDragLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:myapp="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    myapp:mode="drag_right"
    >
    <ImageView
        android:id="@+id/iv_cover"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#000000"
        android:alpha="0"
        />
    <RelativeLayout
        android:id="@+id/layout_drag"
        android:layout_width="200dp"
        android:layout_height="match_parent"
        android:background="#ff0000"
        >
        <TextView
            android:id="@+id/tv_name"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:text="test"
            android:textSize="16sp"
            android:layout_centerInParent="true"
            />
    </RelativeLayout>
</com.yanxuwen.drawer.TextDragLayout>
~~~
我们可以看到有个这样的值 myapp:mode="drag_right" 就是设置右边抽屉，只要改这个值就可以随意更改抽屉位置分别有drag_left,drag_right,drag_top,drag_bottom。
###### 我们可以看到里面有2个子类，其实只要一个子类就可以，那就是layout_drag，记得上面有setContentView(findViewById(R.id.layout_drag));就是设置抽屉布局。至于iv_cover其实就是阴影部分，由于我们不提供任何阴影的控制，因为不同的需求，阴影不同，所以我们设置阴影很简单，就是在布局在加个子类，透明度为0然后在TextDragLayout 的onViewOffset偏移量回调控制阴影透明度变化，这样就会实现阴影效果。

## 3.MainActivity
 ~~~
打开我们只需要mTextDragLayout.open();
关闭只需要 mTextDragLayout.close();
//提供是否可以根据手势滑动，默认true,  false为关闭
 mTextDragLayout.setSlideable(true);
//提供是否可以滑动屏幕边缘来展开抽屉，默认true,  false为关闭功能
 mTextDragLayout.isEdgeSlide(true);
记得在控制back键，返回的时候我们要关闭掉
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mTextDragLayout != null && mTextDragLayout.isOpen()) {
                mTextDragLayout.close();
                return true;
            } else{
                finish();
            }

        }
        return false;
    }
~~~
## 4.基本流程就是这样，很简单，但是如果你要实现类似今日头条那样，有个列表，由于都是上下滑动，所以会导致列表不会滑动，之后滑动抽屉，我们只要简单的加上下面这句话即可
~~~
mTextDragLayout.setRecyclerView(mRecyclerView);
加了上面那句话你就会发现，会先滑动列表，列表滑动到顶才会滑动抽屉，是不是跟今日头条一样，支持4个方向的冲突，
~~~
## github代码：https://github.com/yanxuwen/MyDrawer
#### 喜欢就在github star下,非常感谢o(∩_∩)o~~~，您star下就是我的动力，
## 微信公众号：
![qrcode_for_gh_8e99f824c0d6_344.jpg](http://upload-images.jianshu.io/upload_images/6835615-8b35ce64a1688c8b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
