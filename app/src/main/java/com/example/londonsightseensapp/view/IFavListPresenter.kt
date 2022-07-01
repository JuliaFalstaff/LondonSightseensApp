package com.example.londonsightseensapp.view


interface IFavListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
    fun deleteFromFav(view: V)
    fun openTripMap(view: V)
}