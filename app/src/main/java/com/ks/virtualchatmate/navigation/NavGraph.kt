package com.ks.virtualchatmate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ks.virtualchatmate.chat.ChatScreen
import com.ks.virtualchatmate.sampleScreen.RegistrationScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Registration.route
    ) {
        composable(
            route = Screen.Registration.route
        ) {
            RegistrationScreen(navController)
        }
        composable(
            route = Screen.Chat.route
        ) {
            ChatScreen(koinViewModel())
        }
    }
}
