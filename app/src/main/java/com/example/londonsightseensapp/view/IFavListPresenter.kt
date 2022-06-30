package com.example.londonsightseensapp.view

import com.example.londonsightseensapp.adapters.FavouritePlacesRVAdapter

interface IFavListPresenter<V : IItemView> {
    var itemClickListener: OnClickFavIcon?
    fun bindView(view: V)
    fun getCount(): Int
    fun deleteFromFav(view: V)
}