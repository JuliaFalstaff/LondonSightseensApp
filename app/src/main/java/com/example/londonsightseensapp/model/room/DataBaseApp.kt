package com.example.londonsightseensapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.londonsightseensapp.R
import com.example.londonsightseensapp.model.room.cache.RoomFeature
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList
import com.example.londonsightseensapp.model.room.cache.RoomPlace
import com.example.londonsightseensapp.model.room.dao.FeatureDAO
import com.example.londonsightseensapp.model.room.dao.FeatureListDAO
import com.example.londonsightseensapp.model.room.dao.PlaceDAO
import com.example.londonsightseensapp.utils.Converter

@Database(
    entities = [RoomFeatureList::class, RoomFeature::class, RoomPlace::class],
    version = 6,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class DataBaseApp : RoomDatabase() {

    abstract val placeDAO: PlaceDAO
    abstract val featureDAO: FeatureDAO
    abstract val featureListDAO: FeatureListDAO

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: DataBaseApp? = null
        fun getInstance() = instance
            ?: throw RuntimeException("Database has not been created. Please call create(context)")

        fun getDatabase(context: Context?): DataBaseApp {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(requireNotNull(context), DataBaseApp::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return requireNotNull(instance) { R.string.error_get_db.toString() }
        }
    }
}