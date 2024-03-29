package com.example.londonsightseensapp.model.dataDTO.placeinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WikipediaExtracts(
        @SerializedName("title")
        @Expose
        val title: String,
        @SerializedName("text")
        @Expose
        val textDescription: String,
        @SerializedName("html")
        @Expose
        val html: String,
) : Parcelable
