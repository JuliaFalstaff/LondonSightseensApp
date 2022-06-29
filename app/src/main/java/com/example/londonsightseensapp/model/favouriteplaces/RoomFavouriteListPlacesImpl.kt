package com.example.londonsightseensapp.model.favouriteplaces

import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RoomFavouriteListPlacesImpl(private val db: DataBaseApp): IRoomFavouriteListPlaces {

    override fun getAllFavouriteListPlaces(): Single<List<RoomFavouritePlace>> {
        return Single.fromCallable {
            db.placeDAO.getAllFavourites()
        }.subscribeOn(Schedulers.io())
    }
}