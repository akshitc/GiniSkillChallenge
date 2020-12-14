package com.akshit.catpicker.adapter

import androidx.recyclerview.widget.DiffUtil
import com.akshit.catpicker.model.CatModel

object CatComparator : DiffUtil.ItemCallback<CatModel>() {
    override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {
        return oldItem == newItem
    }
}