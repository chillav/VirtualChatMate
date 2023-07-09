package com.ks.virtualchatmate.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ks.virtualchatmate.api.response.MessageRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel(
    private val chatGptRepository: ChatGptRepository
) : ViewModel() {

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
            val newMessage = ChatMessage(Role.USER, inputText)
            _messagesState.value = _messagesState.value + newMessage
            _inputState.value = ""

            val messageRequests = _messagesState.value.map {
                MessageRequest(role = it.role.value, content = it.content)
            }

            viewModelScope.launch {
                runCatching { chatGptRepository.sendMessage(messageRequests).body() }
                    .onSuccess { response ->
                        response?.choices?.lastOrNull()?.let { choice ->
                            val botAnswer = ChatMessage(Role.AI, choice.messageRequest.content)
                            _messagesState.value = _messagesState.value + botAnswer
                        }
                    }.onFailure {
                        it.printStackTrace()
                        // TODO handle error and notify user
                    }
            }
        }
    }

    private fun fetchMessages(): List<ChatMessage> = emptyList() // TODO fetch
}
