package com.example.londonsightseensapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

open class GlideImageLoader : IImageLoader<ImageView> {
    override fun loadInto(url: String?, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .transform(CircleCrop())
            .into(container)
    }
}