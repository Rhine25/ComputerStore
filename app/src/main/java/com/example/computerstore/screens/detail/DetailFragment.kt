package com.example.computerstore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.computerstore.R
import com.example.computerstore.databinding.DetailFragmentBinding
import com.example.computerstore.screens.list.Computer
import com.example.computerstore.screens.list.ComputerViewModel

class DetailFragment : Fragment() {

    private val viewModel: ComputerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_fragment,
            container,
            false
        )

        binding.computer = Computer()

        binding.buttonCancel.setOnClickListener { v: View ->
            v.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }
        binding.buttonSave.setOnClickListener { v: View ->
            viewModel.addComputer(binding.computer as Computer)
            v.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }
        return binding.root
    }
}