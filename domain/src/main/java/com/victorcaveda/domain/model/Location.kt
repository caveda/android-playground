package com.victorcaveda.domain.model

data class Location(
    val lat: Double,
    val lon: Double
) {
    companion object {
        val DEFAULT_LOCATION = Location(40.420177, -3.703928)
    }
}

