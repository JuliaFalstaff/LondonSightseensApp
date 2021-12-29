package com.example.londonsightseensapp.view

interface PlacesItemView: IItemView {
    fun setName(name: String)
    fun setKind(kind: String)
    fun setRate(rate: Int)
}