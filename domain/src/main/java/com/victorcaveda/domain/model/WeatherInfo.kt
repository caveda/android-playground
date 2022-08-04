package com.victorcaveda.domain.model

import java.time.LocalDateTime

typealias WeatherForecast = Map<String, List<WeatherInstant>>

data class WeatherInfo(
    val current: WeatherInstant,
    val forecast: WeatherForecast,
    val units: WeatherUnits
)

data class WeatherUnits(
    val temperature: String,
    val pressure: String,
    val windspeed: String,
    val humidity: String
)

data class WeatherInstant(
    val time: LocalDateTime,
    val temperature: Double,
    val pressure: Double,
    val code: Int,
    val windspeed: Double,
    val humidity: Double
)
