package com.example.derectory.ui.nav_host

sealed class Route(
    val route: String
) {
    data object MainScreen : Route(route = "mainScreen")
    data object DetailsScreen : Route(route = "detailsScreen")
    data object SendMessageScreen : Route(route = "sendMessageScreen")
}