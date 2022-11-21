package com.example.londonsightseensapp.model.dataDTO.placeinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
        @SerializedName("city")
        @Expose
        val city: String? = "Not found",
        @SerializedName("road")
        @Expose
        val road: String? = "Not found",
        @SerializedName("state")
        @Expose
        val state: String? = "Not found",
        @SerializedName("suburb")
        @Expose
        val suburb: String? = "Not found",
        @SerializedName("country")
        @Expose
        val country: String? = "Not found",

        @SerializedName("state_district")
        @Expose
        val stateDistrict: String? = "Not found",
) : Parcelable