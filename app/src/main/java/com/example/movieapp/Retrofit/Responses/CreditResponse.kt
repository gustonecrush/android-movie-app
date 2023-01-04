package com.example.movieapp.Retrofit

import com.google.gson.annotations.SerializedName

data class CreditResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("cast")
    val cast: ArrayList<Cast>? = null,

    @field:SerializedName("crew")
    val crew: ArrayList<Crew>? = null,

)

data class Cast(

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("gender")
    val gender: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("known_for_department")
    val known_for_department: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("original_name")
    val original_name: String? = null,

    @field:SerializedName("popularity")
    val popularity: Float? = null,

    @field:SerializedName("profile_path")
    val profile_path: String? = null,

    @field:SerializedName("cast_id")
    val cast_id: Int? = null,

    @field:SerializedName("character")
    val character: String? = null,

    @field:SerializedName("credit_id")
    val credit_id: String? = null,

    @field:SerializedName("order")
    val order: Int? = null,

)

data class Crew(

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("gender")
    val gender: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("known_for_department")
    val known_for_department: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("original_name")
    val original_name: String? = null,

    @field:SerializedName("popularity")
    val popularity: Float? = null,

    @field:SerializedName("profile_path")
    val profile_path: String? = null,

    @field:SerializedName("credit_id")
    val credit_id: String? = null,

    @field:SerializedName("department")
    val department: String? = null,

    @field:SerializedName("job")
    val job: String? = null,

)
