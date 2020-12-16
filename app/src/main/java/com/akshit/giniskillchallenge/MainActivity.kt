package com.akshit.giniskillchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.akshit.catpicker.CatPicker
import com.akshit.catpicker.CatPickerConfig
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        start_button.setOnClickListener {
            startCatPicker()
        }
    }

    private fun startCatPicker() {
        CatPicker.start(
            this,
            CatPickerConfig(
                navigateIcon = R.drawable.ic_cancel,
                title = "My Cat Picker",
                background = R.color.colorPrimary
            )
        ) { bitmap ->
            selected_cat_image.isVisible = true
            selected_cat_image.setImageBitmap(bitmap)
        }
    }
}
