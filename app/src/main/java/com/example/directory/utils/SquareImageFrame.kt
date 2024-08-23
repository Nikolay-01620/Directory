package com.example.directory.utils

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.ui.screens.detail_screen.DetailsViewModel


@Composable
fun SquareImageFrame(
    photoUri: String?,
    modifier: Modifier = Modifier
) {
    val viewModel: DetailsViewModel = viewModel()
    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { viewModel.handleImageSelection(it.toString()) }
        }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp) // Задаем размер квадрата
            .clip(RoundedCornerShape(16.dp)) // Закругляем углы рамки
            .background(Color.Gray) // Устанавливаем серый фон
            .border(
                width = 2.dp,
                color = Color.Black, // Цвет границы рамки
                shape = RoundedCornerShape(16.dp) // Закругляем углы границы
            )
    ) {
        AsyncImage(
            model = photoUri,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.baseline_portrait_24), // Плейсхолдер
            modifier = Modifier
                .fillMaxSize() // Заполняем всю рамку изображением
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    imagePickerLauncher.launch("image/*") // Запуск выбора изображения
                }
        )
    }
}


