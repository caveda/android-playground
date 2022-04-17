package com.victorcaveda.data.repository

import com.victorcaveda.domain.model.Station
import com.victorcaveda.domain.repository.AirQualityRepository

class AirQualityRepositoryImpl : AirQualityRepository {

    override fun getAirQualityData(): List<Station> =
        listOf(Station("Station 1"), Station("Station 2"), Station("Station 3"))
}