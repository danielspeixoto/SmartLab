package com.daniel.smartlab.data

import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface API {

    @POST("/rating")
    fun save(@Body rating : Rating) : Call<Void>

    @POST("/user")
//    @FormUrlEncoded
    fun login(@Body user : User) : Call<User>

}