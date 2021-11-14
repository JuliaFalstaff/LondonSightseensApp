package com.example.londonsightseensapp.network

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetworkState {
    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}