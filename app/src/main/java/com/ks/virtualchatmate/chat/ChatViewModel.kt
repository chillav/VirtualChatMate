package com.ks.virtualchatmate.chat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatViewModel : ViewModel() {

    private val _inputState = MutableStateFlow("")
    val inputState = _inputState.asStateFlow()

    private val _messagesState = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messagesState = _messagesState.asStateFlow()

    init {
        _messagesState.value = fetchMessages()
    }

    fun onTextChanged(text: String) {
        _inputState.value = text
    }

    fun onSendClicked() {
        val inputText = _inputState.value
        if (inputText.isNotEmpty()) {
            val newMessage = ChatMessage(Sender.USER, inputText)
            _messagesState.value = _messagesState.value + newMessage
            _inputState.value = ""
        }
    }

    fun fetchMessages(): List<ChatMessage> {
        // Mock data

        val messages = listOf(
            ChatMessage(Sender.AI, "Привет, как дела?"),
            ChatMessage(Sender.AI, "Что нового?"),
            ChatMessage(Sender.AI, "Тоже ничего интересного."),
            ChatMessage(Sender.AI, "Пока!"),
            ChatMessage(Sender.AI, "До свидания!"),
            ChatMessage(Sender.AI, "До свидания!"),
            ChatMessage(Sender.AI, "До свидания!"),
            ChatMessage(Sender.AI, "До свидания!"),
            ChatMessage(Sender.AI, "До свидания!"),
        )
        return messages
    }
}
