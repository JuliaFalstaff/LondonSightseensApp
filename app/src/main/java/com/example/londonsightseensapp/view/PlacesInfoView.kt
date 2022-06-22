package com.example.londonsightseensapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PlacesInfoView : MvpView {
    fun showDescription(description: String)
    fun showName(name: String?)
    fun showCity(city: String?)
    fun showImage(imageUrl: String?)
    fun showError(error: Throwable)
    fun showState(state: String?)
    fun showRoad(road: String?)
    fun showSuburb(suburb: String?)
    fun showRating(rate: String?)
    fun openTripMap(url: String?)
    fun showProgressBar()
    fun hideProgressBar()
}