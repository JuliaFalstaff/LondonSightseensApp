package com.example.londonsightseensapp.presenter

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.favouriteplaces.IRoomFavouriteListPlaces
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace
import com.example.londonsightseensapp.navigation.IScreens
import com.example.londonsightseensapp.utils.convertFavPlaceToPlaceDTO
import com.example.londonsightseensapp.view.FavPlacesItemView
import com.example.londonsightseensapp.view.IFavouritePlacesListPresenter
import com.example.londonsightseensapp.view.IFavouriteView
import com.example.londonsightseensapp.view.OnClickFavIcon
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

        override var itemClickListener: OnClickFavIcon? = null

        override fun bindView(view: FavPlacesItemView) {
            val place = favPlacesList[view.positionItem]
            view.setName(place.name.toString())
            view.setKind(place.kinds.toString())
            view.setAddress(place.address.city.toString())
            view.setDescription(place.wikipediaExtracts.textDescription)
            view.showImage(place.preview.source)
            view.setIcon()
            view.deleteFav(place)
        }

        override fun getCount(): Int = favPlacesList.size
    }

    var favPlacesListPresenter = FavouritePlacesListPresenter()
    private var disposable = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        getAllFavouritePlaces()
        favPlacesListPresenter.itemClickListener = object : OnClickFavIcon {
            override fun deleteFromFav(place: RoomFavouritePlace) {
                viewState.deleteFromFav(place)
            }
        }
    }

    fun deletePlaceFromFavourite(placeFav: RoomFavouritePlace) {
        disposable.add(place.deleteFavouritePlace(placeFav).observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showSuccessDeleteToast()
                }, {
                    viewState.showErrorDeleteToast(it)
                }
            ))
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

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}