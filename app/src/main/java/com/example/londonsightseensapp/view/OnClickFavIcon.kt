package com.example.londonsightseensapp.view

import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace

interface OnClickFavIcon {
    fun deleteFromFav(place: RoomFavouritePlace)
}