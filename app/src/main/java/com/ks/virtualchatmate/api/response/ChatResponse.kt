package com.ks.virtualchatmate.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChatResponse(
    @Json(name = "id") val id: String,
    @Json(name = "object") val obj: String,
    @Json(name = "created") val created: Long,
    @Json(name = "model") val model: String,
    @Json(name = "choices") val choices: List<Choice>,
    @Json(name = "usage") val usage: Usage
)