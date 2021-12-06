package com.leandro1995.mvi.config.callback.ambiente

interface ProgressComponentCallBack {

    fun progress()

    fun messageError(code: Int, message: String)
}