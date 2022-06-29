package com.example.londonsightseensapp.model.favouriteplaces

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import io.reactivex.rxjava3.core.Single

interface IRoomFavouriteListPlaces {
    fun getAllFavouriteListPlaces(): Single<List<RoomFavouritePlace>>
}