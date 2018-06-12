package com.daniel.smartlab.presentation.model

data class Rating(val day : Int, val schedule : Int, var ratings : HashMap<String, Int>, val userId: String) {

    companion object {

        val names = hashMapOf(
                "Temperatura" to "temperatureRating",
                "Barulho" to "noiseRating",
                "Lotação" to "crowdRating",
                "Iluminação" to "lightRating"
        )

        lateinit var types : List<String>

        init {
            var str = names.keys.toString()
            str = str.substring(1, str.length - 1)
            types = str.split(", ")
        }
    }


}