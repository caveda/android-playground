package com.victorcaveda.data.di

import com.victorcaveda.data.repository.AirQualityRepositoryImpl
import com.victorcaveda.domain.repository.AirQualityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAirQualityRepository(
        airQualityRepositoryImpl: AirQualityRepositoryImpl
    ): AirQualityRepository
}