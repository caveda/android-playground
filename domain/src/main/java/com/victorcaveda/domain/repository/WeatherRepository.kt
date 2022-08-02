package com.victorcaveda.domain.repository

import com.victorcaveda.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Result<WeatherInfo>
}