package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.dataDTO.places.Feature

interface IRoomFeatureCache {
    fun saveToDB(features: List<Feature>)
    fun getFeaturesList(): List<Feature>
}