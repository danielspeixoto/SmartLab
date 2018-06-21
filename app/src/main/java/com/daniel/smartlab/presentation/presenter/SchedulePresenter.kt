package com.daniel.smartlab.presentation.presenter

import com.daniel.smartlab.data.Config
import com.daniel.smartlab.presentation.model.Schedule
import com.daniel.smartlab.presentation.view.ScheduleActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulePresenter(val view : ScheduleActivity) {

    fun get(day : Int) {
        view.onLoading()
        Config.DEFAULT.service.getScheduling(day).enqueue(object : Callback<List<Schedule>> {
            override fun onFailure(call: Call<List<Schedule>>?, t: Throwable?) {
                view.onError("Algum erro ocorreu")
            }

            override fun onResponse(call: Call<List<Schedule>>?, response: Response<List<Schedule>>?) {
                view.onStopLoading()
                response!!.body()!!.forEach { view.onScheduleReceived(it) }
            }
        })
    }


}