package com.akshit.catpicker.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.akshit.catpicker.Injection
import com.akshit.catpicker.R

class CatGalleryActivity : AppCompatActivity() {

    private val viewModel: CatGalleryViewModel by viewModels { createViewModelFactory() }

    private fun createViewModelFactory(): ViewModelProvider.Factory {
        return Injection.provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_gallery)
    }
}
