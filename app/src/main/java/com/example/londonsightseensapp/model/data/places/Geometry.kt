package com.example.londonsightseensapp.model.data.places

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geometry(
        @SerializedName("type")
        @Expose
        val type: String,
@SerializedName("coordinates")
@Expose
val coordinates: List<Double>
): Parcelable
