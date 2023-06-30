package com.ks.virtualchatmate.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ks.virtualchatmate.R
import com.ks.virtualchatmate.ui.theme.ArrowBackColor

@Preview
@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .background(Color.White)
    ) {
        Icon(
            tint = ArrowBackColor,
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp, start = 20.dp)
                .align(Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = null,
            modifier = Modifier
                .size(33.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)

        )
        Text(
            style = TextStyle(
                fontFamily = FontFamily.Cursive
            ),
            color = Color.Black,
            text = "Леха Павлович",
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)

        )
    }
}
