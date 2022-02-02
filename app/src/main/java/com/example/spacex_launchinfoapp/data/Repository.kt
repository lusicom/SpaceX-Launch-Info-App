package com.example.spacex_launchinfoapp.data

import com.example.spacex_launchinfoapp.uimodel.LaunchesModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) {

     suspend fun getLaunches(): List<LaunchesModel> = withContext(Dispatchers.IO) {
         remoteDataSource.getLaunches().map {
             LaunchesModel.create(it)
         }
     }
}