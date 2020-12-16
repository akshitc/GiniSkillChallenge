package com.akshit.catpicker

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import com.akshit.catpicker.ui.CatGalleryActivity

object CatPicker {

    var config: CatPickerConfig? = null
    var onSuccessListener: OnSuccessListener? = null

    fun start(
        context: Context,
        config: CatPickerConfig,
        onSuccessListener: OnSuccessListener? = null
    ) {
        this.config = config
        this.onSuccessListener = onSuccessListener
        context.startActivity(Intent(context, CatGalleryActivity::class.java))
    }
}

fun interface OnSuccessListener {
    fun onSuccess(bitmap: Bitmap)
}
