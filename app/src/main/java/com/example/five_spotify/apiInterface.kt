package com.example.five_spotify

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface apiInterface {
    @Headers("X-RapidAPI-Key: 83f0f94370mshfd8143b218431abp1514f1jsncfce7fdf56a9",
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query: String) : Call<music_data>
}