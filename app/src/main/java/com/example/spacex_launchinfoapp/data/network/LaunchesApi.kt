package com.example.spacex_launchinfoapp.data.network

import com.example.spacex_launchinfoapp.data.network.model.PastLaunchesItem
import retrofit2.http.GET

interface LaunchesApi {

    @GET("/v5/launches/past")
    suspend fun getLaunches(): List<PastLaunchesItem>
}