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
import com.example.spacex_launchinfoapp.model.LaunchesModel

class LaunchesAdapter(private val onClick: (LaunchesModel) -> Unit) :
    ListAdapter<LaunchesModel, LaunchesAdapter.LaunchViewHolder>(LaunchDiffCallback) {

    class LaunchViewHolder(itemView: View, val onClick: (LaunchesModel) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val itemImage: ImageView = itemView.findViewById(R.id.launchBadge_imageView)
        private val itemTitle: TextView = itemView.findViewById(R.id.launchName_textView)
        private val itemDate: TextView = itemView.findViewById(R.id.launchDate_textView)
        private var currentLaunch: LaunchesModel? = null

        init {
            itemView.setOnClickListener {
                currentLaunch?.let {
                    onClick(it)
                }
            }
        }

        fun bind(launch: LaunchesModel) {
            currentLaunch = launch

            itemTitle.text = launch.title
            itemDate.text = launch.date
            if (launch.image != null) {
                itemImage.load(launch.image)
            } else {
                itemImage.setImageResource(R.drawable.ic_image_placeholder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.launches_row_layout, parent, false)
        return LaunchViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = getItem(position)
        holder.bind(launch)
        holder.itemView.setOnClickListener {
            launch?.let { it1 -> onClick.invoke(it1) }
        }
    }
}

object LaunchDiffCallback : DiffUtil.ItemCallback<LaunchesModel>() {
    override fun areItemsTheSame(oldItem: LaunchesModel, newItem: LaunchesModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LaunchesModel, newItem: LaunchesModel): Boolean {
        return oldItem.title == newItem.title
    }
}
