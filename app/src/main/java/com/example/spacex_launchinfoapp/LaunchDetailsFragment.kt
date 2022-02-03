package com.example.spacex_launchinfoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.spacex_launchinfoapp.databinding.FragmentLaunchDetailsBinding

class LaunchDetailsFragment : Fragment() {

    private var _binding: FragmentLaunchDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: LaunchDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLaunchDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val launchId = args.launchId
        binding.mockLaunchTextView.text = launchId
        return view
    }
}