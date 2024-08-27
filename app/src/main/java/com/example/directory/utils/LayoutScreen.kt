package com.example.directory.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LayoutScreen(
    name: String,
    secondName: String,
    phoneNumber: String,
    photoUri: String,
    mail: String,
    onNameChange: (String) -> Unit,
    onSecondNameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onMailChange: (String) -> Unit,
    onValueChangeDone: () -> Unit,
    isButtonEnabled: Boolean,
    navController: NavController,
    handleImageSelection: (String) -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

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
            Button(
                onClick = {
                    onValueChangeDone()
                    navController.popBackStack()
                },
                enabled = isButtonEnabled, // Управление активностью кнопки
            ) {
                Text(text = "Готово")
            }
        }
        ImagePicker(photoUri = photoUri, handleImageSelection)
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = name,
            onValueChange = { onNameChange(it) },
            placeholder = { Text(text = "Имя") }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = secondName,
            onValueChange = { onSecondNameChange(it) },
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = phoneNumber,
            onValueChange = { onPhoneNumberChange(it) },
            placeholder = { Text(text = "Номер телефона") }
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = mail,
            onValueChange = { onMailChange(it) },
            placeholder = { Text(text = "Почта") }
        )
    }
}