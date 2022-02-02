package com.example.spacex_launchinfoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.spacex_launchinfoapp.data.Repository
import com.example.spacex_launchinfoapp.uimodel.ShipsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {

    var shipsResponse: MutableLiveData<List<ShipsModel>> = MutableLiveData()

    init {
        loadShips()
    }

    private fun loadShips() = viewModelScope.launch {
        val response = repository.getShips()
        shipsResponse.value = response
    }
}