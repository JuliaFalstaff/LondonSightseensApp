package com.example.londonsightseensapp.di

import com.example.londonsightseensapp.model.placeinfo.IPlaceInfo
import com.example.londonsightseensapp.model.placeinfo.IRoomPlaceCache
import com.example.londonsightseensapp.model.placeinfo.PlaceInfoImpl
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.network.INetworkState
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PlacesInfoModule {

    @Singleton
    @Provides
    fun loadPlaceInfo(
            api: RetrofitApi,
            networkStatus: INetworkState,
            db: IRoomPlaceCache,
    ): IPlaceInfo = PlaceInfoImpl(api, networkStatus, db)
}