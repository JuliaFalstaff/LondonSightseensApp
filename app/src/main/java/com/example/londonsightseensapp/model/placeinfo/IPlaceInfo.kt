package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.data.placeinfo.Place
import io.reactivex.rxjava3.core.Single

interface IPlaceInfo {
    fun loadPlaceInfo(placeId: String): Single<Place>
}