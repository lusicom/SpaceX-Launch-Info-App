package com.example.spacex_launchinfoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.spacex_launchinfoapp.databinding.FragmentLaunchDetailsBinding
import com.example.spacex_launchinfoapp.databinding.FragmentLaunchesBinding
import com.example.spacex_launchinfoapp.databinding.FragmentShipDetailsBinding


class ShipDetailsFragment : Fragment() {

    private var _binding: FragmentShipDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: ShipDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShipDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val shipsId = args.shipId
        binding.mockShipTextView.text = shipsId

        return view
    }
}