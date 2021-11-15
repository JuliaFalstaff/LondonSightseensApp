package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.cache.RoomFeature

class RoomFeatureCacheImpl(private val db: DataBaseApp) : IRoomFeatureCache {
    override fun saveToDB(features: List<Feature>) {
        val roomFeatures = features.map { feature ->
            RoomFeature(
                feature.type,
                feature.id,
                feature.properties
            )
        }
        db.featureDAO.insertAllFeatures(roomFeatures)
    }

    override fun getFeaturesList(): List<Feature> = db.featureDAO.getAll().map { feature ->
        Feature(feature.type, feature.id, feature.properties)
    }
}