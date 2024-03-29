package com.example.londonsightseensapp.navigation

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.ui.FavouritePlacesFragment
import com.example.londonsightseensapp.ui.PlaceInfoFragment
import com.example.londonsightseensapp.ui.PlacesFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {

    override fun places(): Screen {
        return FragmentScreen { PlacesFragment.newInstance() }
    }

    override fun placesInfo(place: Feature): Screen {
        return FragmentScreen { PlaceInfoFragment.newInstance(place) }
    }

    override fun favouritePlace(): Screen {
        return FragmentScreen { FavouritePlacesFragment.newInstance() }
    }
}