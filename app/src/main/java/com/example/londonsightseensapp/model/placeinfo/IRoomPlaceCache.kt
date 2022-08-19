package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import io.reactivex.rxjava3.core.Single

interface IRoomPlaceCache {
    fun saveToDB(place: Place, featureId: Feature?)
    fun saveToFavDB(place: Place, featureId: Feature?)
    fun getPlace(feature: Feature?): Place
    fun getFavData(place: Place, featureId: Feature?): RoomFavouritePlace
    fun delete(place: Place, featureId: Feature?)
}