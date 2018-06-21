package com.daniel.smartlab.data

import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.Schedule
import com.daniel.smartlab.presentation.model.User
import retrofit2.Call
import retrofit2.http.*

interface API {

    @POST("/rating")
    fun save(@Body rating : Rating) : Call<Void>

    @POST("/user")
//    @FormUrlEncoded
    fun login(@Body user : User) : Call<User>

    @GET("/scheduling/{day}")
    fun getScheduling(@Path("day") day: Int) : Call<List<Schedule>>

}