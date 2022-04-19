package com.victorcaveda.playground

import androidx.lifecycle.ViewModel
import com.victorcaveda.domain.model.Station
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAirQualityDataUseCase: GetAirQualityDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<Station>>(emptyList())
    val uiState: StateFlow<List<Station>> = _uiState


    init {
        loadData()
    }

    private fun loadData() {
        _uiState.value = getAirQualityDataUseCase()
    }
}