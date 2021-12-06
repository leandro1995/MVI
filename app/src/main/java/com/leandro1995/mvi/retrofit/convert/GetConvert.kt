package com.leandro1995.mvi.retrofit.convert

import com.google.gson.JsonArray
import com.leandro1995.mvi.model.Post
import com.leandro1995.mvi.retrofit.config.Setting
import com.leandro1995.mvi.retrofit.util.UtilRetrofit

class GetConvert {

    companion object {

        fun postList(jsonArray: JsonArray): MutableList<Post> {

            val postList = mutableListOf<Post>()

            jsonArray.forEach {

                postList.add(
                    Post(
                        id = UtilRetrofit.intEmpty(it.asJsonObject[Setting.ID]),
                        title = UtilRetrofit.stringEmpty(it.asJsonObject[Setting.TITLE]),
                        body = UtilRetrofit.stringEmpty(it.asJsonObject[Setting.BODY])
                    )
                )
            }

            return postList
        }
    }
}