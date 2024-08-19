package com.example.derectory.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel() : ViewModel() {

    private val _contacts = MutableStateFlow("")
    val contacts: StateFlow<String> = _contacts.asStateFlow()
    fun onValueChange(newValue: String) {
        _contacts.value = newValue
    }
}