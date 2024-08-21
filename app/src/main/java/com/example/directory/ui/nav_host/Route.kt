package com.example.directory.ui.nav_host

sealed class Route(
    val route: String
) {
    data object MainScreen : Route(route = "mainScreen")
    data object AddContactScreen : Route(route = "addContactScreen")
    data object SendMessageScreen : Route(route = "sendMessageScreen")
    data object DetailsScreen : Route(route = "detailsScreen")
}