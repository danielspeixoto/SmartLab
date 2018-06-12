package com.daniel.smartlab.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config(val url : String) {

    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service = retrofit.create(API::class.java)

}