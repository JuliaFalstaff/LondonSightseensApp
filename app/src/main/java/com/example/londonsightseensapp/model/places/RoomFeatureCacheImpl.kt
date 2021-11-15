package com.example.londonsightseensapp.model.places

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.dataDTO.places.FeaturesList
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.cache.RoomFeature
import com.example.londonsightseensapp.model.room.cache.RoomFeatureList

class RoomFeatureCacheImpl(private val db: DataBaseApp) : IRoomFeatureCache {
    override fun saveToDB(features: FeaturesList) {

         db.featureListDAO.insertFeatureList(RoomFeatureList(0,features.features))
    }

    override fun getFeaturesList(): FeaturesList {
        var featureList = db.featureListDAO.getAll()
        return FeaturesList((featureList.features))
    }
}

//    override fun getFeaturesList(): List<Feature> {
//        var featureList = db.featureDAO.getAll().map {
//            Feature(it.type, it.id, it.properties)
//        }
//        //не понимаю как тут все это вернуть в FeatureList вместо List<Features>
//    }



//    override fun getFeaturesList(): List<Feature> = db.featureDAO.getAll().map{ feature ->
//        Feature(feature.type, feature.id, feature.properties)
//    }
