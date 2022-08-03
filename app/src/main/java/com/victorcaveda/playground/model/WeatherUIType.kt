package com.victorcaveda.playground.model

import androidx.annotation.DrawableRes
import com.victorcaveda.playground.R

sealed class WeatherUIType(
    val description: String,
    @DrawableRes val image: Int
) {
    object ClearSky : WeatherUIType(
        description = "Clear sky",
        image = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherUIType(
        description = "Mainly clear",
        image = R.drawable.ic_cloudy
    )

    object PartlyCloudy : WeatherUIType(
        description = "Partly cloudy",
        image = R.drawable.ic_cloudy
    )

    object Overcast : WeatherUIType(
        description = "Overcast",
        image = R.drawable.ic_cloudy
    )

    object Foggy : WeatherUIType(
        description = "Foggy",
        image = R.drawable.ic_very_cloudy
    )

    object DepositingRimeFog : WeatherUIType(
        description = "Depositing rime fog",
        image = R.drawable.ic_very_cloudy
    )

    object LightDrizzle : WeatherUIType(
        description = "Light drizzle",
        image = R.drawable.ic_rainshower
    )

    object ModerateDrizzle : WeatherUIType(
        description = "Moderate drizzle",
        image = R.drawable.ic_rainshower
    )

    object DenseDrizzle : WeatherUIType(
        description = "Dense drizzle",
        image = R.drawable.ic_rainshower
    )

    object LightFreezingDrizzle : WeatherUIType(
        description = "Slight freezing drizzle",
        image = R.drawable.ic_snowyrainy
    )

    object DenseFreezingDrizzle : WeatherUIType(
        description = "Dense freezing drizzle",
        image = R.drawable.ic_snowyrainy
    )

    object SlightRain : WeatherUIType(
        description = "Slight rain",
        image = R.drawable.ic_rainy
    )

    object ModerateRain : WeatherUIType(
        description = "Rainy",
        image = R.drawable.ic_rainy
    )

    object HeavyRain : WeatherUIType(
        description = "Heavy rain",
        image = R.drawable.ic_rainy
    )

    object HeavyFreezingRain : WeatherUIType(
        description = "Heavy freezing rain",
        image = R.drawable.ic_snowyrainy
    )

    object SlightSnowFall : WeatherUIType(
        description = "Slight snow fall",
        image = R.drawable.ic_snowy
    )

    object ModerateSnowFall : WeatherUIType(
        description = "Moderate snow fall",
        image = R.drawable.ic_heavysnow
    )

    object HeavySnowFall : WeatherUIType(
        description = "Heavy snow fall",
        image = R.drawable.ic_heavysnow
    )

    object SnowGrains : WeatherUIType(
        description = "Snow grains",
        image = R.drawable.ic_heavysnow
    )

    object SlightRainShowers : WeatherUIType(
        description = "Slight rain showers",
        image = R.drawable.ic_rainshower
    )

    object ModerateRainShowers : WeatherUIType(
        description = "Moderate rain showers",
        image = R.drawable.ic_rainshower
    )

    object ViolentRainShowers : WeatherUIType(
        description = "Violent rain showers",
        image = R.drawable.ic_rainshower
    )

    object SlightSnowShowers : WeatherUIType(
        description = "Light snow showers",
        image = R.drawable.ic_snowy
    )

    object HeavySnowShowers : WeatherUIType(
        description = "Heavy snow showers",
        image = R.drawable.ic_snowy
    )

    object ModerateThunderstorm : WeatherUIType(
        description = "Moderate thunderstorm",
        image = R.drawable.ic_thunder
    )

    object SlightHailThunderstorm : WeatherUIType(
        description = "Thunderstorm with slight hail",
        image = R.drawable.ic_rainythunder
    )

    object HeavyHailThunderstorm : WeatherUIType(
        description = "Thunderstorm with heavy hail",
        image = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromDomain(code: Int): WeatherUIType {
            return when (code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}