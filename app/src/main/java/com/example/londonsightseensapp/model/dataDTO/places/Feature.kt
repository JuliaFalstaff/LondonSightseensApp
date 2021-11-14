package com.example.londonsightseensapp.model.dataDTO.places

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Feature(
        @SerializedName("type")
        @Expose
        val type: String,
        @SerializedName("id")
        @Expose
        val id: String,
        @SerializedName("geometry")
        @Expose
        val geometry: Geometry,
        @SerializedName("properties")
        @Expose
        val properties: Properties,
):Parcelable

