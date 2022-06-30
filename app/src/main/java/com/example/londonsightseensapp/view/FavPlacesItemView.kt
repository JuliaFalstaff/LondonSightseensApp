package com.example.londonsightseensapp.view


interface FavPlacesItemView: IItemView {
    fun setName(name: String)
    fun setKind(kind: String)
    fun setAddress(address: String)
    fun setDescription(address: String)
    fun setIcon()
    fun setNoFavIcon()
    fun showImage(imageUrl: String?)
    fun setClickIcon(place: FavPlacesItemView)
}