package com.example.nukusmarshrutka.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nukusmarshrutka.CarData
import com.example.nukusmarshrutka.Constants
import com.example.nukusmarshrutka.R
import com.example.nukusmarshrutka.databinding.FragmentSearchBinding
import com.example.nukusmarshrutka.presentation.adapter.HomeAdapter

class SearchFragment : Fragment(R.layout.fragment_search) {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!
    private val data = Constants.list
    private val sortedData = mutableListOf<CarData>()
    private val adapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        setupData()
        setupListeners()


    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        with(binding) {

            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            adapter.setOnItemClickListener {
                findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToItemScreenFragment(it.id))
            }

            etStartLocation.addTextChangedListener { text ->
                val startLocation = etEndLocation.text.toString().trim().lowercase()
                val endLocation = text.toString().trim().lowercase()
                findTheNecessaryCar(startLocation, endLocation)
            }

            etEndLocation.addTextChangedListener { text ->
                val startLocation = etStartLocation.text.toString().trim().lowercase()
                val endLocation = text.toString().trim().lowercase()
                findTheNecessaryCar(startLocation, endLocation)
            }
        }
    }

    private fun findTheNecessaryCar(startLocation: String, endLocation: String) {
        if (startLocation.isNotEmpty() && endLocation.isNotEmpty()) {
            sortedData.clear()
            for (item in data) {
                val locationsList = item.locations.toString().lowercase()
                if (locationsList.contains(startLocation) && locationsList.contains(endLocation)) {
                    sortedData.add(item)
                }
            }
            adapter.submitList(sortedData)
            adapter.notifyDataSetChanged()
        } else {
            adapter.submitList(listOf())
            adapter.notifyDataSetChanged()
        }
    }
}
