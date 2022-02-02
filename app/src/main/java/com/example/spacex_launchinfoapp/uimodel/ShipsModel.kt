package com.example.spacex_launchinfoapp.uimodel

import com.example.spacex_launchinfoapp.data.network.shipsmodel.ShipsItem

data class ShipsModel(
    var title: String,
    var image: String?
) {
    companion object {
        fun create(shipsItem: ShipsItem) = ShipsModel(
            title = shipsItem.name,
            image = shipsItem.image
        )
    }
}
