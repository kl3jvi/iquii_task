package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class SecureMedia(
    @SerializedName("oembed")
    val oembed: OembedX,
    @SerializedName("type")
    val type: String
)