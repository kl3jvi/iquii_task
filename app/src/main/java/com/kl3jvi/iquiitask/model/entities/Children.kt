package com.kl3jvi.iquiitask.model.entities


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val `data`: ChildrenData,
    @SerializedName("kind")
    val kind: String
)