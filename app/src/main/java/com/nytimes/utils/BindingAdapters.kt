package com.nytimes.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nytimes.R

/**
 * @author: MOHAMMAD MISBAH
 * @since: 16-Jul-2022
 * @sample: Technology Assessment for Android Role
 * Email Id: mohammadmisbahazmi@gmail.com
 * GitHub: https://github.com/misbahazmi
 * Expertise: Android||Java||Flutter
 */
// important code for loading image here
@BindingAdapter("cover")
fun loadImage(imageView: ImageView, imageURL: String?) {
    Glide.with(imageView.context)
        .setDefaultRequestOptions(RequestOptions())
        .load(imageURL)
        .circleCrop()
        .placeholder(R.drawable.ic_image_default)
        .into(imageView)
}

@BindingAdapter("banner")
fun loadBanner(imageView: ImageView, imageURL: String?) {
    Glide.with(imageView.context)
        .setDefaultRequestOptions(RequestOptions())
        .load(imageURL)
        .placeholder(R.drawable.ic_image_banner_def)
        .into(imageView)
}