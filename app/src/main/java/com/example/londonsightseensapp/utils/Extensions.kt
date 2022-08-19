package com.example.londonsightseensapp.utils

import com.example.londonsightseensapp.model.dataDTO.placeinfo.Place
import com.example.londonsightseensapp.model.room.cache.RoomFavouritePlace

fun String.convertToReadable(text: String): String {
    return text.replace("_", " ", true)
        .replace(",", ", ", true)
}

fun convertFavPlaceToPlaceDTO(favPlace: RoomFavouritePlace): Place {
    return Place(
        favPlace.xid,
        favPlace.name,
        favPlace.address,
        favPlace.kinds,
        favPlace.otm,
        favPlace.wikipediaUrl,
        favPlace.image,
        favPlace.preview,
        favPlace.wikipediaExtracts,
        favPlace.point
    )
}