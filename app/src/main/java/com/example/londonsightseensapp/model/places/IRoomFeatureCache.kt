package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList

interface IRoomFeatureCache {
    fun saveToDB(features: FeaturesList)
    fun getFeaturesList(): FeaturesList
}