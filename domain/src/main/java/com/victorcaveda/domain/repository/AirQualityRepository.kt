package com.victorcaveda.domain.repository

import com.victorcaveda.domain.model.Station

interface AirQualityRepository {
    suspend fun getAirQualityData(): List<Station>
}