package com.example.londonsightseensapp.model.placeinfo

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.DataBaseApp
import com.example.londonsightseensapp.model.room.RoomPlace

class RoomPlaceCacheImpl(private val db: DataBaseApp) : IRoomPlaceCache {
    override fun saveToDB(place: Place, featureId: Feature?) {
        val roomFeature = featureId?.id.let { db.featureDAO.findById(it) }

        val roomPlace = RoomPlace(
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
            roomFeature?.id
        )
        db.placeDAO.insertPLace(roomPlace)
    }

    override fun getPlace(feature: Feature?): Place {
        val roomFeature = feature?.id.let { db.featureDAO.findById(it) }

        val roomPlace = db.placeDAO.findForPlace(roomFeature?.id)
        return Place (
            roomPlace.xid,
            roomPlace.name,
            roomPlace.address,
            roomPlace.kinds,
            roomPlace.otm,
            roomPlace.wikipediaUrl,
            roomPlace.image,
            roomPlace.preview,
            roomPlace.wikipediaExtracts,
            roomPlace.point,
)
    }
}



//
//override fun getRepositoriesList(user: GithubUser?): List<GithubRepository> {
//    val roomUser = user?.login?.let {
//        db.userDao.findByLogin(it)
//    } ?: throw RuntimeException(R.string.error_find_user.toString())
//
//    return db.repositoryDao.findForUser(roomUser.id)
//        .map {
//            GithubRepository(
//                it.id,
//                it.name,
//                it.forks_count,
//                it.html_url,
//                it.language,
//                it.url
//            )
//        }
