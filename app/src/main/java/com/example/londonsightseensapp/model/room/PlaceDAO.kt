package com.example.londonsightseensapp.model.room

import androidx.room.*

@Dao
interface PlaceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPLace (place: RoomPlace)

    @Delete
    fun deletePlace(place: RoomPlace)

    @Update
    fun updatePlace (place: RoomPlace)

    @Query("SELECT * FROM RoomPlace WHERE xid = :placeId LIMIT 1")
    fun findById(placeId: String?) : RoomPlace

    @Query("SELECT * FROM RoomPlace WHERE name = :placeName LIMIT 1")
    fun findByName(placeName: String) : RoomPlace?

    @Query("SELECT * FROM RoomPlace WHERE placeUid = :uid LIMIT 1")
    fun findForPlace(uid: String?): RoomPlace
}