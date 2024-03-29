package com.example.londonsightseensapp.model.dataDTO.places

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feature(
        @SerializedName("type")
        @Expose
        val type: String,
        @SerializedName("id")
        @Expose
        val id: String,
        @SerializedName("properties")
        @Expose
        val properties: Properties,
) : Parcelable

