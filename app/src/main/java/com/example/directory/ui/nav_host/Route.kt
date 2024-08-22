package com.example.directory.ui.nav_host

sealed class Route(
    val route: String
) {
    data object MainScreen : Route(route = "main_screen")
    data object AddContactScreen : Route(route = "add_contact_screen")
    data object SendMessageScreen : Route(route = "send_message_screen")
    data object EditScreen : Route(route = "edit_screen")
}