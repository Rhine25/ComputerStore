package com.example.computerstore.screens.list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.computerstore.R
import com.example.computerstore.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private lateinit var viewModel: ComputerViewModel
    private lateinit var binding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_fragment,
            container,
            false
        )
        setHasOptionsMenu(true)

        binding.fab.setOnClickListener { v: View ->
            v.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }

        Log.d("DEBUGVIEWMODEL", "ViewModelProvider called")
        viewModel = ViewModelProvider(this).get(ComputerViewModel::class.java)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        Log.d("DEBUGVIEWMODEL", "View destroyed")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("DEBUGVIEWMODEL", "Fragment destroyed")
        super.onDestroy()
    }
}