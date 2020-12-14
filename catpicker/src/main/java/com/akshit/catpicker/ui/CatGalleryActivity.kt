package com.akshit.catpicker.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.akshit.catpicker.CatPicker
import com.akshit.catpicker.Injection
import com.akshit.catpicker.R
import com.akshit.catpicker.adapter.CatAdapter
import com.akshit.catpicker.adapter.CatComparator
import com.akshit.catpicker.adapter.CatLoadStateAdapter
import com.akshit.catpicker.adapter.CatSelectionListener
import com.akshit.catpicker.model.CatModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_cat_gallery.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatGalleryActivity : AppCompatActivity(), CatSelectionListener {

    private val viewModel: CatGalleryViewModel by viewModels { createViewModelFactory() }

    private fun createViewModelFactory(): ViewModelProvider.Factory {
        return Injection.provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_gallery)

        setToolBar()
        setViews()
    }

    private fun setToolBar() {
        val config = CatPicker.config
        if (config != null) {
            toolbar.title = config.title
            toolbar.setBackgroundResource(config.background)
            toolbar.setNavigationIcon(config.navigateIcon)
        }
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    private fun setViews() {
        val pagingAdapter = CatAdapter(this, CatComparator)
        cat_grid.adapter = pagingAdapter.withLoadStateFooter(
            CatLoadStateAdapter { pagingAdapter.retry() }
        )

        pagingAdapter.addLoadStateListener { loadState ->
            progress_bar.isVisible = loadState.refresh is LoadState.Loading
            retry_button.isVisible = loadState.refresh is LoadState.Error
            retry_button.setOnClickListener {
                pagingAdapter.retry()
            }
        }

        lifecycleScope.launch {
            viewModel.getCats().collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }

    override fun onCatSelected(catModel: CatModel) {
        val futureTargetBitmap = Glide
            .with(this)
            .asBitmap()
            .load(catModel.url)
            .submit(catModel.width, catModel.height)

        lifecycleScope.launch(Dispatchers.IO) {
            val bitmap = futureTargetBitmap.get()
            withContext(Dispatchers.Main) {
                CatPicker.onSuccessListener?.onSuccess(bitmap)
                onBackPressed()
            }
            futureTargetBitmap.cancel(false)
        }
    }
}
