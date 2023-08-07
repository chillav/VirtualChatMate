package com.ks.virtualchatmate.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ks.virtualchatmate.R
import com.ks.virtualchatmate.ui.theme.TurquoiseColor

@Composable
fun AuthorizationScreen() {
    AuthorizationContent()
}

@Composable
private fun AuthorizationContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AuthTypeButton(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun AuthTypeButton(
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(14.dp)
    Row(
        modifier = modifier
            .height(56.dp)
            .background(color = TurquoiseColor, shape = shape)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.continue_with_google),
            fontSize = 16.sp,
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview
@Composable
private fun AuthorizationContent_Preview() {
    AuthorizationContent()
}