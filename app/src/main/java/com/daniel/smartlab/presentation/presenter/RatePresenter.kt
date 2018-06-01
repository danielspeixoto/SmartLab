package com.daniel.smartlab.presentation.presenter

import android.util.Log
import com.daniel.smartlab.data.Config
import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.User
import com.daniel.smartlab.presentation.view.RateActivity

open class RatePresenter(val view : RateActivity) {

    //TODO Add url
    val config = Config("/TODO ADD")
    var user : User? = null

    fun save(rating : Rating?) : Rating? {
        print(rating)
        Log.d("Rating info", rating.toString())
        return rating
    }

    fun login(deviceId : String) {
        user = config.service.login(deviceId).execute().body()
    }

    fun populateRatings() : List<String> {
        return Rating.types
    }
}