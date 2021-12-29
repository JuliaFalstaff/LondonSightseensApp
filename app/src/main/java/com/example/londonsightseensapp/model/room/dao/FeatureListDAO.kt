package com.example.londonsightseensapp.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList

@Dao
interface FeatureListDAO {
    @Insert
    fun insertFeature(features: RoomFeatureList)

    @Insert
    fun insertFeatureList(features: RoomFeatureList)

    @Query("SELECT * FROM  feature_list")
    fun getAll(): RoomFeatureList
}