package com.example.directory.utils

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R

@Composable
fun DetailsScreen(
    viewModel: ViewModel,
    value: String,
    onClick: () -> Unit,
    navController: NavController
) {

    Column {

        val imagePickerLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                uri?.let { onClick() }
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
            Text(text = "Готово", Modifier.clickable { onClick() })
        }
        AsyncImage(
            model = viewModel,
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
            value = value,
            onValueChange = { onClick() },
            placeholder = { Text(text = "Имя") }
        )
        TextField(
            value = value,
            onValueChange = { (onClick()) },
            placeholder = { Text(text = "Фамилия") }
        )
        TextField(
            value = value,
            onValueChange = { onClick() },
            placeholder = { Text(text = "Номер телефона") }
        )
        Button(onClick = { onClick() }) {
            Text(text = "Удалить контакт")
        }
    }

}