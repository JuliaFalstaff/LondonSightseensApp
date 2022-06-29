package com.example.londonsightseensapp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IFavouriteView: MvpView {
    fun init()
    fun updateList()
    fun showError(error: Throwable)
    fun showProgressBar()
    fun hideProgressBar()
}