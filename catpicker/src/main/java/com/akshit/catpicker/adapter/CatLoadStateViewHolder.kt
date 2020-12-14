package com.akshit.catpicker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.akshit.catpicker.R

class CatLoadStateViewHolder(
    view: View,
    private val retry: () -> Unit
) : RecyclerView.ViewHolder(view) {

    private val retryButton: Button = itemView.findViewById(R.id.retry_btn)
    private val errorMsg: TextView = itemView.findViewById(R.id.error_msg)
    private val progressBar: ProgressBar = itemView.findViewById(R.id.progress_bar)

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            errorMsg.text = itemView.context.getString(R.string.error_msg)
        }
        progressBar.isVisible = loadState is LoadState.Loading
        retryButton.isVisible = loadState !is LoadState.Loading
        errorMsg.isVisible = loadState !is LoadState.Loading

        retryButton.setOnClickListener {
            retry.invoke()
        }
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CatLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cat_load_state_footer_view_item, parent, false)
            return CatLoadStateViewHolder(view, retry)
        }
    }
}