package com.example.nukusmarshrutka.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nukusmarshrutka.Constants
import com.example.nukusmarshrutka.R
import com.example.nukusmarshrutka.databinding.FragmentItemScreenBinding
import com.example.nukusmarshrutka.presentation.adapter.ItemScreenAdapter

class ItemScreenFragment: Fragment(R.layout.fragment_item_screen) {
    private var _binding: FragmentItemScreenBinding? = null
    private val binding: FragmentItemScreenBinding get() = _binding!!
    private val adapter = ItemScreenAdapter()
    private val args by navArgs<ItemScreenFragmentArgs>()
    private val data = Constants.list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemScreenBinding.bind(view)


        setupData()
        setupListeners()

    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter

        data.forEach {
            if (it.id == args.id) {
                binding.tvCarNumber.text = it.carNumber.toString()
                adapter.submitList(it.locations)
            }
        }
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
