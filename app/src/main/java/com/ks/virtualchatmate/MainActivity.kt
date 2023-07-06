package com.ks.virtualchatmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ks.virtualchatmate.chat.ChatScreen
import com.ks.virtualchatmate.ui.theme.VirtualChatMateTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirtualChatMateTheme {
                // A surface container using the 'background' color from the theme
                ChatScreen(viewModel = koinViewModel())
            }
        }
    }
}