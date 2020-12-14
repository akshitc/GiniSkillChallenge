package com.akshit.catpicker.api

import androidx.paging.PagingSource
import com.akshit.catpicker.model.CatModel

internal class CatPagingSource(private val catService: CatService) : PagingSource<Int, CatModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatModel> {
        return try {
            val nextPageNumber = params.key ?: 0
            val limit = params.loadSize
            val response = catService.getCats(limit = limit, page = nextPageNumber)
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
