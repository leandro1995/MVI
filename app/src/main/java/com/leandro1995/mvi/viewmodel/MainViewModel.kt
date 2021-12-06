package com.leandro1995.mvi.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.mvi.intent.MainIntent
import com.leandro1995.mvi.model.User
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    companion object {

        const val LIST = 1
    }

    val mainIntentFlow: MutableStateFlow<MainIntent> by lazy {
        MutableStateFlow(MainIntent.Initial)
    }

    val onClick = fun(action: Int) {

        when (action) {

            LIST -> {

                postListProgress()
            }
        }
    }

    private val user = User()

    private fun postListProgress() {

        mainIntentFlow.value = MainIntent.Progress
    }

    suspend fun servicePostList() {

        user.postList(
            response = { postList ->

                mainIntentFlow.value = MainIntent.PostList(postList = postList)
            },
            errorResponse = { code, message ->

                mainIntentFlow.value = MainIntent.MessageError(code = code, message = message)
            })
    }
}