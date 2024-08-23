package com.example.directory.ui.screens.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.ui.nav_host.Route

@Composable
fun DetailsScreen(navController: NavController = rememberNavController()) {

    Column() {
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
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.image_phone),
                    contentDescription = null
                )
                Text(modifier = Modifier.padding(top = 10.dp, end = 4.dp), text = "Витя")
            }
            Text(
                modifier = Modifier
                    .clickable { navController.navigate(route = Route.EditScreen.route) },
                text = "Править",
                style = MaterialTheme.typography.titleLarge
            )
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BorderedText(text = "Написать")
            BorderedText(text = "Сотовый")
            BorderedText(text = "Видео")
            BorderedText(text = "Почта")
        }
    }
}

@Composable
fun BorderedText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp) // Закругленные углы (можно изменить на другую форму)
            )
            .width(85.dp)
            .padding(10.dp) // Отступы внутри рамки
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsPreview() {
    DetailsScreen()
}