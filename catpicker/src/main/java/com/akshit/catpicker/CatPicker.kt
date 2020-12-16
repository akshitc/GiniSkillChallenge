package com.akshit.catpicker

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import com.akshit.catpicker.ui.CatGalleryActivity

object CatPicker {

    internal var config: CatPickerConfig? = null
    @JvmStatic
    var onSuccessListener: OnSuccessListener? = null

    /**
     * Use this method to start the CatPicker SDK
     * @param context Activity context
     * @param config A CatPickerConfig instance with required title, toolbar color and back icon
     * @param onSuccessListener Listener to get the selected image as bitmap
     */
    @JvmOverloads
    @JvmStatic
    fun start(
        context: Context,
        config: CatPickerConfig = CatPickerConfig(),
        onSuccessListener: OnSuccessListener? = null
    ) {
        this.config = config
        this.onSuccessListener = onSuccessListener
        context.startActivity(Intent(context, CatGalleryActivity::class.java))
    }
}

/**
 * Interface to be used to get the result of the selected image as bitmap back from SDK
 */
fun interface OnSuccessListener {
    fun onSuccess(bitmap: Bitmap)
}
