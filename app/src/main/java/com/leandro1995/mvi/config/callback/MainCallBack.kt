package com.leandro1995.mvi.config.callback

import com.leandro1995.mvi.config.callback.ambiente.ProgressComponentCallBack
import com.leandro1995.mvi.model.Post

interface MainCallBack : ProgressComponentCallBack {

    fun postList(postList: MutableList<Post>)
}