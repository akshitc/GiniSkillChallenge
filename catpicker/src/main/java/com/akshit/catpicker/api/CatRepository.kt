package com.akshit.catpicker.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.akshit.catpicker.model.CatModel
import kotlinx.coroutines.flow.Flow

internal class CatRepository(private val catService: CatService) {

    fun getCats(): Flow<PagingData<CatModel>> {
        return Pager(
            PagingConfig(pageSize = 20, enablePlaceholders = false)
        ) {
            CatPagingSource(catService)
        }.flow
    }
}
