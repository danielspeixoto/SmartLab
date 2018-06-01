package com.daniel.smartlab.data

import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.User
import retrofit2.Call
import retrofit2.http.POST

interface API {

    @POST("/rating")
    fun save(rating : Rating)

    @POST("/user")
    fun login(deviceId : String) : Call<User>

}