package com.akshit.catpicker

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Class used to configure the SDK with the required title, toolbar color and back icon
 * @property title Title of the toolbar
 * @property background Background color of the toolbar
 * @property navigateIcon Drawable to be used for back icon
 */
data class CatPickerConfig @JvmOverloads constructor(
    val title: String = "Cat Picker",
    @ColorRes val background: Int = R.color.yellow,
    @DrawableRes val navigateIcon: Int = R.drawable.ic_arrow_back
)
