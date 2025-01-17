package com.example.directory.ui.screens.main_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.directory.ui.nav_host.Route
import com.example.domain.model.DirectoryDomain
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel
) {
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val contacts by mainViewModel.contacts.collectAsState()



    LaunchedEffect(Unit) {
        mainViewModel.loadContacts()
    }


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Contacts")
            Spacer(modifier = Modifier.padding(10.dp))
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                Modifier.clickable { navController.navigate(route = Route.AddContactScreen.route) })
        }
        TextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                mainViewModel.searchContacts(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            label = { Text(text = "Search") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide() // Закрываем клавиатуру
                    focusManager.clearFocus() // Снимаем фокус с поля ввода
                }
            )
        )
        LazyColumn {
            items(contacts) { contact ->
                ContactItem(
                    contact = contact,
                    onClick = {
                        navController.navigate(route = "${Route.DetailsScreen.route}/${contact.id}")
                    },
                )
            }
        }
    }
}

@Composable
fun ContactItem(contact: DirectoryDomain, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CoilImage(
            imageModel = { contact.photoUri },
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "${contact.name} ${contact.secondName}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(text = contact.phoneNumber, style = MaterialTheme.typography.titleLarge)
        }
    }
}