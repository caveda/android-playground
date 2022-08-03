package com.victorcaveda.data.mapper

import com.victorcaveda.data.model.HourlyUnits
import com.victorcaveda.data.model.WeatherData
import com.victorcaveda.data.model.WeatherDto
import com.victorcaveda.domain.model.WeatherInfo
import com.victorcaveda.domain.model.WeatherInstant
import com.victorcaveda.domain.model.WeatherUnits
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun WeatherDto.toDomain(): WeatherInfo {
    val forecast = data.toDomain()
    val now = LocalDateTime.now()
    val current = forecast.get(now.format(DateTimeFormatter.ISO_LOCAL_DATE))?.let { w ->
        w.findLast {
            it.time < now
        }
    }
    return WeatherInfo(
        units = hourlyUnits.toDomain(),
        forecast = forecast,
        current = current ?: forecast.toList().first().second.first()
    )
}

fun HourlyUnits.toDomain() = WeatherUnits(
    pressure = pressure,
    humidity = humidity,
    temperature = temperature,
    windspeed = windspeed
)

fun WeatherData.toDomain(): Map<String, List<WeatherInstant>> {
    return time.mapIndexed() { index, time ->
        val timeInstant = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME)
        WeatherInstant(
            time = timeInstant,
            pressure = pressures[index],
            humidity = humidities[index],
            code = codes[index],
            windspeed = windspeeds[index],
            temperature = temperatures[index]
        )
    }.groupBy {
        it.time.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }
}