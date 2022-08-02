package com.victorcaveda.data.di

import com.victorcaveda.data.remote.meteo.MeteoDataSource
import com.victorcaveda.data.remote.openWeather.OpenWeatherDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class DataModule {

    companion object {
        const val NETWORK_REQUEST_TIMEOUT_SECONDS = 15L
        const val OPENWEATHER_BASE_URL = "https://api.openweathermap.org/"
        const val METEO_BASE_URL = "https://api.open-meteo.com/"
    }

    @Provides
    fun provideOpenWeatherDataSource(): OpenWeatherDataSource =
        Retrofit.Builder()
            .client(getOkHttpClient())
            .baseUrl(OPENWEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherDataSource::class.java)

    @Provides
    fun provideMeteoDataSource(): MeteoDataSource =
        Retrofit.Builder()
            .client(getOkHttpClient())
            .baseUrl(METEO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MeteoDataSource::class.java)

    private fun getOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
}