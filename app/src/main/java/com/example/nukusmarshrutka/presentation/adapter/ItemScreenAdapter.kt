package com.example.nukusmarshrutka.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nukusmarshrutka.databinding.ItemLocationsBinding

class ItemScreenAdapter: ListAdapter<String, ItemScreenAdapter.ItemScreenViewHolder>(myDiffUtil) {

    inner class ItemScreenViewHolder(private val binding: ItemLocationsBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)
            binding.tvLocation.text = d
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemScreenViewHolder {
        return ItemScreenViewHolder(
            ItemLocationsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemScreenViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}
