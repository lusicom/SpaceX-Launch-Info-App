package com.example.spacex_launchinfoapp.data.network.launchesmodel


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PastLaunchesItem(
    @SerializedName("auto_update")
    val autoUpdate: Boolean,
    @SerializedName("capsules")
    val capsules: @RawValue List<Any>,
    @SerializedName("cores")
    val cores: @RawValue List<Core>,
    @SerializedName("crew")
    val crew: @RawValue List<Any>,
    @SerializedName("date_local")
    val dateLocal: String,
    @SerializedName("date_precision")
    val datePrecision: String,
    @SerializedName("date_unix")
    val dateUnix: Int,
    @SerializedName("date_utc")
    val dateUtc: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("failures")
    val failures: @RawValue List<Any>,
    @SerializedName("fairings")
    val fairings: @RawValue Fairings,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("launch_library_id")
    val launchLibraryId: String,
    @SerializedName("launchpad")
    val launchpad: String,
    @SerializedName("links")
    val links: @RawValue Links,
    @SerializedName("name")
    val name: String,
    @SerializedName("net")
    val net: Boolean,
    @SerializedName("payloads")
    val payloads: List<String>,
    @SerializedName("rocket")
    val rocket: String,
    @SerializedName("ships")
    val ships: @RawValue List<Any>,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Int,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("tbd")
    val tbd: Boolean,
    @SerializedName("upcoming")
    val upcoming: Boolean,
    @SerializedName("window")
    val window: Int
) : Parcelable