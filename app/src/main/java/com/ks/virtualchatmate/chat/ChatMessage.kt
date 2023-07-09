package com.ks.virtualchatmate.chat

data class ChatMessage(
    val role: Role,
    val content: String,
)

enum class Role(val value: String)  {
    USER("user"),
    AI("assistant"),
}
