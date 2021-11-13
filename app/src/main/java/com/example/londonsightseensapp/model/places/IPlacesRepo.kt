package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.data.sights.FeaturesList

import io.reactivex.rxjava3.core.Single

interface IPlacesRepo {
    fun loadPlacesByGeoParams() : Single<FeaturesList>

}