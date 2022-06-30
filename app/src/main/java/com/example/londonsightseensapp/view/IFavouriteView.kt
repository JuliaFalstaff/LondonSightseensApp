package com.example.londonsightseensapp.view

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IFavouriteView: MvpView {
    fun init()
    fun updateList()
    fun showError(error: Throwable)
    fun showProgressBar()
    fun hideProgressBar()
    fun deleteFromFav(place: RoomFavouritePlace)
    fun showSuccessDeleteToast()
    fun showErrorDeleteToast(error: Throwable)
}