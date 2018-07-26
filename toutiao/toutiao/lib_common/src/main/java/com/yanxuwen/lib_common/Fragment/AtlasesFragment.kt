package com.yanxuwen.lib_common.Fragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.yanxuwen.dragview.DragFragment
import com.yanxuwen.lib_common.R
import com.yanxuwen.lib_common.Utils.Glide.GlideOptions.Companion.options4
import kotlinx.android.synthetic.main.common_images.view.*

/**
 * Created by yanxuwen on 2018/6/28.
 * 图片流浏览
 */
class AtlasesFragment : DragFragment() , View.OnClickListener {

    override fun getDragView(): View? = if (view == null) null else view.iv_images

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.common_images)
        super.onCreate(savedInstanceState)

    }
    override fun init() {
    }


    override fun onDragStatus(status: Int) {
    }

    override fun initView() {
        Glide.with(context).load(data as String).transition(DrawableTransitionOptions.withCrossFade()).apply(options4).into(view.iv_images)

    }

    override fun onClick(p0: View?) {
    }
}
