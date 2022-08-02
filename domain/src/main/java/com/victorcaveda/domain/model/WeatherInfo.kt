package com.victorcaveda.domain.model

import java.time.LocalDateTime

data class WeatherInfo(
    val current: WeatherInstant,
    val forecast: Map<String, List<WeatherInstant>>,
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
    val code: UInt,
    val windspeed: Double,
    val humidity: Double
)
