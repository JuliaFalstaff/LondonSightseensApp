package com.example.londonsightseensapp.model.room

import androidx.annotation.NonNull
import androidx.room.*
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Address
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Point
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Preview
import com.example.londonsightseensapp.model.dataDTO.placeinfo.WikipediaExtracts

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomFeature::class,
        parentColumns = ["id"],
        childColumns = ["placeUid"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class RoomPlace(
    @PrimaryKey @NonNull
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
    val placeUid: String?
    )
