package com.example.kakaobank

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DaumSearchService {
    @GET("v2/search/image")
    fun searchImages(
        @Header("Authorization") authorization: String,
        @Query("query") query: String,
        @Query("size") size: Int
    ): Call<SearchResponse>
}