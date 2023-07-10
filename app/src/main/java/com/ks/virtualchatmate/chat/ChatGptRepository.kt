package com.ks.virtualchatmate.chat

import com.ks.virtualchatmate.api.ChatApiService
import com.ks.virtualchatmate.api.request.ChatRequest
import com.ks.virtualchatmate.api.response.ChatResponse
import com.ks.virtualchatmate.api.response.MessageRequest
import retrofit2.Response

class ChatGptRepository(private val chatApiService: ChatApiService) {

    suspend fun sendMessage(messageRequests: List<MessageRequest>): Response<ChatResponse> {
        val request = ChatRequest(messageRequests = messageRequests)
        return chatApiService.getChatCompletion(request)
    }
}