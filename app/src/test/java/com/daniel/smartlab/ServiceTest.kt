package com.daniel.smartlab

import com.daniel.smartlab.data.Config
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ServiceTest {
    @Test
    fun connection_is_correct() {
        val config = Config("http://127.0.0.1:9000")
        print(config.service.login("1").execute().body())
    }
}
