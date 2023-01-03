package com.example.movieapp.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/{category}")
    fun getMoviesByCategory(
        @Path("category") category: String?,
        @Query("api_key") api_key: String?
    ): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id : String?
    ): Call<MovieResponse>

}