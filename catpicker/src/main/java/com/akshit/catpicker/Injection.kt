package com.akshit.catpicker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshit.catpicker.api.CatRepository
import com.akshit.catpicker.api.CatService
import com.akshit.catpicker.ui.CatGalleryViewModel

object Injection {

    private fun provideCatRepository(): CatRepository {
        return CatRepository(CatService.createService())
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CatGalleryViewModel(provideCatRepository()) as T
            }
        }
    }
}
