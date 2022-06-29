package com.example.londonsightseensapp.view

interface FavPlacesItemView: IItemView {
    fun setName(name: String)
    fun setKind(kind: String)
    fun setAddress(address: String)
}