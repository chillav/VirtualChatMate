package com.ks.virtualchatmate.chat

data class ChatMessage(
    val senderId: Sender,
    val content: String,
)

enum class Sender  {
    USER, AI,
}
