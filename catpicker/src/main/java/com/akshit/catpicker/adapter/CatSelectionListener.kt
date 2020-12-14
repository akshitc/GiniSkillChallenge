package com.akshit.catpicker.adapter

import com.akshit.catpicker.model.CatModel

interface CatSelectionListener {

    fun onCatSelected(catModel: CatModel)
}
