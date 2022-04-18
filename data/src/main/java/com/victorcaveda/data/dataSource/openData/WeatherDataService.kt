package com.victorcaveda.data.dataSource.openData

import com.victorcaveda.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataService {

    @GET("data/2.5/onecall?exclude=minutely,hourly,alerts&lang=en")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = "4596df18d7f3e4389a40371e52e0ef9c"
    ): WeatherDto

}