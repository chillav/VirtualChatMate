package com.ks.virtualchatmate.api.request

import com.ks.virtualchatmate.api.response.MessageRequest
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChatRequest(
    @Json(name = "model") val model: String = "gpt-3.5-turbo",
    @Json(name = "messages") val messageRequests: List<MessageRequest>,
)