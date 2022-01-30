package com.example.spacex_launchinfoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class LaunchesFragment : Fragment() {
    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // todo fragment content will be implemented in scope of #4
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }
}