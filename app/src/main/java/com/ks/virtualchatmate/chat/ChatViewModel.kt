package com.ks.virtualchatmate.chat

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ChatViewModel : ViewModel() {

    private val _inputState = MutableStateFlow("")
    val inputState = _inputState.asStateFlow()

    fun onTextChanged(text: String) {
        _inputState.value = text
    }

    fun onSendClicked() {

    }

    fun fetchMessages(): List<ChatMessage> {
        // Mock data

        return listOf(
            ChatMessage(1, "Привет, как дела?"),
            ChatMessage(2, "Привет! Хорошо, спасибо."),
            ChatMessage(1, "Что нового?"),
            ChatMessage(2, "Ничего особенного, а у тебя?"),
            ChatMessage(1, "Тоже ничего интересного."),
            ChatMessage(1, "Пока!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(1, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(1, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(1, "До свидания!"),
            ChatMessage(1, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(2, "До свидания!"),
            ChatMessage(1, "До свидания!"),
        )
    }
}
