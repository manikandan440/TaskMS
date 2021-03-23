package com.example.mstask.Retro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class APIClient {

    var BASE_URL = "https://api.github.com/"
    private var retrofit: Retrofit? = null
    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}