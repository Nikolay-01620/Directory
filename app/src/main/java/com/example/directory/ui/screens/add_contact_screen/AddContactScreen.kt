import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.ui.screens.add_contact_screen.AddContactViewModel

@Composable
fun AddContactScreen(navController: NavController, addContactViewModel: AddContactViewModel) {
    Column {

        val name by addContactViewModel.name.collectAsState()
        val secondName by addContactViewModel.secondName.collectAsState()
        val phoneNumber by addContactViewModel.phoneNumber.collectAsState()
        val photoUri by addContactViewModel.photoUri.collectAsState()
        val isButtonEnabled by addContactViewModel.isButtonEnabled.collectAsState()

        val imagePickerLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                uri?.let { addContactViewModel.handleImageSelection(it.toString()) }
            }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    addContactViewModel.clearFields()
                    navController.popBackStack()
                },
            ) {
                Text(text = "Отменить")
            }
            Text(text = "Контакт")
            Button(
                onClick = {
                    addContactViewModel.addContact()
                    navController.popBackStack()
                },
                enabled = isButtonEnabled, // Управление активностью кнопки
            ) {
                Text(text = "Готово")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = photoUri,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_launcher_background), // Добавьте свой placeholder
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .clickable {
                    imagePickerLauncher.launch("image/*") // Запуск выбора изображения
                }
        )
        TextField(
            value = name,
            onValueChange = addContactViewModel::onNameChange,
            placeholder = { Text(text = "Имя") }
        )
        TextField(
            value = secondName,
            onValueChange = addContactViewModel::onSecondNameChange,
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            value = phoneNumber,
            onValueChange = addContactViewModel::onPhoneNumberChange,
            placeholder = { Text(text = "Номер телефона") }
        )
    }

}