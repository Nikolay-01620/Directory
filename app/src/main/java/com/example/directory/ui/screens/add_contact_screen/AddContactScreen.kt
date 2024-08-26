import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.directory.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory.utils.LayoutScreen

@Composable
fun AddContactScreen(navController: NavController, addContactViewModel: AddContactViewModel) {

    val name by addContactViewModel.name.collectAsState()
    val secondName by addContactViewModel.secondName.collectAsState()
    val phoneNumber by addContactViewModel.phoneNumber.collectAsState()
    val photoUri by addContactViewModel.photoUri.collectAsState()
    val isButtonEnabled by addContactViewModel.isButtonEnabled.collectAsState()

    LayoutScreen(
        name = name,
        secondName = secondName,
        phoneNumber = phoneNumber,
        photoUri = photoUri,
        onNameChange = addContactViewModel::onNameChange,
        onSecondNameChange = addContactViewModel::onSecondNameChange,
        onPhoneNumberChange = addContactViewModel::onPhoneNumberChange,
        onValueChangeDone = addContactViewModel::addContact,
        navController = navController,
        isButtonEnabled = isButtonEnabled,
        handleImageSelection = addContactViewModel::handleImageSelection
    )
}
