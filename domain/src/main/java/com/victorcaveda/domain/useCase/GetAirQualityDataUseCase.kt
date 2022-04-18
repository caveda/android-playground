package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.repository.AirQualityRepository
import javax.inject.Inject

class GetAirQualityDataUseCase @Inject constructor(
    val airQualityRepository: AirQualityRepository
) {
    operator fun invoke() = airQualityRepository.getAirQualityData()
}