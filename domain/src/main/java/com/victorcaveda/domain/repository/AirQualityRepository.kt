package com.victorcaveda.domain.repository

import com.victorcaveda.domain.model.Station

interface AirQualityRepository {
    fun getAirQualityData(): List<Station>
}