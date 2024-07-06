package com.example.nukusmarshrutka.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nukusmarshrutka.Constants
import com.example.nukusmarshrutka.R
import com.example.nukusmarshrutka.databinding.FragmentHomeBinding
import com.example.nukusmarshrutka.presentation.adapter.HomeAdapter

class HomeFragment: Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val adapter = HomeAdapter()
    private val data = Constants.list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)


        setupData()
        setupListeners()

    }

    private fun setupData() {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.toolbar_color)

        binding.recyclerView.adapter = adapter

        val sortedData = data.sortedBy { it.carNumber }

        adapter.submitList(sortedData)
    }

    private fun setupListeners() {

        binding.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        adapter.setOnItemClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToItemScreenFragment(it.id))
        }
    }
}
