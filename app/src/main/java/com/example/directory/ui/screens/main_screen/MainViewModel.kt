package com.example.directory.ui.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _onValueSearchChange = MutableStateFlow("")

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())
    val contacts: StateFlow<List<DirectoryDomain>> = _contacts.asStateFlow()

    fun onValueSearchChange(newValue: String) {
        _onValueSearchChange.value = newValue
    }

    fun loadContacts() {
        viewModelScope.launch {
            val contacts =
                directoryRepository.getAllContacts() // Вы должны реализовать этот метод в репозитории
            _contacts.value = contacts
        }
    }
}