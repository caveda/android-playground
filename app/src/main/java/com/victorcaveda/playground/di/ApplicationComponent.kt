package com.victorcaveda.playground.di

import com.victorcaveda.data.di.AnalyticsModule
import com.victorcaveda.data.di.DataModule
import com.victorcaveda.domain.useCase.GetAirQualityDataUseCase
import com.victorcaveda.playground.MainActivity
import dagger.Component

@Component(modules = [DataModule::class, AnalyticsModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun getGetAirQualityDataUseCase(): GetAirQualityDataUseCase
}