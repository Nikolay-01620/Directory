package com.example.directory.utils

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
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
import coil.compose.rememberAsyncImagePainter
import com.example.directory.R
import com.example.directory.ui.theme.CustomGray
import com.example.directory.ui.theme.CustomGray2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun ImagePicker(
    photoUri: String,
    handleImageSelection: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { handleImageSelection(it.toString()) }
        }

    val painter = rememberAsyncImagePainter(
        model = photoUri,
        placeholder = painterResource(id = R.drawable.baseline_portrait_24),
        error = painterResource(id = R.drawable.baseline_portrait_24)
    )

    AsyncImage(
        placeholder = painter,
        model = photoUri,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = CustomGray,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                imagePickerLauncher.launch("image/*")
            }
    )
}
