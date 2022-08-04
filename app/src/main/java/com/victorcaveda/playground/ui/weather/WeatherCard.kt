package com.victorcaveda.playground.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorcaveda.playground.R
import com.victorcaveda.playground.model.WeatherState
import com.victorcaveda.playground.model.WeatherUIType
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherData?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "[${data.location.lat} , ${data.location.lon}]",
                    )
                    Text(
                        text = data.weather.current.time.format(
                            DateTimeFormatter.ofPattern("MMM dd, HH:mm")
                        ),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = WeatherUIType.fromDomain(data.weather.current.code).image),
                    contentDescription = "weather icon",
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${data.weather.current.temperature} ${data.weather.units.temperature}",
                    fontSize = 50.sp,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = WeatherUIType.fromDomain(data.weather.current.code).description,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherParameterDisplay(
                        value = data.weather.current.pressure.toString(),
                        unit = data.weather.units.pressure,
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_pressure
                        )
                    )
                    WeatherParameterDisplay(
                        value = data.weather.current.humidity.toString(),
                        unit = data.weather.units.humidity,
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_drop
                        )
                    )
                    WeatherParameterDisplay(
                        value = data.weather.current.windspeed.toString(),
                        unit = data.weather.units.windspeed,
                        icon = ImageVector.vectorResource(
                            id = R.drawable.ic_wind
                        )
                    )
                }

            }
        }
    }
}