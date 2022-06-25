package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature

interface IRoomPlaceCache {
    fun saveToDB(place: Place, featureId: Feature?)
    fun saveToFavDB(place: Place, featureId: Feature?)
    fun getPlace(feature: Feature?): Place
}