package com.leandro1995.mvi.intent

import com.leandro1995.mvi.model.Post

sealed class MainIntent {

    object Initial : MainIntent()

    object Progress : MainIntent()

    data class PostList(val postList: MutableList<Post>) : MainIntent()

    data class MessageError(val code: Int, val message: String) : MainIntent()
}