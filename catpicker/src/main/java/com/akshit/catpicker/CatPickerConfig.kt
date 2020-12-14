package com.akshit.catpicker

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class CatPickerConfig(
    val title: String = "Cat Picker",
    @ColorRes val background: Int = R.color.yellow,
    @DrawableRes val navigateIcon: Int = R.drawable.ic_arrow_back
)
