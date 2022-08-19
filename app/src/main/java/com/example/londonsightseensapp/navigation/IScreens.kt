package com.example.londonsightseensapp.navigation

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun places(): Screen
    fun placesInfo(place: Feature): Screen
    fun favouritePlace(): Screen
}

