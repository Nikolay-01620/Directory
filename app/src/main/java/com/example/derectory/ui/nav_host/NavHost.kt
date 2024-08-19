package com.example.derectory.ui.nav_host

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.derectory.ui.screens.MainScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.derectory.ui.screens.MainViewModel

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
    }
}

