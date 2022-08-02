package com.victorcaveda.data.model

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("elevation")
    val elevation: Double,

    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,

    @SerializedName("hourly")
    val data: WeatherData,

    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,

    @SerializedName("latitude")
    val latitude: Double,

    @SerializedName("longitude")
    val longitude: Double,

    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int
)

data class WeatherData(
    @SerializedName("pressure_msl")
    val pressures: List<Double>,

    @SerializedName("relativehumidity_2m")
    val humidities: List<Double>,

    @SerializedName("temperature_2m")
    val temperatures: List<Double>,

    @SerializedName("time")
    val time: List<String>,

    @SerializedName("weathercode")
    val codes: List<UInt>,

    @SerializedName("windspeed_10m")
    val windspeeds: List<Double>
)

data class HourlyUnits(
    @SerializedName("pressure_msl")
    val pressure: String,

    @SerializedName("relativehumidity_2m")
    val humidity: String,

    @SerializedName("temperature_2m")
    val temperature: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("weathercode")
    val weatherCode: String,

    @SerializedName("windspeed_10m")
    val windspeed: String
)