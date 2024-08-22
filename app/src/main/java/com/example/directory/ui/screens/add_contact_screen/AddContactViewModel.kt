package com.example.directory.ui.screens.add_contact_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DirectoryDomain
import com.example.domain.repositories.DirectoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AddContactViewModel(private val directoryRepository: DirectoryRepository) : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()

    private val _secondName = MutableStateFlow("")
    val secondName: StateFlow<String> = _secondName.asStateFlow()

    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()

    private val _photoUri = MutableStateFlow("")
    val photoUri: StateFlow<String> = _photoUri

    val isButtonEnabled: StateFlow<Boolean> = combine(
        _name,
        _secondName,
        _phoneNumber
    ) { name, secondName, phoneNumber ->
        name.isNotBlank() || secondName.isNotBlank() || phoneNumber.isNotBlank()
    }.stateIn(viewModelScope, SharingStarted.Lazily, false)


    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onSecondNameChange(newSecondName: String) {
        _secondName.value = newSecondName
    }

    fun onPhoneNumberChange(newPhoneNumber: String) {
        _phoneNumber.value = newPhoneNumber
    }

    fun addContact() {
        viewModelScope.launch {
            // Проверяем, что все поля заполнены
            if (_name.value.isBlank() || _secondName.value.isBlank() || _phoneNumber.value.isBlank()) {
                return@launch
            }
            val newContact = DirectoryDomain(
                name = _name.value,
                secondName = _secondName.value,
                phoneNumber = _phoneNumber.value,
                photoUri = _photoUri.value
            )
            directoryRepository.insertContact(newContact)
            clearFields()
        }
    }

    fun handleImageSelection(uri: String) {
        _photoUri.value = uri
    }

    fun clearFields() {
        if (_name.value.isNotBlank()) {
            _name.value = ""
        }
        if (_secondName.value.isNotBlank()) {
            _secondName.value = ""
        }
        if (_phoneNumber.value.isNotBlank()) {
            _phoneNumber.value = ""
        }
    }

/*    // Проверка и запрос разрешения
    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
        }
    }


    private val pickImageRequestCode = 1000

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, pickImageRequestCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImageRequestCode && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                // Теперь у вас есть URI изображения, вы можете использовать его для отображения или сохранения
                // Например, передать URI в ViewModel
                addContactViewModel.onPhotoUriChange(uri.toString())
            }
        }
    }*/
}