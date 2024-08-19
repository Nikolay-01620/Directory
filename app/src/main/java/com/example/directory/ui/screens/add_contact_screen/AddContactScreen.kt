import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.directory.R
import com.example.directory.ui.screens.main_screen.MainViewModel

@Composable
fun AddContactScreen(navController: NavController, mainViewModel: MainViewModel) {
    Column {

        val contactName by mainViewModel.contactName.collectAsState()
        val contactSecondName by mainViewModel.contactSecondName.collectAsState()
        val contactPhoneNumber by mainViewModel.contactPhoneNumber.collectAsState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp, vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Отменить", Modifier.clickable { navController.popBackStack() })
            Text(text = "Контакт")
            Text(text = "Готово", Modifier.clickable {
                mainViewModel.addContact()
                navController.popBackStack()
            })
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        TextField(
            value = contactName,
            onValueChange = mainViewModel::onNameChange,
            placeholder = { Text(text = "Имя") })
        TextField(
            value = contactSecondName,
            onValueChange = mainViewModel::onSecondNameChange,
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            value = contactPhoneNumber,
            onValueChange = mainViewModel::onPhoneNumberChange,
            placeholder = { Text(text = "Номер телефона") }
        )
    }

}