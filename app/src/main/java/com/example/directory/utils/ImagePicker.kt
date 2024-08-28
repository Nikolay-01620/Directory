package com.example.directory.utils

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.directory.ui.theme.CustomGray
import com.skydoves.landscapist.coil.CoilImage


@Composable
fun ImagePicker(
    photoUri: ByteArray?,
    handleImageSelection: (ByteArray) -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
                context.contentResolver.openInputStream(uri)
                    ?.use { handleImageSelection(it.readBytes()) }
            }
        }

    CoilImage(
        imageModel = { photoUri },
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
            },
    )
}

