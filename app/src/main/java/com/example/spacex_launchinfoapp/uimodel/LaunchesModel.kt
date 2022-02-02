package com.example.spacex_launchinfoapp.uimodel

import com.example.spacex_launchinfoapp.data.network.model.PastLaunchesItem

data class LaunchesModel(
    var title: String,
    var date: String,
    var image: String?
) {
    companion object {
        fun create(pastLaunchesItem: PastLaunchesItem) = LaunchesModel(
            title = pastLaunchesItem.name,
            date = pastLaunchesItem.dateLocal,
            image = pastLaunchesItem.links.patch.small
        )
    }
}


