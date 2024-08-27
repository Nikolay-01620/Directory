package com.example.directory.ui.screens.edit_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.directory.ui.nav_host.Route
import com.example.directory.utils.LayoutScreen

@Composable
fun EditScreen(editViewModel: EditViewModel, navController: NavController, contactId: Int) {

    LaunchedEffect(contactId) {
        editViewModel.loadContact(contactId)
    }

    val name by editViewModel.name.collectAsState()
    val secondName by editViewModel.secondName.collectAsState()
    val phoneNumber by editViewModel.phoneNumber.collectAsState()
    val photoUri by editViewModel.photoUri.collectAsState()
    val isButtonEnabled by editViewModel.isButtonEnabled.collectAsState()
    val mail by editViewModel.mail.collectAsState()



    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LayoutScreen(
            name = name,
            secondName = secondName,
            phoneNumber = phoneNumber,
            photoUri = photoUri,
            mail = mail,
            onNameChange = editViewModel::onNameChange,
            onSecondNameChange = editViewModel::onSecondNameChange,
            onPhoneNumberChange = editViewModel::onPhoneNumberChange,
            onValueChangeDone = { editViewModel.updateContact(contactId) },
            navController = navController,
            isButtonEnabled = isButtonEnabled,
            handleImageSelection = editViewModel::handleImageSelection,
            onMailChange = editViewModel::onMailChange,
            cancel = editViewModel::clearFields

        )
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                editViewModel.deleteContact(contactId)
                navController.navigate(Route.MainScreen.route)
            }) {
            Text(text = "Delete contact")
        }
    }
}
