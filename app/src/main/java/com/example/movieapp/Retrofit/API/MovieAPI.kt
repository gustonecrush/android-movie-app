package com.example.movieapp.Retrofit.API

import com.example.movieapp.Retrofit.CreditResponse
import com.example.movieapp.Retrofit.MovieResponse
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

    @GET("movie/{id}/credits")
    fun getMovieCredits(
        @Path("id") id : Int?,
        @Query("api_key") api_key: String?
    ): Call<CreditResponse>

}