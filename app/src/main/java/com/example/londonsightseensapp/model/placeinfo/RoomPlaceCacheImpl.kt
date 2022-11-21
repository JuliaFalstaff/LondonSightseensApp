package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.model.room.cache.RoomPlace

class RoomPlaceCacheImpl(private val db: DataBaseApp) : IRoomPlaceCache {
    override fun saveToDB(place: Place, featureId: Feature?) {
        val roomFeature = featureId?.id.let { db.featureDAO.findById(it) }

        val roomPlace = RoomPlace(
            0,
            place.xid,
            place.name,
            place.address,
            place.kinds,
            place.otm,
            place.wikipediaUrl,
            place.image,
            place.preview,
            place.wikipediaExtracts,
            place.point,
            roomFeature?.id,
            false
        )
        db.placeDAO.insertPLace(roomPlace)
    }

    override fun saveToFavDB(place: Place, featureId: Feature?) {
        val roomFeature = featureId?.id.let { db.featureDAO.findById(it) }

        val roomFavPlace = RoomFavouritePlace(
            0,
            place.xid,
            place.name,
            place.address,
            place.kinds,
            place.otm,
            place.wikipediaUrl,
            place.image,
            place.preview,
            place.wikipediaExtracts,
            place.point,
            roomFeature?.id,
            true
        )
        db.placeDAO.insertFavouritePLace(roomFavPlace)
    }

    override fun getPlace(feature: Feature?): Place {
        val roomFeature = feature?.properties?.xid.let { db.placeDAO.findForPlaceByFeatureXiD(it) }
        return Place(
            roomFeature.xid,
            roomFeature.name,
            roomFeature.address,
            roomFeature.kinds,
            roomFeature.otm,
            roomFeature.wikipediaUrl,
            roomFeature.image,
            roomFeature.preview,
            roomFeature.wikipediaExtracts,
            roomFeature.point
        )
    }

    override fun getFavData(place: Place, featureId: Feature?): RoomFavouritePlace {
        val roomFeature = featureId?.properties?.xid.let { db.placeDAO.findForFavPlaceByXiD(it) }
        return RoomFavouritePlace(
            roomFeature.id,
            roomFeature.xid,
            roomFeature.name,
            roomFeature.address,
            roomFeature.kinds,
            roomFeature.otm,
            roomFeature.wikipediaUrl,
            roomFeature.image,
            roomFeature.preview,
            roomFeature.wikipediaExtracts,
            roomFeature.point,
            roomFeature.featureId,
            roomFeature.isFavourite
        )
    }

    override fun delete(place: Place, featureId: Feature?) {
        val roomFeature = featureId?.properties?.xid.let { db.placeDAO.findForFavPlaceByXiD(it) }
        val favRoom = RoomFavouritePlace(
            roomFeature.id,
            roomFeature.xid,
            roomFeature.name,
            roomFeature.address,
            roomFeature.kinds,
            roomFeature.otm,
            roomFeature.wikipediaUrl,
            roomFeature.image,
            roomFeature.preview,
            roomFeature.wikipediaExtracts,
            roomFeature.point,
            roomFeature.featureId,
            roomFeature.isFavourite
        )
        db.placeDAO.deleteFavPlace(favRoom)
    }
}