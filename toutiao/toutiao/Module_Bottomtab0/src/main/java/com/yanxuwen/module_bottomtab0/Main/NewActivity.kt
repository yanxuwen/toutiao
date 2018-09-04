package com.yanxuwen.module_bottomtab0.Main

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.webkit.*
import android.webkit.WebSettings.LayoutAlgorithm
import com.alibaba.android.arouter.facade.annotation.Route
import com.yanxuwen.MyRecyclerview.MyBaseAdapter
import com.yanxuwen.MyRecyclerview.MyRecyclerView
import com.yanxuwen.dragview.DragViewActivity
import com.yanxuwen.lib_common.Adapter.CommentAdapter
import com.yanxuwen.lib_common.Base.BaseActivity
import com.yanxuwen.lib_common.Bean.ARouterPath
import com.yanxuwen.lib_common.Bean.Value
import com.yanxuwen.lib_common.Fragment.ImageViewerFragment
import com.yanxuwen.lib_common.Utils.MyRecyclerViewUtils
import com.yanxuwen.lib_common.Utils.Tools
import com.yanxuwen.lib_common.retrofit.Msg.Msg
import com.yanxuwen.lib_common.retrofit.model.Article.Article
import com.yanxuwen.lib_common.retrofit.model.Comment.Comment
import com.yanxuwen.lib_common.widget.Drawer.ReplyDragLayout
import com.yanxuwen.lib_common.Base.Key.VideoKey
import com.yanxuwen.module_bottomtab0.R
import com.yanxuwen.retrofit.Msg.ObserverListener
import kotlinx.android.synthetic.main.bt0_activity_new.*
import kotlinx.android.synthetic.main.bt0_new_head.view.*
import java.net.URLDecoder
import java.util.regex.Pattern


/**
 * Created by yanxuwen on 2018/5/31.
 */
@Route(path = ARouterPath.Module_Bottomtab0_NewActiviy)
class NewActivity : BaseActivity() , MyRecyclerView.LoadingListener{
    var offset=0
    val mArticle: Article by lazy {
        intent.extras.getSerializable(VideoKey.Article) as Article
    }
    var listCommentData: ArrayList<Comment.DataBean> = ArrayList()
    val mCommentAdapter: CommentAdapter by lazy {
        CommentAdapter(context, listCommentData)
    }
    val head_view: View by lazy {
        LayoutInflater.from(this).inflate(R.layout.bt0_new_head, null)
    }
    val mMyRecyclerViewUtilsComment: MyRecyclerViewUtils by lazy {
        MyRecyclerViewUtils(context, null, rv_new_comment, mCommentAdapter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.bt0_activity_new)
        super.onCreate(savedInstanceState)
        setStatusFull(true)

    }

    override fun initData() {
    }

    override fun initView(status: Value.ObservableStatus?) {
        initListViewComment()
        initWebView()
        if(mArticle==null||mArticle.data==null||mArticle.data.content==null||mArticle.data.content==""){
            mRequestUtils.requestHtml(mArticle?.data?.group_id.toString())
        }else{
            setWebUrl(mArticle.data.content)
        }
    }
    fun initListViewComment(){
        rv_new_comment.addHeaderView(head_view)
        rv_new_comment?.setLoadingListener(this)
        mMyRecyclerViewUtilsComment.setRecyclerView()
        rv_new_comment?.adapter = mCommentAdapter
        mCommentAdapter.setOnItemClickListener(object : MyBaseAdapter.OnItemClickListener{
            override fun onItemClick(holder: MyBaseAdapter.BaseViewHolder?, view: View?, position: Int)=
                    if(listCommentData[position].comment.reply_count!=0L){
                        (common_drag_reply as ReplyDragLayout)?.id= (listCommentData[position]?.comment?.id).toString()
                        (common_drag_reply as ReplyDragLayout)?.open()
                    }else{}

        })
    }
    private fun initWebView() {
        head_view.webview.isScrollContainer = false
        head_view.webview.isScrollbarFadingEnabled = false
        head_view.webview.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        val settings = head_view.webview.settings
        settings.defaultTextEncodingName = "UTF-8"
        settings.layoutAlgorithm = LayoutAlgorithm.SINGLE_COLUMN
        settings.builtInZoomControls = false // 设置显示缩放按钮
        settings.setSupportZoom(false) // 支持缩放

        settings.javaScriptEnabled = true
        settings.blockNetworkImage = false
        head_view.webview.settings.javaScriptEnabled = true
        head_view.webview.settings.blockNetworkImage = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            head_view.webview.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        head_view.webview.addJavascriptInterface(this, "imagelistner")
        head_view.webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                onRefresh()
//                if (error) {
//                    layout_error.setVisibility(View.VISIBLE)
//                } else {
//                    layout_error.setVisibility(View.GONE)
//                }
//                error = false
//                if (loadview != null) {
//                    loadview.dismiss()
//                }
                head_view.webview.settings.blockNetworkImage = false
                super.onPageFinished(view, url)
                // html加载完成之后，添加监听图片的点击js函数
                addImageClickListner()
            }
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (loadview != null && !loadview.isShowing) {
                    loadview.show()
                }
                if (url.startsWith("http:") || url.startsWith("https:")) {
                    return false
                }

