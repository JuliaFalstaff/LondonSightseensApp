package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.example.londonsightseensapp.model.placeinfo.IPlaceInfo
import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.PlacesInfoView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter


class PlaceInfoPresenter(val place: Feature?, val placeInfo: IPlaceInfo, val router: Router, val screen: IScreens) :
        MvpPresenter<PlacesInfoView>() {

    private var disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadInfo()
    }

    private fun loadInfo() {
        disposable.add(place?.let {
            placeInfo.loadPlaceInfo(it).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { detailedInfo ->
                        viewState.showName(detailedInfo.name)
                        viewState.showDescription(detailedInfo.wikipediaExtracts.textDescription)
                        viewState.showImage(detailedInfo.preview.source)
                    },
                    { error -> viewState.showError(error) }
                )
        })
    }


//
//    private fun loadInfo() {
//        disposable.add(place?.properties?.xid?.let {
//            placeInfo.loadPlaceInfo(place)
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(
//                            { detailedInfo ->
//                                viewState.showName(detailedInfo.name)
//                                viewState.showDescription(detailedInfo.wikipediaExtracts.textDescription)
//                                viewState.showImage(detailedInfo.preview.source)
//                            },
//                            { error -> viewState.showError(error) }
//                    )
//        })
//    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }


    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}