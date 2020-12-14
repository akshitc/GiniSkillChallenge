package com.akshit.catpicker.adapter

import com.akshit.catpicker.model.CatModel

internal interface CatSelectionListener {

    fun onCatSelected(catModel: CatModel)
}
