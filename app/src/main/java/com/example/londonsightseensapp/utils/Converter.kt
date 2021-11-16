package com.example.londonsightseensapp.utils

import androidx.room.TypeConverter
import com.example.londonsightseensapp.model.dataDTO.places.Feature
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converter {
    private val gson = Gson()
    @TypeConverter
    fun toJson(segments: List<Feature?>?): String {
        return gson.toJson(segments)
    }

    @TypeConverter
    fun formJson(json: String?): List<Feature> {
        return gson.fromJson<List<Feature>>(
            json,
            object : TypeToken<List<Feature?>?>() {}.type
        )
    }
}