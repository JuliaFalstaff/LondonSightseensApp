package com.example.londonsightseensapp.presenter

import android.util.Log
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.placeinfo.IPlaceInfo
import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.PlacesInfoView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject


class PlaceInfoPresenter(
    val place: Feature?
) :
    MvpPresenter<PlacesInfoView>() {

    @Inject
    lateinit var placeInfo: IPlaceInfo
    @Inject
    lateinit var router: Router

    private var disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadInfo()
        viewState.showRating(place?.properties?.rate.toString())
        viewState.showName(place?.properties?.name)
    }

    private fun loadInfo() {
        disposable.add(place?.let {
            placeInfo.loadPlaceInfo(it).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { detailedInfo ->
                        viewState.showDescription(detailedInfo.wikipediaExtracts.textDescription)
                        viewState.showImage(detailedInfo.preview.source)
                        viewState.showRoad(detailedInfo.address.road)
                        viewState.showState(detailedInfo.address.stateDistrict)
                        viewState.showSuburb(detailedInfo.address.suburb)
                        viewState.showCity(detailedInfo.address.city)
                        viewState.openTripMap(detailedInfo.otm)
                    },
                    { error ->
                        viewState.showError(error)
                        Log.e("RX", error.printStackTrace().toString())
                    }
                )
        })
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