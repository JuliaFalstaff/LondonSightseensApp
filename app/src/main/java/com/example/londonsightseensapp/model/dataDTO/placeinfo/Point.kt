package com.example.londonsightseensapp.model.dataDTO.placeinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Point(
        @SerializedName("lon")
        @Expose
        val lon: Double,
        @SerializedName("lat")
        @Expose
        val lat: Double,
) : Parcelable
