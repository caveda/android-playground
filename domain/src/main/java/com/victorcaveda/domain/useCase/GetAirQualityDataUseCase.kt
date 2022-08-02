package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.repository.AirQualityRepository
import javax.inject.Inject

class GetAirQualityDataUseCase @Inject constructor(
    private val airQualityRepository: AirQualityRepository
) {
    suspend operator fun invoke() = airQualityRepository.getAirQualityData()
}