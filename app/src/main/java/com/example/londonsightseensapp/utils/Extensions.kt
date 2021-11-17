package com.example.londonsightseensapp.utils

fun String.convertToReadable(text: String) : String {
    return text.replace("_", " ", true).replace("," , ", ", true)
}