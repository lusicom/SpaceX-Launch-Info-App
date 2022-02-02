package com.example.spacex_launchinfoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.spacex_launchinfoapp.data.Repository
import com.example.spacex_launchinfoapp.uimodel.LaunchesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {

    var launchesResponse: MutableLiveData<List<LaunchesModel>> = MutableLiveData()

    init {
        loadLaunches()
    }

    private fun loadLaunches() = viewModelScope.launch {
        val response = repository.getLaunches()
        launchesResponse.value = response
    }
}