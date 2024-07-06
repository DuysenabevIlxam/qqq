package com.example.nukusmarshrutka.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nukusmarshrutka.CarData
import com.example.nukusmarshrutka.databinding.ItemCarBinding
import com.example.nukusmarshrutka.databinding.ItemLocationsBinding

class HomeAdapter: ListAdapter<CarData, HomeAdapter.HomeViewHolder>(myDiffUtil) {

    private var onItemClickListener: ((CarData) -> Unit)? = null

    fun setOnItemClickListener(block: (CarData) -> Unit) {
        onItemClickListener = block
    }

    inner class HomeViewHolder(private val binding: ItemCarBinding): ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)
            with(binding) {
                tvCarNumber.text = d.carNumber.toString()
                tvLocations.text = "${d.locations[0]}\n${d.locations[2]}..."

                btnItem.setOnClickListener {
                    onItemClickListener?.invoke(d)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(position)
    }

    private object myDiffUtil: DiffUtil.ItemCallback<CarData>() {
        override fun areItemsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CarData, newItem: CarData): Boolean {
            return oldItem == newItem
        }

    }
}