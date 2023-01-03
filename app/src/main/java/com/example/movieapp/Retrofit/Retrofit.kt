package com.example.movieapp.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    val BASE_URL = "https://api.themoviedb.org/3/"
    var API_KEY  = "2e856250c0594b8135bd2d581713f693"

    fun getRetroData(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}