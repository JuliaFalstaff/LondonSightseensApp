package com.example.londonsightseensapp.model.retrofit


import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {

    @GET("ru/places/bbox")
    fun loadSights(
        @Query("lon_min") lonMin: Double,
        @Query("lon_max") lonMax: Double,
        @Query("lat_min") latMin: Double,
        @Query("lat_max") latMax: Double,
        @Query("apikey") apiKey: String
    ): Single<FeaturesList>

    @GET("ru/places/xid/{xid}")
    fun loadPlaceInfo(
            @Path("xid") xid: String?,
            @Query("apikey") apiKey: String
    ): Single<Place>
}


