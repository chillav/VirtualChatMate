package com.ks.virtualchatmate.navigation

sealed class Screen(val route: String) {
    object Registration : Screen(route = "registration_screen")
    object Chat : Screen(route = "chat_screen")
}
