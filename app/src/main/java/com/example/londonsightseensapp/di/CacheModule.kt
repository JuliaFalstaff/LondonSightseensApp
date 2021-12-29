package com.example.londonsightseensapp.di

import androidx.room.Room
import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.model.placeinfo.IRoomPlaceCache
import com.example.londonsightseensapp.model.placeinfo.RoomPlaceCacheImpl
import com.example.londonsightseensapp.model.places.IRoomFeatureCache
import com.example.londonsightseensapp.model.places.RoomFeatureCacheImpl
import com.example.londonsightseensapp.model.room.DataBaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App): DataBaseApp = Room.databaseBuilder(
            app,
            DataBaseApp::class.java,
            "database.db"
    )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun placesCache(database: DataBaseApp): IRoomFeatureCache =
            RoomFeatureCacheImpl(database)

    @Singleton
    @Provides
    fun placeInfoCache(database: DataBaseApp): IRoomPlaceCache =
            RoomPlaceCacheImpl(database)
}