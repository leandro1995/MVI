package com.leandro1995.mvi.intent.config

import com.leandro1995.mvi.intent.MainIntent
import com.leandro1995.mvi.config.callback.MainCallBack

object MainIntentConfig {

    private lateinit var mainCallBack: MainCallBack

    fun instance(mainCallBack: MainCallBack): MainIntentConfig {

        MainIntentConfig.mainCallBack = mainCallBack

        return this
    }

    fun mainCollect(mainIntent: MainIntent) {

        when (mainIntent) {

            is MainIntent.Progress -> {

                mainCallBack.progress()
            }
            is MainIntent.PostList -> {

                mainCallBack.postList(mainIntent.postList)
            }
            is MainIntent.MessageError -> {

                mainCallBack.messageError(mainIntent.code, mainIntent.message)
            }
            else -> {

            }
        }
    }
}