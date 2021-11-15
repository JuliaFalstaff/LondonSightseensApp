package com.example.londonsightseensapp.model.room.cache

import androidx.room.*
import com.example.londonsightseensapp.model.dataDTO.places.Properties
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomFeatureList::class,
        parentColumns = ["id"],
        childColumns = ["featuredIdList"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomFeature (
    val type: String,
    @PrimaryKey
    val id: String,
    @Embedded
    val properties: Properties,
    val featuredIdList: Int
)