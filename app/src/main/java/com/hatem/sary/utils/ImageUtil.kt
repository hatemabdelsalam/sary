package com.hatem.sary.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageUtil {
    companion object {
        private const val TAG = "ImageUtil"

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadPicture(imageView: ImageView, url: String?) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}