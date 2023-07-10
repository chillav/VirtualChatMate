package com.ks.virtualchatmate.api

import com.ks.virtualchatmate.Constants.CHAT_GPT_API_KEY
import com.ks.virtualchatmate.api.request.ChatRequest
import com.ks.virtualchatmate.api.response.ChatResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatApiService {
    @Headers("Authorization: Bearer $CHAT_GPT_API_KEY")
    @POST("/v1/chat/completions")
    suspend fun getChatCompletion(@Body request: ChatRequest): Response<ChatResponse>
}