package com.example.londonsightseensapp.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.londonsightseensapp.R

@Database (entities = [RoomFeature::class, RoomPlace::class], version = 2, exportSchema = false)
abstract class DataBaseApp : RoomDatabase() {

    abstract val placeDAO: PlaceDAO
    abstract val featureDAO: FeatureDAO

    companion object {
        private const val DB_NAME = "database.db"
        private var instance: DataBaseApp? = null
        fun getInstance() = instance ?: throw RuntimeException("Database has not been created. Please call create(context)")

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