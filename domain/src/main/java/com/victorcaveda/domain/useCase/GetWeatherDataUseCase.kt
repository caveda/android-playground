package com.victorcaveda.domain.useCase

import com.victorcaveda.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double) =
        weatherRepository.getWeather(latitude, longitude)
}