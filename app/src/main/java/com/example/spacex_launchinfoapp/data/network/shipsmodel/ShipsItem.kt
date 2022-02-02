package com.example.spacex_launchinfoapp.data.network.shipsmodel


import com.google.gson.annotations.SerializedName

data class ShipsItem(
    @SerializedName("abs")
    val abs: Int,
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("class")
    val classX: Int,
    @SerializedName("course_deg")
    val courseDeg: Any,
    @SerializedName("home_port")
    val homePort: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imo")
    val imo: Int,
    @SerializedName("last_ais_update")
    val lastAisUpdate: Any,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("launches")
    val launches: List<String>,
    @SerializedName("legacy_id")
    val legacyId: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("mass_kg")
    val massKg: Int,
    @SerializedName("mass_lbs")
    val massLbs: Int,
    @SerializedName("mmsi")
    val mmsi: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("speed_kn")
    val speedKn: Any,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("year_built")
    val yearBuilt: Int
)