package com.akshit.catpicker.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.akshit.catpicker.model.CatModel

class CatAdapter(
    private val listener: CatSelectionListener,
    diffCallback: DiffUtil.ItemCallback<CatModel>
) : PagingDataAdapter<CatModel, CatViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        return holder.bind(getItem(position), listener)
    }
}
