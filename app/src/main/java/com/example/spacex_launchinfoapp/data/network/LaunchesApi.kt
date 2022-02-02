package com.example.spacex_launchinfoapp.data.network

import com.example.spacex_launchinfoapp.data.network.launchesmodel.PastLaunchesItem
import com.example.spacex_launchinfoapp.data.network.shipsmodel.ShipsItem
import retrofit2.http.GET

interface LaunchesApi {

    @GET("/v5/launches/past")
    suspend fun getLaunches(): List<PastLaunchesItem>

    @GET("v4/ships")
    suspend fun getShips(): List<ShipsItem>
}