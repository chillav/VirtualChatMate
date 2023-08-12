package com.ks.virtualchatmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.ks.virtualchatmate.authorization.AuthorizationScreen
import com.ks.virtualchatmate.navigation.SetupNavigationGraph
import com.ks.virtualchatmate.ui.theme.VirtualChatMateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VirtualChatMateTheme {
                SetupNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
