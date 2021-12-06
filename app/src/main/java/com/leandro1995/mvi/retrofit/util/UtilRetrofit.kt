package com.leandro1995.mvi.retrofit.util

import com.google.gson.JsonElement

class UtilRetrofit {

    companion object {

        fun intEmpty(jsonElement: JsonElement): Int = if (jsonElement.isJsonNull) {
            -1
        } else {
            jsonElement.asInt
        }

        fun stringEmpty(jsonElement: JsonElement): String = if (jsonElement.isJsonNull) {
            ""
        } else {
            jsonElement.asString
        }
    }
}