package com.ks.virtualchatmate.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.ks.virtualchatmate.R
import com.ks.virtualchatmate.ui.theme.BlueColor
import com.ks.virtualchatmate.ui.theme.MsgResponseColor
import com.ks.virtualchatmate.ui.theme.MsgSendColor
import com.ks.virtualchatmate.ui.theme.PurpleColor

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(62.dp)
            .background(Color.White)
    ) {
        Icon(
            tint = PurpleColor,
            painter = painterResource(id = R.drawable.ic_navigation_back),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp, start = 20.dp)
                .align(Alignment.CenterVertically)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatInputField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    onSendClicked: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = text,
            maxLines = 3,
            onValueChange = { onTextChanged(it) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(CircleShape),
            singleLine = false,
            placeholder = { Text(stringResource(id = R.string.Enter_the_message)) },
            trailingIcon = {
                Icon(
                    modifier = Modifier
                        .clickable { onSendClicked() },
                    imageVector = Icons.Outlined.Send,
                    tint = BlueColor,
                    contentDescription = null
                )
            }
        )
    }
}

@Composable
fun ChatScreen(viewModel: ChatViewModel) {

    val state = viewModel.inputState.collectAsState()
    val chatContentState = viewModel.messagesState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar()
        }, bottomBar = {
            ChatInputField(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                text = state.value,
                onTextChanged = { viewModel.onTextChanged(it) },
                onSendClicked = { viewModel.onSendClicked() },
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            ChatContent(
                messages = chatContentState.value.reversed()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatContent(
    messages: List<ChatMessage>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        reverseLayout = true,
    ) {
        items(messages) { message ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp),
            ) {
                if (message.role == Role.USER) {
                    Spacer(modifier = Modifier.weight(1f))
                    TextField(
                        value = message.content,
                        onValueChange = {},
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = MsgSendColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                        ),
                        readOnly = true,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 18.dp,
                                    topEnd = 18.dp,
                                    bottomStart = 18.dp,
                                    bottomEnd = 6.dp
                                )
                            ),
                    )
                } else {
                    TextField(
                        value = message.content,
                        onValueChange = {},
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = MsgResponseColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        readOnly = true,
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
