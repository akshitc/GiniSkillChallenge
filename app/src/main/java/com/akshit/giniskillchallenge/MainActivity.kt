package com.akshit.giniskillchallenge

import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.akshit.catpicker.CatPicker
import com.akshit.catpicker.CatPickerConfig
import com.akshit.catpicker.OnSuccessListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnSuccessListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        start_button.setOnClickListener {
            CatPicker.start(this, CatPickerConfig(), this)
        }
    }

    override fun onSuccess(bitmap: Bitmap) {
        selected_cat_image.isVisible = true
        selected_cat_image.setImageBitmap(bitmap)
    }
}
