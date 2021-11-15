package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.BuildConfig
import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.network.INetworkState
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlaceInfoImpl(val api: RetrofitApi,
                    val networkStatus: INetworkState,
                    val db: IRoomPlaceCache
) : IPlaceInfo {
    companion object {
        const val API_KEY = BuildConfig.TRIP_MAP_API_KEY
    }

    override fun loadPlaceInfo(featureId: Feature): Single<Place> = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            featureId.properties.xid.let { id ->
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

//    override fun loadPlaceInfo(placeId: String): Single<Place> = api.loadPlaceInfo(placeId, API_KEY).subscribeOn(Schedulers.io())
}