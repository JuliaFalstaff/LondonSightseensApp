package com.example.londonsightseensapp.di

import com.example.londonsightseensapp.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {
    @Provides
    fun app(): App {
        return app
    }
}