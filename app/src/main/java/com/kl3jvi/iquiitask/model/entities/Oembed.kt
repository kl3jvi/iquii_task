package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class Oembed(
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("author_url")
    val authorUrl: String,
    @SerializedName("cache_age")
    val cacheAge: Long,
    @SerializedName("height")
    val height: Any,
    @SerializedName("html")
    val html: String,
    @SerializedName("provider_name")
    val providerName: String,
    @SerializedName("provider_url")
    val providerUrl: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("version")
    val version: String,
    @SerializedName("width")
    val width: Int
)