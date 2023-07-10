package com.ks.virtualchatmate.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MessageRequest(
    @Json(name = "role") val role: String,
    @Json(name = "content") val content: String,
)