package com.example.oazisn.dramalist.utils

import com.example.oazisn.dramalist.dao.TrendingMusicResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("trending.php")
    fun getTrending(@Query("country") country: String, @Query("type") type: String, @Query("format") format: String): Flowable<TrendingMusicResponse>
}