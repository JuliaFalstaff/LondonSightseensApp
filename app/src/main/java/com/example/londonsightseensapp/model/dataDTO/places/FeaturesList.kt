package com.example.londonsightseensapp.model.dataDTO.places

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FeaturesList(
        @SerializedName("features")
        @Expose
        val features: List<Feature>,
) : Parcelable



