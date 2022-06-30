package com.example.londonsightseensapp.view

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace

interface FavPlacesItemView: IItemView {
    fun setName(name: String)
    fun setKind(kind: String)
    fun setAddress(address: String)
    fun setDescription(address: String)
    fun setIcon()
    fun showImage(imageUrl: String?)
    fun deleteFav(place: RoomFavouritePlace)
}