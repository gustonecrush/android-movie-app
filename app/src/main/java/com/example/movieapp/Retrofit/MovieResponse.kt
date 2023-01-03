package com.example.movieapp.Retrofit

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @field:SerializedName("dates")
    val dates: Dates? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("results")
    val results: ArrayList<Results>? = null

)

data class Dates (

    @field:SerializedName("maximum")
    val maximum: String? = null,

    @field:SerializedName("minimum")
    val minimum: String? = null,

    )

data class Results (

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("backdrop_path")
    val backdrop_path: String? = null,

    @field:SerializedName("genre_ids")
    val genre_ids: ArrayList<Int>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("original_language")
    val original_language: String? = null,

    @field:SerializedName("original_title")
    val original_title: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("popularity")
    val popularity: Float? = null,

    @field:SerializedName("poster_path")
    val poster_path: String? = null,

    @field:SerializedName("release_date")
    val release_date: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("vote_average")
    val vote_average: Float? = null,

    @field:SerializedName("vote_count")
    val vote_count: Int? = null,

    )
