package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList

class RoomFeatureCacheImpl(private val db: DataBaseApp) : IRoomFeatureCache {
    override fun saveToDB(features: FeaturesList) {

        db.featureListDAO.insertFeatureList(RoomFeatureList(0, features.features))
    }

    override fun getFeaturesList(): FeaturesList {
        var featureList = db.featureListDAO.getAll()
        return FeaturesList((featureList.features))
    }
}
