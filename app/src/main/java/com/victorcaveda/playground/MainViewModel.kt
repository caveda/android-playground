package com.victorcaveda.playground

import androidx.lifecycle.ViewModel
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAirQualityDataUseCase: GetAirQualityDataUseCase
) : ViewModel() {
    val message = "Hilt ViewModel"
}