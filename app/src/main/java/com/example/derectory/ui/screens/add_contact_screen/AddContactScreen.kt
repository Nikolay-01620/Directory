package com.example.derectory.ui.screens.add_contact_screen

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.derectory.R

@Composable
fun AddContactScreen(navController: NavController) {
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
            Text(text = "Готово", Modifier.clickable { })
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Text(text = "", Modifier.clickable { })
        TextField(value = "Имя", onValueChange = {})
        TextField(value = "Фамилия", onValueChange = {})
        TextField(value = "Добавить телефон", onValueChange = {})
    }

}