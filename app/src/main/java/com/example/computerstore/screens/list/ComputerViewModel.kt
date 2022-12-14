package com.example.computerstore.screens.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComputerViewModel : ViewModel() {

    private val _computers = MutableLiveData<MutableList<Computer>>()
    val computers: LiveData<MutableList<Computer>>
        get() = _computers

    init {
        _computers.value = mutableListOf()
    }

    fun addComputer(computer: Computer) {
        _computers.value!!.add(computer)
    }
}