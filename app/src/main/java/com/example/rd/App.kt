package com.example.rd

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            val androidContext = androidContext(this@App)
            modules(appModule)
        }
    }
}