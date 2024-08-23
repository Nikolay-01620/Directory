import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.directory.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory.utils.DetailsScreen

@Composable
fun AddContactScreen(navController: NavController, addContactViewModel: AddContactViewModel) {

    val name by addContactViewModel.name.collectAsState()
    val secondName by addContactViewModel.secondName.collectAsState()
    val phoneNumber by addContactViewModel.phoneNumber.collectAsState()
    val photoUri by addContactViewModel.photoUri.collectAsState()
    val isButtonEnabled by addContactViewModel.isButtonEnabled.collectAsState()


    DetailsScreen(
        name = name,
        secondName = secondName,
        phoneNumber = phoneNumber,
        photoUri = photoUri,
        handleImageSelection = { addContactViewModel.handleImageSelection() },
        onNameChange = { addContactViewModel.onNameChange() },
        onSecondNameChange = { addContactViewModel.onNameChange() },
        onPhoneNumberChange = { addContactViewModel.onNameChange() },
        onValueDone = { addContactViewModel.addContact() },
        navController = navController
    )


}