                // Otherwise allow the OS to handle things like tel, mailto, etc.
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                } catch (e: Exception) {
                }

                return true
            }

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
//                error = true
//                layout_error.setVisibility(View.VISIBLE)
            }

            override fun onReceivedHttpError(view: WebView, request: WebResourceRequest, errorResponse: WebResourceResponse) {
                //                error=true;
                //                layout_error.setVisibility(View.VISIBLE);
                super.onReceivedHttpError(view, request, errorResponse)
            }
        }
        head_view.webview.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(origin: String,
                                                            callback: GeolocationPermissions.Callback) {
                // TODO Auto-generated method stub
                super.onGeolocationPermissionsShowPrompt(origin, callback)
                callback.invoke(origin, true, false)
            }
        }
//        layout_error.setOnClickListener(View.OnClickListener {
//            error = false
//            webview.reload()
//        })
    }
     fun setWebUrl(url : String){
         val sb = StringBuilder()
        sb.append("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />")
                .append("<head>")
                .append("<link rel=\"stylesheet\" href=\"http://s0.pstatp.com/inapp/TTDefaultCSS.css\" type=\"text/css\" media=\"screen\" title=\"no title\" charset=\"utf-8\">")
                .append("<script type=\"text/javascript\" src=\"http://s0.pstatp.com/inapp/TTDefaultJS.js\"></script>")
//                .append("<script type=\"text/javascript\" src=\"file:///android_asset/js/android-common-forum.js\"></script>")
//                .append("<script type=\"text/javascript\" src=\"file:///android_asset/js/lib.js\"></script>")
//                .append("<script type=\"text/javascript\" src=\"file:///android_asset/js/lib-forum.js\"></script>")
                .append("</head>")
                .append("<body><p style=\"word-break:break-all; padding:2px;\">")
                .append(url)
                .append("</p></body></html>")
        var html = sb.toString().replace("<a class=\"image\"  href", "<img src")
        html = html.replace("bytedance://large_image?url=", "")
         //图片url转码
        for(str in Tools.getString(html, "<img src=", "&index")) {
            var url= URLDecoder.decode(str, "UTF-8")
            html = html.replace(str, url)
        }
        for (str in Tools.getString(html, "&index", "\"")) {
            html = html.replaceFirst("&index"+str, "")
        }
         head_view.webview.loadDataWithBaseURL("", html, "text/html", "utf-8", null)
         getAllImageUrlFromHtml(html)
     }
    override fun onRefresh() {
        offset=0
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtilsComment.limit,mArticle.data?.group_id.toString(), mArticle.data?.group_id.toString())
    }
    override fun onLoadMore() {
        offset=listCommentData.size
        mRequestUtils.requestComment(offset,mMyRecyclerViewUtilsComment.limit,mArticle.data?.group_id.toString(), mArticle.data?.group_id.toString())
    }

    /**评论*/
    fun notifyDataSetChangedComment(isRefresh: Boolean, count: Int, overtime: Boolean) {
        mMyRecyclerViewUtilsComment.notifyDataSetChanged(count, overtime)
    }

    override fun onNotifyData(status: ObserverListener.STATUS?, type: String?, mobject: Any?) {
        when (type) {
            Msg.Comment->{
                if (mRequestUtils.isDataFail(status)) {
                    notifyDataSetChangedComment(true, 0, status == ObserverListener.STATUS.ERROR)
                    return
                }
                if (mobject != null) {
                    var mComment = (mobject as Comment)
                    if(mComment.isRefresh){
                        listCommentData.clear()
                    }
                    var list_data = ArrayList<Comment.DataBean>()
                    if (mComment != null && mComment.data != null) {
                        list_data.addAll(mComment.data)
                    }
                    listCommentData.addAll(list_data)
                    notifyDataSetChangedComment(true, list_data.size, false)
                }
            }
            Msg.Article->{
                if (mRequestUtils.isDataFail(status)) {
                    return
                }
                if (mobject != null) {
                    var mHtml = (mobject as Article)
                    if(mHtml!=null&&mHtml.data!=null&&mHtml.data.content!=null){
                        setWebUrl(mHtml.data.content)
                    }
                }
            }else->{
            super.onNotifyData(status, type, mobject)
        }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 先从父控件中移除WebView
        head_view.webview.stopLoading()
        head_view.webview.settings.javaScriptEnabled = false
        head_view.webview.clearHistory()
        head_view.webview.removeAllViews()
        head_view.webview.destroy()
        head_view.webViewContainer.removeView(head_view.webview)


    }

    override fun onBackPressed() {
       if((common_drag_reply as ReplyDragLayout).isOpen){
           (common_drag_reply as ReplyDragLayout).close()
           return
       }
        super.onBackPressed()
    }
    // 注入js函数监听
    private fun addImageClickListner() {
        // 这段js函数的功能就是，遍历所有的img几点，并添加onclick函数，
        //函数的功能是在图片点击的时候调用本地java接口并传递url过去
        head_view.webview.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "    objs[i].onclick=function()  " +
                "    {  "
                + "        window.imagelistner.openImage(this.src);  " +
                "    }  " +
                "}" +
                "})()");
    }
    @android.webkit.JavascriptInterface
    public fun openImage(src :String){
        if(listImgSrc==null||listImgSrc.isEmpty())return
        var position=listImgSrc.indexOf(src)
        var listFragment: java.util.ArrayList<Class<*>> = java.util.ArrayList()

        for(i in listImgSrc.indices){
            listFragment.add(ImageViewerFragment::class.java)
        }

//        //展开放大图片
        DragViewActivity.startActivity(context, position,object : DragViewActivity.OnDataListener{

            override fun getListData(): java.util.ArrayList<Any> = listImgSrc

            override fun onBackPressed(): Boolean = true

            override fun getListView(): java.util.ArrayList<View>? = null

            override fun getListFragmentClass(): java.util.ArrayList<Class<*>> = listFragment

            override fun onPageSelected(position: Int) = Unit

            override fun init() = Unit

        })

    }
    var IMAGE_URL_TAG = "<img.*src=(.*?)[^>]*?>"
    var IMAGE_URL_CONTENT = "http:\"?(.*?)(\"|>|\\s+)"
    var listImgSrc=ArrayList<Any>()
    private fun getAllImageUrlFromHtml(html: String): List<String> {
        val matcher = Pattern.compile(IMAGE_URL_TAG).matcher(html)
        val listImgUrl = ArrayList<String>()
        while (matcher.find()) {
            listImgUrl.add(matcher.group())
        }
        //从图片对应的地址对象中解析出 src 标签对应的内容
        getAllImageUrlFormSrcObject(listImgUrl)
        return listImgUrl
    }

    /***
     * 从图片对应的地址对象中解析出 src 标签对应的内容，即 url
     * 例如 "http://sc1.hao123img.com/data/f44d0aab7bc35b8767de3c48706d429e"
     * @param listImageUrl 图片地址对象例如 ：
     * <img src="http://sc1.hao123img.com/data/f44daab"></img>
     */
    private fun getAllImageUrlFormSrcObject(listImageUrl: List<String>): List<Any> {
        for (image in listImageUrl) {
            val matcher = Pattern.compile(IMAGE_URL_CONTENT).matcher(image)
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length - 1))
            }
        }
        return listImgSrc
    }
}