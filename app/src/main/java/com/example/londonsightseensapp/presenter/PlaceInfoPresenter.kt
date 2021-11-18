package com.example.londonsightseensapp.presenter

import android.util.Log
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.placeinfo.IPlaceInfo
import com.example.londonsightseensapp.view.PlacesInfoView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject


class PlaceInfoPresenter(
        val place: Feature?,
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
        place?.let { viewState.showRating(it.properties.rate.toString()) }
        place?.let { viewState.showName(it.properties.name) }
    }

    private fun loadInfo() {
        disposable.add(place?.let { it ->
            placeInfo.loadPlaceInfo(it).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { detailedInfo ->
                                detailedInfo.wikipediaExtracts.textDescription.let { viewState.showDescription(it) }
                                detailedInfo.preview.source?.let { viewState.showImage(it) }
                                detailedInfo.wikipediaExtracts.textDescription?.let { viewState.showDescription(it) }
                                detailedInfo.address.road?.let { viewState.showRoad(it) }
                                detailedInfo.address.stateDistrict?.let { viewState.showState(it) }
                                detailedInfo.address.suburb.let { viewState.showSuburb(it) }
                                detailedInfo.address.city.let { viewState.showCity(it) }
                                detailedInfo.otm.let { viewState.openTripMap(it) }
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