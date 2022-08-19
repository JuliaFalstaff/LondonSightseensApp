package com.example.londonsightseensapp.model.room.cache

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Address
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Point
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Preview
import com.example.londonsightseensapp.model.dataDTO.placeinfo.WikipediaExtracts

@Entity(
        foreignKeys = [ForeignKey(
                entity = RoomFeature::class,
                parentColumns = ["id"],
                childColumns = ["featureId"],
                onDelete = ForeignKey.CASCADE
        )]
)
data class RoomPlace(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val xid: String?,
        val name: String?,
        @Embedded
        val address: Address,
        val kinds: String?,
        val otm: String,
        val wikipediaUrl: String,
        val image: String,
        @Embedded
        val preview: Preview,
        @Embedded
        val wikipediaExtracts: WikipediaExtracts,
        @Embedded
        val point: Point,
        val featureId: String?,
        val isFavourite: Boolean
)
