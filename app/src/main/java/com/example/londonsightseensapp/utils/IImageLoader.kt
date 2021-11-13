package com.example.londonsightseensapp.utils

interface IImageLoader<T> {
    fun loadInto(url: String?, container: T)
}