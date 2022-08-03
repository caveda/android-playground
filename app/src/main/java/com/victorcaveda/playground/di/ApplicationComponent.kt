package com.victorcaveda.playground.di

import android.app.Application
import com.victorcaveda.data.di.DataModule
import com.victorcaveda.data.di.RepositoriesModule
import com.victorcaveda.playground.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class, RepositoriesModule::class])
@Singleton
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): ApplicationComponent
    }
}