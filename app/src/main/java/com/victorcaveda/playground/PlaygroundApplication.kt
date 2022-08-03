package com.victorcaveda.playground

import android.app.Application
import com.victorcaveda.playground.di.ApplicationComponent
import com.victorcaveda.playground.di.DaggerApplicationComponent


class PlaygroundApplication : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}