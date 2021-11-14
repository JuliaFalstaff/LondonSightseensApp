package com.example.londonsightseensapp.model.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.londonsightseensapp.model.dataDTO.places.Geometry
import com.example.londonsightseensapp.model.dataDTO.places.Properties
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class RoomFeature (
    val type: String,
    @PrimaryKey
    val id: String,
    @Ignore
    val geometry: Geometry,
    @Embedded
    val properties: Properties,
)