package com.example.mstask.Retro

import android.graphics.Movie
import com.example.mstask.Response.RepoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET




interface ApiInterface {

    @GET("repositories")
    fun getRepos(): Call<List<RepoResponse>>

    /*@GET("volley_array.json")
    fun getMovies() : Call<List<Movie>>*/

    companion object {

        var BASE_URL = "https://api.github.com/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}