package com.azimjonc.projects.whatsup.app

import android.app.Application
import com.azimjonc.projects.whatsup.di.localModule
import com.azimjonc.projects.whatsup.di.remoteModule
import com.azimjonc.projects.whatsup.di.repositoryModule
import com.azimjonc.projects.whatsup.di.usecaseModule
import com.azimjonc.projects.whatsup.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(repositoryModule, usecaseModule, localModule, remoteModule, viewModelModule)
        }
    }
}