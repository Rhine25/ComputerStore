package com.example.computerstore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.computerstore.R
import com.example.computerstore.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

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
        return binding.root
    }
}