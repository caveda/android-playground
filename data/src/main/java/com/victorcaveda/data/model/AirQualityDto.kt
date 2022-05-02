package com.victorcaveda.data.model

import com.google.gson.annotations.SerializedName

data class AirQualityDto(
    @SerializedName("coord")
    val location: Coordinate,
    @SerializedName("list")
    val values: List<Measure>
)

data class Coordinate(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double
)

data class Measure(
    @SerializedName("dt")
    val timeStamp: Long,
    @SerializedName("main")
    val main: MainIndex,
    @SerializedName("components")
    val components: Components,
)

data class MainIndex(
    @SerializedName("aqi")
    val qualityIndex: Int
)

data class Components(
    @SerializedName("co")
    val co: Double,
    @SerializedName("nh3")
    val nh3: Double,
    @SerializedName("no")
    val no: Double,
    @SerializedName("no2")
    val no2: Double,
    @SerializedName("o3")
    val o3: Double,
    @SerializedName("pm10")
    val pm10: Double,
    @SerializedName("pm2_5")
    val pm25: Double,
    @SerializedName("so2")
    val so2: Double
)