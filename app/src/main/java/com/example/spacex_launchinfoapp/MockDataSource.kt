package com.example.spacex_launchinfoapp

import com.example.spacex_launchinfoapp.model.LaunchesModel

class MockDataSource {

    fun getDataSet(): ArrayList<LaunchesModel> {
        val list = arrayListOf<LaunchesModel>()

        repeat(10) {
            list.add(LaunchesModel(
                "Launch $it", "$it.03.2011", "https://i.imgur.com/BrW201S.png"
            ))
        }

        return list
    }
}