package com.ks.virtualchatmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ks.virtualchatmate.navigation.SetupNavigationGraph
import com.ks.virtualchatmate.ui.theme.VirtualChatMateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VirtualChatMateTheme {
                SetupNavigationGraph(
                    navController = rememberNavController(),
                    user = Firebase.auth.currentUser
                )
            }
        }
    }
}
