package com.example.londonsightseensapp.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.model.room.cache.RoomFeature
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList
import com.example.londonsightseensapp.model.room.cache.RoomPlace
import com.example.londonsightseensapp.model.room.dao.FeatureDAO
import com.example.londonsightseensapp.model.room.dao.FeatureListDAO
import com.example.londonsightseensapp.model.room.dao.PlaceDAO
import com.example.londonsightseensapp.utils.Converter

@Database(
        entities = [RoomFeatureList::class, RoomFeature::class, RoomPlace::class, RoomFavouritePlace::class],
        version = 8,
        exportSchema = false
)
@TypeConverters(Converter::class)
abstract class DataBaseApp : RoomDatabase() {

    abstract val placeDAO: PlaceDAO
    abstract val featureDAO: FeatureDAO
    abstract val featureListDAO: FeatureListDAO
}