package com.victorcaveda.data.repository

import com.victorcaveda.data.mapper.toDomain
import com.victorcaveda.data.remote.meteo.MeteoDataSource
import com.victorcaveda.domain.model.WeatherInfo
import com.victorcaveda.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(val weatherAPI: MeteoDataSource) :
    WeatherRepository {

    override suspend fun getWeather(latitude: Double, longitude: Double): Result<WeatherInfo> {
        return try {
            Result.success(weatherAPI.getWeather(latitude, longitude).toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}