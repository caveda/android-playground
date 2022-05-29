package com.victorcaveda.playground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victorcaveda.domain.model.Station
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAirQualityDataUseCase: GetAirQualityDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<Station>>(emptyList())
    val uiState: StateFlow<List<Station>> = _uiState


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = getAirQualityDataUseCase()
        }
    }
}