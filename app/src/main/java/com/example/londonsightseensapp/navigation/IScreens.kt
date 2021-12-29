package com.example.londonsightseensapp.navigation

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun places(): Screen
    fun placesInfo(place: Feature): Screen
}

