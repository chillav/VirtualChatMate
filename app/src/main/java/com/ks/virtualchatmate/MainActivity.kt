package com.ks.virtualchatmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.ks.virtualchatmate.chat.ChatInputField
import com.ks.virtualchatmate.chat.Toolbar
import com.ks.virtualchatmate.ui.theme.VirtualChatMateTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirtualChatMateTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Toolbar()
                    }, bottomBar = {
                        ChatInputField(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        )
                    }

                ) { contentPadding ->
                    Column(
                        modifier = Modifier
                            .padding(contentPadding)
                            .fillMaxSize()
                    ) {

                    }
                }
            }
        }
    }
}