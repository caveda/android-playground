package com.victorcaveda.data.repository

import com.victorcaveda.data.remote.openWeather.WeatherDataSource
import com.victorcaveda.domain.model.Station
import com.victorcaveda.domain.repository.AirQualityRepository
import javax.inject.Inject

class AirQualityRepositoryImpl @Inject constructor(val weatherService: WeatherDataSource) :
    AirQualityRepository {

    override suspend fun getAirQualityData(): List<Station> {
        val airQuality = weatherService.getAirQuality(lat = "43.5452", lon = "-5.661920")
        return listOf(
            Station(airQuality.toString())
        )
    }
}