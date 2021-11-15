package com.example.londonsightseensapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PlacesInfoView : MvpView {
    fun showDescription(description: String)
    fun showName(name: String?)
    fun showAddress (address: String)
    fun showImage (imageUrl: String)
    fun showError(error: Throwable)
}