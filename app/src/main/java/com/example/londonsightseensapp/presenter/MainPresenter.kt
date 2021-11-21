package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.IMainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() : MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.places())
    }

    fun backClicked() {
        router.exit()
    }
}