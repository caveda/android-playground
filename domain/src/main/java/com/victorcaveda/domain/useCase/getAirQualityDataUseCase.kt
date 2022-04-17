package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.repository.AirQualityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class getAirQualityDataUseCase(
    private val airQualityRepository: AirQualityRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    operator fun invoke() = airQualityRepository.getAirQualityData()
}