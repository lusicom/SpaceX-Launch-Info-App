package com.example.spacex_launchinfoapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex_launchinfoapp.R
import com.example.spacex_launchinfoapp.adapters.ShipsAdapter
import com.example.spacex_launchinfoapp.databinding.FragmentShipsBinding
import com.example.spacex_launchinfoapp.uimodel.ShipsModel
import com.example.spacex_launchinfoapp.viewmodels.ShipsViewModel
import com.todkars.shimmer.ShimmerRecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShipsFragment : Fragment() {

    private var _binding: FragmentShipsBinding? = null
    private val binding get() = _binding!!

    private lateinit var shimmerShipRecyclerView: ShimmerRecyclerView
    private val shipsViewModel: ShipsViewModel by viewModels()

    private val shipsAdapter = ShipsAdapter { ship ->
        Toast.makeText(context, ship.id, Toast.LENGTH_SHORT).show()
        adapterOnClick(ship)
    }

    private fun adapterOnClick(ship: ShipsModel) {
        val passId = ship.id
        val action = ShipsFragmentDirections.actionNavShipsToShipDetailsFragment(passId)
        view?.findNavController()!!.navigate(action)
    }

    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShipsBinding.inflate(inflater, container, false)

        setUpShipsRecyclerView()
        observeLShipsData()

        return binding.root
    }

    private fun setUpShipsRecyclerView() {
        binding.shipsRecyclerView.adapter = shipsAdapter
        binding.shipsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeLShipsData() {
        shipsViewModel.shipsResponse.observe(viewLifecycleOwner)
        { list ->
            shipsAdapter.submitList(list)
        }
    }

    private fun showShimmerEffect() {
        shimmerShipRecyclerView = binding.shipsRecyclerView
        shimmerShipRecyclerView.showShimmer()
    }

}