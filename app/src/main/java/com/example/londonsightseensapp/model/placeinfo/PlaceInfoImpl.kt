package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.BuildConfig
import com.example.londonsightseensapp.model.data.placeinfo.Place
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlaceInfoImpl(val api: RetrofitApi) : IPlaceInfo {
    companion object {
        const val API_KEY = BuildConfig.TRIP_MAP_API_KEY
    }

    override fun loadPlaceInfo(placeId: String): Single<Place> = api.loadPlaceInfo(placeId, API_KEY).subscribeOn(Schedulers.io())
}