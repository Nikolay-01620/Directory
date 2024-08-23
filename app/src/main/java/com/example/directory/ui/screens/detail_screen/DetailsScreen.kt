package com.example.directory.ui.screens.detail_screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.ui.nav_host.Route
import com.example.directory.ui.screens.main_screen.MainViewModel

@Composable
fun DetailsScreen(
    navController: NavController,
    detailsViewModel: DetailsViewModel,
    contactId: Int
) {

    LaunchedEffect(contactId) {
        detailsViewModel.loadContact(contactId)
    }


    val contact = detailsViewModel.contacts.collectAsState().value.find { it.id == contactId }

    val name by detailsViewModel.name.collectAsState()
    val secondName by detailsViewModel.secondName.collectAsState()
    val phoneNumber by detailsViewModel.phoneNumber.collectAsState()
    val photoUri by detailsViewModel.photoUri.collectAsState()

    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { detailsViewModel.handleImageSelection(it.toString()) }
        }

    Column(modifier = Modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                modifier = Modifier
                    .clickable { navController.popBackStack() },
                text = "Контакты",
                style = MaterialTheme.typography.titleLarge
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                AsyncImage(
                    model = photoUri,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.baseline_portrait_24), // Добавьте свой placeholder
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .clickable {
                            imagePickerLauncher.launch("image/*") // Запуск выбора изображения
                        }
                )
                Text(modifier = Modifier.padding(top = 10.dp, end = 4.dp), text = name)
                Text(modifier = Modifier.padding(top = 10.dp, end = 4.dp), text = secondName)
            }
            Text(
                modifier = Modifier
                    .clickable {
                        if (contact != null) {
                            navController.navigate(route = Route.EditScreen.route)
                        }
                    },
                text = "Править",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BorderedText(text = "Написать", modifier = Modifier.width(85.dp))
            BorderedText(text = phoneNumber, modifier = Modifier.width(85.dp))
            BorderedText(text = "Видео", modifier = Modifier.width(85.dp))
            BorderedText(text = "Почта", modifier = Modifier.width(85.dp))
        }
        Spacer(modifier = Modifier.padding(top = 18.dp))

        // Первый нижний бордер с высотой в 2 раза больше
        BorderedText(
            text = "Большой бордер 1",
            modifier = Modifier
                .fillMaxWidth() // Растягивается на всю ширину
                .height(50.dp)
                .padding(horizontal = 10.dp)
        )

        Spacer(modifier = Modifier.padding(top = 18.dp))

        // Второй нижний бордер с высотой в 4 раза больше
        BorderedText(
            text = "Большой бордер 2",
            modifier = Modifier
                .fillMaxWidth() // Растягивается на всю ширину
                .height(100.dp) // Высота как четыре обычных бордера
                .padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.padding(top = 18.dp))
        Border()
    }
}

@Composable
fun BorderedText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp) // Закругленные углы (можно изменить на другую форму)
            )
            .padding(10.dp) // Отступы внутри рамки
    )
}

@Composable
fun Border() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = "Строка 1",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )
        Divider(color = Color.Gray, thickness = 2.dp) // Красная линия разделения

        Text(
            text = "Строка 2",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )
        Divider(color = Color.Gray, thickness = 2.dp) // Зеленая линия разделения

        Text(
            text = "Строка 3",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsPreview() {
    //DetailsScreen()
}