package com.victorcaveda.data.di

import com.victorcaveda.data.repository.AirQualityRepositoryImpl
import com.victorcaveda.data.repository.WeatherRepositoryImpl
import com.victorcaveda.domain.repository.AirQualityRepository
import com.victorcaveda.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module

@Module
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAirQualityRepository(
        airQualityRepositoryImpl: AirQualityRepositoryImpl
    ): AirQualityRepository

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository
}