package com.example.directory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.directory.ui.nav_host.NavHost
import com.example.directory.ui.screens.add_contact_screen.AddContactViewModel
import com.example.directory.ui.screens.detail_screen.DetailsViewModel
import com.example.directory.ui.screens.edit_screen.EditViewModel
import com.example.directory.ui.screens.main_screen.MainViewModel
import com.example.directory.ui.theme.DirectoryTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by inject()
    private val addContactViewModel: AddContactViewModel by inject()
    private val editViewModel: EditViewModel by inject()
    private val detailsViewModel: DetailsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DirectoryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        mainViewModel = mainViewModel,
                        addContactViewModel = addContactViewModel,
                        editViewModel = editViewModel,
                        detailsViewModel = detailsViewModel
                    )
                }
            }
        }
    }
}

