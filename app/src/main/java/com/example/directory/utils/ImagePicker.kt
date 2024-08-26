package com.example.directory.utils

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.directory.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private val _photoUri = MutableStateFlow("")
val photoUri: StateFlow<String> = _photoUri

@Composable
fun ImagePicker(photoUri: String) {

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { handleImageSelection(it.toString()) }
        }

    AsyncImage(
        placeholder = painterResource(id = R.drawable.baseline_portrait_24),
        model = photoUri,
        contentDescription = null,
        contentScale = ContentScale.Crop,// Добавьте свой placeholder
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable { imagePickerLauncher.launch("image/*") }
            .background(color = Color.Gray) // Цвет фона
            .clip(RoundedCornerShape(16.dp))
    )

}

fun handleImageSelection(uri: String) {
    _photoUri.value = uri
}