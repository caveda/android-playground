package com.victorcaveda.data.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.victorcaveda.data.remote.meteo.MeteoDataSource
import com.victorcaveda.data.remote.openWeather.OpenWeatherDataSource
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class DataModule {

    companion object {
        const val NETWORK_REQUEST_TIMEOUT_SECONDS = 15L
        const val OPENWEATHER_BASE_URL = "https://api.openweathermap.org/"
        const val METEO_BASE_URL = "https://api.open-meteo.com/"
    }

    private val okHttpClient: OkHttpClient by lazy {
        buildOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideOpenWeatherDataSource(): OpenWeatherDataSource =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(OPENWEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherDataSource::class.java)

    @Provides
    @Singleton
    fun provideMeteoDataSource(): MeteoDataSource =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(METEO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MeteoDataSource::class.java)

    @Provides
    @Singleton
    fun provideFuseLocationProviderClient(app: Application): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(app)

    fun buildOkHttpClient() =
        OkHttpClient.Builder()
            .connectTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_REQUEST_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
}