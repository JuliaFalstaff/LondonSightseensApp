package com.example.londonsightseensapp.model.places


import com.example.londonsightseensapp.BuildConfig
import com.example.londonsightseensapp.model.data.places.FeaturesList
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlacesRepoImpl(val api: RetrofitApi): IPlacesRepo {

    companion object {
        const val API_KEY = BuildConfig.TRIP_MAP_API_KEY
        const val LON_MIN_LONDON: Double = -0.12574
        const val LON_MAX_LONDON: Double = -0.111302
        const val LAT_MIN_LONDON: Double = 51.50853
        const val LAT_MAX_LONDON: Double = 51.529515
    }


    override fun loadPlacesByGeoParams(): Single<FeaturesList> =
        api
            .loadSights(LON_MIN_LONDON, LON_MAX_LONDON, LAT_MIN_LONDON, LAT_MAX_LONDON, API_KEY)
            .subscribeOn(Schedulers.io())
}

///ru/places/bbox?lon_min=-0.12574&lon_max=-0.111302&lat_min=51.50853&lat_max=51.529515&apikey=5ae2e3f221c38a28845f05b64f3414d1e25ff9d2003c4dc1b4e262e7