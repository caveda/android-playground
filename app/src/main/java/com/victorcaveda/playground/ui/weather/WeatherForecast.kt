package com.victorcaveda.playground.ui.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.victorcaveda.domain.model.WeatherForecast
import com.victorcaveda.domain.model.WeatherUnits

@Composable
fun WeatherForecast(
    forecast: WeatherForecast,
    units: WeatherUnits,
    modifier: Modifier = Modifier
) {
    val forecastList = remember(forecast) {
        forecast.keys zip forecast.values
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            items(forecastList) { item ->
                WeatherDayForecast(
                    day = item.first,
                    units = units,
                    hourlyForecast = item.second,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        })
}
