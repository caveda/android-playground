package com.victorcaveda.playground.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victorcaveda.domain.model.WeatherInstant
import com.victorcaveda.domain.model.WeatherUnits
import com.victorcaveda.playground.model.WeatherUIType
import java.time.format.DateTimeFormatter

@Composable
fun WeatherHourDisplay(
    data: WeatherInstant,
    units: WeatherUnits,
    modifier: Modifier = Modifier
) {
    val formattedTime = remember(data) {
        data.time.format(DateTimeFormatter.ofPattern("HH:mm"))
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = formattedTime,
            fontSize = 12.sp,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = WeatherUIType.fromDomain(data.code).image),
            contentDescription = "parameter image",
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = "${data.temperature}${units.temperature}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}