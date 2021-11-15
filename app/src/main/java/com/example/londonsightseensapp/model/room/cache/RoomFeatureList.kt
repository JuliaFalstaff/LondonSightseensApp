package com.example.londonsightseensapp.model.room.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import com.example.londonsightseensapp.model.room.converter.Converter

@Entity(tableName = "feature_list")
data class RoomFeatureList(
    @PrimaryKey(autoGenerate = true)
        val id: Int,
    @TypeConverters(Converter::class)
        val features: List<Feature>
)
