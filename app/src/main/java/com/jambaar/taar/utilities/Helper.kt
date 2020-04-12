package com.jambaar.taar.utilities

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Glide.showImage(imageUri: String, imageView: ImageView) {
    Glide.with(context)
        .load(imageUri)
        .fitCenter()
        .into(imageView)
}
