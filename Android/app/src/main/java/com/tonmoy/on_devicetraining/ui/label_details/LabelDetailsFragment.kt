package com.tonmoy.on_devicetraining.ui.label_details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.tonmoy.on_devicetraining.R
import com.tonmoy.on_devicetraining.data.Image
import com.tonmoy.on_devicetraining.databinding.FragmentHomeBinding
import com.tonmoy.on_devicetraining.databinding.FragmentLabelDetailsBinding
import com.tonmoy.on_devicetraining.ui.adapter.ImageAdapter
import com.tonmoy.on_devicetraining.ui.adapter.LabelAdapter


class LabelDetailsFragment : Fragment() {
    private var _binding: FragmentLabelDetailsBinding? = null


    private val binding get() = _binding!!
    private var adapter: ImageAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLabelDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupAdapter()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.captureButton.setOnClickListener {
            adapter?.submitList((0..100).map { Image() })
            Log.i("sdfsdf", "onViewCreated: ")
        }
    }

    private fun setupAdapter() {
        adapter = ImageAdapter()
        binding.recycler.adapter = adapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}