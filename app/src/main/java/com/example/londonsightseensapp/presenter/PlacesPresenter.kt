package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.places.IPlacesRepo
import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.IPlacesListPresenter
import com.example.londonsightseensapp.view.PlacesItemView
import com.example.londonsightseensapp.view.PlacesView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class PlacesPresenter(val place: IPlacesRepo, val router: Router, val screen: IScreens) : MvpPresenter<PlacesView>() {

    class PlacesListPresenter : IPlacesListPresenter {
        val placesList = mutableListOf<Feature>()

        override var itemClickListener: ((PlacesItemView) -> Unit)? = null

        override fun bindView(view: PlacesItemView) {
            val place = placesList[view.positionItem]
            view.setName(place.properties.name)
        }

        override fun getCount(): Int = placesList.size
    }

    var placesListPresenter = PlacesListPresenter()
    private var disposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        placesListPresenter.itemClickListener = { place ->
            openPlaceInfo(place)
        }
    }

    private fun loadData() {

        disposable.addAll(place.loadPlacesByGeoParams()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { repos ->
                    placesListPresenter.placesList.clear()
                    placesListPresenter.placesList.addAll(repos.features)
                    viewState.updateList()
                },
                { error -> viewState.showError(error) }
            ))
    }

    private fun openPlaceInfo(place: PlacesItemView) {
        router.navigateTo(screen.placesInfo( placesListPresenter.placesList[place.positionItem]))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}