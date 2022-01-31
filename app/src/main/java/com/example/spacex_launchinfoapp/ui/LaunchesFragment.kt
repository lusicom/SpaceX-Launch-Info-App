package com.example.spacex_launchinfoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_launchinfoapp.adapters.LaunchesAdapter
import com.example.spacex_launchinfoapp.databinding.FragmentLaunchesBinding
import com.example.spacex_launchinfoapp.model.LaunchesModel
import com.todkars.shimmer.ShimmerRecyclerView

class LaunchesFragment : Fragment() {

    private var _binding: FragmentLaunchesBinding? = null
    private val binding get() = _binding!!

    private lateinit var shimmerLaunchRecyclerView: ShimmerRecyclerView

    private val launchesAdapter = LaunchesAdapter {
        Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchesBinding.inflate(inflater, container, false)

        showShimmerEffect()
        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.launchesRecyclerView.adapter = launchesAdapter
        binding.launchesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        launchesAdapter.submitList(getLaunchesSet())
    }

    private fun showShimmerEffect() {
        shimmerLaunchRecyclerView = binding.launchesRecyclerView
        shimmerLaunchRecyclerView.showShimmer()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

private fun getLaunchesSet(): ArrayList<LaunchesModel> {
    val list = arrayListOf<LaunchesModel>()

    repeat(10) {
        list.add(
            LaunchesModel(
                "Launch $it", "$it.03.2011", "https://i.imgur.com/BrW201S.png"
            )
        )
    }
    return list
}

