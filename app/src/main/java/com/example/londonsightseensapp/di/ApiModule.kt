package com.example.londonsightseensapp.di

import com.example.londonsightseensapp.App
import com.example.londonsightseensapp.model.retrofit.RetrofitApi
import com.example.londonsightseensapp.network.AndroidNetworkStatus
import com.example.londonsightseensapp.network.INetworkState
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @NameBaseUrl
    @Provides
    fun baseUrl(): String = "https://api.opentripmap.com/0.1/"

    @Provides
    fun api(@NameBaseUrl baseUrl: String): RetrofitApi = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(RetrofitApi::class.java)

    @Singleton
    @Provides
    fun networkStatus(app: App): INetworkState = AndroidNetworkStatus(app)

}