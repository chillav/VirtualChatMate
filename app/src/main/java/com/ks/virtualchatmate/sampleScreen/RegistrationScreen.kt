package com.ks.virtualchatmate.sampleScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ks.virtualchatmate.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Chat.route)
            },
            text = "Hello gus",
            color = Color.Black,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
@Preview(showBackground = true)
fun RegistrationScreenPreview() {
    RegistrationScreen(
        navController = rememberNavController()
    )
}