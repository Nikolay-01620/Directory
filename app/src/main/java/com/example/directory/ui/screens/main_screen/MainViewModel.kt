package com.example.directory.ui.screens.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DirectoryRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<DirectoryDomain>>(emptyList())
    val contacts: StateFlow<List<DirectoryDomain>> = _contacts.asStateFlow()

    private val _contactName = MutableStateFlow("")
    val contactName: StateFlow<String> = _contactName.asStateFlow()

    private val _contactPhoneNumber = MutableStateFlow("")
    val contactPhoneNumber: StateFlow<String> = _contactPhoneNumber.asStateFlow()


    fun onNameChange(newName: String) {
        _contactName.value = newName
    }

    fun onPhoneNumberChange(newPhoneNumber: String) {
        _contactPhoneNumber.value = newPhoneNumber
    }
    fun onValueChange(newValue: String) {
        _contactName.value = newValue
    }


    fun addContact() {
        viewModelScope.launch {
            val name = _contactName.value
            val phoneNumber = _contactPhoneNumber.value

            if (name.isNotBlank() && phoneNumber.isNotBlank()) {
                // Создайте объект Domain модели
                val newContact = DirectoryDomain(name = name, phoneNumber = phoneNumber)

                // Сохраните в репозиторий
                repository.insertContact(newContact)

                // Очистите поля после добавления
                _contactName.value = ""
                _contactPhoneNumber.value = ""
            }
        }
    }
}