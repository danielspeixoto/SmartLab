package com.daniel.smartlab.data

import retrofit2.Retrofit

class Config(val url : String) {

    val retrofit = Retrofit.Builder().baseUrl(url).build()
    val service = retrofit.create(API::class.java)

}