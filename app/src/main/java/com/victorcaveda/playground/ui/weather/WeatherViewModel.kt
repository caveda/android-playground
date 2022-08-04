package com.victorcaveda.playground.ui.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.domain.useCase.GetCurrentLocationUseCase
import com.victorcaveda.domain.useCase.GetWeatherDataUseCase
import com.victorcaveda.playground.model.WeatherScreenData
import com.victorcaveda.playground.model.WeatherState
import com.victorcaveda.playground.model.WeatherStateError
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherData() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            getCurrentLocationUseCase()?.let { location ->
                getWeatherDataUseCase(location.lat, location.lon).fold(
                    { weather ->
                        state = state.copy(
                            isLoading = false,
                            error = null,
                            weatherData = WeatherScreenData(weather, location)
                        )
                    },
                    { error ->
                        state = state.copy(
                            isLoading = false,
                            error = WeatherStateError.GenericError(
                                error.message ?: "Unknown error"
                            ),
                            weatherData = null
                        )
                    }
                )
            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = WeatherStateError.LocationNotAvailableError,
                    weatherData = null
                )
            }
        }
    }
}