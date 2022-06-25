package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IPlaceInfo {
    fun loadPlaceInfo(featureId: Feature?): Single<Place>
    fun savePlaceToFavourite(place: Place, featureId: Feature?) : Completable
}