package com.example.londonsightseensapp.model.room.dao

import androidx.room.*
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.model.room.cache.RoomPlace

@Dao
interface PlaceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPLace(place: RoomPlace)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouritePLace(place: RoomFavouritePlace)

    @Delete
    fun deletePlace(place: RoomPlace)

    @Delete
    fun deleteFavPlace(place: RoomFavouritePlace)

    @Update
    fun updatePlace(place: RoomPlace)

    @Query("SELECT * FROM RoomPlace WHERE name = :placeName LIMIT 1")
    fun findByName(placeName: String): RoomPlace?

    @Query("SELECT * FROM RoomPlace WHERE xid = :featureXid LIMIT 1")
    fun findForPlaceByFeatureXiD(featureXid: String?): RoomPlace

    @Query("SELECT * FROM favourite_place WHERE xid = :featureXid LIMIT 1")
    fun findForFavPlaceByXiD(featureXid: String?): RoomFavouritePlace

    @Query("SELECT * FROM RoomPlace WHERE featureId = :featureId LIMIT 1")
    fun findForPlaceByUid(featureId: String?): RoomPlace
}