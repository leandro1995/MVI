package com.leandro1995.mvi.retrofit.config

import com.leandro1995.mvi.retrofit.api.GetApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val getApiService: GetApiService = retrofit.create(GetApiService::class.java)
}