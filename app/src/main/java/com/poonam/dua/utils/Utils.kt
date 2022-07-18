package com.poonam.dua.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

object Utils {
    fun getDrawableInt(context: Context?, name: String?): Int {
        return context?.resources!!.getIdentifier(name, "drawable", context.packageName)
    }

    fun getResourceInt(context: Context?, defType: String, name: String): Int {
        return context?.resources!!.getIdentifier(name, defType, context.packageName)
    }

    fun setImageToImageView(context: Context, imageView: ImageView, drawable: Int) {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.NONE) // because file name is always same
            .skipMemoryCache(true)

        Glide.with(context)
            .load(drawable)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }
}