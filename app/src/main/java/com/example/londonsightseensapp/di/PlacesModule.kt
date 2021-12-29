package com.example.londonsightseensapp.di

import com.example.londonsightseensapp.model.places.IPlacesRepo
import com.example.londonsightseensapp.model.places.IRoomFeatureCache
import com.example.londonsightseensapp.model.places.PlacesRepoImpl
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.network.INetworkState
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PlacesModule {
    @Singleton
    @Provides
    fun loadPlacesByGeoParams(
            api: RetrofitApi,
            networkStatus: INetworkState,
            db: IRoomFeatureCache,
    ): IPlacesRepo = PlacesRepoImpl(api, networkStatus, db)
}