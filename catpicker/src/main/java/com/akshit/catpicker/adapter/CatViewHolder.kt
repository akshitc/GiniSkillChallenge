package com.akshit.catpicker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.akshit.catpicker.R
import com.akshit.catpicker.model.CatModel
import com.bumptech.glide.Glide

internal class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: CatModel?, listener: CatSelectionListener) {
        if (item != null) {
            val imageView = itemView.findViewById<ImageView>(R.id.cat_image)
            val constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.parent_layout)
            Glide
                .with(itemView)
                .load(item.url)
                .placeholder(R.drawable.ic_placeholder)
                .into(imageView)

            val ratio = String.format("%d:%d", item.width, item.height)
            val set = ConstraintSet()
            set.clone(constraintLayout)
            set.setDimensionRatio(imageView.id, ratio)
            set.applyTo(constraintLayout)

            itemView.setOnClickListener {
                listener.onCatSelected(item)
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): CatViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cat_grid_item, parent, false)
            return CatViewHolder(view)
        }
    }
}