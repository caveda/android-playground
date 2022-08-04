package com.victorcaveda.playground.ui.weather

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorcaveda.domain.model.WeatherInstant
import com.victorcaveda.domain.model.WeatherUnits

@Composable
fun WeatherDayForecast(
    day: String,
    hourlyForecast: List<WeatherInstant>,
    units: WeatherUnits,
    modifier: Modifier = Modifier
) {

    Column(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
    {
        Text(
            text = day,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(content = {
            items(hourlyForecast) { hourData ->
                WeatherHourDisplay(
                    data = hourData,
                    units = units,
                    modifier = Modifier
                        .height(100.dp)
                        .padding(horizontal = 16.dp)
                )

            }
        })
    }
}