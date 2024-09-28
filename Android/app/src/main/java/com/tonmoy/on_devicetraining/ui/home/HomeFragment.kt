package com.tonmoy.on_devicetraining.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tonmoy.on_devicetraining.data.Label
import com.tonmoy.on_devicetraining.databinding.FragmentHomeBinding
import com.tonmoy.on_devicetraining.ui.adapter.LabelAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null


    private val binding get() = _binding!!

    private var adapter:LabelAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupAdapter()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter?.submitList(listOf(Label("Cat"),Label("Dog")))
    }

    private fun setupAdapter() {
        adapter = LabelAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}