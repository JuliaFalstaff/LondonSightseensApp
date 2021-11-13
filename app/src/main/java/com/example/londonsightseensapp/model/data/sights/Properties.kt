package com.example.londonsightseensapp.model.data.sights

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Properties(

        @SerializedName("xid")
        @Expose
        val xid: String,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("rate")
        @Expose
        val rate: Int,

        @SerializedName("wikidata")
        @Expose
        val wikidata: String,

        @SerializedName("kinds")
        @Expose
        val kinds: String,
) : Parcelable
