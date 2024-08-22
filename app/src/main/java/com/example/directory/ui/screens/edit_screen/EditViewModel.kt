package com.example.directory.ui.screens.edit_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _secondName = MutableStateFlow("")
    val secondName: StateFlow<String> = _secondName.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()


    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onSecondNameChange(newSecondName: String) {
        _secondName.value = newSecondName
    }

    fun onPhoneNumberChange(newPhoneNumber: String) {
        _phoneNumber.value = newPhoneNumber
    }

    fun updateContact(contactId: Int) {
        viewModelScope.launch {
            val updatedContact = DirectoryDomain(
                id = contactId,
                name = _name.value,
                secondName = _secondName.value,
                phoneNumber = _phoneNumber.value,
                photoUri = ""
            )
            directoryRepository.updateContact(updatedContact)
        }
    }

    fun loadContact(contactId: Int) {
        viewModelScope.launch {
            val contact = directoryRepository.getContactById(contactId)
            contact?.let {
                _name.value = it.name
                _secondName.value = it.secondName
                _phoneNumber.value = it.phoneNumber
            }
        }
    }

}