package com.example.londonsightseensapp.model.dataDTO.placeinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    @SerializedName("city")
    @Expose
    val city: String? = "",
    @SerializedName("road")
    @Expose
    val road: String? = "",
    @SerializedName("state")
    @Expose
    val state: String? = "",
    @SerializedName("suburb")
    @Expose
    val suburb: String? = "",
    @SerializedName("country")
    @Expose
    val country: String? = "",

    @SerializedName("state_district")
    @Expose
    val stateDistrict: String? = ""
) : Parcelable