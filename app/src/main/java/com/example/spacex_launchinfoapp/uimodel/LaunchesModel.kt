package com.example.spacex_launchinfoapp.uimodel

import com.example.spacex_launchinfoapp.data.network.launchesmodel.PastLaunchesItem
data class LaunchesModel(
    var id: String,
    var title: String,
    var date: String,
    var image: String?
) {
    companion object {
        fun create(pastLaunchesItem: PastLaunchesItem) = LaunchesModel(
            id = pastLaunchesItem.id,
            title = pastLaunchesItem.name,
            date = pastLaunchesItem.dateLocal,
            image = pastLaunchesItem.links.patch.small
        )
    }
}


