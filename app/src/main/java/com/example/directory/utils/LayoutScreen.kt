package com.example.directory.utils

import android.graphics.Paint.Style
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.directory.ui.theme.CustomGray

@Composable
fun LayoutScreen(
    name: String,
    secondName: String,
    phoneNumber: String,
    photoUri: String,
    mail: String,
    onNameChange: (String) -> Unit,
    onSecondNameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onMailChange: (String) -> Unit,
    onValueChangeDone: () -> Unit,
    isButtonEnabled: Boolean,
    navController: NavController,
    handleImageSelection: (String) -> Unit,
    cancel: () -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp, vertical = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                cancel()
                navController.popBackStack()
            }) {
                Text(text = "Отменить")
            }
            Text(
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.W400,
                text = "Контакт"
            )
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
        Card(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            border = BorderStroke(1.dp, color = CustomGray),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            ImagePicker(
                photoUri = photoUri,
                handleImageSelection,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Divider(color = CustomGray, thickness = 1.dp)
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = name,
                onValueChange = { onNameChange(it) },
                placeholder = { Text(text = "Имя") }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = secondName,
                onValueChange = { onSecondNameChange(it) },
                placeholder = { Text(text = "Фамилия") }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = phoneNumber,
                onValueChange = { onPhoneNumberChange(it) },
                placeholder = { Text(text = "Номер телефона") }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = mail,
                onValueChange = { onMailChange(it) },
                placeholder = { Text(text = "Почта") }
            )
        }
    }
}