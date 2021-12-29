package com.example.londonsightseensapp.model.room.dao


import androidx.room.*
import com.example.londonsightseensapp.model.room.cache.RoomFeature

@Dao
interface FeatureDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFeature(feature: RoomFeature)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllFeatures(features: List<RoomFeature>)

    @Query("SELECT * FROM RoomFeature")
    fun getAll(): List<RoomFeature>

    @Delete
    fun deleteFeature(feature: RoomFeature)

    @Delete
    fun deleteFeatureList(features: List<RoomFeature>)

    @Update
    fun updateFeaturesList(features: List<RoomFeature>)

    @Update
    fun updateFeature(feature: RoomFeature)

    @Query("SELECT * FROM RoomFeature WHERE id = :featureId LIMIT 1")
    fun findById(featureId: String?): RoomFeature?

    @Query("SELECT * FROM RoomFeature WHERE xid = :featureXid LIMIT 1")
    fun findBuXidProperty(featureXid: String): RoomFeature?
}