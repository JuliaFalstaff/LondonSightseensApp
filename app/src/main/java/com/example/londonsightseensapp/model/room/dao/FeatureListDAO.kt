package com.example.londonsightseensapp.model.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList
import io.reactivex.rxjava3.core.Single

@Dao
interface FeatureListDAO {
    @Insert
    fun insertFeature(features: RoomFeatureList)

    @Insert
    fun insertFeatureList(features: RoomFeatureList)

    @Query("SELECT * FROM  feature_list")
    fun getAll() : RoomFeatureList

//
//    @Query(value = "SELECT * FROM feature WHERE id = :id")
//    fun findById(id: String): Feature


}