package com.example.computerstore.screens.list

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.computerstore.R
import com.example.computerstore.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private val viewModel: ComputerViewModel by activityViewModels()
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

        viewModel.computers.value?.forEach { computer: Computer ->
            addComputerItem(computer)
        }

        return binding.root
    }

    private fun addComputerItem(computer: Computer) {
        val inflater = LayoutInflater.from(context)
        val computerView = inflater.inflate(R.layout.computer_item, null, false)
        computerView.findViewById<TextView>(R.id.computer_name).text = computer.name
        computerView.findViewById<TextView>(R.id.company_name).text = computer.company
        computerView.findViewById<TextView>(R.id.year).text = computer.year
        computerView.findViewById<TextView>(R.id.description).text = computer.description
        binding.itemList.addView(computerView)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}