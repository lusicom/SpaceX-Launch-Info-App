package com.example.spacex_launchinfoapp.data

import com.example.spacex_launchinfoapp.data.network.LaunchesApi
import com.example.spacex_launchinfoapp.data.network.launchesmodel.PastLaunchesItem
import com.example.spacex_launchinfoapp.data.network.shipsmodel.ShipsItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val launchesApi: LaunchesApi) {
    suspend fun getLaunches(): List<PastLaunchesItem> {
        return launchesApi.getLaunches()
    }

    suspend fun getShips(): List<ShipsItem> {
        return launchesApi.getShips()
    }
}