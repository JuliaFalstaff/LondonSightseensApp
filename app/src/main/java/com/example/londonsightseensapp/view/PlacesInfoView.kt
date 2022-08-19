package com.example.londonsightseensapp.view

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
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
    fun clickToFavouriteIcon()
    fun showSuccessSaveToast()
    fun showErrorSavingFav(error: Throwable)
    fun setFavIcon()
    fun setNotFavIcon()
    fun showSuccessDeleteToast()
    fun showErrorDeleteToast(error: Throwable)
}