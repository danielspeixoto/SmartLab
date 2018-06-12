package com.daniel.smartlab.presentation.presenter

import android.os.AsyncTask.execute
import android.util.Log
import com.daniel.smartlab.data.Config
import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.User
import com.daniel.smartlab.presentation.view.RateActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RatePresenter(val view : RateActivity) {

    val config = Config("https://reclab-mate84.herokuapp.com/")
    var user : User? = null

    fun save(rating : Rating?) : Rating? {
        config.service.save(rating!!).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                view.showMessage("Erro, tente novamente mais tarde")
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                view.showMessage("Avaliação salva com sucesso!")
            }
        })
        return rating
    }

    fun login(deviceId : String) {

        config.service.login(User("", deviceId)).enqueue(object : Callback<User?> {
            override fun onFailure(call: Call<User?>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<User?>?, response: Response<User?>?) {
                user = response!!.body()
            }
        })
    }

    fun populateRatings() : List<String> {
        return Rating.types
    }
}