package com.example.londonsightseensapp.model.places


import com.example.londonsightseensapp.BuildConfig
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.network.INetworkState
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlacesRepoImpl(
    val api: RetrofitApi,
    val networkStatus: INetworkState,
    val db: IRoomFeatureCache
) : IPlacesRepo {

    companion object {
        const val API_KEY = BuildConfig.TRIP_MAP_API_KEY
        const val LON_MIN_LONDON: Double = -0.12574
        const val LON_MAX_LONDON: Double = -0.111302
        const val LAT_MIN_LONDON: Double = 51.50853
        const val LAT_MAX_LONDON: Double = 51.529515
    }

    override fun loadPlacesByGeoParams(): Single<List<Feature>> =
        networkStatus.isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    api.loadSights(
                        LON_MIN_LONDON,
                        LON_MAX_LONDON,
                        LAT_MIN_LONDON,
                        LAT_MAX_LONDON,
                        API_KEY
                    )
                        .flatMap { places ->
                            Single.fromCallable {
                                db.saveToDB(places)
                                places
                            }
                        }
                        .onErrorReturn {
                            db.getFeaturesList()
                        }
                } else {
                    Single.fromCallable {
                        db.getFeaturesList()
                    }
                }.subscribeOn(Schedulers.io())
            }
}