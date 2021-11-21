package com.example.londonsightseensapp.model.dataDTO.placeinfo


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Place(
        @SerializedName("xid")
        @Expose
        val xid: String?,
        @SerializedName("name")
        @Expose
        val name: String?,
        @SerializedName("address")
        @Expose
        val address: Address,
        @SerializedName("kinds")
        @Expose
        val kinds: String?,
        @SerializedName("otm")
        @Expose
        val otm: String,
        @SerializedName("wikipedia")
        @Expose
        val wikipediaUrl: String,
        @SerializedName("image")
        @Expose
        val image: String,
        @SerializedName("preview")
        @Expose
        val preview: Preview,
        @SerializedName("wikipedia_extracts")
        @Expose
        val wikipediaExtracts: WikipediaExtracts,
        @SerializedName("point")
        @Expose
        val point: Point,
) : Parcelable
