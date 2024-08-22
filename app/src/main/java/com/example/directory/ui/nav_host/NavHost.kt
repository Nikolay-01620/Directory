package com.example.directory.ui.nav_host

import AddContactScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.directory.ui.screens.main_screen.MainScreen
import androidx.navigation.compose.NavHost
import com.example.directory.ui.screens.details_screen.EditScreen
import com.example.directory.ui.screens.main_screen.MainViewModel

@Composable
fun NavHost(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel
) {
    NavHost(
        navController = navController, startDestination = Route.MainScreen.route
    ) {
        composable(Route.MainScreen.route) {
            MainScreen(navController = navController, mainViewModel)
        }
        composable(Route.AddContactScreen.route) {
            AddContactScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable(Route.EditScreen.route) {
            EditScreen(navController = navController, mainViewModel = mainViewModel)
        }
    }
}

