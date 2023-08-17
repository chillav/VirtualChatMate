package com.ks.virtualchatmate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseUser
import com.ks.virtualchatmate.authorization.AuthorizationScreen
import com.ks.virtualchatmate.chat.ChatScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupNavigationGraph(
    navController: NavHostController,
    user: FirebaseUser?
) {
    NavHost(
        navController = navController,
        startDestination = if (user != null) {
            Screen.Chat.route
        } else {
            Screen.Authorization.route
        }
    ) {
        composable(
            route = Screen.Authorization.route
        ) {
            AuthorizationScreen(navController)
        }
        composable(
            route = Screen.Chat.route
        ) {
            ChatScreen(koinViewModel())
        }
    }
}
