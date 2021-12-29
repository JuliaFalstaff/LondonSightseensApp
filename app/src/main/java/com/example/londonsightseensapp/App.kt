package com.example.londonsightseensapp

import android.app.Application
import com.example.londonsightseensapp.di.AppComponent
import com.example.londonsightseensapp.di.AppModule
import com.example.londonsightseensapp.di.DaggerAppComponent
import com.facebook.stetho.Stetho

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        Stetho.initializeWithDefaults(this)
    }
}