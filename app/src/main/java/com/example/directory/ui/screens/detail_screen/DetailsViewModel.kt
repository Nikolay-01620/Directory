package com.example.directory.ui.screens.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())
    val contacts: StateFlow<List<DirectoryDomain>> = _contacts.asStateFlow()

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _secondName = MutableStateFlow("")
    val secondName: StateFlow<String> = _secondName.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()

    private val _photoUri = MutableStateFlow("")
    val photoUri: StateFlow<String> = _photoUri

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onSecondNameChange(newSecondName: String) {
        _secondName.value = newSecondName
    }

    fun onPhoneNumberChange(newPhoneNumber: String) {
        _phoneNumber.value = newPhoneNumber
    }

    fun handleImageSelection(uri: String) {
        _photoUri.value = uri
    }

    fun loadContact(contactId: Int) {
        viewModelScope.launch {
            val contact = directoryRepository.getContactById(contactId)
            contact?.let {
                _name.value = it.name
                _secondName.value = it.secondName
                _phoneNumber.value = it.phoneNumber
                _photoUri.value = it.photoUri.toString()
            }
        }
    }

}