package com.example.spacex_launchinfoapp.ui

import android.graphics.Path
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_launchinfoapp.viewmodels.LaunchesViewModel
import com.example.spacex_launchinfoapp.adapters.LaunchesAdapter
import com.example.spacex_launchinfoapp.databinding.FragmentLaunchesBinding
import com.example.spacex_launchinfoapp.uimodel.LaunchesModel
import com.todkars.shimmer.ShimmerRecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchesFragment : Fragment() {

    private var _binding: FragmentLaunchesBinding? = null
    private val binding get() = _binding!!

    private lateinit var shimmerLaunchRecyclerView: ShimmerRecyclerView
    private val launchesViewModel: LaunchesViewModel by viewModels()
    private val launchesAdapter = LaunchesAdapter { launch ->
        Toast.makeText(context, launch.id, Toast.LENGTH_SHORT).show()
        adapterOnClick(launch)
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLaunchesBinding.inflate(inflater, container, false)
        val view = binding.root

        setupRecyclerView()
        observeLaunchesData()

        return view
    }

    private fun adapterOnClick(launch: LaunchesModel) {
        val passId = launch.id
        val action = LaunchesFragmentDirections.actionNavLaunchesToLaunchDetailsFragment(passId)
        view?.findNavController()!!.navigate(action)
    }

    private fun setupRecyclerView() {
        binding.launchesRecyclerView.adapter = launchesAdapter
        binding.launchesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeLaunchesData(){
        launchesViewModel.launchesResponse.observe(viewLifecycleOwner)
        { list -> launchesAdapter.submitList(list)
        }
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



