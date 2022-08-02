package com.victorcaveda.playground

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.domain.model.WeatherInfo
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import com.victorcaveda.domain.useCase.GetCurrentLocation
import com.victorcaveda.domain.useCase.GetWeatherDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAirQualityDataUseCase: GetAirQualityDataUseCase,
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val getCurrentLocation: GetCurrentLocation
) : ViewModel() {

    private val _uiState = MutableStateFlow<WeatherInfo?>(null)
    val uiState: StateFlow<WeatherInfo?> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val location = getCurrentLocation()
            getWeatherDataUseCase(location.lat, location.lon).fold(
                { weather -> _uiState.value = weather },
                { error -> error.message?.let { Log.d("Weather", it) } }
            )
        }
    }
}