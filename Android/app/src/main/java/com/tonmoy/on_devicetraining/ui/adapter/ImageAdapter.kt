package com.tonmoy.on_devicetraining.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tonmoy.on_devicetraining.R
import com.tonmoy.on_devicetraining.data.Image
import com.tonmoy.on_devicetraining.data.Label
import com.tonmoy.on_devicetraining.databinding.RowImageBinding
import com.tonmoy.on_devicetraining.databinding.RowLabelBinding

class ImageAdapter : ListAdapter<Image,ImageAdapter.ImageViewHolder>(ImageAdapter.DiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowImageBinding.inflate(layoutInflater,parent,false)
        return  ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImageViewHolder(private val binding:RowImageBinding):RecyclerView.ViewHolder(
        binding.root
    ){
        fun bind(image: Image){

        }
    }
    class DiffCallback:DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

    }
}