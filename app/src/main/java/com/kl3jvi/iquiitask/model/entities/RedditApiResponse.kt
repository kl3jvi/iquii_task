package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class RedditApiResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("kind")
    val kind: String
)