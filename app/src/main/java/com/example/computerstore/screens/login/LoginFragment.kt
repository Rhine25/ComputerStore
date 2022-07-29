package com.example.computerstore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.computerstore.R
import com.example.computerstore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        return binding.root
    }

}