package com.example.directory.ui.screens.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.directory.R
import com.example.directory.ui.nav_host.Route

@Composable
fun DetailsScreen(navController: NavController, contactId: Int) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .clickable { navController.popBackStack() },
            text = "Контакты",
            style = MaterialTheme.typography.titleLarge
        )
        Column {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.image_phone),
                contentDescription = null
            )
            Text(text = "Витя")
        }
        Text(
            modifier = Modifier
                .clickable { navController.navigate(route = "${Route.EditScreen.route}/$contactId") },
            text = "Править",
            style = MaterialTheme.typography.bodyMedium
        )
    }
    /*    Column(
            modifier = Modifier
        ) {

            Row() {
                BorderedText()
                BorderedText()
                BorderedText()
                BorderedText()
            }
        }
    }*/

    @Composable
    fun BorderedText() {
        Text(
            text = "This is a bordered text",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp) // Закругленные углы (можно изменить на другую форму)
                )
                .padding(16.dp) // Отступы внутри рамки
        )
    }
}