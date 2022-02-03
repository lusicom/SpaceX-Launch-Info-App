package com.example.spacex_launchinfoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.spacex_launchinfoapp.R
import com.example.spacex_launchinfoapp.uimodel.ShipsModel

class ShipsAdapter(private val onClick: (ShipsModel) -> Unit) :
    ListAdapter<ShipsModel, ShipsAdapter.ShipViewHolder>(ShipDiffCallback) {

    class ShipViewHolder(itemView: View, val onClick: (ShipsModel) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.ship_imageView)
        private val itemTitle: TextView = itemView.findViewById(R.id.shipName_textView)
        private var currentShip: ShipsModel? = null

        init {
            itemView.setOnClickListener {
                currentShip?.let {
                    onClick(it)
                }
            }
        }

        fun bind(ship: ShipsModel) {
            currentShip = ship
            itemTitle.text = ship.title
            if (ship.image != null) {
                itemImage.load(ship.image)
            } else {
                itemImage.setImageResource(R.drawable.ic_image_placeholder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.ships_row_layout, parent, false)
        return ShipViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ShipViewHolder, position: Int) {
        val launch = getItem(position)
        holder.bind(launch)
        holder.itemView.setOnClickListener {
            launch?.let { it1 -> onClick.invoke(it1) }
        }
    }
}

object ShipDiffCallback : DiffUtil.ItemCallback<ShipsModel>() {
    override fun areItemsTheSame(oldItem: ShipsModel, newItem: ShipsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShipsModel, newItem: ShipsModel): Boolean {
        return oldItem == newItem
    }
}
