package com.akshit.catpicker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshit.catpicker.api.CatRepository
import com.akshit.catpicker.model.CatModel
import kotlinx.coroutines.flow.Flow

class CatGalleryViewModel(private val catRepository: CatRepository) : ViewModel() {

    fun getCats(): Flow<PagingData<CatModel>> {
        return catRepository.getCats().cachedIn(viewModelScope)
    }
}
