package com.victorcaveda.playground.model

data class WeatherState(
    val weatherData: WeatherScreenData? = null,
    val isLoading: Boolean = false,
    val error: WeatherStateError? = null
)
