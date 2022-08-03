package com.victorcaveda.playground.model

import com.victorcaveda.domain.model.Location
import com.victorcaveda.domain.model.WeatherInfo

data class WeatherScreenData(
    val weather: WeatherInfo,
    val location: Location
)
