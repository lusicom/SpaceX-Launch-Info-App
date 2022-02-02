package com.example.spacex_launchinfoapp.data.network.launchesmodel


import com.google.gson.annotations.SerializedName

data class Patch(
    @SerializedName("large")
    val large: String,
    @SerializedName("small")
    val small: String
)