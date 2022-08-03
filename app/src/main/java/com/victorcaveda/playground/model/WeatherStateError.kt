package com.victorcaveda.playground.model

sealed class WeatherStateError(val message: String) {
    object LocationNotAvailableError :
        WeatherStateError("No location available. Please, grant permissions and enable GPS")

    class GenericError(errorMessage: String) : WeatherStateError(errorMessage)
}
