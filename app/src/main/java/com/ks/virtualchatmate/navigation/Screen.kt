package com.ks.virtualchatmate.navigation

sealed class Screen(val route: String) {
    object Authorization : Screen(route = "authorization_screen")
    object Chat : Screen(route = "chat_screen")
}
