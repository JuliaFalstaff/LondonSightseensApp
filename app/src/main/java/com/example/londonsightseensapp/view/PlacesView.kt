package com.example.londonsightseensapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PlacesView : MvpView {
    fun init()
    fun updateList()
    fun showError(error: Throwable)
}