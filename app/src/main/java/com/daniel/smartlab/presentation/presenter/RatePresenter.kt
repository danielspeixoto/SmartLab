package com.daniel.smartlab.presentation.presenter

import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.view.RateActivity

class RatePresenter(val view : RateActivity) {

    fun save(rating : Rating) {

    }

    fun populateRatings() : List<String> {
        return Rating.types
    }
}