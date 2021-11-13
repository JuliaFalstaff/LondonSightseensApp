package com.example.londonsightseensapp.model.data.placeinfo

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Preview(
    @SerializedName("source")
    @Expose
    val source: String,
    @SerializedName("height")
    @Expose
    val height: Int,
    @SerializedName("width")
    @Expose
    val width: Int
) : Parcelable