package com.example.londonsightseensapp.model.favouriteplaces

import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IRoomFavouriteListPlaces {
    fun getAllFavouriteListPlaces(): Single<List<RoomFavouritePlace>>
    fun deleteFavouritePlace(place: RoomFavouritePlace): Completable
}