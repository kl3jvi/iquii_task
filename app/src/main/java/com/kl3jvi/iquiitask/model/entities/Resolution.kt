package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class Resolution(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)