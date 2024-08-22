package com.example.directory.ui.nav_host

import AddContactScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.directory.ui.screens.main_screen.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.example.directory.ui.screens.edit_screen.EditScreen
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
        composable(
            route = "${Route.EditScreen.route}/{contactId}",
            arguments = listOf(navArgument("contactId") { type = NavType.IntType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getInt("contactId")
            contactId?.let {
                EditScreen(navController = navController, mainViewModel = mainViewModel, contactId = it)
            }
        }

    }
}

