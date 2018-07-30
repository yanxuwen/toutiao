package com.yanxuwen.lib_common.Utils.Glide

import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.yanxuwen.lib_common.R

/**
 * Created by yanxuwen on 2018/5/28.
 */
class  GlideOptions{
    companion object {
        open val options by lazy {
            RequestOptions()
                    .centerCrop()
                    .placeholder(R.color.common_gray_30)
//            .error(com.yanxuwen.myutils.R.drawable.loadimage)
                    .priority(Priority.HIGH)
        }
        open val options2 by lazy {
            RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.common_ic_img_loading)
                    .error(R.drawable.common_ic_img_loadfail)
                    .priority(Priority.HIGH)
        }

        open val options3 by lazy {
            RequestOptions()
                    .placeholder(R.color.common_gray_30)
                    .error(R.drawable.common_ic_img_loadfail)
                    .priority(Priority.HIGH)
        }
        open val options4 by lazy {
            RequestOptions()
                    .placeholder(R.color.transparent)
                    .error(R.drawable.common_ic_img_loadfail)
                    .priority(Priority.HIGH)
        }
        open val optionsRound by lazy {
            RequestOptions()
                    .centerCrop()
                    .priority(Priority.HIGH)
                    .transform(GlideRoundTransform(50))
        }
    }
}