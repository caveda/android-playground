package com.victorcaveda.playground

import android.app.Application
import com.victorcaveda.playground.di.DaggerApplicationComponent


class PlaygroundApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
}