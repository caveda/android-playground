package com.victorcaveda.data.dataSource.openData

import com.victorcaveda.data.BuildConfig
import com.victorcaveda.data.model.AirQualityDto
import com.victorcaveda.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherDataSource {

    @GET("data/2.5/onecall?exclude=minutely,hourly,alerts&lang=en")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = BuildConfig.OPENWEATHER_API_KEY
    ): WeatherDto


    @GET("data/2.5/air_pollution")
    suspend fun getAirQuality(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = BuildConfig.OPENWEATHER_API_KEY
    ): AirQualityDto
}