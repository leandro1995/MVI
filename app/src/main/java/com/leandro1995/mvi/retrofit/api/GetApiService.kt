package com.leandro1995.mvi.retrofit.api

import com.google.gson.JsonArray
import retrofit2.Response
import retrofit2.http.GET

interface GetApiService {

    @GET("posts")
    suspend fun postList(): Response<JsonArray>
}