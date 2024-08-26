package com.example.directory.utils

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R

@Composable
fun LayoutScreen(
    name: String,
    secondName: String,
    phoneNumber: String,
    photoUri: String,
    handleImageSelection: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onSecondNameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onValueChangeDone: () -> Unit,
    isButtonEnabled: Boolean,
    navController: NavController,
) {

    Column {

        val imagePickerLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                uri?.let { handleImageSelection(it.toString()) }
            }
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
        AsyncImage(
            placeholder = painterResource(id = R.drawable.baseline_portrait_24),
            model = photoUri,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .clickable { imagePickerLauncher.launch("image/*") }
                .background(color = Color.Gray) // Цвет фона
                .clip(RoundedCornerShape(16.dp))
        )
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