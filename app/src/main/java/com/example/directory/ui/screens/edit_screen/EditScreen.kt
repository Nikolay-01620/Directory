package com.example.directory.ui.screens.edit_screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.utils.SquareImageFrame

@Composable
fun EditScreen(editViewModel: EditViewModel, navController: NavController, contactId: Int) {

    LaunchedEffect(contactId) {
        editViewModel.loadContact(contactId)
    }

    val name by editViewModel.name.collectAsState()
    val secondName by editViewModel.secondName.collectAsState()
    val phoneNumber by editViewModel.phoneNumber.collectAsState()
    val photoUri by editViewModel.photoUri.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

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
                editViewModel.updateContact(contactId)
                navController.popBackStack()
            })
        }
        SquareImageFrame(photoUri = photoUri)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = editViewModel::onNameChange,
            placeholder = { Text(text = "Имя") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),

            value = secondName,
            onValueChange = editViewModel::onSecondNameChange,
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),

            value = phoneNumber,
            onValueChange = editViewModel::onPhoneNumberChange,
            placeholder = { Text(text = "Номер телефона") }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                editViewModel.deleteContact(contactId)
                navController.popBackStack()
            }) {
            Text(text = "Удалить контакт")
        }
    }

}

/*
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


    DetailsScreen(
        name = name,
        secondName = secondName,
        phoneNumber = phoneNumber,
        photoUri = photoUri,
        handleImageSelection = editViewModel::handleImageSelection,
        onNameChange = editViewModel::onNameChange,
        onSecondNameChange = editViewModel::onSecondNameChange,
        onPhoneNumberChange = editViewModel::onPhoneNumberChange,
        onValueChangeDone = editViewModel::updateContact(),
        navController = navController,
        isButtonEnabled = isButtonEnabled
    )

}*/
