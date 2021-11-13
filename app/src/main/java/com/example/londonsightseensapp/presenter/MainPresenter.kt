package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.IMainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.places())
    }

    fun backClicked() {
        router.exit()
    }
}