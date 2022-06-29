package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.model.favouriteplaces.IRoomFavouriteListPlaces
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.view.FavPlacesItemView
import com.example.londonsightseensapp.view.IFavouritePlacesListPresenter
import com.example.londonsightseensapp.view.IFavouriteView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject

class FavouritePlacesPresenter() :
        MvpPresenter<IFavouriteView>() {

    @Inject
    lateinit var place: IRoomFavouriteListPlaces

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screen: IScreens

    class FavouritePlacesListPresenter : IFavouritePlacesListPresenter {
        val favPlacesList = mutableListOf<RoomFavouritePlace>()

        override var itemClickListener: ((FavPlacesItemView) -> Unit)? = null

        override fun bindView(view: FavPlacesItemView) {
            val place = favPlacesList[view.positionItem]
            view.setName(place.name.toString())
            view.setKind(place.kinds.toString())
            view.setAddress(place.address.city.toString())
        }

        override fun getCount(): Int = favPlacesList.size
    }

    var favPlacesListPresenter = FavouritePlacesListPresenter()
    private var disposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        getAllFavouritePlaces()

//        favPlacesListPresenter.itemClickListener = { place ->
//            openPlaceInfo(place)
//        }
    }

    private fun getAllFavouritePlaces() {
        disposable.addAll(place.getAllFavouriteListPlaces()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            viewState.showProgressBar()
                            favPlacesListPresenter.favPlacesList.clear()
                            favPlacesListPresenter.favPlacesList.addAll(it)
                            viewState.updateList()
                            viewState.hideProgressBar()
                        },
                        { error ->
                            viewState.hideProgressBar()
                            viewState.showError(error)
                        }
                ))
    }

//    private fun openPlaceInfo(place: FavPlacesItemView) {
//        router.navigateTo(screen.favouritePlace(favPlacesListPresenter.favPlacesList[place.positionItem]))
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