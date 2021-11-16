package com.example.londonsightseensapp.model.room.cache

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.londonsightseensapp.model.dataDTO.places.Properties

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomFeatureList::class,
        parentColumns = ["id"],
        childColumns = ["featuredIdList"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomFeature(
    val type: String,
    @PrimaryKey
    val id: String,
    @Embedded
    val properties: Properties,
    val featuredIdList: Int
)