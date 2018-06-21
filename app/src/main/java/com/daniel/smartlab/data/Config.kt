package com.daniel.smartlab.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config(val url : String) {

    companion object {
        val DEFAULT = Config("https://reclab-mate84.herokuapp.com/")
    }

    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service = retrofit.create(API::class.java)

}