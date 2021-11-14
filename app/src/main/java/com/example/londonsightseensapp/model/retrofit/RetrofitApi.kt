package com.example.londonsightseensapp.model.retrofit


import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitApi {

    @GET("ru/places/bbox?lon_min=-0.12574&lon_max=-0.111302&lat_min=51.50853&lat_max=51.529515")
    fun loadSights(
            @Query("lon_min") lonMin: Double,
            @Query("lon_max") lonMax: Double,
            @Query("lat_min") latMin: Double,
            @Query("lat_max") latMax: Double,
            @Query("apikey") apiKey: String
    ) : Single<List<Feature>>

    @GET("ru/places/xid/{xid}")
    fun loadPlaceInfo(
        @Path("xid") xid: String,
        @Query("apikey") apiKey: String
    ) : Single<Place>
}


