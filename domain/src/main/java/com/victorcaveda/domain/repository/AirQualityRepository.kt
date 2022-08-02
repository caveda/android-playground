package com.victorcaveda.domain.repository

import com.victorcaveda.domain.model.Station

interface AirQualityRepository {
    suspend fun getAirQualityData(): List<Station> // TODO return value a Result<T>
}