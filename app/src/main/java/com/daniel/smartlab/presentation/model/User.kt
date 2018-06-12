package com.daniel.smartlab.presentation.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("_id") val id: String, val deviceId: String) {
}