package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.BuildConfig
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.network.INetworkState
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlaceInfoImpl(
    val api: RetrofitApi,
    val networkStatus: INetworkState,
    val db: IRoomPlaceCache,
) : IPlaceInfo {
    companion object {
        const val API_KEY = BuildConfig.TRIP_MAP_API_KEY
    }

    override fun loadPlaceInfo(featureId: Feature?): Single<Place> =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                featureId?.properties?.xid.let { id ->
                    api.loadPlaceInfo(id, API_KEY)
                        .flatMap { place ->
                            Single.fromCallable {
                                db.saveToDB(place, featureId)
                                place
                            }
                        }
                        .onErrorReturn {
                            db.getPlace(featureId)
                        }
                }
                    .subscribeOn(Schedulers.io())
            } else {
                Single.fromCallable {
                    db.getPlace(featureId)
                }
            }
        }.subscribeOn(Schedulers.io())

    override fun savePlaceToFavourite(place: Place, featureId: Feature?): Completable {
        return Completable.fromCallable {
            db.saveToFavDB(place, featureId)
        }.subscribeOn(Schedulers.io())
    }

    override fun getFavData(place: Place, featureId: Feature?): Single<RoomFavouritePlace> {
        return Single.fromCallable {
            db.getFavData(place, featureId)
        }.subscribeOn(Schedulers.io())
    }

    override fun delete(place: Place, featureId: Feature?): Completable {
        return Completable.fromCallable {
            db.delete(place, featureId)
        }.subscribeOn(Schedulers.io())
    }
}