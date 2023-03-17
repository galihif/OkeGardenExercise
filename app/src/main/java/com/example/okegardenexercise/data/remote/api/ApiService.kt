package com.example.okegardenexercise.data.remote.api

import com.example.okegardenexercise.data.remote.dto.WeatherDataDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") q: String,
    ):WeatherDataDto
}