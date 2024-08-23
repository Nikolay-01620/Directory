package com.example.directory.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LayoutScreen(
    name: String,
    secondName: String,
    phoneNumber: String,
    photoUri: String,
    onNameChange: (String) -> Unit,
    onSecondNameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onValueChangeDone: () -> Unit,
    isButtonEnabled: Boolean,
    navController: NavController,
) {
    Column {
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
        SquareImageFrame(photoUri = photoUri)
        TextField(
            value = name,
            onValueChange = { onNameChange(it) },
            placeholder = { Text(text = "Имя") }
        )
        TextField(
            value = secondName,
            onValueChange = { onSecondNameChange(it) },
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            value = phoneNumber,
            onValueChange = { onPhoneNumberChange(it) },
            placeholder = { Text(text = "Номер телефона") }
        )
    }
}