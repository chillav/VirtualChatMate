package com.ks.virtualchatmate.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Choice(
    @Json(name = "index") val index: Int,
    @Json(name = "message") val messageRequest: MessageRequest,
    @Json(name = "finish_reason") val finishReason: String
)