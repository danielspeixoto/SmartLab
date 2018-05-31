package com.daniel.smartlab.presentation.model

data class Rating(val day : Int, val schedule : Int, val ratings : HashMap<String, Int>, val deviceID: String) {

    companion object {
        val types = listOf(
                "Temperatura",
                "Barulho"
        )
    }
}