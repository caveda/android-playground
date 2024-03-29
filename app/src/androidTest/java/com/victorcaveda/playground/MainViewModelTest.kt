package com.victorcaveda.playground

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.victorcaveda.data.model.*
import com.victorcaveda.data.remote.openWeather.OpenWeatherDataSource
import com.victorcaveda.data.repository.AirQualityRepositoryImpl
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import com.victorcaveda.playground.ui.weather.WeatherViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var sut: WeatherViewModel
    lateinit var useCase: GetAirQualityDataUseCase
    val weatherSource: OpenWeatherDataSource = mockk()

    @Before
    fun setup() {

        val repository = AirQualityRepositoryImpl(weatherSource)
        useCase = GetAirQualityDataUseCase(repository)
    }


    @Test
    fun getUiState() {
        // Arrange
        coEvery {
            weatherSource.getAirQuality(
                any(),
                any(),
                any()
            )
        } answers { AirQualityDto(firstArg(), secondArg()) }

        // Act
        sut = WeatherViewModel(useCase)

        // Assert
        val state = sut.weatherInfo.first()
        Assert.assertTrue(sut.weatherInfo.get)
        Assert.assertTrue(true)
    }

    private fun buildAirQualityDto(lat: String, len: String) =
        AirQualityDto(
            Coordinate(lat.toDouble(), len.toDouble()),
            listOf(Measure(0, MainIndex(4), Components(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1)))
        )
}