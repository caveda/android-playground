package com.victorcaveda.data.remote.meteo

import com.victorcaveda.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MeteoAPI {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double
    ): WeatherDto
}