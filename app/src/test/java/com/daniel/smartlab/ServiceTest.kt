package com.daniel.smartlab

import com.daniel.smartlab.data.Config
import com.daniel.smartlab.presentation.model.Rating
import com.daniel.smartlab.presentation.model.User
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ServiceTest {

    val config = Config("http://192.168.0.24:9000")

    @Test
    fun connection_is_correct() {
        print(config.service.login(User("","122")).execute().body())
    }

    @Test
    fun save_rating() {
        val id = config.service.login(User("","122")).execute().body()!!.id
        config.service.save(Rating(
            3,
            9,
                hashMapOf<String, Int>("Temperatura" to 3,
                        "Barulho" to 2),
                id
        )).execute()
    }

    @Test
    fun convert() {
        print(Rating.types[1])
    }


}
