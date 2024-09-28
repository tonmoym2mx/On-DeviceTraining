package com.tonmoy.on_devicetraining.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tonmoy.on_devicetraining.R
import com.tonmoy.on_devicetraining.data.Label
import com.tonmoy.on_devicetraining.databinding.RowLabelBinding

class LabelAdapter : ListAdapter<Label,LabelAdapter.LabelViewHolder>(LabelAdapter.DiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowLabelBinding.inflate(layoutInflater,parent,false)
        return  LabelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LabelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LabelViewHolder(private val binding:RowLabelBinding):RecyclerView.ViewHolder(
        binding.root
    ){
         fun bind(label: Label){
             binding.labelName.text = label.name
             binding.labelDesc.text = "${label.dataCount} Images"
             binding.cardView.setOnClickListener {
                 it.findNavController().navigate(R.id.action_navigation_home_to_labelDetailsFragment)
             }
         }
    }
     class DiffCallback:DiffUtil.ItemCallback<Label>(){
        override fun areItemsTheSame(oldItem: Label, newItem: Label): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Label, newItem: Label): Boolean {
            return oldItem == newItem
        }

    }
}